package org.example.entity;

import java.util.ArrayList;
import java.util.List;

public class TableConfiguration {
    private final List<Integer> tableConfigImageIds = new ArrayList<>();

    public void addImageId(int id) {
        tableConfigImageIds.add(id);
    }

    public List<Integer> getImageIds() {
        return List.copyOf(tableConfigImageIds);
    }
}
