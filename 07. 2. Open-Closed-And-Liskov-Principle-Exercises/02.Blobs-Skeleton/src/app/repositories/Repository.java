package app.repositories;

import app.interfaces.Blob;

import java.util.Map;

/**
 * Created by Hristo Skipernov on 09/05/2017.
 */
public interface Repository<T extends Blob> {
    void add(T element);


    Map<String, T> findAll();
}
