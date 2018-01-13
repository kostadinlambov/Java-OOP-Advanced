package pr03_04_Barracks.core.commands;

import pr03_04_Barracks.contracts.Executable;
import pr03_04_Barracks.contracts.Repository;
import pr03_04_Barracks.contracts.UnitFactory;

public abstract class Command implements Executable {

    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected Command(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    public String[] getData() {
        return this.data;
    }

    public Repository getRepository() {
        return this.repository;
    }

    public UnitFactory getUnitFactory() {
        return this.unitFactory;
    }
}
