# Java8 Coding Questrions

## Java Data Reference
- Employee.java
```java
  package com.jd.inttest.core;

import java.util.List;

/**
 * Created by jd birla on 02-02-2023 at 13:37
 */
public class Employee {

  private Integer id;
  private String name;
  private String grade;
  private String dept;
  private double salary;
  private List<Address> address;

  public Employee() {
  }

  public Employee(Integer id, String name, String grade, String dept, double salary,
      List<Address> address) {
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

  public List<Address> getAddress() {
    return address;
  }

  public void setAddress(List<Address> address) {
    this.address = address;
  }

  @Override
  public String toString() {
    return "Employee{" +
        "id=" + id +
        ", name='" + name + '\'' +
        ", grade='" + grade + '\'' +
        ", dept='" + dept + '\'' +
        ", salary=" + salary +
        ", address=" + address +
        '}';
  }
}
```
- Address.java
```java
package com.jd.inttest.core;

/**
 * Created by jd birla on 02-02-2023 at 13:38
 */
public class Address {
    private String city;
    private String country;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Address() {
        super();
    }

    public Address(String city, String country) {
        super();
        this.city = city;
        this.country = country;
    }

    @Override
    public String toString() {
        return "Address [city=" + city + ", country=" + country + "]";
    }
}

```
- EmployeeDataBase.java
```java
package com.jd.inttest.core;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Created by jd birla on 02-02-2023 at 13:33
 */
public class EmployeeDatabase {

  public static List<com.jd.inttest.core.Employee> getEmployees() {
    return Stream.of(
        new com.jd.inttest.core.Employee(101, "Ram", "A", "Manager", 120000,
            List.of((new Address("Indore", "India")), (new Address("Pune", "India")))),
        new com.jd.inttest.core.Employee(102, "Raju", "B", "IT", 120000,
            List.of((new Address("Chennai", "India")), (new Address("Bangalore", "India")))),
        new com.jd.inttest.core.Employee(103, "Abhijit", "C", "DEV", 80000,
            List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India")))),
        new com.jd.inttest.core.Employee(104, "Bhupendra", "D", "BAU", 50000,
            List.of((new Address("Indore", "India")), (new Address("Mumbai", "India")))),
        new com.jd.inttest.core.Employee(105, "Niranjan", "A", "Lead", 110000,
            List.of((new Address("Chennai", "India")), (new Address("Tokyo", "Japan")))),
        new com.jd.inttest.core.Employee(106, "Sunil", "B", "IT", 80000,
            List.of((new Address("Chennai", "India")), (new Address("Bangalore", "India")))),
        new com.jd.inttest.core.Employee(107, "Gajanand", "A", "Manager", 120000,
            List.of((new Address("Indore", "India")), (new Address("Pune", "India")))),
        new com.jd.inttest.core.Employee(108, "Mrp", "A", "DEV", 70000,
            List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India"))))

    ).collect(Collectors.toList());
  }
}

```
## Iterations
### Array
```java
```
### List
```java
```
### Set 
```java
```
### Map
```java
```
## Second highest or Nth Highest problem
```java

```
## 
