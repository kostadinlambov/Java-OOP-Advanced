package p10_Inferno_Infinity.entities.contracts;

public interface Weapon extends Comparable<Weapon>{

    double getLevel();

    void addGem(int socketIndex, String gemType);

    void removeGem(int socketIndex);

    String additionalPrint();
}
