package panzer.models.vehicles;

import panzer.contracts.*;
import panzer.models.parts.ArsenalPart;
import panzer.models.parts.EndurancePart;
import panzer.models.parts.ShellPart;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public abstract class BaseVehicle implements Vehicle {

    private String model;
    private double weight;
    private BigDecimal price;
    private int attack;
    private int defense;
    private int hitPoints;
    private Assembler vehicleAssembler;

    protected BaseVehicle(String model, double weight, BigDecimal price, int attack,
                          int defense, int hitPoints, Assembler vehicleAssembler) {
        this.model = model;
        this.weight = weight;
        this.price = price;
        this.attack = attack;
        this.defense = defense;
        this.hitPoints = hitPoints;
        this.vehicleAssembler = vehicleAssembler;
    }

    @Override
    public double getTotalWeight() {
        return this.weight;
    }

    @Override
    public BigDecimal getTotalPrice() {
        return this.price;
    }

    @Override
    public long getTotalAttack() {
        return this.attack;
    }

    @Override
    public long getTotalDefense() {
        return this.defense;
    }

    @Override
    public long getTotalHitPoints() {
        return this.hitPoints;
    }


//    @Override
//    public long getTotalAttack() {
//        return this.attack;
//    }
//
//    @Override
//    public long getTotalDefense() {
//        return this.defense;
//    }
//
//    @Override
//    public long getTotalHitPoints() {
//        return this.hitPoints;
//    }

    @Override
    public void addArsenalPart(Part arsenalPart) {
        this.vehicleAssembler.addArsenalPart(arsenalPart);
    }

    @Override
    public void addShellPart(Part shellPart) {
        this.vehicleAssembler.addShellPart(shellPart);

    }

    @Override
    public void addEndurancePart(Part endurancePart) {
        this.vehicleAssembler.addEndurancePart(endurancePart);
    }

    @Override
    public Iterable<Part> getParts() throws NoSuchMethodException, NoSuchFieldException, IllegalAccessException {

        List<Part> partList = new ArrayList<>();

        Class<?> assemblerClass = vehicleAssembler.getClass();
        Constructor constructor = assemblerClass.getDeclaredConstructor();

        Field arsenalPartsField = assemblerClass.getDeclaredField("arsenalParts");
        Field shellPartsField = assemblerClass.getDeclaredField("shellParts");
        Field endurancePartsField = assemblerClass.getDeclaredField("enduranceParts");
        Field partListField = assemblerClass.getDeclaredField("partList");

        arsenalPartsField.setAccessible(true);
        shellPartsField.setAccessible(true);
        endurancePartsField.setAccessible(true);
        partListField.setAccessible(true);

        List<AttackModifyingPart> arsenalParts = (List<AttackModifyingPart>) arsenalPartsField.get(vehicleAssembler);
        List<DefenseModifyingPart> shellParts = (List<DefenseModifyingPart>) shellPartsField.get(vehicleAssembler);
        List<HitPointsModifyingPart> enduranceParts = (List<HitPointsModifyingPart>) endurancePartsField.get(vehicleAssembler);
        List<Part> partListSorted = (List<Part>) partListField.get(vehicleAssembler);

        partList.addAll(arsenalParts);
        partList.addAll(shellParts);
        partList.addAll(enduranceParts);

        return partListSorted;
    }


    private List<Part> getSortedParts() throws NoSuchFieldException, IllegalAccessException, NoSuchMethodException {
        List<Part> partList = new ArrayList<>();

        Class<?> assemblerClass = vehicleAssembler.getClass();
        Constructor constructor = assemblerClass.getDeclaredConstructor();

        Field partListField = assemblerClass.getDeclaredField("partList");


        partListField.setAccessible(true);

        List<Part> partListSorted = (List<Part>) partListField.get(vehicleAssembler);
        return partListSorted;

    }

    @Override
    public String getModel() {
        return this.model;
    }


    @Override
    public String toString() {

        DecimalFormat df = new DecimalFormat("#.###");
        StringBuilder sb = new StringBuilder();

        List<String> partsNames = new ArrayList<>();

        double totalWeight = 0L;
        BigDecimal totalPrice = new BigDecimal("0");
        long totalAttack = 0;
        long totalEndzrance = 0;
        long totalDefense = 0;
        totalPrice = totalPrice.add(getTotalPrice());
        totalWeight += getTotalWeight();
        totalAttack += getTotalAttack();
        totalEndzrance += getTotalHitPoints();
        totalDefense += getTotalDefense();
        try {
            for (Part part : this.getParts()) {
                totalWeight += part.getWeight();
                totalPrice = totalPrice.add(part.getPrice());
                if (part instanceof ArsenalPart) {
                    totalAttack += ((ArsenalPart) part).getAttackModifier();
                } else if (part instanceof EndurancePart) {
                    totalEndzrance += ((EndurancePart) part).getHitPointsModifier();
                } else if (part instanceof ShellPart) {
                    totalDefense += ((ShellPart) part).getDefenseModifier();
                }

            }
        } catch (NoSuchMethodException | NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }

        sb.append(String.format("%s - %s%n", this.getClass().getSimpleName(), this.model));
        sb.append(String.format("Total Weight: %.3f%n", totalWeight));
        sb.append(String.format("Total Price: %s%n", totalPrice.setScale(3, RoundingMode.HALF_UP )));
        sb.append(String.format("Attack: %d%n", totalAttack));
        sb.append(String.format("Defense: %d%n", totalDefense));
        sb.append(String.format("HitPoints: %d%n", totalEndzrance));

        try {
            if (getSortedParts().size() == 0) {
                sb.append("Parts: None");
            } else {
                for (Part part : this.getSortedParts()) {
                    partsNames.add(part.getModel());
                }

                String stringToPrint = "Parts: " + partsNames.toString().replaceAll("[\\[\\]]", "");
                sb.append(stringToPrint);

            }
            return sb.toString();
        } catch (NoSuchFieldException | IllegalAccessException | NoSuchMethodException e) {
            e.printStackTrace();
        }

        return null;
    }
}
