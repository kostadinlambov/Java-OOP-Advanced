package app.models;

import app.interfaces.Attack;
import app.interfaces.Behavior;
import app.interfaces.Blob;
import app.models.attacks.PutridFart;
import app.models.behavors.Aggressive;

public class BlobImpl implements Blob {

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    //TODO: usage???
    //private int triggerCount;

    private int initialHealth;
    private int initialDamage;

    public BlobImpl(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;

        this.initialHealth = health;
        this.initialDamage = damage;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getInitialDamage() {
        return this.initialDamage;
    }


//    @Override
//    public void addHealth(int health) {
//        this.currentHealth += health;
//    }


//    @Override
//    public void removeHealth(int removeHealth) {
//        this.currentHealth -= removeHealth;
//    }

    @Override
    public int getHealth() {
        return this.currentHealth;
    }

    @Override
    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;
        }

        if (this.currentHealth <= this.initialHealth / 2) {
            this.triggerBehavior();
        }
    }


    @Override
    public int getDamage() {
        return this.damage;
    }

    @Override
    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

//    // TODO: usage??
//    public void attack(BlobImpl target) {
//        if (this.attack instanceof PutridFart) {
//            this.attackAffectTarget(this, target);
//        }
//    }

    @Override
    public void reduceHealthAfterAttack(int damage) {
        this.currentHealth -= damage;
        if(this.currentHealth <= (this.initialHealth / 2)){
            this.triggerBehavior();
        }
//        int currentHealth = this.getHealth();
//        currentHealth -= damage;
//        this.setHealth(currentHealth);
    }


    //TODO refactor this code
    private void triggerBehavior() {
        if (this.behavior.isTriggered()) {
            throw new IllegalStateException("It's already triggered");
        } else {
            this.behavior.trigger(this);
        }

    }

//    public Behavior getBehavior() {
//        return this.behavior;
//    }

//    public String getName() {
//        return this.name;
//    }
//
//    public void update() {
//        if (this.behavior.isTriggered()) {
//            if (this.behavior instanceof Aggressive) {
//                if (this.behavior.isTriggered()) {
//                    // ((Aggressive) this.behavior).setIsTriggered(true);
//                    this.applyAgressiveRecurrentEffect();
//                }
//            }
//        }
//    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.name);
        }

        return String.format("Blob %s: %s HP, %s Damage", this.name, this.getHealth(), this.getDamage());
    }

//    private void attackAffectSource(BlobImpl source) {
//        source.setHealth(source.getHealth() - source.getHealth() / 2);
//    }
//
//    private void attackAffectTarget(BlobImpl source, BlobImpl target) {
//        target.reduceHealthAfterAttack(source.getDamage() * 2);
//    }
//
//    private void applyAgressiveTriggerEffect() {
//        this.setDamage(this.getDamage() * 2);
//    }

//    private void applyAgressiveRecurrentEffect() {
//        if (((Aggressive) this.behavior).toDelayRecurrentEffect()) {
//            // ((Aggressive)this.behavior).setToDelayRecurrentEffect(false);
//        } else {
//            this.setDamage(this.getDamage() - 5);
//
//            if (this.getDamage() <= this.initialHealth) {
//                this.setDamage(this.initialDamage);
//            }
//        }
//    }
}
