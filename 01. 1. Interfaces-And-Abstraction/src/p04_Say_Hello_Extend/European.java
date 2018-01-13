package p04_Say_Hello_Extend;

public class European extends BasePerson implements Person{

    European(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Hello";
    }
}
