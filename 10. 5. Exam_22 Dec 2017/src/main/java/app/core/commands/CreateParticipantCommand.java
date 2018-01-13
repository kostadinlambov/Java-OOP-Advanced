package app.core.commands;

import app.core.BaseCommand;

public class CreateParticipantCommand extends BaseCommand {
    @Override
    public void execute() {
        super.getBattlefield().createParticipant(super.getParams().get(0), super.getParams().get(1));
    }
}
