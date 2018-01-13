package hell.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Executable {
    void execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;
}
