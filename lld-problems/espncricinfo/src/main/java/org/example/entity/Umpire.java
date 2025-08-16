package org.example.entity;

import org.example.enums.UmpireType;

public class Umpire {
    public String name;
    public int age;
    public String country;
    public UmpireType type = UmpireType.FIELD;

    public Umpire(String name, String country) {
        this.name = name;
        this.country = country;
    }
}
