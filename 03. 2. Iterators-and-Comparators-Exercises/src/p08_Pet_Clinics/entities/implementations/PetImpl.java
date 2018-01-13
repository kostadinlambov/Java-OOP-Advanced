package p08_Pet_Clinics.entities.implementations;

import p08_Pet_Clinics.entities.interfaces.Pet;

public class PetImpl implements Pet {

    private String name;
    private int age;
    private String kind;

    public PetImpl(String name, int age, String kind) {
        this.setName(name);
        this.setAge(age);
        this.setKind(kind);
    }

    @Override
    public String getName() {
        return this.name;
    }

    private void setName(String name) {
        this.name = name;
    }

    @Override
    public int getAge() {
        return this.age;
    }

    private void setAge(int age) {
        this.age = age;
    }

    @Override
    public String getKind() {
        return this.kind;
    }

    private void setKind(String kind) {
        this.kind = kind;
    }


    @Override
    public String toString() {
        return String.format("%s %d %s", this.getName(), this.getAge(),
                this.getKind());
    }
}
