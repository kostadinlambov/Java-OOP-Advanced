package app.models.specials;

import app.contracts.Hero;
import app.contracts.Special;

public abstract class AbstractSpecial implements Special {

    private Hero owner;
    private boolean isActive;

    protected AbstractSpecial() {
        this.isActive = false;
    }

    @Override
    public void setOwner(Hero owner) {
        this.owner = owner;
    }

    protected void setActive(boolean active) {
        isActive = active;
    }

    protected Hero getOwner() {
        return this.owner;
    }

    protected boolean isActive() {
        return this.isActive;
    }
}
