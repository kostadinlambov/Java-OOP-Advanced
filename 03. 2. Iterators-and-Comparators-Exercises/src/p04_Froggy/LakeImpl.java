package p04_Froggy;

import java.util.*;
import java.util.function.Consumer;

public class LakeImpl<T> implements Lake<T> {

    private List<T> inputData;

    LakeImpl() {
        this.setInputData();
    }

    private void setInputData() {
        this.inputData = new ArrayList<>();
    }

    @Override
    public void addElements(T... elements) {
        this.inputData.addAll(Arrays.asList(elements));
    }

    @Override
    public List<T> getInputData() {
        return Collections.unmodifiableList(this.inputData);
    }

    @Override
    public void sortElements() {
        List<T> sortedElements = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            if (i == 0) {
                Iterator<T> iterator = new Frog();
                int count = 0;
                while (iterator.hasNext()) {
                    if (count % 2 == 0) {
                        sortedElements.add(this.inputData.get(count));
                    }
                    iterator.next();
                    count++;
                }
            } else {
                Iterator<T> iterator = new Frog();
                int count = 0;
                while (iterator.hasNext()) {
                    if (count % 2 == 1) {
                        sortedElements.add(this.inputData.get(count));
                    }
                    iterator.next();
                    count++;
                }
            }
        }

        this.inputData = sortedElements;
    }

    @Override
    public void print() {
        System.out.println(String.join(", ", this.inputData.toString())
                .replaceAll("[\\[\\]]", ""));
    }

    @Override
    public void forEach(Consumer<? super T> action) {
        Iterator<T> customIterator = new Frog();
        while (customIterator.hasNext()) {
            action.accept(customIterator.next());
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new Frog();
    }

    private final class Frog implements Iterator<T> {
        private int index;

        public Frog() {
            this.index = 0;
        }

        @Override
        public boolean hasNext() {
            return this.index < inputData.size();
        }

        @Override
        public T next() {
            return inputData.get(this.index++);
        }
    }
}


