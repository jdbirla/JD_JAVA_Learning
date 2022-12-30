package predifine.FI.consumer;

import java.util.ArrayList;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;

public class BiConsumerEx1 {
	public static void main(String[] args) {

		BiConsumer<String, String> bc = (a, b) -> System.out.println(a + b);
		bc.accept("Jitendra", "Birla");
		System.out.println("*********************************************");

		ArrayList<Employee> al = new ArrayList<Employee>();

		BiFunction<String, Double, Employee> bf = (name, salary) -> new Employee(name, salary);

		al.add(bf.apply("Jitendra", 100000.0));
		al.add(bf.apply("Jitendra1", 10000.0));
		al.add(bf.apply("Jitendra2", 1000340.0));
		al.add(bf.apply("Jitendra3", 1000032.0));

		BiConsumer<Employee, Double> bc1 = (emp, incr) -> emp.salary = emp.salary + incr;

		for (Employee e : al) {
			bc1.accept(e, 500.0);
		}

		for (Employee e : al) {
			System.out.println(e.name + "  " + e.salary);
		}
		System.out.println("*********************************************");


	}

}
