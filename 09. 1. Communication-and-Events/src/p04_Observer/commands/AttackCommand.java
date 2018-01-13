package p04_Observer.commands;

import p04_Observer.interfaces.Attacker;
import p04_Observer.interfaces.Command;

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
