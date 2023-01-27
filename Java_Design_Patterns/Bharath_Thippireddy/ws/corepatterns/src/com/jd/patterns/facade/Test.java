package com.jd.patterns.facade;

public class Test {

	public static void main(String[] args) {
//		OrderProcessor orderProcessor = new OrderProcessor();
//		if (orderProcessor.checkStock("Macbook")) {
//			String orderId = orderProcessor.placrOrder("mack", 5);
//			orderProcessor.shipOrder(orderId);
//		}
		OrderFacade orderFacade = new OrderFacade();
		orderFacade.processOrder("MacBook", 5);
	}

}
