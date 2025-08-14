package org.example.service;

import java.time.LocalDate;

public abstract class Service {
    public LocalDate issuedAt;

    public boolean addInvoiceItem() {
        return true;
    }
}
