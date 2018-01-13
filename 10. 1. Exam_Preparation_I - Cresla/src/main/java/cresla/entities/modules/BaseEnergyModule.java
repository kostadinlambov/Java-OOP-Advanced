package cresla.entities.modules;

import cresla.interfaces.EnergyModule;

public abstract class BaseEnergyModule extends BaseModule implements EnergyModule {

    private int energyOutput;

    protected BaseEnergyModule(int id, int energyOutput) {
        super(id);
        this.energyOutput = energyOutput;
    }

    @Override
    public int getEnergyOutput() {
        return this.energyOutput;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Module - %d", this.getClass().getSimpleName(),
                super.getId())).append(System.lineSeparator());
        sb.append(String.format("Energy Output: %d", this.getEnergyOutput()));

        return sb.toString().trim();
    }
}
