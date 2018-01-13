package p05_Kings_Gambit_Extended.warriors;

import p05_Kings_Gambit_Extended.abstractClasses.WarriorAbstract;

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
