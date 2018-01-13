package p02_Kings_Gambit.abstractClasses;


import p02_Kings_Gambit.interfaces.Warrior;

public abstract class WarriorAbstract implements Warrior {
    private String name;

    public WarriorAbstract(String name){
        this.name = name;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void handle() {
    }
}
