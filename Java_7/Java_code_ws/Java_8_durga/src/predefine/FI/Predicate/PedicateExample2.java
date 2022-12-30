package predefine.FI.Predicate;

import java.util.function.Predicate;

public class PedicateExample2 {

	public static void main(String[] args) {

		Predicate<SoftwareEngineer> allowed = SE -> SE.age >= 18 && SE.isHavingGF == true;

		SoftwareEngineer[] arr = { new SoftwareEngineer("Jitendra", 28, true), new SoftwareEngineer("sunil", 28, false),
				new SoftwareEngineer("punit", 17, true), new SoftwareEngineer("shivam", 22, true),

		};

		System.out.println("Allwoed memebers");

		for (SoftwareEngineer se : arr) {

			if (allowed.test(se)) {
				System.out.println(se);

			}
		}

	}

}
