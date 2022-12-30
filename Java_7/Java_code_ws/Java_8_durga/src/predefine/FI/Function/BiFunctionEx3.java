package predefine.FI.Function;

import java.util.function.BiFunction;

public class BiFunctionEx3 {

	public static void main(String[] args) {
		Employee e = new Employee(101, "JD Birla", 2000);
		TimeSheet t = new TimeSheet(101, 30);

		BiFunction<Employee, TimeSheet, Double> bf1 = (emp, time) -> emp.dailywage * time.days;

		System.out.println(bf1.apply(e, t));
	}

}
