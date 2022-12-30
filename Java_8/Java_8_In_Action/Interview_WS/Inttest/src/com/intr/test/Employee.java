package com.intr.test;

public class Employee {
	private Integer id;
	private String name;
	private String grade;
	private String dept;
	private double salary;
	private Address address; 

	public Employee() {
	}

	public Employee(Integer id, String name, String grade, String dept, double salary, Address address) {
		super();
		this.id = id;
		this.name = name;
		this.grade = grade;
		this.dept = dept;
		this.salary = salary;
		this.address = address;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", grade=" + grade + ", dept=" + dept + ", salary=" + salary
				+ ", address=" + address + "]";
	}

	

	
}
