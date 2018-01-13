package blobs.engine;

import blobs.annotations.Inject;
import blobs.interfaces.*;
import blobs.interfaces.Runnable;
import blobs.repositories.Repository;
import blobs.utility.MutableBoolean;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "drop";
    private static final String COMMAND_CLASS_PATH = "blobs.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    private InputReader reader;
    private OutputWriter writer;
    private Repository<Blob> blobRepository;
    private MutableBoolean isEventToggled;

    public Engine(InputReader reader, OutputWriter writer, Repository<Blob> blobRepository, MutableBoolean flag) {
        this.reader = reader;
        this.writer = writer;
        this.blobRepository = blobRepository;
        this.isEventToggled = flag;
    }

    @Override
    public void run() {

        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));

            try {
                String result = this.dispatchCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
                this.updateBlobs();
                if (result != null) {
                    this.writer.writeLine(result);
                }
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException | IllegalStateException e) {
                this.writer.writeLine(e.getMessage());
            }

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        if (command.contains("-")) {
            command = Arrays.stream(command.split("-")).map(w -> String.valueOf(w.charAt(0)).toUpperCase() + w.substring(1)).collect(Collectors.joining(""));
        } else {
            command = String.valueOf(command.charAt(0)).toUpperCase() + command.substring(1);
        }
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Constructor<Executable> constructor = commandClass.getDeclaredConstructor();
        Executable executable = constructor.newInstance();
        injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fieldsBaseCommand = executable.getClass().getSuperclass().getDeclaredFields();
        Field[] fieldsCommand = executable.getClass().getDeclaredFields();
        Field[] allFields = null;
        if (fieldsCommand.length > 0) {
            allFields = new Field[fieldsBaseCommand.length + fieldsCommand.length];
            System.arraycopy(fieldsBaseCommand, 0, allFields, 0, fieldsBaseCommand.length);
            System.arraycopy(fieldsCommand, 0, allFields, fieldsBaseCommand.length, fieldsCommand.length);
        }

        for (Field field : fieldsCommand.length > 0 ? allFields : fieldsBaseCommand) {
            if (field.isAnnotationPresent(Inject.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if (field.getType().equals(currentField.getType())) {
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }

    private void updateBlobs() {
        for (Blob blob : this.blobRepository.findAll().values()) {
            blob.update();
        }
    }
}