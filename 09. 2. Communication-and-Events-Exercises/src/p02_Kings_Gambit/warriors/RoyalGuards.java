package p02_Kings_Gambit.warriors;

import p02_Kings_Gambit.abstractClasses.WarriorAbstract;

public class RoyalGuards  extends WarriorAbstract {

    public RoyalGuards(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void handle() {
        System.out.printf("Royal Guard %s is defending!%n", super.getName());
    }
}
