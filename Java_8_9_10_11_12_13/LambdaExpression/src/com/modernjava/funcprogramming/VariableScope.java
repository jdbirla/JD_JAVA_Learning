package com.modernjava.funcprogramming;

import java.util.List;
import java.util.function.IntConsumer;

public class VariableScope {
	   static int l=0;
    public static void main(String[] args) {
        //Case1
    	//int a =10; //local variable
       // IntConsumer intConsumer = (a) -> System.out.println(a*10); //Compile time Error {Lambda expression's parameter a cannot redeclare another local variable defined in an enclosing scope. }

    	int b =10; //local variable
        IntConsumer intConsumer = (a) -> System.out.println(a*10); //

        //Case 2
        int k=0;
        List<Instructor> instructors =  Instructors.getAll();
        instructors.forEach(instructor  ->{
       //  	System.out.println( k++); //Compile time Error  {Local variable k defined in an enclosing scope must be final or effectively final}
        });
        
        //Case 3
     
        List<Instructor> instructors1 =  Instructors.getAll();
        instructors1.forEach(instructor  ->{
        	System.out.println( instructor + " " +l); //No error as variable define as class level and its static
            l++;
        });
        		
        
    }
}
