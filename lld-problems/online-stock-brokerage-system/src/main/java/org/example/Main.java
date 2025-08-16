package org.example;

import org.example.account.Member;
import org.example.command.Command;
import org.example.command.CommandInvoker;
import org.example.command.PlaceOrderCommand;
import org.example.entity.Address;
import org.example.entity.Stock;
import org.example.entity.StockExchange;
import org.example.entity.StockInventory;
import org.example.enums.OrderType;
import org.example.enums.TimeEnforcementType;
import org.example.enums.TradeSide;
import org.example.notification.decorator.LoggingNotificationDecorator;
import org.example.notification.template.EmailNotification;
import org.example.notification.template.Notification;
import org.example.observer.PriceAlertObserver;
import org.example.order.Order;
import org.example.order.OrderBuilder;
import org.example.payment.ElectronicBankPayment;
import org.example.payment.PaymentContext;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        // --- Setup domain: inventory, stocks, member ---
        StockInventory inventory = new StockInventory("NSE");
        inventory.addStock(new Stock("RELIANCE", new BigDecimal("2500.00")));
        inventory.addStock(new Stock("INFY", new BigDecimal("1500.00")));

        Member alice = new Member(
                "alice",
                "secret",
                new Address(560001, "MG Road", "Bengaluru", "KA", "IN"),
                "alice@example.com",
                "+919999999999",
                LocalDate.now()
        );

        // --- Strategy: deposit funds via Electronic Bank ---
        PaymentContext payCtx = new PaymentContext(new ElectronicBankPayment("ACCT-001"));
        var payResult = payCtx.execute(alice, new BigDecimal("100000.00"));
        System.out.println("[Payment] " + payResult.getStatus() + " ref=" + payResult.getReferenceId()
                + " bal=" + alice.getAvailableFundsForTrading());

        // --- Observer: price alert via Notification Template + Decorator ---
        Notification email = new LoggingNotificationDecorator(new EmailNotification());
        PriceAlertObserver alert = new PriceAlertObserver(
                alice, "RELIANCE", new BigDecimal("2510.00"), true, email
        );
        inventory.attach(alert);

        // Simulate price move → should trigger alert
        inventory.updatePrice("RELIANCE", new BigDecimal("2512.35"));

        // --- Build an order (Builder + Factory + Composite) ---
        Order buyLimit = new OrderBuilder()
                .type(OrderType.LIMIT)
                .clientOrderId("cli-123")
                .memberId(alice.getId())
                .symbol("RELIANCE")
                .side(TradeSide.BUY)
                .tif(TimeEnforcementType.GTC)
                .quantity(100)
                .limitPrice(new BigDecimal("2505.00"))
                .build();

        // Note: OrderFactory.adds a single part with qty=100 for us

        // --- Command: place order via StockExchange Singleton ---
        StockExchange ex = StockExchange.getInstance();
        Command placeOrder = new PlaceOrderCommand(ex, inventory, alice, buyLimit);

        CommandInvoker invoker = new CommandInvoker();
        invoker.submit(placeOrder);

        // Could queue more commands (e.g., SendNotificationCommand), then run all:
        invoker.runAll();

        // Observe updated position
        var pos = alice.getStockPositions().get("RELIANCE");
        System.out.println("[Position] " + pos.getSymbol() + " qty=" + pos.getQuantity()
                + " avg=" + pos.getAvgPrice());
    }
}