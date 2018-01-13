package pr03_04_Barracks.core.commands;

import pr03_04_Barracks.contracts.Repository;
import pr03_04_Barracks.contracts.UnitFactory;

public class ReportCommand extends Command {
    protected ReportCommand(String[] data, Repository repository, UnitFactory unitFactory) {
        super(data, repository, unitFactory);
    }

    @Override
    public String execute() {
        String output = super.getRepository().getStatistics();
        return output;
    }
}
