package p02_Kings_Gambit.warriors;

import p02_Kings_Gambit.abstractClasses.WarriorAbstract;

public class Footman extends WarriorAbstract {

    public Footman(String name) {
        super(name);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void handle() {
        System.out.printf("Footman %s is panicking!%n", super.getName());
    }
}
