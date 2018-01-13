package blobs.observers;

import blobs.interfaces.Blob;
import blobs.interfaces.OutputWriter;

public class DeadBlobObserver extends AbstractObserver {

    public DeadBlobObserver(Blob blob, OutputWriter writer) {
        super(blob, writer);
    }

    @Override
    public void update() {
        super.getWriter().writeLine("Blob %s was killed", super.getBlob().getName());
    }
}
