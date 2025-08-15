package org.example.entity;

public record Address(
        String streetAddress,
        String city,
        String state,
        String zipcode,
        String country
) {
}
