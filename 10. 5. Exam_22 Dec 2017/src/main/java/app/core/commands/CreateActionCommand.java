package app.core.commands;

import app.core.BaseCommand;

public class CreateActionCommand extends BaseCommand {
    @Override
    public void execute() {
        super.getBattlefield().createAction(super.getParams().get(0), super.getParams().stream().skip(1).toArray(String[]::new));
    }
}
