package app.contracts;

import java.lang.reflect.InvocationTargetException;

public interface SpecialFactory {

    Special create(String specialName) throws
            ClassNotFoundException,
            IllegalAccessException,
            InstantiationException,
            NoSuchMethodException,
            InvocationTargetException;
}
