package pr03_04_Barracks.interpreters;

import pr03_04_Barracks.contracts.CommandInterpreter;
import pr03_04_Barracks.contracts.Executable;
import pr03_04_Barracks.contracts.Repository;
import pr03_04_Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class CommandInterpreterImpl implements CommandInterpreter {
    private static final String COMMANDS_PACKAGE_NAME =
            "pr03_04_Barracks.core.commands.";

    private static final String COMMNAD_SUFFIX = "Command";

    private Repository repository;
    private UnitFactory unitFactory;

    public CommandInterpreterImpl(Repository repository, UnitFactory unitFactory) {
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    @Override
    public Executable interpretCommand(String[] data, String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        String correctCommandName = String.valueOf(commandName.charAt(0)).toUpperCase() +
                commandName.substring(1);

        Class<?> commandClass;
        try {
            commandClass = Class.forName(COMMANDS_PACKAGE_NAME + correctCommandName + COMMNAD_SUFFIX);
        } catch (ClassNotFoundException cnfe) {
            throw new RuntimeException("Invalid command!");
        }

        Constructor<?> constructor = commandClass.getDeclaredConstructor(String[].class, Repository.class, UnitFactory.class);
        constructor.setAccessible(true);
        Executable command = (Executable) constructor.newInstance(data, this.repository, this. unitFactory);
        return command;
    }
}
