package p03_Mediator.commands;


import p03_Mediator.interfaces.AttackGroup;
import p03_Mediator.interfaces.Command;
import p03_Mediator.interfaces.Target;

public class GroupTargetCommand implements Command {

    private AttackGroup group;
    private Target target;

    public GroupTargetCommand(AttackGroup group, Target target) {
        this.group = group;
        this.target = target;
    }

    @Override
    public void execute() {
        this.group.groupTarget(this.target);
    }
}
