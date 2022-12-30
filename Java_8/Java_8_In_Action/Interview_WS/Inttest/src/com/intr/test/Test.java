package com.intr.test;

import java.util.List;
import java.util.stream.Collectors;

public class Test {

	public static void main(String[] args) {

		 List<Employee> empList =  EmployeeDatabase.getEmployees();
		System.out.println(empList);
		
		//Comparator<Employee> comp =  (a,b) -> a.getId().
		List<Employee> collect = empList.stream().sorted( 
				(e1,e2) -> e1.getId().compareTo(e2.getId()) 
				).collect(Collectors.toList());
		System.out.println("Sort by id: "+collect);

	 List<Employee> collect2 = empList.stream().sorted( 
				(e1,e2) -> e1.getAddress().getCity().compareTo(e2.getAddress().getCity())
				).collect(Collectors.toList());
		System.out.println("Sort by Address city: "+collect2);
		
	}

}
