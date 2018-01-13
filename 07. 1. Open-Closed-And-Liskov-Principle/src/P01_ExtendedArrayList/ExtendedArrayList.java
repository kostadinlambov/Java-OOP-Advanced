package P01_ExtendedArrayList;


import java.util.List;

public interface ExtendedArrayList<T> extends List<T> {

    T min();

    T max();
}
