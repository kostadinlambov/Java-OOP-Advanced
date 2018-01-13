package app.models.participants;

import app.contracts.Targetable;
import app.models.Config;

public class Necromancer extends AbstractHero {

    public Necromancer() {
        super.setStrength(Config.NECROMANCER_BASE_STRENGTH);
        super.setDexterity(Config.NECROMANCER_BASE_DEXTERITY);
        super.setIntelligence(Config.NECROMANCER_BASE_INTELLIGENCE);
    }

    @Override
    public double getDamage() {
        return ((this.getIntelligence() * 2) + (this.getDexterity() * 2)) + this.getStrength() * 2;
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

        super.updateSpecial();

        String result = this.getName() + " attacked!";
        if (!target.isAlive()) {
            this.levelUp();
            target.giveReward(this);
            result += String.format(" %s has been slain by %s.", target.getName(), this.getName());
        }

        return result;
    }
}
