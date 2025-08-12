package org.example.entity;

// ======================================================
// ================  WORLD: CITY → CINEMA → HALL → SEAT  =
// ======================================================

import java.util.ArrayList;
import java.util.List;

public class City {
    private int cityId;
    private String name, state, zipCode;
    private final List<Cinema> cinemas = new ArrayList<>();

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int v) {
        cityId = v;
    }

    public String getName() {
        return name;
    }

    public void setName(String v) {
        name = v;
    }

    public String getState() {
        return state;
    }

    public void setState(String v) {
        state = v;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String v) {
        zipCode = v;
    }

    public List<Cinema> getCinemas() {
        return cinemas;
    }
}
