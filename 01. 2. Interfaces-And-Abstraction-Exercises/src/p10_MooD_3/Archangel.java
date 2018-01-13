package p10_MooD_3;

public class Archangel extends BaseGameObject {

    private int mana;

    public Archangel(String username, int level, int mana) {
        super(username, level);
        this.mana = mana;
    }

    public int getMana() {
        return this.mana;
    }

    private int calculateProduct() {
        return this.getMana() * super.getLevel();
    }

    @Override
    public String getHashPassword() {
        StringBuilder sb = new StringBuilder(super.getUsername()).reverse();
        String hashPassword = sb.append(super.getUsername().length() * 21).toString();
        return String.format("%s", hashPassword);
    }


    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(calculateProduct());
        return super.toString() + sb.toString();
    }
}
