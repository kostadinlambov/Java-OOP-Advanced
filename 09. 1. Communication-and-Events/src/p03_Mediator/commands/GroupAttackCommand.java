package p03_Mediator.commands;

import p03_Mediator.interfaces.AttackGroup;
import p03_Mediator.interfaces.Command;

public class GroupAttackCommand implements Command{

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupAttack();
    }
}
