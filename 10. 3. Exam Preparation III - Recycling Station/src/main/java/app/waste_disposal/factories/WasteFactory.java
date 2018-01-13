package app.waste_disposal.factories;

import app.waste_disposal.contracts.Waste;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class WasteFactory {

    private static final String WASTE_FOLDER_PATH = "app.waste_disposal.entities.waste.";
    private static final String WASTE_CLASS_SUFFIX = "Garbage";

    private WasteFactory() {
    }

    public static Waste createWaste(String name, double weight, double volumePerKg, String wasteType) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> wasteClass = Class.forName(WASTE_FOLDER_PATH + wasteType + WASTE_CLASS_SUFFIX);
        Constructor constructor = wasteClass.getDeclaredConstructor(String.class, double.class, double.class);

        Waste waste = (Waste) constructor.newInstance(name, weight, volumePerKg);
        return waste;

    }
}
