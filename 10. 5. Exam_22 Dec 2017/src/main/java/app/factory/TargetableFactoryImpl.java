package app.factory;

import app.contracts.Targetable;
import app.contracts.TargetableFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TargetableFactoryImpl implements TargetableFactory {
    private static final String PARTICIPANT_CLASS_PATH = "app.models.participants.";

    public Targetable create(String name, String className) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> participantClass = Class.forName(PARTICIPANT_CLASS_PATH + className);
        Constructor<?> declaredConstructor = participantClass.getDeclaredConstructor();
        Targetable targetable = (Targetable) declaredConstructor.newInstance();
        targetable.setName(name);

        return targetable;
    }
}
