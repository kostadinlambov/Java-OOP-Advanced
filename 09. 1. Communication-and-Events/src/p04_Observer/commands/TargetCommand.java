package p04_Observer.commands;


import p04_Observer.interfaces.Attacker;
import p04_Observer.interfaces.Command;
import p04_Observer.interfaces.Target;

public class TargetCommand implements Command {
    private Attacker attacker;
    private Target target;

    public TargetCommand(Attacker attacker, Target target) {
        this.attacker = attacker;
        this.target = target;
    }

    @Override
    public void execute() {
        this.attacker.setTarget(this.target);
    }
}
