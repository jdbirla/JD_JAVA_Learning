package com.intr.test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class EmployeeDatabase {

	public static List<Employee> getEmployees() {
		return Stream.of(

				new Employee(101, "john", "A", "DEV", 60000, new Address("Indore", "India")),
				new Employee(109, "peter", "B", "DEV", 30000, new Address("Bhopal", "India")),
				new Employee(102, "mak", "A", "QA", 80000, new Address("Delhi", "India")),
				new Employee(103, "kim", "A", "QA", 90000, new Address("Banglore", "India")),
				new Employee(104, "json", "C", "DEVOPS", 15000, new Address("Pune", "India")),
				new Employee(105, "jitu", "A", "AWS", 150000, new Address("Chennai", "India"))

		).collect(Collectors.toList());
	}
}
