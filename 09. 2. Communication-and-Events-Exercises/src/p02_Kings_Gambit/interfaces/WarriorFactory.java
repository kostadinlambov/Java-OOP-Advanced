package p02_Kings_Gambit.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface WarriorFactory {
    Warrior createWarrior(String warriorType, String name) throws ClassNotFoundException,
            NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;
}
