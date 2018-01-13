package p07_Equality_Logic;

public class Person {

    private String name;
    private int age;

    Person(String name, int age) {
        this.setName(name);
        this.setAge(age);
    }

    public int hashCode() {
        return 37 * (this.age + this.name.length());
    }

    public boolean equals(Object obj) {
        Person person = (Person) obj;
        return this.age == person.age && this.name.equals(person.name);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }

    String getName() {
        return this.name;
    }

    int getAge() {
        return this.age;
    }
}
