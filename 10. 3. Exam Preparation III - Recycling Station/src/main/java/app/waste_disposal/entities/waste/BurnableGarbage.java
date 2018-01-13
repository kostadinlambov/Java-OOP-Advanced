package app.waste_disposal.entities.waste;

import app.waste_disposal.annotations.BurnableGarbageStrategyAnnotation;

@BurnableGarbageStrategyAnnotation
public class BurnableGarbage extends BaseWaste {


    public BurnableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
