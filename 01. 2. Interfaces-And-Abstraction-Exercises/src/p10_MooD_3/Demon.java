package p10_MooD_3;

public class Demon extends BaseGameObject {

    private double energy;

    public Demon(String username,  int level, double energy) {
        super(username, level);
        this.energy = energy;
    }

    private double getEnergy() {
        return this.energy;
    }

    @Override
    public String getHashPassword() {
        return String.format("%s", super.getUsername().length() * 217);
    }


    private double calculateProduct() {
        return this.getEnergy() * super.getLevel();
    }

    @Override
    public int getLevel() {
        return super.getLevel();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(calculateProduct());
        return super.toString() + sb.toString();
    }
}
