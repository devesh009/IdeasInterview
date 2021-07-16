package com.ideas.interview;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNull;

public class AcceptanceTest {

    private Controller controller;
    private Display display;
    private Barista barista;
    private Cashier cashier;

    private static final Integer COFFEE_PRICE = 10;

    @Test
    public void dispenseBlackCoffeeForFree() {
        powerUp();
        assertEquals("Please select a coffee type", display.currentMessage());
        CoffeeType userInput = CoffeeType.COFFEE1;
        Integer paidAmount = 10;
        assertEquals("Great Choice!", display.currentMessage());

        controller.acceptPayment(10);
        assertEquals("Payment is accepted ..!", display.currentMessage());

        controller.dispense();
        assertEquals(CoffeeType.COFFEE1, barista.servedCoffee());
        assertEquals("Please collect your delicious coffee", display.currentMessage());

    }

    private AcceptanceTest userWants(CoffeeType coffeeType) {
        controller.userWants(coffeeType);
        return this;
    }

    private void powerUp() {

        display = new Display();
        barista = new Barista();
        cashier = new Cashier();
        controller = new Controller(display, barista, cashier);
    }

    @Test
    public void dispensePaidCoffee() {
        powerUp();
        assertEquals("Please select a coffee type", display.currentMessage());
        CoffeeType inputCoffeeType = CoffeeType.COFFEE2;
        Integer paidAmount = 10;

        userWants(inputCoffeeType);
        assertEquals("Please pay the amount..!", display.currentMessage());

        controller.acceptPayment(10);
        assertEquals("Payment is accepted ..!", display.currentMessage());

        controller.dispense();
        assertNotEquals("Please pay 10 Rs!", display.currentMessage());
        assertEquals(CoffeeType.COFFEE2, barista.servedCoffee());
        assertEquals("Please collect your delicious coffee", display.currentMessage());
    }

    @Test
    public void notDispensePaidCoffee() {
        powerUp();
        assertEquals("Please select a coffee type", display.currentMessage());
        CoffeeType inputCoffeeType = CoffeeType.COFFEE2;
        Integer paidAmount = 101;
        userWants(inputCoffeeType);
        assertEquals("Please pay the amount..!", display.currentMessage());

        controller.acceptPayment(paidAmount);
        assertEquals("Please pay Exactly Ruppes /-10", display.currentMessage());


        controller.dispense();
        assertEquals("Please complete the payment process ...", display.currentMessage());
        assertNull(barista.servedCoffee());

        assertNotEquals(CoffeeType.COFFEE2, barista.servedCoffee());
        assertNotEquals("Please collect your delicious coffee", display.currentMessage());

    }
}
