package cresla.interfaces;

import java.lang.reflect.InvocationTargetException;

public interface Reactor extends Identifiable {

    long getTotalEnergyOutput();

    long getTotalHeatAbsorbing();

    int getModuleCount() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException;

    void addEnergyModule(EnergyModule energyModule);

    void addAbsorbingModule(AbsorbingModule absorbingModule);
}
