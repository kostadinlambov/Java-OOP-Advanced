package pr05_BarracksWars_Return_of_the_Dependencies.core.commands;

import pr05_BarracksWars_Return_of_the_Dependencies.contracts.Repository;
import pr05_BarracksWars_Return_of_the_Dependencies.contracts.UnitFactory;

public class ReportCommand extends Command {

    @Override
    public String execute() {
        String output = super.getRepository().getStatistics();
        return output;
    }
}
