package p05_Kings_Gambit_Extended.abstractClasses;

import p05_Kings_Gambit_Extended.interfaces.Warrior;

public abstract class WarriorAbstract implements Warrior {
    private String name;
    private int hitsCount;

    public WarriorAbstract(String name){
        this.name = name;
        this.hitsCount = 0;
    }

    @Override
    public int getHitsCount() {
        return this.hitsCount;
    }

    @Override
    public void setHitsCount(int hitsCount) {
        this.hitsCount = hitsCount;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void handle() {
    }
}
