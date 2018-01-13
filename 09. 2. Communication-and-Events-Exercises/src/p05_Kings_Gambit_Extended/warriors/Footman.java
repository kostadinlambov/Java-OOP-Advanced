package p05_Kings_Gambit_Extended.warriors;

import p05_Kings_Gambit_Extended.abstractClasses.WarriorAbstract;

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
