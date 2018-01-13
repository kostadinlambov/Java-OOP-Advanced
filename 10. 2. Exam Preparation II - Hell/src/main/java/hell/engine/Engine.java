package hell.engine;

import hell.entities.miscellaneous.ItemCollection;
import hell.interfaces.Executable;
import hell.interfaces.InputReader;
import hell.interfaces.OutputWriter;
import hell.repositories.Repository;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Engine implements Runnable {
    private static final String TERMINATE_COMMAND = "Quit";
    private static final String COMMAND_CLASS_PATH = "hell.commands.";
    private static final String COMMAND_CLASS_NAME_SUFFIX = "Command";

    private List<String> params;
    InputReader reader;
    OutputWriter writer;
    Repository repository;


    public Engine(InputReader reader, OutputWriter writer, Repository repository) {
        this.reader = reader;
        this.writer = writer;
        this.repository = repository;
    }

    @Override
    public void run() {
        while (true) {
            List<String> tokens = new ArrayList<>(Arrays.asList(this.reader.readLine().split("\\s+")));
            try {
                this.dispatchCommand(tokens.get(0), tokens.stream().skip(1).collect(Collectors.toList()));
            } catch (ClassNotFoundException | IllegalAccessException | InstantiationException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }

            if (TERMINATE_COMMAND.equals(tokens.get(0))) {
                break;
            }
        }
    }

    private void dispatchCommand(String command, List<String> tokens) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        this.params = tokens;

        Class<?> commandClass = Class.forName(COMMAND_CLASS_PATH + command + COMMAND_CLASS_NAME_SUFFIX);
        Executable executable = (Executable) commandClass.newInstance();
        injectDependencies(executable);
        executable.execute();
    }

    private void injectDependencies(Executable executable) throws IllegalAccessException {
        Field[] fields = executable.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(ItemCollection.class)) {
                Field[] currentFields = this.getClass().getDeclaredFields();
                for (Field currentField : currentFields) {
                    if(field.getType().equals(currentField.getType())){
                        field.setAccessible(true);
                        field.set(executable, currentField.get(this));
                    }
                }
            }
        }
    }
}

