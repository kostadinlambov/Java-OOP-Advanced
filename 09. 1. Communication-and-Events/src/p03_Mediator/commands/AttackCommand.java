package p03_Mediator.commands;

import p03_Mediator.interfaces.Attacker;
import p03_Mediator.interfaces.Command;

public class AttackCommand implements Command {

   private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        attacker.attack();
    }
}
