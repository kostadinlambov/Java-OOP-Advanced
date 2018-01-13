package p01_Jar_of_T;

import java.util.ArrayDeque;
import java.util.Deque;

public class Jar<T> {

    private  Deque<T> cotents;

    public Jar(){
        this.cotents = new ArrayDeque<>();
    }

    public void add(T element) {
        this.cotents.push(element);
    }

    public T remove(){
        return this.cotents.pop();
    }
}
