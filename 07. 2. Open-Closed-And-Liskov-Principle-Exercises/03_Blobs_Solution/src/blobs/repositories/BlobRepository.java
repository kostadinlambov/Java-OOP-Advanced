package blobs.repositories;

import blobs.interfaces.Blob;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;

public class BlobRepository<T extends Blob> implements Repository<Blob> {
    private Map<String, Blob> blobs;

    public BlobRepository() {
        this.blobs = new LinkedHashMap<>();
    }

    @Override
    public void add(Blob blob) {
        this.blobs.put(blob.getName(), blob);
    }

    @Override
    public Blob findByName(String name) {
        return this.blobs.get(name);
    }

    @Override
    public Map<String, Blob> findAll() {
        return Collections.unmodifiableMap(this.blobs);
    }
}
