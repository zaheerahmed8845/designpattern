package org.example.storage;

public class GoogleCloudStorage implements Storage {

    public GoogleCloudStorage(int capacityInMb) {
        System.out.println("Allocated "+capacityInMb+" on GCP");
    }

    @Override
    public String getId() {
        return "GCP Storage";
    }

    @Override
    public String toString() {
        return "GoogleCloudStorage";
    }
}
