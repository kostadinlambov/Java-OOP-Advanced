package cresla.entities.reactors;

import cresla.entities.containers.ModuleContainer;
import cresla.interfaces.*;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.LinkedList;

public abstract class BaseReactor implements Reactor {

    private static final String CONTAINERS_PACKAGE_NAME = "cresla.entities.containers.";
    private static final String CONTAINER_TYPE_CLASS_NAME = "ModuleContainer";


    private int id;
    private Container container;

    protected BaseReactor(int id, Container container) {
        this.id = id;
        this.container = container;
    }

    protected Container getContainer() {
        return this.container;
    }

    @Override
    public abstract long getTotalEnergyOutput();

    @Override
    public abstract long getTotalHeatAbsorbing();

    @Override
    public void addEnergyModule(EnergyModule energyModule) {
        this.container.addEnergyModule(energyModule);
    }

    @Override
    public void addAbsorbingModule(AbsorbingModule absorbingModule) {
        this.container.addAbsorbingModule(absorbingModule);
    }

    @Override
    public int getId() {
        return this.id;
    }

    @SuppressWarnings("unchecked")
    @Override()
    public int getModuleCount() throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException,
            IllegalAccessException, InvocationTargetException, InstantiationException {
//        Class<?> moduleContainerClass = Class.forName(CONTAINERS_PACKAGE_NAME + CONTAINER_TYPE_CLASS_NAME);
        Class<?> moduleContainerClass = ModuleContainer.class;

//        Constructor constructor = moduleContainerClass.getDeclaredConstructor();
//        ModuleContainer moduleContainer = (ModuleContainer) constructor.newInstance();
      //  Field modulesByInputField = moduleContainerClass.getDeclaredField("modulesByInput");

        Field modulesByInputField = moduleContainerClass.getDeclaredFields()[1];
        modulesByInputField.setAccessible(true);
        LinkedList<Module> modulesByInput = (LinkedList<Module>) modulesByInputField.get(this.container);
        int moduleCount = modulesByInput.size();
        return moduleCount;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("%s - %d", this.getClass().getSimpleName(), this.getId())).append(System.lineSeparator());
        if (this.getTotalEnergyOutput() > this.getTotalHeatAbsorbing()) {
            sb.append(String.format("Energy Output: %d", 0)).append(System.lineSeparator());
        } else {
            sb.append(String.format("Energy Output: %d", this.getTotalEnergyOutput())).append(System.lineSeparator());
        }
        sb.append(String.format("Heat Absorbing: %d", this.getTotalHeatAbsorbing())).append(System.lineSeparator());
        try {
            sb.append(String.format("Modules: %d", this.getModuleCount())).append(System.lineSeparator());
        } catch (ClassNotFoundException | NoSuchFieldException
                | IllegalAccessException | NoSuchMethodException
                | InvocationTargetException | InstantiationException e) {
            e.printStackTrace();
        }

        return sb.toString().trim();
    }
}
