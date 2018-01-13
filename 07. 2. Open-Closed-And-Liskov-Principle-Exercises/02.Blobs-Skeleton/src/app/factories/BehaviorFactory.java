package app.factories;

import app.interfaces.Attack;
import app.interfaces.Behavior;
import app.models.attacks.Blobplode;
import app.models.attacks.PutridFart;
import app.models.behavors.Aggressive;
import app.models.behavors.Inflated;

public class BehaviorFactory {
    private BehaviorFactory() {
    }

    public static Behavior create(String type) {
        if(type.equalsIgnoreCase("Aggressive")){
            return new Aggressive();
        }else{
            return new Inflated();
        }
    }
}
