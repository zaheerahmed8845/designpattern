package org.example.observer;

import org.example.enums.EventType;


public interface Observer {
    void onEvent(Subject subject, EventType type, Object payload);
}
