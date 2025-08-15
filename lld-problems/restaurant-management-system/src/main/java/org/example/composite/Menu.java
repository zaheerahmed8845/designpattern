package org.example.composite;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Menu extends MenuComponent {
    private final List<MenuComponent> sections = new ArrayList<>();
    private final int menuId;
    private final String title;
    private final String description;

    public Menu(int menuId, String title, String description) {
        this.menuId = menuId;
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
        sections.add(c);
    }

    @Override
    public void remove(MenuComponent c) {
        sections.remove(c);
    }

    @Override
    public List<MenuComponent> children() {
        return Collections.unmodifiableList(sections);
    }
}
