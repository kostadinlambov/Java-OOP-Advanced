package p02_Kings_Gambit.warriors;

import p02_Kings_Gambit.abstractClasses.WarriorAbstract;

public class King extends WarriorAbstract {

    public King(String name) {
        super(name);
    }

    @Override
    public void handle() {
        System.out.printf("King %s is under attack!%n", super.getName());

    }
}
