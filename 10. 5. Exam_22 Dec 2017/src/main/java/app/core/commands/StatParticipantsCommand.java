package app.core.commands;

import app.core.BaseCommand;

public class StatParticipantsCommand extends BaseCommand {
    @Override
    public void execute() {
        super.getBattlefield().reportParticipants();
    }
}
