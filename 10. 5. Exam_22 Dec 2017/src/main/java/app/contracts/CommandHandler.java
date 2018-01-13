package app.contracts;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface CommandHandler {

    void executeCommand(String command, List<String> params) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException;
}
