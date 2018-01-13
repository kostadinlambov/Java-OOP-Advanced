package app.factories;

import app.interfaces.Attack;
import app.models.attacks.Blobplode;
import app.models.attacks.PutridFart;

public class AttackFactory {
    private AttackFactory() {
    }

    public static Attack create(String type) {
        if(type.equals("Blobplode")){
            return new Blobplode();
        }else{
            return new PutridFart();
        }
    }
}
