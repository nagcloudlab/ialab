package com.example.bill;

import com.example.pm.PriceMatrix;

import java.util.Collections;
import java.util.List;

/**
 * @author Tom
 */

public class BillingImpl implements Billing {

    private PriceMatrix priceMatrix;

    public BillingImpl(PriceMatrix priceMatrix) {
        this.priceMatrix = priceMatrix;
    }

    @Override
    public double getTotalPrice(List<String> cartItems) {
        double totalPrice = 0;
//        Collections.reverse(cartItems);
        for (String item : cartItems) {
            System.out.println(item);
            double price = priceMatrix.getPrice(item);
            totalPrice += price;
        }
        return totalPrice;
    }
}
