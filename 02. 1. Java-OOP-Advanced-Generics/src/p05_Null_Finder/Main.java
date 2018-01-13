package p05_Null_Finder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Integer> ints = new ArrayList<>();
        Collections.addAll(ints, 1,2, null, 21, 12, null);

        System.out.println(ListUtils.getNullIndices(ints));
    }
}
