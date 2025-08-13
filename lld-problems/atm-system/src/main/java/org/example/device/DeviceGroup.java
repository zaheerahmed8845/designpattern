package org.example.device;

import java.util.ArrayList;
import java.util.List;

public class DeviceGroup implements Device {
    private final List<Device> children = new ArrayList<>();

    public DeviceGroup add(Device d) {
        children.add(d);
        return this;
    }

    @Override
    public void selfTest() {
        for (Device d : children) d.selfTest();
    }
}
