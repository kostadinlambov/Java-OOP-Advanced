package app.models.attacks;

import app.interfaces.Attack;
import app.interfaces.Blob;

public class Blobplode implements Attack {


    @Override
    public void execute(Blob attacker, Blob target) {
        attacker.reduceHealthAfterAttack(attacker.getHealth() - (attacker.getHealth()/2));
        target.reduceHealthAfterAttack(attacker.getDamage() * 2);
    }
}
