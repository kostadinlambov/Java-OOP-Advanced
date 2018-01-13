package blobs.factories;

import blobs.interfaces.Behavior;
import blobs.models.behavors.Aggressive;
import blobs.models.behavors.Inflated;

public final class BehaviorFactory {
    private static final String AGGRESSIVE_BEHAVIOR_TYPE = "Aggressive";

    private BehaviorFactory() {
    }

    public static Behavior create(String type) {
        if (AGGRESSIVE_BEHAVIOR_TYPE.equalsIgnoreCase(type)) {
            return new Aggressive();
        } else {
            return new Inflated();
        }
    }
}
