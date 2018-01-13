package pr03_04_Barracks.core.commands;

import pr03_04_Barracks.contracts.Executable;
import pr03_04_Barracks.contracts.Repository;
import pr03_04_Barracks.contracts.UnitFactory;

public abstract class BaseCommand implements Executable{
    private String[] data;
    private Repository repository;
    private UnitFactory unitFactory;

    protected BaseCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        this.data = data;
        this.repository = repository;
        this.unitFactory = unitFactory;
    }

    protected String[] getData() {
        return this.data;
    }

    protected Repository getRepository() {
        return this.repository;
    }

    protected UnitFactory getUnitFactory() {
        return this.unitFactory;
    }

}
