package app.core;

import app.annotations.Inject;
import app.interfaces.Blob;
import app.interfaces.Executable;
import app.repositories.Repository;

import java.util.List;

public abstract class BaseCommand implements Executable {

    @Inject
    private List<String> params;

    @Inject
    private Repository<Blob> blobRepository;

    protected BaseCommand(){}

    protected List<String> getParams(){
       return this.params;
    }

    protected Repository<Blob> getRepository(){
        return this.blobRepository;
    }
}
