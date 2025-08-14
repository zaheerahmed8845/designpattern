package org.example.command;

import org.example.entity.Order;
import org.example.enums.PaymentStatus;
import org.example.payment.Payment;

public class MakePaymentCommand implements Command {
    private final Order order;
    private final Payment payment;

    public MakePaymentCommand(Order order, Payment payment) {
        this.order = order;
        this.payment = payment;
    }

    @Override
    public boolean execute() {
        PaymentStatus ps = order.makePayment(payment);
        return ps == PaymentStatus.Confirmed;
    }

    @Override
    public String name() {
        return "makePayment(" + payment.getClass().getSimpleName() + ")";
    }
}
