package blobs.factories;

import blobs.interfaces.Attack;
import blobs.models.attacks.Blobplode;
import blobs.models.attacks.PutridFart;

public final class AttackFactory {
    private static final String BLOBPLODE_ATTACK_TYPE = "Blobplode";

    private AttackFactory() {
    }

    public static Attack create(String type) {
        if (BLOBPLODE_ATTACK_TYPE.equalsIgnoreCase(type)) {
            return new Blobplode();
        } else {
            return new PutridFart();
        }
    }
}
