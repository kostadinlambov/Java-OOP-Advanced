package pr05_BarracksWars_Return_of_the_Dependencies.contracts;

import java.lang.reflect.InvocationTargetException;

public interface CommandInterpreter {

	Executable interpretCommand(String commandName) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
