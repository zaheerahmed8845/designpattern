package org.example.instance;

import org.example.common.Capacity;
import org.example.storage.Storage;

public class Ec2Instance implements Instance {

    public Ec2Instance(Capacity capacity) {
        System.out.println("Ec2 instance with capacity : " + capacity);
    }

    @Override
    public void start() {
        System.out.println("Ec2 Instance started");
    }

    @Override
    public void stop() {
        System.out.println("Ec2 Instance stopped");
    }

    @Override
    public void attachStorage(Storage storage) {
        System.out.println("Ec2 storage attached");
    }

    @Override
    public String toString() {
        return "Ec2Instance";
    }
}
