package pr03_04_Barracks.core.commands;

import pr03_04_Barracks.contracts.Repository;
import pr03_04_Barracks.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand extends Command {
    private static final String RETIRE_MESSAGE_FORMAT = "%s retired!";

    protected RetireCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        try{
            super.getRepository().removeUnit(super.getData()[1]);
        }catch(IllegalStateException ise){
            return ise.getMessage();
        }

        return String.format(RETIRE_MESSAGE_FORMAT, super.getData()[1]);
    }
}
