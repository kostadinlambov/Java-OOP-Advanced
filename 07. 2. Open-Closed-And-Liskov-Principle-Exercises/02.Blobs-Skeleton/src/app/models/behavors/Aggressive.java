package app.models.behavors;


import app.interfaces.Blob;

public class Aggressive extends AbstractBehavior {

    private static final int AGGRESSIVE_DAMAGE_MULTIPLY = 2;
    private static final int AGGRESSIVE_DAMAGE_DECREMENT = 5;

    //private int sourceInitialDamage;

    @Override
    public void trigger(Blob blob) {
        blob.setDamage(blob.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
        //  this.sourceInitialDamage = blob.getDamage();
        super.setIsTriggered(true);

        // this.applyTriggerEffect(blob);
    }

    @Override
    public void applyRecurrentEffect(Blob blob) {

        blob.setDamage(blob.getDamage() - AGGRESSIVE_DAMAGE_DECREMENT);

        if (blob.getDamage() <= blob.getInitialDamage()) {
            blob.setDamage(blob.getInitialDamage());
        }
//        }
    }


//    private void applyTriggerEffect(Blob blob) {
//        //blob.setDamage(source.getDamage() * AGGRESSIVE_DAMAGE_MULTIPLY);
//    }
}
