package panzer;

import panzer.contracts.InputReader;
import panzer.contracts.Manager;
import panzer.contracts.OutputWriter;
import panzer.controller.ManagerImpl;
import panzer.io.Reader;
import panzer.io.Writer;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InstantiationException, IllegalAccessException, InvocationTargetException {

        InputReader reader = new Reader();
        OutputWriter writer = new Writer();
        Manager manager = new ManagerImpl();
        List<String> input = new ArrayList<>();

        whileLoop:
        while (true) {

            input = Arrays.asList(reader.readLine().split("\\s+"));
            String command = input.get(0);
            switch (command) {
                case "Vehicle":
                    writer.println(manager.addVehicle(input.stream().skip(1).collect(Collectors.toList())));
                    break;
                case "Part":
                    writer.println(manager.addPart(input.stream().skip(1).collect(Collectors.toList())));
                    break;
                case "Inspect":
                    writer.println(manager.inspect(input.stream().skip(1).collect(Collectors.toList())));
                    break;
                case "Battle":
                    writer.println(manager.battle(input.stream().skip(1).collect(Collectors.toList())));
                    break;
                default:
                    writer.println(manager.terminate(input));
                    break whileLoop;
            }
        }
    }
}
