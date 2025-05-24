package org.example.factory;

import org.example.common.Capacity;
import org.example.instance.GCPInstance;
import org.example.instance.Instance;
import org.example.storage.S3Storage;
import org.example.storage.Storage;

public class GCPResourceFactory implements ResourceFactory{
    @Override
    public Instance createInstance(Capacity capacity) {
        return new GCPInstance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
