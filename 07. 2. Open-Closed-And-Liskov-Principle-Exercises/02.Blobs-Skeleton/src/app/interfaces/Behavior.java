package app.interfaces;

public interface Behavior {
     void trigger(Blob source);
    void applyRecurrentEffect(Blob source);

    boolean isTriggered();
}
