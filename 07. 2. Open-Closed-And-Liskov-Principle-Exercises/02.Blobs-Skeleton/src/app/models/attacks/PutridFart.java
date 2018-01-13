package app.models.attacks;

import app.interfaces.Attack;
import app.interfaces.Blob;

public class PutridFart implements Attack {

    public void execute(Blob attacker, Blob target) {
        target.reduceHealthAfterAttack(attacker.getDamage());
    }
}
