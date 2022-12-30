package predefine.FI.Function;

import java.util.ArrayList;
import java.util.function.BiFunction;

public class BiFunctionEx2 {

	public static void main(String[] args) {
		ArrayList<Student> al = new ArrayList<Student>();
		BiFunction<String, Integer, Student> bf2 = (s, m) -> new Student(s, m);
		al.add(bf2.apply("jitendra", 75));
		al.add(bf2.apply("Shiva", 71));
		al.add(bf2.apply("Durga", 72));
		for (Student s : al) {
			System.out.println(s);

		}
	}

}
