package app.waste_disposal.entities.strategies;

import app.waste_disposal.ProcessingDataImpl;
import app.waste_disposal.contracts.GarbageDisposalStrategy;
import app.waste_disposal.contracts.ProcessingData;
import app.waste_disposal.contracts.Waste;


public class StorableGarbageStrategy implements GarbageDisposalStrategy {

    @Override
    public ProcessingData processGarbage(Waste garbage) {
        double totalGarbageVolume = garbage.getWeight() * garbage.getVolumePerKg();

        double energyProduced = 0;
        double energyUsed = totalGarbageVolume * 0.13;
        double capitalEarned = 0;
        double capitalUsed = totalGarbageVolume * 0.65;

        double energyBalance = energyProduced - energyUsed;
        double capitalBalance = capitalEarned - capitalUsed;

        ProcessingData processingData = new ProcessingDataImpl(energyBalance,capitalBalance);

        return processingData;

    }
}
