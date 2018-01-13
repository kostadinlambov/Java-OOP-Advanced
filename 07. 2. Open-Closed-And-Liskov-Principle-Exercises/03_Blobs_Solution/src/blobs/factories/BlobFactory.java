package blobs.factories;

import blobs.interfaces.Attack;
import blobs.interfaces.Behavior;
import blobs.interfaces.Blob;
import blobs.models.BlobImpl;

public final class BlobFactory  {

    private BlobFactory() {
    }

    public static Blob create(String name, int health, int damage, Behavior behavior, Attack attack) {
        return new BlobImpl(name, health, damage, behavior, attack);
    }
}
