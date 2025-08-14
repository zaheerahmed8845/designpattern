package org.example.payment;

import org.example.entity.Address;
import org.example.enums.PaymentStatus;

public class ElectronicBankTransfer extends Payment {
    private String bankName;
    private int routingNumber;
    private int accountNumber;
    private Address billingAddress;

    @Override
    public PaymentStatus makePayment() {
        this.status = PaymentStatus.Confirmed;
        return status;
    }
}
