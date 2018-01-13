package blobs.core;

import blobs.annotations.Inject;
import blobs.interfaces.Blob;
import blobs.interfaces.Executable;
import blobs.repositories.Repository;

import java.util.Collections;
import java.util.List;

public abstract class BaseCommand implements Executable {

    @Inject
    private List<String> params;
    @Inject
    private Repository<Blob> blobRepository;

    protected BaseCommand() {}

    protected List<String> getParams() {
        return Collections.unmodifiableList(this.params);
    }

    protected Repository<Blob> getBlobRepository() {
        return this.blobRepository;
    }
}
