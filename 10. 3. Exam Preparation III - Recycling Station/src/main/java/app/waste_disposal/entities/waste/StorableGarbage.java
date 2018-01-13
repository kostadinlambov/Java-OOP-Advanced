package app.waste_disposal.entities.waste;

import app.waste_disposal.annotations.StorableGarbageStrategyAnnotation;


@StorableGarbageStrategyAnnotation
public class StorableGarbage extends BaseWaste {


    public StorableGarbage(String name, double weight, double volumePerKg) {
        super(name, weight, volumePerKg);
    }
}
