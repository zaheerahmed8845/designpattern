package org.example.factory;

import org.example.common.Capacity;
import org.example.instance.Instance;
import org.example.storage.Storage;

public interface ResourceFactory {
    Instance createInstance(Capacity capacity);
    Storage createStorage(int capMib);
}
