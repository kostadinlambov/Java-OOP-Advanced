package p04_Froggy;

import java.util.List;

public interface Lake<T> extends Iterable<T> {

    void addElements(T... elements);

    List<T> getInputData();

    void sortElements();

    void print();
}
