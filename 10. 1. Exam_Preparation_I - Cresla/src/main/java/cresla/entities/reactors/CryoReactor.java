package cresla.entities.reactors;

import cresla.interfaces.Container;
import cresla.interfaces.EnergyModule;

public class CryoReactor extends BaseReactor {

    private int cryoProductionIndex;


    public CryoReactor(int id, Container container, int cryoProductionIndex) {
        super(id, container);
        this.cryoProductionIndex = cryoProductionIndex;
    }

    @Override
    public long getTotalEnergyOutput() {
        long result = super.getContainer().getTotalEnergyOutput() * this.cryoProductionIndex;
        if(result > this.getTotalHeatAbsorbing()) {
            result = 0;
        }
        return result;
    }

    @Override
    public long getTotalHeatAbsorbing() {
        return super.getContainer().getTotalHeatAbsorbing();
    }


    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        super.addEnergyModule(energyModule);
    }
}
