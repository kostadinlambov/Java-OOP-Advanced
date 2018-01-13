package p13_Create_Custom_Class_Annotation.entities.interfaces;

public interface Weapon extends Comparable<Weapon>{

    double getLevel();

    void addGem(int socketIndex, String gemType);

    void removeGem(int socketIndex);

    String additionalPrint();
}
