package com.jd.patterns.facade;

public class OrderFacade {
	private OrderProcessor orderProcessor = new OrderProcessor();

	public void processOrder(String name , int quantity) {
		if (orderProcessor .checkStock(name)) {
			String orderId = orderProcessor .placrOrder(name, quantity);
			orderProcessor .shipOrder(orderId);
		}

	}

}
