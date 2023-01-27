package com.bharath.patterns;

public class ProductCollection implements Collection {

	int numberOfProducts = 0;
	Product[] products;

	public ProductCollection() {
		products = new Product[10];
	}

	public void addProduct(Product product) {
		products[numberOfProducts] = product;
		numberOfProducts = numberOfProducts + 1;
	}

	@Override
	public Iterator createIterator() {
		return new ProductIterator(products);
	}
}
