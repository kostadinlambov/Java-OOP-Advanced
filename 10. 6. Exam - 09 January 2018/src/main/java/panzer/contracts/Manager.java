package panzer.contracts;

import java.lang.reflect.InvocationTargetException;
import java.util.List;

public interface Manager {
    String addVehicle(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    String addPart(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException;

    String inspect(List<String> arguments);

    String battle(List<String> arguments);

    String terminate(List<String> arguments);
}
