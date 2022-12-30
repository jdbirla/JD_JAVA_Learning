package predefine.FI.Predicate;

public class SoftwareEngineer {

	String name;
	int age;
	boolean isHavingGF;

	public SoftwareEngineer(String name, int age, boolean isHavingGF) {
		this.name = name;
		this.age = age;
		this.isHavingGF = isHavingGF;
	}

	@Override
	public String toString() {
		return name;
	}
	

}
