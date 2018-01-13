package P01_ExtendedArrayList;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.BiFunction;

public class ExtendedArrayListImpl<T extends Comparable<T>> extends ArrayList<T> implements ExtendedArrayList<T> {


    @Override
    public T min() {
        BiFunction<T, T, Boolean> function = (t, t2) -> t.compareTo(t2) > 0;
        return getMaxOrMin(function);
    }

    @Override
    public T max() {
        BiFunction<T, T, Boolean> function = (t, t2) -> t.compareTo(t2) < 0;
        return getMaxOrMin(function);
    }

    private T getMaxOrMin(BiFunction<T, T, Boolean> function) {
        T maxOrMin = null;
        Iterator<T> iterator = super.iterator();
        while (iterator.hasNext()) {
            T nextElement = iterator.next();
            if (maxOrMin == null || function.apply(maxOrMin, nextElement)) {
                maxOrMin = nextElement;
            }
        }
        return maxOrMin;
    }

    public static void main(String[] args) {
        ExtendedArrayList<Integer> numbers = new ExtendedArrayListImpl<>();
        numbers.add(100);
        numbers.add(1000);
        numbers.add(-100);
        numbers.add(101);

        System.out.println("max: " + numbers.max());
        System.out.println("min: " + numbers.min());
    }
}
