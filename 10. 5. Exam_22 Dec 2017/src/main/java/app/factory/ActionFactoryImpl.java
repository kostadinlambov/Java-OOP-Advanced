package app.factory;

import app.contracts.Action;
import app.contracts.ActionFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ActionFactoryImpl implements ActionFactory {
    private static final String ACTION_CLASS_PATH = "app.models.actions.";

    public Action create(String actionName) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> actionClass = Class.forName(ACTION_CLASS_PATH + actionName);
        Constructor<?> declaredConstructor = actionClass.getDeclaredConstructor();
        Action action = (Action) declaredConstructor.newInstance();

        return action;
    }
}
