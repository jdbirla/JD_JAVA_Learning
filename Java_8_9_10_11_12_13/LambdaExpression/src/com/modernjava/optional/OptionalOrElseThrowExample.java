package com.modernjava.optional;

import java.util.Optional;

public class OptionalOrElseThrowExample {
    public static void main(String[] args) {
        //orElse
        Integer[] numbers = new Integer[10]; 
        numbers[0] = 1;
        Optional<Integer> number = Optional.ofNullable(numbers[0]);
        int result = number.orElse(-1);
        System.out.println("result = " + result);

        //orElseGet
        result = number.orElseGet(() -> -1);
        System.out.println("result - orElseGet = " + result);

        //orElseThrow
        try {
            result = number.orElseThrow(Exception::new);
            System.out.println("result orElseThrow = " + result);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

/*
result = -1
result - orElseGet = -1
java.lang.Exception
	at java.base/java.util.Optional.orElseThrow(Optional.java:403)
	at com.modernjava.optional.OptionalOrElseThrowExample.main(OptionalOrElseThrowExample.java:20)


*/