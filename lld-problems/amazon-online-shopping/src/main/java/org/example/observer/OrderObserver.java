package org.example.observer;

import org.example.entity.Order;

public interface OrderObserver {
    void onOrderStatusChanged(Order order);
}
