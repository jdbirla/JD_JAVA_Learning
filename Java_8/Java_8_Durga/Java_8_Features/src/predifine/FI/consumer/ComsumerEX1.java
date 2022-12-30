package predifine.FI.consumer;

import java.util.ArrayList;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class ComsumerEX1 {

	public static void main(String[] args) {
		Consumer<String> c = S -> System.out.println(S);
		c.accept("Hello Birla");
		System.out.println("****************************************************");

		ArrayList<Movie> al = new ArrayList<Movie>();
		al.add(new Movie("Bahubali", "Prabash"));
		al.add(new Movie("super 30", "Hritik"));
		al.add(new Movie("Baranji bhai jann", "Salman"));

		Consumer<Movie> C2 = M -> {
			System.out.println("Movie name : " + M.name + " ; Hero name :" + M.hero);
		};

		for (Movie m : al) {
			C2.accept(m);

		}
		System.out.println("****************************************************");

		ArrayList<Student> als = new ArrayList<Student>();
		als.add(new Student("JD1", 74));
		als.add(new Student("JD2", 62));
		als.add(new Student("JD3", 55));
		als.add(new Student("JD4", 80));
		als.add(new Student("JD4", 96));

		Predicate<Student> p1 = S -> S.marks >= 60;
		Function<Student, String> f1 = S -> {
			if (S.marks > 75) {
				return "A";
			} else if (S.marks >= 65) {
				return "B";
			} else if (S.marks >= 55) {
				return "C";
			} else {
				return "D";

			}
		};
		Consumer<Student> C3 = S -> System.out.println(S.name + " grade :" + f1.apply(S));

		for (Student s : als) {
			if (p1.test(s)) {
				C3.accept(s);
			}
		}
		System.out.println("****************************************************");

	}

}
