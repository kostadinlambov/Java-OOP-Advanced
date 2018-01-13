package p07_Equality_Logic;


import sun.reflect.generics.tree.Tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        Set<Person> hashSetPersons = new HashSet<>();
        Set<Person> treeSetPersons = new TreeSet<>(new NameComparator());

        int numberOfPersons = Integer.parseInt(reader.readLine());

        for (int i = 0; i < numberOfPersons; i++) {

            String[] tokens = reader.readLine().split("\\s+");

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);

            Person person = new Person(name, age);

            hashSetPersons.add(person);
            treeSetPersons.add(person);
        }

        System.out.println(treeSetPersons.size());
        System.out.println(hashSetPersons.size());
    }
}
