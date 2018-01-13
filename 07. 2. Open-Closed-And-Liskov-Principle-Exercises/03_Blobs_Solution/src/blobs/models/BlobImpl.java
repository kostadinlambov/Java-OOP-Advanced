package blobs.models;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.interfaces.Blob;
import blobs.interfaces.Observer;

import java.util.HashMap;
import java.util.Map;

public class BlobImpl implements Blob {
    private static final String DEAD_BLOB_OBSERVER_NAME = "DeadBlobObserver";
    private static final String TOGGLES_BEHAVIOR_OBSERVER_NAME = "TogglesBehaviorObserver";

    private String name;
    private int currentHealth;
    private int damage;
    private Behavior behavior;
    private Attack attack;
    private int triggerCount;
    private Map<String, Observer> observers;
    private int initialHealth;

    public BlobImpl(String name, int health, int damage, Behavior behavior, Attack attack) {
        this.name = name;
        this.currentHealth = health;
        this.damage = damage;
        this.behavior = behavior;
        this.attack = attack;
        this.observers = new HashMap<>();
        this.initialHealth = health;
    }

    @Override
    public int getHealth() {
        return this.currentHealth;
    }

    @Override
    public void setHealth(int health) {
        this.currentHealth = health;

        if (this.currentHealth < 0) {
            this.currentHealth = 0;

            if (this.behavior.isTriggered() && this.observers.containsKey(DEAD_BLOB_OBSERVER_NAME)) {
                this.observers.get(DEAD_BLOB_OBSERVER_NAME).update();
            }
        }

        if (this.currentHealth <= this.initialHealth / 2 && !this.behavior.isTriggered()) {
            this.triggerBehavior();
        }
    }

    @Override
    public int getDamage() {
        return this.damage;
    }

    public void setDamage(int currentDamage) {
        this.damage = currentDamage;
    }

    @Override
    public Behavior getBehavior() {
        return this.behavior;
    }

    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public void attack(Blob target) {
        this.attack.execute(this, target);
    }

    @Override
    public void update() {
        if (this.behavior.isTriggered()) {
            this.triggerCount++;
            if (this.triggerCount > 1) {
                this.behavior.applyRecurrentEffect(this);
            }
        }
    }

    @Override
    public void attach(Observer observer){
        observers.putIfAbsent(observer.getClass().getSimpleName(), observer);
    }

    @Override
    public String toString() {
        if (this.getHealth() <= 0) {
            return String.format("Blob %s KILLED", this.getName());
        }

        return String.format("Blob %s: %s HP, %s Damage", this.getName(), this.getHealth(), this.getDamage());
    }

    private void triggerBehavior() {
        if (this.observers.containsKey(TOGGLES_BEHAVIOR_OBSERVER_NAME)) {
            this.observers.get(TOGGLES_BEHAVIOR_OBSERVER_NAME).update();
        }
        this.behavior.trigger(this);
    }
}