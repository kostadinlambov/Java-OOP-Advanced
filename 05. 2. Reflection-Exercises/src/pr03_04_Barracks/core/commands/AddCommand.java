package pr03_04_Barracks.core.commands;

import pr03_04_Barracks.contracts.Repository;
import pr03_04_Barracks.contracts.Unit;
import pr03_04_Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class AddCommand extends Command {


    public AddCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String unitType = super.getData()[1];
        Unit unitToAdd = super.getUnitFactory().createUnit(unitType);
        super.getRepository().addUnit(unitToAdd);
        String output = unitType + " added!";
        return output;
    }
}
