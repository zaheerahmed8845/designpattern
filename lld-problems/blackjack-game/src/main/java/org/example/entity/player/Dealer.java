package org.example.entity.player;

import org.example.entity.Person;
import org.example.enums.AccountStatus;

public class Dealer extends Player {
    public Dealer(String id, String password, Person person) {
        super(id, password, 0.0, AccountStatus.ACTIVE, person);
    }
}