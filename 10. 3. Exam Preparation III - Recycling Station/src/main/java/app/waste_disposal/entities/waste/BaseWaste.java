package app.waste_disposal.entities.waste;

import app.waste_disposal.contracts.Waste;

public abstract class BaseWaste implements Waste {

    private String name;
    private double weight;
    private double volumePerKg;


    protected BaseWaste(String name, double weight, double volumePerKg) {
        this.name = name;
        this.weight = weight;
        this.volumePerKg = volumePerKg;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public double getVolumePerKg() {
        return this.volumePerKg;
    }

    @Override
    public double getWeight() {
        return this.weight;
    }


    @Override
    public String toString() {
        return String.format("%.2f kg of %s successfully processed!", this.weight, this.name);
    }
}
