package p14_Refactoring_Bonus.entities.interfaces;

public interface Weapon extends Comparable<Weapon>{

    double getLevel();

    void addGem(int socketIndex, String gemType);

    void removeGem(int socketIndex);

    String additionalPrint();
}
