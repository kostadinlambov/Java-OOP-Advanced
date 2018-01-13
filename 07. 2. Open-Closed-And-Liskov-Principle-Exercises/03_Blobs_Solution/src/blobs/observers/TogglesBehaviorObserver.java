package blobs.observers;

import blobs.interfaces.Blob;
import blobs.interfaces.OutputWriter;

public class TogglesBehaviorObserver extends AbstractObserver {

    public TogglesBehaviorObserver(Blob blob, OutputWriter writer) {
        super(blob, writer);
    }

    @Override
    public void update() {
        super.getWriter().writeLine(String.format("Blob %s toggled %sBehavior", super.getBlob().getName(), super.getBlob().getBehavior().getClass().getSimpleName()));
    }
}
