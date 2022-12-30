package predefine.FI.Predicate;

import java.util.ArrayList;
import java.util.function.Predicate;

public class EmployeeManagment {

	public static void main(String[] args) {
		ArrayList<Employee> empList = new ArrayList<Employee>();

		empList.add(new Employee("Jitendra", "CTO", 10000000, "Tokyo"));
		empList.add(new Employee("Punit", "Soft Engg.", 2000, "Banglore"));
		empList.add(new Employee("Tokosan", "CEO", 10000000, "Tokyo"));
		empList.add(new Employee("Koitabashisan", "Manager", 1000000, "Banglore"));
		empList.add(new Employee("Kirti", "Emplyoee", 100000, "Tokyo"));

		Predicate<Employee> p1 = e -> e.designation.equalsIgnoreCase("Manager");
		Predicate<Employee> p2 = e -> e.city.equalsIgnoreCase("Banglore");
		Predicate<Employee> p3 = e -> e.salary < 20000;

		System.out.println("All managers");

		display(p1, empList);
		System.out.println("All employees from Banglore");

		display(p2, empList);
		System.out.println("All employees who got hiked");
		display(p3, empList);
		System.out.println("All managers from banglore");
		display(p1.and(p2), empList);
		System.out.println("All managers or salary less than 20K");

		display(p1.or(p3), empList);

	}

	public static void display(Predicate<Employee> p, ArrayList<Employee> list) {

		for (Employee e : list) {

			if (p.test(e)) {
				System.out.println(e);
			}
		}
		System.out.println("*********************************");

	}
}
