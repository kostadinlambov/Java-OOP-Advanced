package p10_Tuple;

public class TupleImpl<T, E> implements Tuple<T, E> {
    private T firstObject;
    private E secondObject;

    public TupleImpl(T firstObject, E secondObject) {
        this.setFirstObject(firstObject);
        this.setSecondObject(secondObject);
    }

    @Override
    public T getFirstObject() {
        return this.firstObject;
    }

    private void setFirstObject(T firstObject) {
        this.firstObject = firstObject;
    }

    @Override
    public E getSecondObject() {
        return this.secondObject;
    }

    private void setSecondObject(E secondObject) {
        this.secondObject = secondObject;
    }

    @Override
    public String toString() {
        return this.getFirstObject() + " -> " + this.getSecondObject();
    }
}
