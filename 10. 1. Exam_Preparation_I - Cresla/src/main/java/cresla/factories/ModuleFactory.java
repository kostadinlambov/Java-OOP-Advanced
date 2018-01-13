package cresla.factories;


import cresla.interfaces.Module;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class ModuleFactory {

    private static final String MODULE_PACKAGE_NAME = "cresla.entities.modules.";
   // private static final String REACTOR_NAME_SUFFIX = "Reactor";

    private ModuleFactory() {
    }

    public static Module createModule(int id, int additionalParameter, String moduleType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> moduleClass = Class.forName(MODULE_PACKAGE_NAME + moduleType);
        Constructor<?> moduleConstructor = moduleClass.getDeclaredConstructor(int.class, int.class);
        Module module = (Module) moduleConstructor.newInstance(id, additionalParameter);
        return module;
    }
}
