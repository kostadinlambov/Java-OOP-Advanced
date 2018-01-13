package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Wizard extends AbstractHero {

    public Wizard() {
        super.setStrength(Config.WIZARD_BASE_STRENGTH);
        super.setDexterity(Config.WIZARD_BASE_DEXTERITY);
        super.setIntelligence(Config.WIZARD_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return (this.getIntelligence() * 5) + this.getDexterity();
    }

    @Override
    public String attack(Targetable target) {
        if (!this.isAlive()) {
            return this.getName() + " is dead! Cannot attack.";
        }

        if (!target.isAlive()){
            return target.getName() + " is dead! Cannot be attacked.";
        }

        super.updateSpecial();

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
