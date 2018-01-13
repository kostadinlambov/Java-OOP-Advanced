package p07_Food_Shortage;

public class Robot implements Birthday {
    private String model;
    private String id;

    public Robot(String model, String id) {
        this.model = model;
        this.id = id;
    }

    @Override
    public boolean checkYearOfBirth(String yearToCompare) {
        if (this.id.endsWith(yearToCompare)) {
            return true;
        }
        return false;
    }

    @Override
    public String getBirthday() {
        return null;
    }
}
