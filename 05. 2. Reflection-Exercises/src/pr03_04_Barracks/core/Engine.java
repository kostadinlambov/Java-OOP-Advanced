package pr03_04_Barracks.core;

import pr03_04_Barracks.contracts.*;
import pr03_04_Barracks.contracts.Runnable;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.InvocationTargetException;

public class Engine implements Runnable {

    private Repository repository;
    private UnitFactory unitFactory;
    private CommandInterpreter interpreter;

    public Engine(Repository repository, UnitFactory unitFactory, CommandInterpreter interpreter) {
        this.repository = repository;
        this.unitFactory = unitFactory;
        this.interpreter = interpreter;
    }

    @Override
    public void run() {
        BufferedReader reader = new BufferedReader(
                new InputStreamReader(System.in));
        while (true) {
            try {
                String input = reader.readLine();
                if ("fight".equals(input)) {
                    break;
                }
                String[] data = input.split("\\s+");
                String commandName = data[0];
                Executable command = this.interpreter.interpretCommand(data, commandName);
                String result = command.execute();

                System.out.println(result);
            } catch (RuntimeException e) {
                System.out.println(e.getMessage());
            } catch (IOException | IllegalAccessException | InstantiationException | ClassNotFoundException | NoSuchMethodException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }

//    // TODO: refactor for problem 4
//    private String interpredCommand(String[] data, String commandName) throws IllegalAccessException,
//            ClassNotFoundException, InstantiationException, NoSuchMethodException, InvocationTargetException {
//        String result;
//        switch (commandName) {
//            case "add":
//                result = this.addUnitCommand(data);
//                break;
//            case "report":
//                result = this.reportCommand(data);
//                break;
//            case "fight":
//                result = this.fightCommand(data);
//                break;
//            default:
//                throw new RuntimeException("Invalid command!");
//        }
//        return result;
//    }
//
//    private String reportCommand(String[] data) {
//        String output = this.repository.getStatistics();
//        return output;
//    }
//
//    private String addUnitCommand(String[] data) throws IllegalAccessException, InstantiationException, ClassNotFoundException, NoSuchMethodException, InvocationTargetException {
//        String unitType = data[1];
//        Unit unitToAdd = this.unitFactory.createUnit(unitType);
//        this.repository.addUnit(unitToAdd);
//        String output = unitType + " added!";
//        return output;
//    }
//
//    private String fightCommand(String[] data) {
//        return "fight";
//    }
}
