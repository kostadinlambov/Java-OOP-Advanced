package pr05_BarracksWars_Return_of_the_Dependencies.core.commands;

import pr05_BarracksWars_Return_of_the_Dependencies.annotations.Inject;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Executable;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Repository;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.UnitFactory;

public abstract class Command implements Executable {

    @Inject
    private String[] data;
    @Inject
    private Repository repository;
    @Inject
    private UnitFactory unitFactory;

    protected Command() {
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
