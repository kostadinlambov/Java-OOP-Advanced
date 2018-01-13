package p12_Inferno_Infinity_Command_Pattern.entities.enumerations;

public enum WeaponType {

    AXE(5, 10, 4),SWORD(4, 6, 3),KNIFE(3, 4, 2);

    private int minDamage;
    private int maxDamage;
    private int numberOfSockets;

    WeaponType(int minDamage, int maxDamage, int numberOfSockets) {
        this.minDamage = minDamage;
        this.maxDamage = maxDamage;
        this.numberOfSockets = numberOfSockets;
    }

    public int getMinDamage() {
        return this.minDamage;
    }

    public int getMaxDamage() {
        return this.maxDamage;
    }

    public int getNumberOfSockets() {
        return this.numberOfSockets;
    }
}
