package p05_Comparing_Objects;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        List<Person> personList = new ArrayList<>();

        while (true) {
            String[] tokens = reader.readLine().split("\\s+");

            if ("END".equalsIgnoreCase(tokens[0])) {
                break;
            }

            String name = tokens[0];
            int age = Integer.parseInt(tokens[1]);
            String town = tokens[2];

            Person person = new Person(name, age, town);
            personList.add(person);
        }


        int indexOfPerson = Integer.parseInt(reader.readLine()) - 1;

        Person personToCompare = personList.get(indexOfPerson);

        int countOfEqualPersons = 0;
        int countOfNotEqualPersons = 0;
        int totalNumberOfPeople = personList.size();

        for (Person person : personList) {
            if (person.compareTo(personToCompare) == 0) {
                countOfEqualPersons++;
            }else{
                countOfNotEqualPersons++;

            }
        }

        if (countOfEqualPersons > 1){
            System.out.printf("%d %d %d", countOfEqualPersons, countOfNotEqualPersons, totalNumberOfPeople);
        }else{
            System.out.println("No matches");
        }
    }
}
