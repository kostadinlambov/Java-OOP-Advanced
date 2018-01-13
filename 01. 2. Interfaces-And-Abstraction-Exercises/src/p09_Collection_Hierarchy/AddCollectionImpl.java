package p09_Collection_Hierarchy;

import java.util.ArrayList;
import java.util.List;

public class AddCollectionImpl<T> implements AddCollection<T> {

    private List<T> elements;

    public AddCollectionImpl() {
        this.elements = new ArrayList<>();
    }

    @Override
    public int add(T element) {
        this.elements.add(element);
        return this.elements.size()-1;
    }
}
