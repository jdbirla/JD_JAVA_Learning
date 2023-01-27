package com.bharath.patterns;

import java.util.Iterator;

public class ProductUtilIterator implements Iterator<Product> {

	Product[] products;
	int pos = 0;

	public ProductUtilIterator(Product[] products) {
		this.products = products;
	}

	@Override
	public boolean hasNext() {
		if (pos >= products.length || products[pos] == null) {
			return false;
		} else {
			return true;
		}
	}

	@Override
	public Product next() {
		return products[pos++];
	}

}
