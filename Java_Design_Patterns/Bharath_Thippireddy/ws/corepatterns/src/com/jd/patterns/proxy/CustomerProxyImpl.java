package com.jd.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class CustomerProxyImpl implements Customer{

	CustomerImpl customerImpl = new CustomerImpl();
	
	@Override
	public int getId() {
		return customerImpl.getId();
	}

	@Override
	public List<Order> getOrders() {
		ArrayList<Order> arrayList = new ArrayList<Order>();
		Order order1 = new Order();
		order1.setId(1);
		order1.setProductName("Iphone");
		order1.setQuantity(100);

		arrayList.add(order1);
		
		Order order2 = new Order();
		order2.setId(2);
		order2.setProductName("Mac");
		order2.setQuantity(200);
		
		arrayList.add(order2);

		return arrayList;
	}

}
