package panzer.factories;

import panzer.contracts.Assembler;
import panzer.contracts.Vehicle;
import panzer.models.miscellaneous.VehicleAssembler;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;

public final class VehicleFactory {

    private static final String VEHICLE_PACKAGE_NAME = "panzer.models.vehicles.";

    private VehicleFactory() {
    }


    public static Vehicle createVehicle(String vehicleType, String model, double weight,
                                        BigDecimal price, int attack, int defense, int hitPoints) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {

        Assembler vehicleAssembler = new VehicleAssembler();

        Class<?> vehicleClass = Class.forName(VEHICLE_PACKAGE_NAME + vehicleType);
        Constructor constructor = vehicleClass.getDeclaredConstructor(String.class, double.class, BigDecimal.class, int.class,
                int.class, int.class, Assembler.class);

        Vehicle vehicle = (Vehicle) constructor.newInstance(model, weight, price, attack,
                defense, hitPoints, vehicleAssembler);

        return vehicle;
    }
}
