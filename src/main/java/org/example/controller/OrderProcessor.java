package org.example.controller;
import org.example.model.Order;
import org.example.service.payment.PaymentMethod;
import org.example.service.pricing.PricingStrategy;
import org.example.service.notification.NotificationService;

public class OrderProcessor {
    private PricingStrategy pricingStrategy;
    private PaymentMethod paymentMethod;
    private NotificationService notificationService;

    public OrderProcessor(PricingStrategy pricingStrategy,
                          PaymentMethod paymentMethod,
                          NotificationService notificationService) {
        this.pricingStrategy = pricingStrategy;
        this.paymentMethod = paymentMethod;
        this.notificationService = notificationService;
    }

    public void process(Order order) {
        double total = pricingStrategy.calculatePrice(order.getTotal());
        paymentMethod.pay(total);
        notificationService.notifyUser("Order processed successfully!");
    }
}