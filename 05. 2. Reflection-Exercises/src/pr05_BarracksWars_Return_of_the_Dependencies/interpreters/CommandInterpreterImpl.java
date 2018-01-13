package pr05_BarracksWars_Return_of_the_Dependencies.interpreters;

import pr05_BarracksWars_Return_of_the_Dependencies.contracts.CommandInterpreter;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Executable;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Repository;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME =
            "pr05_BarracksWars_Return_of_the_Dependencies.core.commands.";

    private static final String COMMAND_SUFFIX = "Command";


    @Override
    public Executable interpretCommand(String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String correctCommandName = String.valueOf(commandName.charAt(0)).toUpperCase() +
                commandName.substring(1);

        Class<?> commandClass;
        try {
            commandClass = Class.forName(COMMANDS_PACKAGE_NAME + correctCommandName + COMMAND_SUFFIX);
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Invalid command!");
        }

        Constructor<?> constructor = commandClass.getDeclaredConstructor();
        constructor.setAccessible(true);
        Executable command = (Executable) constructor.newInstance();
        return command;
    }
}
