package org.example.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MenuSection extends MenuComponent {
    private final String title;
    private final String description;
    private final List<MenuComponent> items = new ArrayList<>();

    public MenuSection(String title, String description) {
        this.title = title;
        this.description = description;
    }

    @Override
    public String getTitle() {
        return title;
    }

    @Override
    public String getDescription() {
        return description;
    }

    @Override
    public void add(MenuComponent c) {
        items.add(c);
    }

    @Override
    public void remove(MenuComponent c) {
        items.remove(c);
    }

    @Override
    public List<MenuComponent> children() {
        return Collections.unmodifiableList(items);
    }
}
