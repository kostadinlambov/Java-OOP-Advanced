package p06_Strategy_Pattern;

public class Person{

    private String name;
    private int age;

    Person(String name, int age) {
        this.setName(name);
        this.setAge(age);

    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return this.name;
    }

    public int getAge() {
        return this.age;
    }
}
