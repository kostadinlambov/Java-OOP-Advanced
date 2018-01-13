package p05_Border_Control;

public class Robot implements Identificatable {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public boolean detain(String digitToCompare) {
        if (this.id.endsWith(digitToCompare)) {
            return true;
        }
        return false;
    }

    @Override
    public String getId() {
        return this.id;
    }
}
