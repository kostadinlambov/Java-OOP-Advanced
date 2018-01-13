package p02_Generic_Box_of_Integer;

public class Generic_Class_Box<T> {

    private T value;

    public Generic_Class_Box(T value){
        this.value = value;
    }

    @Override
    public String toString(){
        return value.getClass().getCanonicalName()+": " + this.value;
    }
}
