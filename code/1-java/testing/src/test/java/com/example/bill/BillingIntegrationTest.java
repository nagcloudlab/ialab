package com.example.bill;

import com.example.pm.PriceMatrix;
import com.example.pm.PriceMatrix_v1;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillingIntegrationTest {

    private Billing billing;
    private PriceMatrix priceMatrix;

    @BeforeEach
    public void setup() {
        priceMatrix = new PriceMatrix_v1();
        billing = new BillingImpl(priceMatrix);
    }

    @Test
    public void testTotalPriceOfEmptyCart() {
        List<String> emptyCart = new ArrayList<>();
        assertEquals(0, billing.getTotalPrice(emptyCart));
    }

    @Test
    public void testTotalPriceOfCart() {
        List<String> cartItems = new ArrayList<>();
        cartItems.add("123");
        cartItems.add("456");
        cartItems.add("789");
        double actual = billing.getTotalPrice(cartItems);
        assertEquals(300.00, actual);
    }
}
