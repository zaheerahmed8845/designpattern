package org.example.instance;

import org.example.common.Capacity;
import org.example.storage.Storage;

public class GCPInstance implements Instance {

    public GCPInstance(Capacity capacity) {
        System.out.println("GCP instance with capacity : " + capacity);
    }

    @Override
    public void start() {
        System.out.println("GCP Instance started");
    }

    @Override
    public void stop() {
        System.out.println("GCP Instance stopped");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("GCP Storage attached");
    }

    @Override
    public String toString() {
        return "GCP Instance";
    }
}
