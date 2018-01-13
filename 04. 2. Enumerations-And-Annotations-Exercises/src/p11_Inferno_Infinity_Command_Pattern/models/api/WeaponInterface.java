package p11_Inferno_Infinity_Command_Pattern.models.api;

public interface WeaponInterface<T> extends Comparable<T> {
    String getName();

    void addGem(String gemType, int index);

    void removeGem(int index);

    double getItemLevel();
}
