package app.engine;

import app.annotations.Inject;
import app.interfaces.Blob;
import app.interfaces.Executable;
import app.interfaces.InputReader;
import app.interfaces.OutputWriter;
import app.repositories.Repository;


import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;


public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "drop";
    private static final String COMMAND_CLASS_PATH = "app.core.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    private InputReader reader;
    private OutputWriter writer;
    private Repository<Blob> repository;


    public Engine(InputReader reader, OutputWriter writer, Repository<Blob> repository) {
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));
            try {
                String result = this.dispatchCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
                if (result != null) {
                    this.writer.writeLine(result);
                }


            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }
        }
    }

    @SuppressWarnings("unchecked")
    private String dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        command = String.valueOf(command.charAt(0)).toUpperCase() + command.substring(1);
        this.params = tokens;
        Class<Executable> commandClass = (Class<Executable>) Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Executable executable = commandClass.newInstance();
        injectDependencies(executable);
        return executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getSuperclass().getDeclaredFields();

        for (Field field : fields) {
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
}
