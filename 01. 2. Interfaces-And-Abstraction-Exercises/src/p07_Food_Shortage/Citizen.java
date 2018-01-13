package p07_Food_Shortage;

public class Citizen implements Birthday, Buyer {
    private String name;
    private String age;
    private String id;
    private String birthday;
    private int food;

    public Citizen(String name, String age, String id, String birthday) {
        this.name = name;
        this.age = age;
        this.id = id;
        this.birthday = birthday;
    }

    Citizen(String birthday) {
        this.birthday = birthday;
        this.food = 0;
    }

    @Override
    public boolean checkYearOfBirth(String yearToCompare) {
        if (this.birthday.endsWith(yearToCompare)) {
            return true;
        }
        return false;
    }

    @Override
    public String getBirthday() {
        return this.birthday;
    }

    @Override
    public void buyFood() {
       this.setFood(this.food += 10);
    }

    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public int getFood() {
        return this.food;
    }

    @Override
    public String getName() {
        return this.name;
    }
}
