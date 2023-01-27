package com.jd.patterns.facade;

public class OrderProcessor {

	public boolean checkStock(String name) {
		System.out.println("checking stock");
		return true;
	}

	public String placrOrder(String name, int quantity) {
		System.out.println("Order placed");
		return "id123";
	}

	public void shipOrder(String orderId) {
		System.out.println("Order Shipped");
	}

}
