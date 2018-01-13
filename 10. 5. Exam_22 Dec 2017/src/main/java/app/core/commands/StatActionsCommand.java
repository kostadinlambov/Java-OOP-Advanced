package app.core.commands;

import app.core.BaseCommand;

public class StatActionsCommand extends BaseCommand {
    @Override
    public void execute() {
        super.getBattlefield().reportActions();
    }
}
