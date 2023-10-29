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
//1. Find the second largest element in the array using stream, it will work for duplicate numbers also
 int[] arr1={7,7,5,6,6,1,4,4,2};
        Integer integer = Arrays.stream(arr1)
                .boxed()
                .distinct()
                .sorted(Comparator.comparing(Integer::intValue).reversed())
                .limit(2)
                .skip(1)
                .findFirst()
                .get();
        System.out.println(integer); //6

/*---------------------------------------------------------------------------*/
//2. The second highest salary from the employee list returns as employee object and it should work even if two employees have the same salary
 double secondHighestSalary = EmployeeDatabase.getEmployees().stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst()
                .orElse(0.0);

        List<Employee> secondHighestSalaryEmployees = EmployeeDatabase.getEmployees().stream()
                .filter(employee -> employee.getSalary() == secondHighestSalary)
                .collect(Collectors.toList());

        secondHighestSalaryEmployees.forEach(System.out::println);//Employee{id=103, name='Abhijit', grade='C', dept='DEV', salary=110000.0, address=[Address [city=Kolkata, country=India], Address [city=Bhopal, country=India]]}

```
## Second or nth most frequent occurrence in word
```java
//1. Find the second or nth most frequent occurrence in the word it will give the result character
   String st = "aaababddd";
        Map<String, Long> collect = Arrays.stream(st.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + ": " + v));//a: 4 b: 2 d: 3


        String s = collect.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .skip(1)
                .map(Map.Entry::getKey)
                .findFirst()
                .get();
        System.out.println(" String :" + s);//String :d
/*---------------------------------------------------------------------------*/

//1. Find the second or nth most frequent occurrence in the word it will give result as LinkedHashMap 
  String st = "aaababdddeee";
        Map<String, Long> collect = Arrays.stream(st.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + ": " + v));//a: 4 b: 2 d: 3


        LinkedHashMap<String, Long> collect1 = collect.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .skip(1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        collect1.forEach((k,v) -> System.out.println("collect1 :->"+ k +" : "+v));//collect1 :->d : 3

```
