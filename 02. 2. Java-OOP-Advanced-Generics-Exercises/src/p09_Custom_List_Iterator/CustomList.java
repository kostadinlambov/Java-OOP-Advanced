package p09_Custom_List_Iterator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class CustomList<T extends Comparable<T>> implements Iterable<T> {

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
    }

    T getMin() {
        return Collections.min(this.listOfElements);
    }

    void sort() {
        this.listOfElements.sort(Comparable::compareTo);
    }

    @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();

        for (T element : listOfElements) {
            sb.append(element).append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    @Override
    public Iterator<T> iterator() {
        return this.listOfElements.iterator();
    }
}
