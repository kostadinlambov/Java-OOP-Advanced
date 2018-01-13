package blobs.observers;

import blobs.interfaces.Blob;
import blobs.interfaces.Observer;
import blobs.interfaces.OutputWriter;

public abstract class AbstractObserver implements Observer {

    private Blob blob;
    private OutputWriter writer;

    protected AbstractObserver(Blob blob, OutputWriter writer) {
        this.blob = blob;
        this.writer = writer;
    }

    protected OutputWriter getWriter() {
        return this.writer;
    }

    protected Blob getBlob() {
        return this.blob;
    }
}
