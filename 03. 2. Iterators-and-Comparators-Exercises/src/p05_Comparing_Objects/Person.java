package p05_Comparing_Objects;

public class Person implements Comparable<Person> {

    private String name;
    private int age;
    private String town;

    Person(String name, int age, String town) {
        this.setName(name);
        this.setAge(age);
        this.setTown(town);
    }

    private void setName(String name) {
        this.name = name;
    }

    private void setAge(int age) {
        this.age = age;
    }


    private void setTown(String town) {
        this.town = town;
    }

    @Override
    public int compareTo(Person person) {
        if (this.name.compareTo(person.name) == 0) {
            if (this.age == person.age) {
                return this.town.compareTo(person.town);
            } else if (this.age > person.age) {
                return 1;
            } else {
                return -1;
            }
        } else {
            return this.name.compareTo(person.name);
        }
    }
}
