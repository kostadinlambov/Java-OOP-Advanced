package p06_Mirror_Image;

import p06_Mirror_Image.interfaces.Wizard;

public class WizardImpl implements Wizard {
    private int id;
    private String name;
    private int magicalPower;
    boolean hasCastReflectionSpell;

    public WizardImpl(String name, int magicalPower) {
        this.name = name;
        this.magicalPower = magicalPower;
        this.id = 0;
        this.hasCastReflectionSpell = false;
    }

    @Override
    public boolean isHasCastReflectionSpell() {
        return this.hasCastReflectionSpell;
    }

    @Override
    public void setHasCastReflectionSpell(boolean hasCastReflectionSpell) {
        this.hasCastReflectionSpell = hasCastReflectionSpell;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public int getMagicalPower() {
        return this.magicalPower;
    }

    @Override
    public void setMagicalPower(int magicalPower) {
        this.magicalPower = magicalPower;
    }
}

