package p08_Military_Elite.implementation;

import p08_Military_Elite.interfaces.Soldier;

public abstract class SoldierImpl implements Soldier {

    private int id;
    private String firstName;
    private String lastName;

    public SoldierImpl(int id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    @Override
    public String getFirstName() {
        return this.firstName;
    }
    @Override
    public String getLastName() {
        return this.lastName;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String toString() {
        return String.format("Name: %s %s Id: %d", this.getFirstName(), this.getLastName(), this.getId());
    }
}
