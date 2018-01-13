package p04_Say_Hello_Extend;

public class Chinese extends BasePerson implements Person{

    Chinese(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Djydjybydjy";
    }
}
