package org.example.person;

public class Passenger extends Person {
    public String passengerId;
    public String passportNumber;
    public String gender;

    public Passenger(String name, String email, String phone, String passportNumber) {
        super(name, email, phone);
        this.passengerId = "P-" + System.currentTimeMillis();
        this.passportNumber = passportNumber;
    }
}
