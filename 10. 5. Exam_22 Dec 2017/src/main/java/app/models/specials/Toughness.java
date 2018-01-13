package app.models.specials;

import app.contracts.Hero;
import app.models.Config;

public class Toughness extends AbstractSpecial {

    public Toughness() {}

    @Override
    public void update() {
        Hero owner = super.getOwner();
        if (!super.isActive()) {
            if (owner.getHealth() <= (owner.getStrength() * Config.HERO_HEALTH_MULTIPLIER) / 2) {
                this.setActive(true);
                owner.setStrength(owner.getStrength() + owner.getIntelligence());
            }
        }

        if (super.isActive()) {
            if (owner.getHealth() > (owner.getStrength() * Config.HERO_HEALTH_MULTIPLIER) / 2) {
                this.setActive(false);
                owner.setStrength(owner.getStrength() - owner.getIntelligence());
            }
        }
    }

    @Override
    public void refresh() {
        if (super.isActive()) {
            super.getOwner().setStrength(super.getOwner().getStrength() - super.getOwner().getIntelligence());
            this.setActive(false);
        }
    }
}
