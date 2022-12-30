package basic.lambda.FI;

public class Employee {
	int empNo;
	String empName;
	Employee(int empNo, String empName)
	{
		this.empNo = empNo;
		this.empName = empName;
		
	}
	@Override
	public String toString() {
		return "Employee [empNo=" + empNo + ", empName=" + empName + "]";
	}
	
	
	

}
