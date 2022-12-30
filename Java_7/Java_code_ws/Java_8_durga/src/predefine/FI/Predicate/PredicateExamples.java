package predefine.FI.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class PredicateExamples {
	public static void main(String[] args) {
		Predicate<String> startwithK = S -> S.startsWith("K");
		Predicate<String> remomveNull = S -> S != null && !S.isEmpty();
		// example1
		String[] name = { "Jitendra", "Kajal", "Malika", "Katrina", "Kareena" };
		for (String s : name) {
			if (startwithK.test(s)) {
				System.out.println("Start s with K: " + s);

			}

		}

		// Example2 remove null values and sstring values

		String[] nameArray = { "Jitendra", "Kajal", "", "Katrina", "Kareena", null };
		ArrayList<String> al = new ArrayList<String>();

		for (String s : nameArray) {
			if (remomveNull.test(s)) {
				al.add(s);
			}

		}
		System.out.println("Valid array list : " + al);

	}
}
