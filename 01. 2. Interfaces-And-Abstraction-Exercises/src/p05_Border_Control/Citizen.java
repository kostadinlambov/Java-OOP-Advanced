package p05_Border_Control;

public class Citizen implements Identificatable {
    private String name;
    private String age;
    private String id;

    public Citizen(String name, String age, String id) {
        this.name = name;
        this.age = age;
        this.id = id;
    }

    @Override
    public boolean detain(String digitToCompare) {

        if (id.endsWith(digitToCompare)) {
            return true;
        }

        return false;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
