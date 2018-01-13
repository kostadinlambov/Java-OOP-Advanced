package p06_Strategy_Pattern;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> nameComparedTreeSet = new TreeSet<>(new NameComparator());
        Set<Person> ageComparedTreeSet = new TreeSet<>(new AgeComparator());

        int numberOfPersons = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfPersons; i++) {

            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            nameComparedTreeSet.add(person);
            ageComparedTreeSet.add(person);
        }

        for (Person person : nameComparedTreeSet) {
            System.out.println(person.getName() + " " + person.getAge());
        }

        for (Person person : ageComparedTreeSet) {
            System.out.println(person.getName() + " " + person.getAge());
        }
    }
}
