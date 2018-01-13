package p02_Generic_Array_Creator;

import java.lang.reflect.Array;

public class ArrayCreator {

    @SuppressWarnings("unchecked")
    public static <T> Object[] create(int length, T item) {
        //T[] array = (T[]) new Object[length];
        Object[] objects = new Object[length];

        for (int i = 0; i < objects.length; i++) {
            objects[i] = item;
        }
        return  objects;
    }

    @SuppressWarnings("unchecked")
    public static <T> T[] create(Class<T> cl, int length, T item) {
        T[] array = (T[]) Array.newInstance(cl, length);
        //Object[] objects = new Object[length];
        for (int i = 0; i < array.length; i++) {
            array[i] = item;
        }
        return array;
    }

}
