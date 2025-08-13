package org.example.factory;

import org.example.enums.VehicleStatus;
import org.example.vehicle.Vehicle;

public abstract class VehicleFactory {
    public abstract Vehicle create(VehicleSpec spec);

    public static class VehicleSpecBuilder {
        private final VehicleSpec spec = new VehicleSpec();

        public VehicleSpecBuilder id(int id) {
            spec.vehicleId = id;
            return this;
        }

        public VehicleSpecBuilder plate(String p) {
            spec.licensePlateNumber = p;
            return this;
        }

        public VehicleSpecBuilder capacity(int c) {
            spec.passengerCapacity = c;
            return this;
        }

        public VehicleSpecBuilder status(VehicleStatus s) {
            spec.status = s;
            return this;
        }

        public VehicleSpecBuilder model(String m) {
            spec.model = m;
            return this;
        }

        public VehicleSpecBuilder year(int y) {
            spec.manufacturingYear = y;
            return this;
        }

        public VehicleSpec build() {
            return spec;
        }
    }
}
