package cresla.factories;

import cresla.interfaces.Container;
import cresla.interfaces.Reactor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public final class ReactorFactory {
    private static final String REACTOR_PACKAGE_NAME = "cresla.entities.reactors.";
    private static final String REACTOR_NAME_SUFFIX = "Reactor";


    private ReactorFactory() {
    }

    public static Reactor createReactor(String reactorType, int additionalParameter, Container container, int id) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> reactorClass = Class.forName(REACTOR_PACKAGE_NAME + reactorType + REACTOR_NAME_SUFFIX);
        Constructor<?> reactrorConstructor = reactorClass.getDeclaredConstructor(int.class, Container.class, int.class);
        Reactor reactor = (Reactor) reactrorConstructor.newInstance(id, container, additionalParameter);
        return reactor;
    }
}
