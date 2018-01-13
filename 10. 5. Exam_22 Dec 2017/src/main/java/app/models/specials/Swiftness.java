package app.models.specials;

import app.contracts.Hero;
import app.models.Config;

public class Swiftness extends AbstractSpecial {

    public Swiftness() {}

    @Override
    public void update() {
        Hero owner = super.getOwner();
        if (!super.isActive()) {
            if (owner.getHealth() >= (owner.getStrength() * Config.HERO_HEALTH_MULTIPLIER) / 2) {
                super.setActive(true);
                owner.setDexterity(owner.getDexterity() + owner.getIntelligence());
            }
        }

        if (super.isActive()) {
            if (owner.getHealth() < (owner.getStrength() * Config.HERO_HEALTH_MULTIPLIER) / 2) {
                this.setActive(false);
                owner.setDexterity(owner.getDexterity() - owner.getIntelligence());
            }
        }
    }

    @Override
    public void refresh() {
        if (super.isActive()) {
            super.getOwner().setDexterity(super.getOwner().getDexterity() - super.getOwner().getIntelligence());
            this.setActive(false);
        }
    }
}
