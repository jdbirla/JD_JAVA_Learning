package com.modernjava.funcprogramming;

import java.util.function.Function;

public class FunctionExample {
    public static void main(String[] args) {
        Function<Integer, Double> sqrt = n -> Math.sqrt(n);
        System.out.println("Square root of 64: " + sqrt.apply(64));
        System.out.println("Square root of 81: " + sqrt.apply(81));

        Function<String,String> lowercaseFunction = s1 -> s1.toLowerCase();
        Function<Integer,Integer> multiple5 = n1 -> n1 *5;
        Function<Integer,Integer> divideby2 = n1 -> n1 /2;

        System.out.println("JD ==>"+multiple5.andThen(divideby2).apply(5)); //JD ==>12
        System.out.println("JD ==>"+divideby2.compose(multiple5).apply(5));//JD ==>12
        System.out.println("JD ==>"+multiple5.compose(divideby2.compose(multiple5)).apply(5));//JD ==>60

        
        
        
        System.out.println(lowercaseFunction.apply("PROGRAMMING"));
        Function<String, String> concatFunction = (s) -> s.concat(" In Java");

        System.out.println(lowercaseFunction.andThen(concatFunction).apply("PROGRAMMING"));

        System.out.println(lowercaseFunction.compose(concatFunction).apply("PROGRAMMING"));



    /*
	   --Output
	   
	   Square root of 64: 8.0
		Square root of 81: 9.0
		JD ==>12
		JD ==>12
		JD ==>60
		programming
		programming In Java
		programming in java

	
	*/


    }
}
