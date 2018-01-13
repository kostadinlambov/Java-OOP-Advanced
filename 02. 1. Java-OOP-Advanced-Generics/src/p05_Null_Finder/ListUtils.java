package p05_Null_Finder;

import java.util.ArrayList;
import java.util.List;

public class ListUtils {

    public static <T extends Comparable<T>> T getMin(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T firstElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (firstElement.compareTo(list.get(i)) > 0) {
                firstElement = list.get(i);
            }
        }
        return firstElement;
    }

    public static <T extends Comparable<T>> T getMax(List<T> list) {
        if (list.isEmpty()) {
            throw new IllegalArgumentException();
        }

        T firstElement = list.get(0);
        for (int i = 1; i < list.size(); i++) {
            if (firstElement.compareTo(list.get(i)) < 0) {
                firstElement = list.get(i);
            }
        }
        return firstElement;
    }

    public static List<Integer> getNullIndices(List<?> list){
        List<Integer> nulls = new ArrayList<>();

        for (int i = 0; i < list.size(); i++) {
            if(list.get(i) == null){
                nulls.add(i);
            }
        }

        return nulls;
    }
}
