package panzer.factories;

import panzer.contracts.Part;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class PartFactory {

    private static final String PART_PACKAGE_NAME = "panzer.models.parts.";
    private static final String PART_SUFFIX = "Part";

    private PartFactory() {
    }


    public static Part createPart(String partType, String model, double weight,
                                  BigDecimal price, int additionalParameter) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Class<?> partClass = Class.forName(PART_PACKAGE_NAME + partType + PART_SUFFIX);
        Constructor constructor = partClass.getDeclaredConstructor(String.class, double.class, BigDecimal.class, int.class);

        Part part = (Part) constructor.newInstance(model, weight, price, additionalParameter);

        return part;
    }
}
