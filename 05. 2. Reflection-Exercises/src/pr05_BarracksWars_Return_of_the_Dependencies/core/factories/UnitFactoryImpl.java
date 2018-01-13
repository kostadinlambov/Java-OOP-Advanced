package pr05_BarracksWars_Return_of_the_Dependencies.core.factories;

import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Unit;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr05_BarracksWars_Return_of_the_Dependencies.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<?> unitConstructor = unitClass.getDeclaredConstructor();
        Unit unit = (Unit) unitConstructor.newInstance();
        //Unit unit = (Unit) unitClass.newInstance();
        return unit;
    }
}
