package p05_Kings_Gambit_Extended.factories;

import p05_Kings_Gambit_Extended.interfaces.Warrior;
import p05_Kings_Gambit_Extended.interfaces.WarriorFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WarriorFactoryImpl implements WarriorFactory {

    private static  final String WARRIORS_PACKAGE_NAME =
            "p05_Kings_Gambit_Extended.warriors.";

    @Override
    public Warrior createWarrior(String warriorType, String name) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> warriorClass = Class.forName(WARRIORS_PACKAGE_NAME + warriorType);
        Constructor<?> warriorConstructor = warriorClass.getDeclaredConstructor(String.class);
        Warrior warrior = (Warrior) warriorConstructor.newInstance(name);
      //  Warrior warrior = (Warrior) warriorClass.newInstance();
        return warrior;
    }
}
