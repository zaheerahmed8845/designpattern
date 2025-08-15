package org.example.person;

import org.example.entity.TableConfiguration;

import java.awt.*;

public class Manager extends Person {
    public TableConfiguration addTableConfig(TableConfiguration cfg) {
        return cfg;
    }

    public Menu updateMenu(Menu menu) {
        return menu;
    }
}
