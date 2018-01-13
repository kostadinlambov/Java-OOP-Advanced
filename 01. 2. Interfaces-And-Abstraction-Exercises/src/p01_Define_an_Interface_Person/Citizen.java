package p01_Define_an_Interface_Person;

public class Citizen implements Person {

    private String name;
    private int age;

    public Citizen(String name, int age) {
        this.setName(name);
        this.setAge(age);
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
}
