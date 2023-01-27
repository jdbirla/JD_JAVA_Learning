package com.jd.patterns.decorator;

public class PizzaShop {

	public static void main(String[] args) {
		Pizza pizza = new VeggiePizzaDecorator(new CheesePizzaDecorator2(new PlainPizza()));
		pizza.bake();
	}

}
