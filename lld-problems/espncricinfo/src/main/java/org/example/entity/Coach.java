package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class Coach {
    public String name;
    public int age;
    public String country;
    public List<Team> teams = new ArrayList<>();

    public Coach(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }
}