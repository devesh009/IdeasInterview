package com.ideas.interview;

public class Controller {
    private final Display display;
    private final Barista barista;
    private CoffeeType coffeeType;
    private Cashier cashier;

    public Controller(Display display, Barista barista, Cashier cashier) {
        this.display = display;
        this.barista = barista;
        this.cashier = cashier;
        display.show("Please select a coffee type");
    }

    public void userWants(CoffeeType coffeeType) {
        this.coffeeType = coffeeType;
        display.show("Great Choice!");
        display.show("Please pay the amount..!");
    }

    public void dispense() {
        if (cashier.getPaiedAmount().equals(Cashier.COFFEE_PRICE)) {
            barista.serve(coffeeType);
            display.show("Please collect your delicious coffee");
        } else {
            display.show("Please complete the payment process ...");
        }
    }

    public void acceptPayment(Integer paiedAmount) {

        if (cashier.acceptPayment(paiedAmount)) {
            display.show("Payment is accepted ..!");
        } else {
            display.show("Please pay Exactly Ruppes /-10");
        }
    }
}
