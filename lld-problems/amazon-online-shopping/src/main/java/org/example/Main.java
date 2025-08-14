package org.example;

import org.example.command.AddProductToCartCommand;
import org.example.command.CommandInvoker;
import org.example.command.MakePaymentCommand;
import org.example.command.PlaceOrderCommand;
import org.example.customer.AuthenticatedUser;
import org.example.customer.Customer;
import org.example.customer.CustomerFactory;
import org.example.entity.Order;
import org.example.enums.OrderStatus;
import org.example.notification.EmailNotification;
import org.example.notification.SmsNotification;
import org.example.observer.NotificationObserverAdapter;
import org.example.payment.Cash;
import org.example.payment.CreditCard;
import org.example.product.Product;
import org.example.product.ProductCategory;
import org.example.proxy.CachedProductRepositoryProxy;
import org.example.proxy.ProductRepository;
import org.example.proxy.RealProductRepository;

public class Main {
    public static void main(String[] args) {
        // ----- Composite: Category with Products -----
        ProductCategory mobiles = new ProductCategory("Mobiles", "Smartphones and accessories");
        Product iphone = new Product("P1", "iPhone 15", 899.0);
        Product pixelBuds = new Product("P2", "Pixel Buds", 149.0);
        mobiles.addProduct(iphone);
        mobiles.addProduct(pixelBuds);

        // ----- Proxy: cached product repository -----
        ProductRepository repo = new CachedProductRepositoryProxy(new RealProductRepository());
        repo.save(iphone);
        repo.save(pixelBuds);
        System.out.println("Repo fetch P1: " + repo.getById("P1").getName());
        System.out.println("Repo fetch P1 (cached): " + repo.getById("P1").getName());

        // ----- Factory Method: create users aligned with diagram -----
        Customer guest = CustomerFactory.createGuest();
        Customer authUser = CustomerFactory.createAuthenticatedUser("zaheer");

        // ----- Command: addProduct() to ShoppingCart -----
        CommandInvoker invoker = new CommandInvoker();
        invoker.submit(new AddProductToCartCommand(authUser.getCart(), repo.getById("P1"), 1));
        invoker.submit(new AddProductToCartCommand(authUser.getCart(), repo.getById("P2"), 2));
        System.out.println("Cart total = " + authUser.getCart().getTotalPrice());

        // ----- Observer: notifications on Order status change -----
        Order order = new Order();
        order.setCustomer((AuthenticatedUser) authUser);
        order.addObserver(new NotificationObserverAdapter(new EmailNotification("user@example.com")));
        order.addObserver(new NotificationObserverAdapter(new SmsNotification("+91-90000-00000")));

        // Place order (Unshipped) and then pay using Strategy = Payment subclass
        invoker.submit(new PlaceOrderCommand(order));
        invoker.submit(new MakePaymentCommand(order, new CreditCard()));

        // Shipment / status updates notify observers
        order.setStatus(OrderStatus.Shipped);
        order.setStatus(OrderStatus.Confirmed); // for demo; normally Confirmed precedes Shipped
        order.setStatus(OrderStatus.Refunded);  // any change will notify

        // Switch strategy easily for another payment attempt
        invoker.submit(new MakePaymentCommand(order, new Cash()));
    }
}