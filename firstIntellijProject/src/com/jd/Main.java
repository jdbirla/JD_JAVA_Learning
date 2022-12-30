package com.jd;

import com.jd.model.Product;

public class Main {

    public static void main(String[] args) {
        String name = "Hello World";
        System.out.println(name);

        Product product = new Product("Jitendra");
        System.out.println(product.getName());
    }
}
