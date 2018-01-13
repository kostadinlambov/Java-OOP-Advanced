package p06_Generic_Count_Method_Doubles;

import java.util.List;

public class BoxClass {

    public static <T extends Comparable<T> > int countMethod(List<T> listOfElements, T elementToCompare){

        int counter = 0;
        for (int i = 0; i < listOfElements.size(); i++) {
            if(listOfElements.get(i).compareTo(elementToCompare) > 0){
                counter++;
            }
        }
        return counter;
    }
}
