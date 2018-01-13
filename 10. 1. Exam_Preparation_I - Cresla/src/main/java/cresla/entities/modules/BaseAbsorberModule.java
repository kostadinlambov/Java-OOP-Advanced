package cresla.entities.modules;

import cresla.interfaces.AbsorbingModule;

public abstract class BaseAbsorberModule extends BaseModule implements AbsorbingModule{

    private int heatAbsorbing ;

    protected BaseAbsorberModule(int id, int heatAbsorbing) {
        super(id);
        this.heatAbsorbing = heatAbsorbing;
    }

    @Override
    public int getHeatAbsorbing() {
        return this.heatAbsorbing;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(String.format("%s Module - %d", this.getClass().getSimpleName(),
                super.getId())).append(System.lineSeparator());
        sb.append(String.format("Heat Absorbing: %d", this.getHeatAbsorbing()));

        return sb.toString().trim();
    }
}
