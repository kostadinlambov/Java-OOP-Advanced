package blobs.factories;

import blobs.interfaces.Blob;
import blobs.interfaces.Observer;
import blobs.interfaces.OutputWriter;
import blobs.observers.DeadBlobObserver;
import blobs.observers.TogglesBehaviorObserver;

public final class ObserverFactory {

    private ObserverFactory() {
    }

    public static Observer createDeadBlobObserver(Blob blob, OutputWriter writer) {
        return new DeadBlobObserver(blob, writer);
    }

    public static Observer createTogglesBehaviorObserver(Blob blob, OutputWriter writer) {
        return new TogglesBehaviorObserver(blob, writer);
    }
}
