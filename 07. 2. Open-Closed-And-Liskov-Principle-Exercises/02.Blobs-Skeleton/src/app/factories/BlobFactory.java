package app.factories;

import app.interfaces.Attack;
import app.interfaces.Behavior;
import app.interfaces.Blob;
import app.models.BlobImpl;


/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public final class BlobFactory {
    private BlobFactory() {
    }

    public static Blob create(String name, int health, int damage, Behavior behavior, Attack attack) {
        return new BlobImpl(name, health, damage, behavior, attack);
    }
}

