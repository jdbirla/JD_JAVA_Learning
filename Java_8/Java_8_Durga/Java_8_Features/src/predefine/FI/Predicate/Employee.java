package predefine.FI.Predicate;

public class Employee {

	String name;
	String designation;
	double salary;
	String city;

	public Employee(String name, String designation, double salary, String city) {
		this.name = name;
		this.designation = designation;
		this.salary = salary;
		this.city = city;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Employee [name=");
		builder.append(name);
		builder.append(", designation=");
		builder.append(designation);
		builder.append(", salary=");
		builder.append(salary);
		builder.append(", city=");
		builder.append(city);
		builder.append("]");
		return builder.toString();
	}

}
