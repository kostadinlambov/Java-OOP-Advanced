package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Warrior extends AbstractHero {

    public Warrior() {
        super.setStrength(Config.WARRIOR_BASE_STRENGTH);
        super.setDexterity(Config.WARRIOR_BASE_DEXTERITY);
        super.setIntelligence(Config.WARRIOR_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getStrength() * 2) + this.getDexterity();
    }

    @Override
    public void takeDamage(double damage) {
        super.updateSpecial();
        super.takeDamage(damage);
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        target.takeDamage(this.getDamage());

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }
}
