package p03_Stack_Iterator;

import java.util.*;
import java.util.function.Consumer;

public class StackImpl<T> implements Stack<T> {

    private List<T> data;

    public StackImpl() {
        this.setData();
    }

    private void setData() {
        this.data = new ArrayList<>();
        //this.data = Arrays.asList(data);
    }

    @Override
    public void push(T... data) {
        this.data.addAll(Arrays.asList(data));
    }

    @Override
    public T pop() {
        if (data.size() == 0) {
            throw new UnsupportedOperationException("No elements");
        }
        return data.remove(data.size() - 1);
    }

//    public void forEach(Consumer<? super T> action) {
//        List<T> reversedCollection = new ArrayList<>();
//        for (int i = 0; i < this.data.size(); i++) {
//            T element = this.data.get(this.data.size() - 1 - i);
//            reversedCollection.add(element);
//        }
//
//        for (T t : reversedCollection) {
//            action.accept(t);
//        }
//    }

    public void forEach(Consumer<? super T> action) {
        Iterator<T> customIterator = new MyReversedStackIterator();
        while (customIterator.hasNext()) {
            action.accept(customIterator.next());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new MyStackIterator();
    }

    private final class MyReversedStackIterator implements Iterator<T> {
        private int index;

        MyReversedStackIterator() {
            this.index = data.size() - 1;
        }

        @Override
        public boolean hasNext() {
            return this.index >= 0;
        }

        @Override
        public T next() {
            return data.get(index--);
        }
    }

    private final class MyStackIterator implements Iterator<T> {

        private int index;

        MyStackIterator() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < data.size();
        }

        @Override
        public T next() {
            return data.get(this.index++);
        }
    }
}
