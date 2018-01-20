package pr05_BarracksWars_Return_of_the_Dependencies.core;

import pr05_BarracksWars_Return_of_the_Dependencies.annotations.Inject;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.*;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.Runnable;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;
    private CommandInterpreter interpreter;

    public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter interpreter) {

        this.repository = repository;
        this.unitFactory = unitFactory;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                if ("fight".equals(input)) {
                    break;
                }
                String[] data = input.split("\\s+");
                String commandName = data[0];
                Executable command = this.interpreter.interpretCommand(commandName);
                //this.data = Arrays.stream(data).skip(1).toArray(String[]::new);
                this.data = data;
                this.injectDependencies(command);

                String result = command.execute();

                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

    private void injectDependencies(Executable command) throws IllegalAccessException {
        Field[] commandFields = command.getClass().getSuperclass()
                .getDeclaredFields();
        Field[] engineFields = this.getClass().getDeclaredFields();


        for (Field commandField : commandFields) {
            if(commandField.isAnnotationPresent(Inject.class)){
                for (Field engineFiled : engineFields) {
                    if(commandField.getType().equals(engineFiled.getType())
                    && commandField.getName().equals(engineFiled.getName())){
                        commandField.setAccessible(true);
                        engineFiled.setAccessible(true);
                        commandField.set(command, engineFiled.get(this));
                    }
                }
            }
        }

    }
}
