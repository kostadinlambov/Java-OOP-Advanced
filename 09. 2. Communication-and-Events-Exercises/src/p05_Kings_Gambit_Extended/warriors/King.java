package p05_Kings_Gambit_Extended.warriors;

import p05_Kings_Gambit_Extended.abstractClasses.WarriorAbstract;

public class King extends WarriorAbstract {

    public King(String name) {
        super(name);
    }

    @Override
    public void handle() {
        System.out.printf("King %s is under attack!%n", super.getName());
    }
}
