package pr05_BarracksWars_Return_of_the_Dependencies.core.commands;

import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Repository;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.UnitFactory;

import java.lang.reflect.InvocationTargetException;

public class RetireCommand extends Command {
    private static final String RETIRE_MESSAGE_FORMAT = "%s retired!";


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
