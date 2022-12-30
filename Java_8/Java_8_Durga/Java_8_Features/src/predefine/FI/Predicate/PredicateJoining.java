package predefine.FI.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateJoining {
	public static ArrayList<Integer> m1(Predicate<Integer> p, int[] x) {
		ArrayList<Integer> Al = new ArrayList<Integer>();

		for (int x1 : x) {
			if (p.test(x1)) {
				Al.add(x1);
			}
		}
		return Al;

	}

	public static void main(String[] args) {

		int[] x = { 0, 5, 10, 15, 20, 25, 30 };
		Predicate<Integer> p1 = I -> I > 10;
		Predicate<Integer> p2 = I -> I % 2 == 0;
		System.out.println("Number greater than 10 : " + m1(p1, x));
		System.out.println("Number even number are : " + m1(p2, x));
		System.out.println("Number not greater than 10 : " + m1(p1.negate(), x));
		System.out.println("Number greater than 10 and even number : " + m1(p1.and(p2), x));
		System.out.println("Number greater than 10 or even number : " + m1(p1.or(p2), x));

	}

}
