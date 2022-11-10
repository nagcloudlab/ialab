package com.example.bill;

import com.example.pm.PriceMatrix;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InOrder;
import org.mockito.Mock;

import static org.mockito.Mockito.*;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BillingTest {

    private Billing billing;
    private PriceMatrix priceMatrix;


    @BeforeEach
    public void setup() {
        priceMatrix = mock(PriceMatrix.class);
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
//        when(priceMatrix.getPrice("123")).thenReturn(100.00);
//        when(priceMatrix.getPrice("456")).thenReturn(200.00);
//        when(priceMatrix.getPrice("789")).thenReturn(300.00);
        when(priceMatrix.getPrice(anyString())).thenReturn(100.00);
        InOrder inOrder = inOrder(priceMatrix);
        double actual = billing.getTotalPrice(cartItems);
        assertEquals(300.00, actual);
//        verify(priceMatrix).getPrice("123");
//        verify(priceMatrix).getPrice("456");
//        verify(priceMatrix).getPrice("789");
//        verify(priceMatrix, times(3)).getPrice(anyString());
        inOrder.verify(priceMatrix).getPrice("123");
        inOrder.verify(priceMatrix).getPrice("456");
        inOrder.verify(priceMatrix).getPrice("789");
        verify(priceMatrix,never()).getPrice("111");
    }

}
