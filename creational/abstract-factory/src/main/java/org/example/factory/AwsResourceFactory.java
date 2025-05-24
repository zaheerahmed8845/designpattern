package org.example.factory;

import org.example.common.Capacity;
import org.example.instance.Ec2Instance;
import org.example.instance.Instance;
import org.example.storage.S3Storage;
import org.example.storage.Storage;

public class AwsResourceFactory implements ResourceFactory {
    @Override
    public Instance createInstance(Capacity capacity) {
        return new Ec2Instance(capacity);
    }

    @Override
    public Storage createStorage(int capMib) {
        return new S3Storage(capMib);
    }
}
