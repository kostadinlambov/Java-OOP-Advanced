package pr03_04_Barracks.core.factories;

import pr03_04_Barracks.contracts.Unit;
import pr03_04_Barracks.contracts.UnitFactory;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class UnitFactoryImpl implements UnitFactory {

    private static final String UNITS_PACKAGE_NAME =
            "pr03_04_Barracks.models.units.";

    @Override
    public Unit createUnit(String unitType) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {

        Class<?> unitClass = Class.forName(UNITS_PACKAGE_NAME + unitType);
        Constructor<?> unitConstructor = unitClass.getDeclaredConstructor();
        Unit unit = (Unit) unitConstructor.newInstance();
        //Unit unit = (Unit) unitClass.newInstance();
        return unit;
    }
}
