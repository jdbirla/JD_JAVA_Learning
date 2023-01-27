package com.jd.patterns.decorator;

public class CheesePizzaDecorator2 extends PizzaDecorator {

	public CheesePizzaDecorator2(Pizza pizza) {
		super(pizza);
	}

	public void bake() {
		super.bake();
		System.out.println("Adding cheese toppings");
	}

}
