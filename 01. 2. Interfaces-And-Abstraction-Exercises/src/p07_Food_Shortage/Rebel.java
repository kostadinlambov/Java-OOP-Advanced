package p07_Food_Shortage;

public class Rebel implements  Buyer{

    private String name;
    private int age;
    private String group;
    private int food;

    public Rebel(String name, int age, String group) {
        this.name = name;
        this.age = age;
        this.group = group;
        this.food = 0;
    }

    private void setFood(int food) {
        this.food = food;
    }

    @Override
    public void buyFood() {
        this.setFood(this.food += 5);
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
