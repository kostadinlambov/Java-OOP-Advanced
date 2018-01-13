package blobs.models.behavors;

import blobs.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;

    protected AbstractBehavior() {
    }

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }
}
