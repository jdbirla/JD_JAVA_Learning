package basic.lambda.FI;

public class TestLambda1 {

	public static void main(String[] args) {

		//Code1
		/*
		 * Interf i = ()->System.out.println("M1 method impmentation"); Interf i1 =
		 * ()->System.out.println("M1  i1 method impmentation");
		 * 
		 * i.m1(); i1.m1();
		 */
		
		//Code2
		/*
		 * Interf i = (a,b)-> System.out.println("The sum is "+ (a+b)); i.add(10, 10);
		 * i.add(10, 20);
		 */

		//code 3
		/*
		 * Interf i =s-> s.length(); System.out.println( i.adlength("Birla jitendra"));
		 */
		
		//code 4
		
		Interf i = y-> y*y;
		System.out.println(i.squareIt(4));
		
	}

}
