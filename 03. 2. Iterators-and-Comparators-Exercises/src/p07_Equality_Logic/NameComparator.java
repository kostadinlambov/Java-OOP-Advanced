package p07_Equality_Logic;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        if (firstPerson.getName().compareTo(secondPerson.getName())== 0) {
            return Integer.compare(firstPerson.getAge(), secondPerson.getAge());
        } else if(firstPerson.getName().compareTo(secondPerson.getName()) > 0){
            return 1;
        }else{
            return -1;
        }
    }
}
