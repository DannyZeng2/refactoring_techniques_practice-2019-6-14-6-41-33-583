package com.tws.refactoring.extract_variable;

public class PriceCalculator {
    public static final int DISCOUNT_MIN_NUM = 500;
    public static final double DISCOUNT_RATE= 0.05;
    public static final double SHIPING_COST_RATE = 0.1;
    public static final double SHIPING_COST_MAX = 100.0;
    double getPrice(int quantity, int itemPrice) {
        int basePrice = quantity * itemPrice;
        double discount = Math.max(0, quantity - DISCOUNT_MIN_NUM) * itemPrice * DISCOUNT_RATE;
        double shipingCost = Math.min(quantity * itemPrice * SHIPING_COST_RATE, SHIPING_COST_MAX);
        return basePrice - discount + shipingCost;
    }
}
