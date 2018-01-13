package cresla.entities.reactors;

import cresla.interfaces.AbsorbingModule;
import cresla.interfaces.Container;

public class HeatReactor extends BaseReactor {

    private int heatReductionIndex;

    public HeatReactor(int id, Container container, int heatReductionIndex) {
        super(id, container);
        this.heatReductionIndex = heatReductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getContainer().getTotalEnergyOutput();

        if (result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }


    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing() + this.heatReductionIndex;
    }


    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        super.addAbsorbingModule(absorbingModule);
    }

    
}
