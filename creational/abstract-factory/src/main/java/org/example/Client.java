package org.example;

import org.example.common.Capacity;
import org.example.factory.AwsResourceFactory;
import org.example.factory.GCPResourceFactory;
import org.example.factory.ResourceFactory;
import org.example.instance.Instance;
import org.example.storage.Storage;

public class Client {

    private ResourceFactory resourceFactory;

    public Client(ResourceFactory resourceFactory) {
        this.resourceFactory = resourceFactory;
    }

    public Instance createServer(Capacity capacity, int capMib) {
        Instance instance = resourceFactory.createInstance(capacity);
        Storage storage = resourceFactory.createStorage(capMib);
        instance.attachStorage(storage);
        return instance;
    }

    public static void main(String[] args) {
        Client aws = new Client(new AwsResourceFactory());
        Instance i1 = aws.createServer(Capacity.SMALL, 20480);
        i1.start();
        i1.stop();

        System.out.println("*************************************************");
        Client gcp = new Client(new GCPResourceFactory());
        i1 = gcp.createServer(Capacity.MICRO, 10840);
        i1.start();
        i1.stop();
    }
}