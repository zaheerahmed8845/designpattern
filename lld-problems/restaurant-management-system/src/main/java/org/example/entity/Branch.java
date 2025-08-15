package org.example.entity;

import java.awt.*;

public class Branch {
    private String name;
    private String location;
    private String addressLine;
    private Menu menu;
    private TableConfiguration tableConfig;

    public Branch(String name, String location, String addressLine, Menu menu, TableConfiguration tableConfig) {
        this.name = name;
        this.location = location;
        this.addressLine = addressLine;
        this.menu = menu;
        this.tableConfig = tableConfig;
    }

    public boolean addTableConfig(TableConfiguration cfg) {
        this.tableConfig = cfg;
        return true;
    }

    // getters/setters omitted
}
