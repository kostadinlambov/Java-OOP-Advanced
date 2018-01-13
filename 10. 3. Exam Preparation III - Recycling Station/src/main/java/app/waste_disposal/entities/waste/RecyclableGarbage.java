package app.waste_disposal.entities.waste;

import app.waste_disposal.annotations.RecyclableGarbageStrategyAnnotation;

@RecyclableGarbageStrategyAnnotation
public class RecyclableGarbage extends BaseWaste {


    public RecyclableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
