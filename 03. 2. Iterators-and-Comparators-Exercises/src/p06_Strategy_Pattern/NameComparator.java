package p06_Strategy_Pattern;

import java.util.Comparator;

public class NameComparator implements Comparator<Person> {

    @Override
    public int compare(Person firstPerson, Person secondPerson) {
        if(firstPerson.getName().length() == secondPerson.getName().length()){
            char firstPersonFirstLetter = firstPerson.getName().toLowerCase().charAt(0);
            char secondPersonFirstLetter = secondPerson.getName().toLowerCase().charAt(0);
            if(firstPersonFirstLetter > secondPersonFirstLetter) {
                return 1;
            }else if(firstPersonFirstLetter < secondPersonFirstLetter){
                return -1;
            }else{
                return 0;
            }
        }else if(firstPerson.getName().length() > secondPerson.getName().length()){
            return 1;
        }else{
            return -1;
        }
    }
}
