package app.factory;

import app.contracts.Special;
import app.contracts.SpecialFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class SpecialFactoryImpl implements SpecialFactory {
    private static final String SPECIAL_CLASS_PATH = "app.models.specials.";

    public Special create(String specialName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> specialClass = Class.forName(SPECIAL_CLASS_PATH + specialName);
        Constructor<?> declaredConstructor = specialClass.getDeclaredConstructor();
        Special special = (Special) declaredConstructor.newInstance();

        return special;
    }
}
