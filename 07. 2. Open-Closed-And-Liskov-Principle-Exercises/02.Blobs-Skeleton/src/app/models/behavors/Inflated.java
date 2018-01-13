package app.models.behavors;

import app.interfaces.Blob;

public class Inflated extends AbstractBehavior {
    private static final int ADD_HEALTH = 50;
    private static final int REMOVE_HEALTH = 10;


    @Override
    public void trigger(Blob blob) {
        blob.setHealth(blob.getHealth() + ADD_HEALTH);
        super.setIsTriggered(true);
//        source.setDamage(source.getDamage() + 50);
//        super.setIsTriggered();
    }

    @Override
    public void applyRecurrentEffect(Blob blob) {
        blob.setHealth(blob.getHealth() - REMOVE_HEALTH);
    }
}
