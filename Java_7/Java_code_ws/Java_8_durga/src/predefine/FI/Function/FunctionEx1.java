package predefine.FI.Function;

import java.util.ArrayList;
import java.util.function.Function;

public class FunctionEx1 {

	public static void main(String[] args) {

		Function<String, Integer> f = s -> s.length();
		System.out.println("length :" + f.apply("Jitendra "));
		System.out.println("***********************************************");

		Function<Integer, Integer> f1 = I -> I * I;
		System.out.println("Square :" + f1.apply(5));
		Function<String, String> f3 = S -> S.replaceAll(" ", "");
		System.out.println("***********************************************");

		System.out.println("Remove  spaces :" + f3.apply(" Jitendra birla is a genius"));
		System.out.println("***********************************************");

		Function<String, Integer> f4 = S -> S.length() - S.replaceAll(" ", "").length();
		System.out.println("Count   spaces :" + f4.apply("Jitendra birla is a genius"));
		System.out.println("***********************************************");

		ArrayList<Student> al = new ArrayList<Student>();
		al.add(new Student("J.D.1", 74));
		al.add(new Student("J.D.2", 60));
		al.add(new Student("J.D.3", 89));

		Function<Student, String> f5 = S -> {
			int marks = S.marks;
			if (marks >= 80) {
				return "A";
			} else if (marks >= 60) {
				return "B";
			} else if (marks >= 50) {
				return "C";
			} else {
				return "D";
			}

		};

		for (Student s : al) {
			System.out.println("Stundent :" + s.name + " Grade :" + f5.apply(s));
		}
		System.out.println("***********************************************");

	}

}
