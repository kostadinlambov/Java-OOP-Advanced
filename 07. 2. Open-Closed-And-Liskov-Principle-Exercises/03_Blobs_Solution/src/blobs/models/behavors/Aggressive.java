package blobs.models.behavors;

import blobs.interfaces.Blob;

public class Aggressive extends AbstractBehavior {
    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    private int sourceInitialDamage;

    @Override
    public void trigger(Blob blob) {
        this.sourceInitialDamage = blob.getDamage();
        super.setIsTriggered(true);
        blob.setDamage(blob.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
    }

    @Override
    public void applyRecurrentEffect(Blob blob) {
        blob.setDamage(blob.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);

        if (blob.getDamage() <= this.sourceInitialDamage) {
            blob.setDamage(this.sourceInitialDamage);
        }
    }
}