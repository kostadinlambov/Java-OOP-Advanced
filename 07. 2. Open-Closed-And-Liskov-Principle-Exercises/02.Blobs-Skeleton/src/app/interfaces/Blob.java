package app.interfaces;

public interface Blob {
    String getName();

    int getInitialDamage();

   // void addHealth(int health);

    int getHealth();

    int getDamage();

    void setDamage(int currentDamage);

    void setHealth(int health);

  //  void reduceHealthAfterAttack(int damage);

    //void removeHealth(int removeHealth);
}

