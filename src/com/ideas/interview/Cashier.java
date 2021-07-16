package com.ideas.interview;

public class Cashier {
    public static final Integer COFFEE_PRICE = 10;
    private Integer paiedAmount = 0;

    public boolean acceptPayment(Integer paiedAmount) {

        if (COFFEE_PRICE.equals(paiedAmount)) {
            setPaiedAmount(paiedAmount);
            return true;
        } else {
            return false;
        }
    }

    public Integer getPaiedAmount() {
        return paiedAmount;
    }

    public void setPaiedAmount(Integer paiedAmount) {
        this.paiedAmount = paiedAmount;
    }


}
