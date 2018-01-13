package app.models.participants;

import app.contracts.Hero;
import app.contracts.Special;
import app.contracts.Targetable;
import app.models.Config;

public abstract class AbstractHero implements Hero {

    private int strength;
    private int dexterity;
    private int intelligence;
    private int level;

    private double health;
    private String name;
    private boolean isAlive;
    private double gold;

    private Special special;

    protected AbstractHero(){
        this.setAlive(true);
        this.level = 1;
        this.setGold(Config.HERO_START_GOLD);
    }

    @Override
    public void giveReward(Targetable target){
        target.receiveReward(this.getGold());
        this.setGold(0);
    }

    @Override
    public void receiveReward(double reward){
        this.gold += reward;
    }

    @Override
    public void takeDamage(double damage) {
        this.setHealth(this.getHealth() - damage);
        if (this.getHealth() <= 0){
            this.setAlive(false);
        }
    }

    @Override
    public int getStrength() {
        return strength;
    }

    @Override
    public void setStrength(int strength) {
        int healthDifference = (strength - this.strength) * Config.HERO_HEALTH_MULTIPLIER;
        this.strength = strength;
        this.setHealth(this.getHealth() + healthDifference);
    }

    @Override
    public int getDexterity() {
        return dexterity;
    }

    @Override
    public void setDexterity(int dexterity) {
        this.dexterity = dexterity;
    }

    @Override
    public int getIntelligence() {
        return intelligence;
    }

    @Override
    public void setIntelligence(int intelligence) {
        this.intelligence = intelligence;
    }

    @Override
    public double getHealth() {
        return health;
    }

    @Override
    public void setHealth(double health) {
        if (health < 0) {
            health = 0;
        }

        if (health > this.getStrength() * Config.HERO_HEALTH_MULTIPLIER) {
            health = this.getStrength() * Config.HERO_HEALTH_MULTIPLIER;
        }

        this.health = health;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public double getGold() {
        return gold;
    }

    @Override
    public boolean isAlive() {
        return isAlive;
    }

    @Override
    public void levelUp() {
        this.setHealth(this.getStrength() * Config.HERO_HEALTH_MULTIPLIER);
        this.refreshSpecial();
        this.setStrength(this.getStrength() * 2);
        this.setDexterity(this.getDexterity() * 2);
        this.setIntelligence(this.getIntelligence() * 2);
        this.setLevel(this.getLevel() + 1);
    }

    @Override
    public void setSpecial(Special special) {
        this.special = special;
        this.special.setOwner(this);
    }

    @Override
    public Special getSpecial() {
        return this.special;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append(String.format("  Name: %s | Class: %s%n", this.getName(), this.getClass().getSimpleName()));
        sb.append(String.format("  Health: %.2f | Damage: %.2f%n", this.getHealth(), this.getDamage()));
        sb.append(String.format("  %d STR | %d DEX | %d INT | %.2f Gold", this.getStrength(), this.getDexterity(), this.getIntelligence(), this.getGold()));

        return sb.toString();
    }

    @Override
    public abstract double getDamage();

    @Override
    public abstract String attack(Targetable target);

    protected void updateSpecial() {
        Special special = this.getSpecial();
        if (special != null) {
            special.update();
        }
    }

    protected void refreshSpecial() {
        Special special = this.getSpecial();
        if (special != null) {
            special.refresh();
        }
    }

    private int getLevel() {
        return level;
    }

    private void setLevel(int level) {
        this.level = level;
    }

    private void setGold(double gold) {
        this.gold = gold;
    }

    private void setAlive(boolean condition){
        this.isAlive = condition;
    }
}
