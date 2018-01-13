package app.contracts;

import java.lang.reflect.InvocationTargetException;

public interface ActionFactory {
    Action create(String actionName) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException;
}
