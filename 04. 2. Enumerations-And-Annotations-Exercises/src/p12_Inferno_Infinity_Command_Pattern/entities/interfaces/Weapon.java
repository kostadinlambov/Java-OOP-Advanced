package p12_Inferno_Infinity_Command_Pattern.entities.interfaces;

public interface Weapon extends Comparable<Weapon>{

    double getLevel();

    String getName();

    void addGem(int socketIndex, String gemType);

    void removeGem(int socketIndex);

    String additionalPrint();
}
