package org.example.observer;

import org.example.account.Member;
import org.example.notification.NotificationMessage;
import org.example.notification.template.Notification;

import java.math.BigDecimal;
import java.util.Objects;

public class PriceAlertObserver implements PriceObserver {
    private final Member recipient;
    private final String symbol;
    private final BigDecimal triggerPrice;
    private final boolean triggerOnOrAbove; // true: ≥ trigger; false: ≤ trigger
    private Notification notifier;          // pluggable channel (can be decorated)

    public PriceAlertObserver(Member recipient,
                              String symbol,
                              BigDecimal triggerPrice,
                              boolean triggerOnOrAbove,
                              Notification notifier) {
        this.recipient = Objects.requireNonNull(recipient);
        this.symbol = Objects.requireNonNull(symbol);
        this.triggerPrice = Objects.requireNonNull(triggerPrice);
        this.triggerOnOrAbove = triggerOnOrAbove;
        this.notifier = Objects.requireNonNull(notifier);
    }

    public void setNotifier(Notification notifier) {
        this.notifier = Objects.requireNonNull(notifier);
    }

    @Override
    public void onPrice(String sym, BigDecimal newPrice) {
        if (!symbol.equals(sym) || newPrice == null) return;

        boolean fire = triggerOnOrAbove
                ? newPrice.compareTo(triggerPrice) >= 0
                : newPrice.compareTo(triggerPrice) <= 0;

        if (fire) {
            String direction = triggerOnOrAbove ? "reached/above" : "reached/below";
            NotificationMessage msg = new NotificationMessage(
                    "Price Alert: " + symbol,
                    symbol + " " + direction + " " + triggerPrice + " (now " + newPrice + ")"
            );
            notifier.send(recipient, msg);
        }
    }
}
