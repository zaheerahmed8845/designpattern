package org.example.builder;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Meal {
    private final int mealId;
    private final List<MealItem> items;

    private Meal(int mealId, List<MealItem> items) {
        this.mealId = mealId;
        this.items = items;
    }

    public int getMealId() {
        return mealId;
    }

    public List<MealItem> getItems() {
        return Collections.unmodifiableList(items);
    }

    public double total() {
        return items.stream().mapToDouble(MealItem::lineTotal).sum();
    }

    public static class Builder {
        private int mealId;
        private final List<MealItem> items = new ArrayList<>();

        public Builder id(int id) {
            this.mealId = id;
            return this;
        }

        public Builder addItem(MealItem item) {
            items.add(item);
            return this;
        }

        public Meal build() {
            return new Meal(mealId, List.copyOf(items));
        }
    }
}
