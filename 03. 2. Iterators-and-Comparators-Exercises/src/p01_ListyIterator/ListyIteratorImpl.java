package p01_ListyIterator;

import java.util.Arrays;
import java.util.List;

public class ListyIteratorImpl implements ListyIterator {

    private List<String> collection;
    private int index;

    ListyIteratorImpl(String... collection) {
        this.setCollection(collection);
        this.index = 0;
    }

    private void setCollection(String... collection) {
        this.collection = Arrays.asList(collection);
    }

    @Override
    public boolean move() {
        if (this.index < this.collection.size() - 1) {
            this.index++;
            return true;
        }
        return false;
    }

    @Override
    public boolean hasNext() {
        if (this.index < this.collection.size() - 1) {
            return true;
        }
        return false;
    }

    @Override
    public void print() {
        if (this.collection.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }
        System.out.println(collection.get(this.index));
    }
}
