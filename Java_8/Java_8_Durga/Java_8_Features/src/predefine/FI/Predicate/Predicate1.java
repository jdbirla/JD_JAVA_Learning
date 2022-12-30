package predefine.FI.Predicate;

import java.util.ArrayList;
import java.util.Collection;
import java.util.function.Predicate;

public class Predicate1 {

	public static void main(String[] args) {

		Predicate<Integer> p =  I->I>10;
		Predicate<String> p1 =  S->S.length()>5; //length of string is grater than 5
		Predicate<Collection> p2 = C->C.isEmpty();
		
		int i = 5;
		System.out.println("Predicate answer : "+p.test(i));
		
		String s = "Jitu";
		System.out.println("Predicate answer for string length : "+p1.test(s));
		
		ArrayList<String> al1 =  new ArrayList<String>();
	//	al1.add("Jitendta");
		
		System.out.println("Predicate answer for given collection is empty or not  : "+p2.test(al1));

		
	
	}

}
