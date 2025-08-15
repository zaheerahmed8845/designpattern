package org.example.composite;

import java.util.List;

public abstract class MenuComponent {
    public String getTitle() {
        throw new UnsupportedOperationException();
    }

    public String getDescription() {
        throw new UnsupportedOperationException();
    }

    public double getPrice() {
        throw new UnsupportedOperationException();
    }

    public void add(MenuComponent c) {
        throw new UnsupportedOperationException();
    }

    public void remove(MenuComponent c) {
        throw new UnsupportedOperationException();
    }

    public List<MenuComponent> children() {
        throw new UnsupportedOperationException();
    }
}
