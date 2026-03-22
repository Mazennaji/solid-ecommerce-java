package org.example;
import org.example.controller.OrderProcessor;
import org.example.model.Order;
import org.example.model.Product;
import org.example.service.notification.EmailNotification;
import org.example.service.payment.PayPalPayment;
import org.example.service.pricing.DiscountPricing;

import java.util.Arrays;


public class Main {
    public static void main(String[] args) {

        Product p1 = new Product("Laptop", 1000);
        Product p2 = new Product("Mouse", 50);

        Order order = new Order(Arrays.asList(p1, p2));

        OrderProcessor processor = new OrderProcessor(
                new DiscountPricing(),
                new PayPalPayment(),
                new EmailNotification()
        );

        processor.process(order);
    }
}