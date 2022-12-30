package predefine.FI.Predicate;

import java.util.function.IntPredicate;
import java.util.function.LongPredicate;

public class intPredicateEx1 {
	public static void main(String[] args) {
		int[] x = { 0, 5, 10, 25, 20 };
		IntPredicate p = i -> i % 2 == 0;
		for (int x1 : x) {
			if (p.test(x1)) {
				System.out.println(x1);
			}

		}

		LongPredicate l = i -> i % 2 == 0;

		for (int x1 : x) {
			if (l.test(x1)) {
				System.out.println(x1);
			}

		}
	}
}
