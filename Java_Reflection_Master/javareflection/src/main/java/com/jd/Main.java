package com.jd;


import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;

public class Main {
    public static void main(String[] args) throws URISyntaxException {
        System.out.println("Hello world!");
        URL res = Main.class.getClassLoader().getResource("com/jd");
        System.out.println(res);
        URI packageUri = Main.class.getResource("com.jd").toURI();
        System.out.println(packageUri);
    }
}