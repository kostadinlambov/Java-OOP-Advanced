package p02_Collection;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class ListyIteratorImpl implements ListyIterator, Iterable {

    private List<String> collection;
    private int index;
   // private Iterator<String> currentIterator;

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

    @Override
    public void printAll() {
        if (this.collection.size() == 0) {
            throw new IllegalArgumentException("Invalid Operation!");
        }

        StringBuilder sb = new StringBuilder();

        for (String element : this.collection) {
            sb.append(element).append(" ");
        }

        System.out.println(sb.toString().trim());
    }


    @Override
    public Iterator iterator() {
        return new MyIterator();
    }

    @Override
    public void forEach(Consumer action) {
       // this.currentIterator = new MyIterator();
        while (iterator().hasNext()) {
            action.accept(this.iterator().next());
        }
    }

    private final class MyIterator implements Iterator {
        private int index;

        MyIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < collection.size();
        }

        @Override
        public String next() {
            return collection.get(index++);
        }
    }
}
