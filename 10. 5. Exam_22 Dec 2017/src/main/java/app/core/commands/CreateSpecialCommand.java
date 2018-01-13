package app.core.commands;

import app.core.BaseCommand;

public class CreateSpecialCommand extends BaseCommand {
    @Override
    public void execute() {
        super.getBattlefield().createSpecial(super.getParams().get(0), super.getParams().get(1));
    }
}
