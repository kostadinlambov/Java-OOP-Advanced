package app.models.behavors;

import app.interfaces.Behavior;

public abstract class AbstractBehavior implements Behavior {

    private boolean isTriggered;
    //private boolean toDelayRecurrentEffect;

    protected AbstractBehavior() {
      //  this.toDelayRecurrentEffect = true;
    }

    //TODO check all getters and setters

    @Override
    public boolean isTriggered() {
        return this.isTriggered;
    }

    protected void setIsTriggered(boolean isTriggered) {
        this.isTriggered = isTriggered;
    }

//    public boolean toDelayRecurrentEffect() {
//        return this.toDelayRecurrentEffect;
//    }
//
//    protected void setToDelayRecurrentEffect(boolean toDelayRecurrentEffect){
//        this.toDelayRecurrentEffect = toDelayRecurrentEffect;
//    }

}
