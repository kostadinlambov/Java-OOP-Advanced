package blobs.models.attacks;

import blobs.interfaces.Attack;
import blobs.interfaces.Blob;

public class PutridFart implements Attack {

    @Override
    public void execute(Blob attacker, Blob target) {
        target.setHealth(target.getHealth() - attacker.getDamage());
    }
}
