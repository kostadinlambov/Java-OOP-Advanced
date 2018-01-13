package panzer.controller;

import panzer.contracts.Manager;
import panzer.contracts.Part;
import panzer.contracts.Vehicle;
import panzer.core.PanzerBattleOperator;
import panzer.factories.PartFactory;
import panzer.factories.VehicleFactory;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;

import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ManagerImpl implements Manager {

    Map<String, Vehicle> vehicleMap;
    Map<String, Part> partMap;
    List<Part> partList;
    List<Vehicle> vehicleList;

    public ManagerImpl() {
        this.vehicleMap = new LinkedHashMap<>();
        this.partMap = new LinkedHashMap<>();
        this.partList = new ArrayList<>();
    }

    @Override
    public String addVehicle(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {


        String type = arguments.get(0);
        String model = arguments.get(1);
        double weight = Double.parseDouble(arguments.get(2));
        BigDecimal price = new BigDecimal(arguments.get(3));
        int attack = Integer.parseInt(arguments.get(4));
        int defense = Integer.parseInt(arguments.get(5));
        int hitPoints = Integer.parseInt(arguments.get(6));

        Vehicle vehicle = VehicleFactory.createVehicle(type, model, weight, price, attack, defense, hitPoints);

        vehicleMap.put(model, vehicle);
        vehicleList.add(vehicle);
        return String.format("Created %s Vehicle - %s", type, model);
    }

    @Override
    public String addPart(List<String> arguments) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

        // •	Part {vehicleModel} {partType} {model} {weight} {price} {additionalParameter}
        String vehicleModel = arguments.get(0);
        String partType = arguments.get(1);
        String model = arguments.get(2);
        double weight = Double.parseDouble(arguments.get(3));
        BigDecimal price = new BigDecimal(arguments.get(4));
        int additionalParameter = Integer.parseInt(arguments.get(5));

        Part part = PartFactory.createPart(partType, model, weight, price, additionalParameter);

        partList.add(part);

        if (part instanceof ArsenalPart) {
            this.vehicleMap.get(vehicleModel).addArsenalPart(part);
        } else if (part instanceof EndurancePart) {
            this.vehicleMap.get(vehicleModel).addEndurancePart(part);
        } else if (part instanceof ShellPart) {
            this.vehicleMap.get(vehicleModel).addShellPart(part);
        }

        return String.format("Added %s - %s to Vehicle - %s", partType, model, vehicleModel);
    }

    @Override
    public String inspect(List<String> arguments) {

        String model = arguments.get(0);

        StringBuilder sb = new StringBuilder();
        List<Part> partsToPrint = new ArrayList<>();
        if (vehicleMap.containsKey(model)) {
            Vehicle vehicle = vehicleMap.get(model);

            return vehicle.toString();

        } else {
            for (Part part : partList) {
                if ("model".equals(part.getModel())) {
                    return part.toString();
                }
            }

        }
        return null;
    }

    @Override
    public String battle(List<String> arguments) {

        String vehicle1Model = arguments.get(0);
        String vehicle2Model = arguments.get(1);


        Vehicle vehicle1 = vehicleMap.get(vehicle1Model);
        Vehicle vehicle2 = vehicleMap.get(vehicle2Model);


        PanzerBattleOperator panzerBattleOperator = new PanzerBattleOperator();
        String winnerModel = panzerBattleOperator.battle(vehicle1, vehicle2);

        String stringToPrint = String.format("%s versus %s -> %s Wins! Flawless Victory!",
                vehicle1.getModel(), vehicle2.getModel(), winnerModel);
        return stringToPrint;

    }

    @Override
    public String terminate(List<String> arguments) {
        StringBuilder sb = new StringBuilder();
        String stringToPrint = "Parts: " + this.vehicleList.toString().replaceAll("[\\[\\]]", "");
        sb.append(stringToPrint);
        for (Vehicle vehicle : vehicleMap.values()) {
            sb.append(vehicle.getModel());
        }
//        "Remaining Vehicles: {vehicle1Model}, {vehicle2Model}...\n" +
//                "Defeated Vehicles: {defeatedVehicle1Model}, {defeatedVehicle2Model}...\n" +
//                "Currently Used Parts: {countOfCurrentlyUsedParts}\n";

//        for (Part part : this.getSortedParts()) {
//            partsNames.add(part.getModel());
//        }
        return null;
    }
}
