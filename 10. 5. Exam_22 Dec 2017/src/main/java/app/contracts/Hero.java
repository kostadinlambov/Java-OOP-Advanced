package app.contracts;

public interface Hero extends Targetable, Specialist {

    int getStrength();

    void setStrength(int strength);

    int getDexterity();

    void setDexterity(int dexterity);

    int getIntelligence();

    void setIntelligence(int intelligence);

}
