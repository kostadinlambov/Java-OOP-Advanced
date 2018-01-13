package p04_Say_Hello_Extend;

public class Bulgarian extends BasePerson implements Person {

    Bulgarian(String name) {
        super(name);
    }

    @Override
    public String sayHello() {
        return "Здравей";
    }
}
