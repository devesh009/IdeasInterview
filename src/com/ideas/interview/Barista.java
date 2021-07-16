package com.ideas.interview;

public class Barista {

	private CoffeeType servedCoffee;

	public void serve(CoffeeType coffeeType) {
		servedCoffee = coffeeType;
	}

	public CoffeeType servedCoffee() {
		return servedCoffee;
	}

}
