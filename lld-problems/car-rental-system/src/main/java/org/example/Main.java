package org.example;

import org.example.command.CancelReservationCommand;
import org.example.command.CommandInvoker;
import org.example.decorator.*;
import org.example.entity.Fine;
import org.example.entity.ReservationManager;
import org.example.entity.VehicleReservation;
import org.example.enums.CarType;
import org.example.enums.ReservationStatus;
import org.example.enums.VehicleStatus;
import org.example.equipment.Navigation;
import org.example.factory.CarFactory;
import org.example.factory.VehicleFactory;
import org.example.observer.EmailReservationObserver;
import org.example.observer.SMSReservationObserver;
import org.example.person.Customer;
import org.example.pricing.DynamicPricingStrategy;
import org.example.pricing.PriceContext;
import org.example.search.VehicleCatalog;
import org.example.service.Wifi;
import org.example.vehicle.Vehicle;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // 1) Inventory via Factory Method
        VehicleFactory.VehicleSpecBuilder builder = new VehicleFactory.VehicleSpecBuilder()
                .id(101).plate("KA-01-AB-1234").capacity(5)
                .status(VehicleStatus.Available).model("Civic").year(2022);
        VehicleFactory carFactory = new CarFactory(CarType.Compact);
        Vehicle car = carFactory.create(builder.build());

        VehicleCatalog catalog = new VehicleCatalog();
        catalog.index(car);

        // 2) Customer + observers
        Customer customer = new Customer("zaheer", "secret", "DL-1234567", LocalDate.now().plusYears(5));
        ReservationManager rm = ReservationManager.getInstance();
        rm.registerObserver(new EmailReservationObserver(customer));
        rm.registerObserver(new SMSReservationObserver(customer));

        // 3) Reservation
        LocalDateTime start = LocalDateTime.now().plusDays(1);
        LocalDateTime end = start.plusDays(3);
        VehicleReservation reservation = new VehicleReservation(
                7001, customer.getAccountId(), car.getVehicleId(), start, end,
                "Bangalore Airport", "Bangalore Downtown"
        );
        reservation.addEquipment(new Navigation(1, 300));
        reservation.addService(new Wifi(2, 200));
        rm.addReservation(reservation);
        rm.changeStatus(reservation.getReservationId(), ReservationStatus.Confirmed);

        // 4) Strategy + Decorator pricing pipeline
        PriceContext ctx = new PriceContext(3, 50.0, 1.0, true, 120, car.getTypeKey(), start, end);
        PriceComponent pipeline = new BasePrice(new DynamicPricingStrategy());
        pipeline = new PeakSeasonDecorator(pipeline, 1.20);
        pipeline = new DiscountDecorator(pipeline, 0.10); // 10% off
        double priceBeforeFines = pipeline.quote(ctx);

        PriceComponent withFines = new FuelFineDecorator(new DamageFineDecorator(pipeline, 30.0), 5.0, 2.0);
        double finalPrice = withFines.quote(ctx);

        System.out.println("Price before fines: " + priceBeforeFines);
        System.out.println("Final price (with fines): " + finalPrice);

        // 5) Command example
        CommandInvoker invoker = new CommandInvoker();
        boolean cancelled = invoker.run(new CancelReservationCommand(reservation.getReservationId()));
        System.out.println("Reservation cancelled? " + cancelled);

        // 6) Attach fine for record-keeping
        reservation.setFine(new Fine(40.0, "Minor damage and fuel deficiency"));

        // 7) Search demo
        List<Vehicle> compacts = catalog.searchByType(CarType.Compact.name());
        System.out.println("Catalog results for COMPACT: " + compacts.size());
    }
}