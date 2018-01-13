package p03_Mediator.commands;


import p03_Mediator.interfaces.Attacker;
import p03_Mediator.interfaces.Command;
import p03_Mediator.interfaces.Target;

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
