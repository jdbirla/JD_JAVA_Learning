package basic.lambda.FI;

import java.util.ArrayList;
import java.util.Collections;

public class SortingEmployeeComparatorLambda {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<Employee> empList =  new ArrayList<Employee>();
		empList.add(new Employee(15, "Jitednra Birla 1"));
		empList.add(new Employee(17, "Jitednra Birla 2"));
		empList.add(new Employee(13, "Jitednra Birla 3"));
		empList.add(new Employee(14, "Jitednra Birla 4"));
		empList.add(new Employee(12, "Jitednra Birla 5"));
		empList.add(new Employee(16, "Jitednra Birla 6"));

		System.out.println("before sorting empList" + empList);
		
		Collections.sort(empList, (e1,e2)->(e1.empNo > e2.empNo)?-1:(e1.empNo < e2.empNo)?1:0);
		
		System.out.println("after sorting empList" + empList);

	}
}
