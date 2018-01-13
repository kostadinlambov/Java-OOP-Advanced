package p02_Command.commands;

import p02_Command.interfaces.Attacker;
import p02_Command.interfaces.Command;

public class AttackCommand implements Command {

   private Attacker attacker;

    public AttackCommand(Attacker attacker) {
        this.attacker = attacker;
    }

    public void execute() {
        attacker.attack();
    }
}
