package org.example.instance;

import org.example.storage.Storage;

public interface Instance {

    void start();

    void stop();

    void attachStorage(Storage storage);
}
