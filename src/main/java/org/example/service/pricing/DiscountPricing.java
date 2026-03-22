package org.example.service.pricing;

public class DiscountPricing implements PricingStrategy {
    public double calculatePrice(double basePrice) {
        return basePrice * 0.9;
    }
}