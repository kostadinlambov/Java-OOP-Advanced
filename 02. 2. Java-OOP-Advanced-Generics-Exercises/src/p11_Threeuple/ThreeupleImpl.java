package p11_Threeuple;

public class ThreeupleImpl<T, E, D> implements Threeuple<T, E, D> {

    private T firstObject;
    private E secondObject;
    private D thirdObject;

    public ThreeupleImpl(T firstObject, E secondObject, D thirdObject) {
        this.setFirstObject(firstObject);
        this.setSecondObject(secondObject);
        this.setThirdObject(thirdObject);
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
    public D getThirdObject() {
        return this.thirdObject;
    }

    private void setThirdObject(D thirdObject) {
        this.thirdObject = thirdObject;
    }

    @Override
    public String toString() {
        return this.getFirstObject() + " -> " + this.getSecondObject()
                + " -> " + this.getThirdObject();
    }
}
