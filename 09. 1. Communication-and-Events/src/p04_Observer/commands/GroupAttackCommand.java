package p04_Observer.commands;

import p04_Observer.interfaces.AttackGroup;
import p04_Observer.interfaces.Command;

public class GroupAttackCommand implements Command {

    private AttackGroup group;

    public GroupAttackCommand(AttackGroup group) {
        this.group = group;
    }

    @Override
    public void execute() {
        group.groupAttack();
    }
}
