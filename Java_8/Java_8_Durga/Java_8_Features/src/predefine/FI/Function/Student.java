package predefine.FI.Function;

public class Student {

	String name;
	int marks;

	public Student(String name, int marks) {
		this.name = name;
		this.marks = marks;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Student [name=");
		builder.append(name);
		builder.append(", marks=");
		builder.append(marks);
		builder.append("]");
		return builder.toString();
	}
	
	

}

