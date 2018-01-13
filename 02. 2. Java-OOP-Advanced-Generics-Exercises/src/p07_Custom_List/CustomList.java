package p07_Custom_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CustomList<T extends Comparable<T>> {

    private List<T> listOfElements;

    CustomList() {
        this.listOfElements = new ArrayList<>();
    }


    void add(T element) {
        this.listOfElements.add(element);
    }

    T remove(int index) {
        return this.listOfElements.remove(index);
    }

    boolean contains(T element) {
        return this.listOfElements.contains(element);
    }

    void swap(int firstIndex, int secondIndex) {
        T firstElement = this.listOfElements.get(firstIndex);
        T secondElement = this.listOfElements.get(secondIndex);
        this.listOfElements.set(secondIndex, firstElement);
        this.listOfElements.set(firstIndex, secondElement);
    }

    int countGreaterThan(T elementToCompare) {
        int counter = 0;
        for (T listOfElement : this.listOfElements) {
            if (listOfElement.compareTo(elementToCompare) > 0) {
                counter++;
            }
        }

        return counter;
    }

    T getMax() {
        return Collections.max(this.listOfElements);
//        T max = this.listOfElements.get(0);
//        for (int i = 1; i < this.listOfElements.size(); i++) {
//            if(max.compareTo(this.listOfElements.get(i)) < 0){
//                max = this.listOfElements.get(i);
//            }
//        }
//        return max;
    }


    T getMin() {
        return Collections.min(this.listOfElements);
//        T min = this.listOfElements.get(0);
//        for (int i = 1; i < this.listOfElements.size(); i++) {
//            if(min.compareTo(this.listOfElements.get(i)) > 0){
//                min = this.listOfElements.get(i);
//            }
//        }
//        return min;
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (T element : listOfElements) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

//    public void print(){
//        for (T element : listOfElements) {
//            System.out.println(element);
//        }
//    }
}
