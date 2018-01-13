package p03_Stack_Iterator;

public interface Stack<T> extends Iterable<T>{
    void push(T... data);

    T pop();
}
