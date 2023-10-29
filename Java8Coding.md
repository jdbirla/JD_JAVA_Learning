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
        new com.jd.inttest.core.Employee(103, "Abhijit", "C", "DEV", 110000,
            List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India")))),
        new com.jd.inttest.core.Employee(104, "Bhupendra", "D", "BAU", 10000,
            List.of((new Address("Indore", "India")), (new Address("Mumbai", "India")))),
        new com.jd.inttest.core.Employee(105, "Niranjan", "A", "Lead", 90000,
            List.of((new Address("Chennai", "India")), (new Address("Tokyo", "Japan")))),
        new com.jd.inttest.core.Employee(106, "Sunil", "B", "IT", 80000,
            List.of((new Address("Chennai", "India")), (new Address("Bangalore", "India")))),
        new com.jd.inttest.core.Employee(107, "Gajanand", "A", "Manager", 70000,
            List.of((new Address("Indore", "India")), (new Address("Pune", "India")))),
        new com.jd.inttest.core.Employee(108, "Mrp", "A", "DEV", 60000,
            List.of((new Address("Kolkata", "India")), (new Address("Bhopal", "India"))))

    ).collect(Collectors.toList());
  }
}


```
## Iterations
### Array
```java
//1. Using a for loop:
int[] numbers = {1, 2, 3, 4, 5};
for (int i = 0; i < numbers.length; i++) {
    System.out.println(numbers[i]);
}

//2. Using an enhanced for loop (for-each loop):
int[] numbers = {1, 2, 3, 4, 5};
for (int number : numbers) {
    System.out.println(number);
}

//3. Using the Arrays class from java.util:
int[] numbers = {1, 2, 3, 4, 5};
List<Integer> numberList = Arrays.asList(numbers);
for (int number : numberList) {
    System.out.println(number);
}

//4. Using a while loop:
int[] numbers = {1, 2, 3, 4, 5};
int i = 0;
while (i < numbers.length) {
    System.out.println(numbers[i]);
    i++;
}

//5. Using Java Streams (Java 8 and later):
int[] numbers = {1, 2, 3, 4, 5};
Arrays.stream(numbers).forEach(number -> System.out.println(number));

```
### List
```java
//1. For Each Loop (Enhanced For Loop):
List<Employee> employees = EmployeeDatabase.getEmployees();

for (Employee employee : employees) {
    System.out.println(employee.getName());
}

//2. Iterator
List<Employee> employees = EmployeeDatabase.getEmployees();
        Iterator<Employee> iterator = employees.iterator();

        while (iterator.hasNext()) {
            Employee employee = iterator.next();
            System.out.println(employee.getName());
        }
//3.For Loop (Traditional):
  List<Employee> employees = EmployeeDatabase.getEmployees();

        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            System.out.println(employee.getName());
        }
//4.Java 8 Stream API:
    List<Employee> employees = EmployeeDatabase.getEmployees();

        employees.stream()
                .forEach(employee -> System.out.println(employee.getName()));


```
### Set 
```java
//1. Using an enhanced for loop (for-each loop):
Set<String> stringSet = new HashSet<>();
stringSet.add("apple");
stringSet.add("banana");
stringSet.add("cherry");

for (String element : stringSet) {
    System.out.println(element);
}

//2.Using an Iterator:
Set<Integer> numberSet = new TreeSet<>();
numberSet.add(1);
numberSet.add(2);
numberSet.add(3);

Iterator<Integer> iterator = numberSet.iterator();
while (iterator.hasNext()) {
    Integer element = iterator.next();
    System.out.println(element);
}

//3.Using Java Streams (Java 8 and later):
Set<Double> doubleSet = new LinkedHashSet<>();
doubleSet.add(1.1);
doubleSet.add(2.2);
doubleSet.add(3.3);

doubleSet.stream().forEach(element -> System.out.println(element));

//4.Using forEach method (Java 8 and later):
Set<String> colors = new HashSet<>();
colors.add("red");
colors.add("green");
colors.add("blue");

colors.forEach(color -> System.out.println(color));

//5.Using a while loop and toArray method:
Set<Character> charSet = new HashSet<>();
charSet.add('A');
charSet.add('B');
charSet.add('C');

Object[] charArray = charSet.toArray();
for (Object element : charArray) {
    System.out.println(element);
}



```
### Map
```java
 Map<String, Integer> map = new HashMap<>();
        map.put("one", 1);
        map.put("two", 2);
        map.put("three", 3);
        //foreach
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
        //while loop
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String key = entry.getKey();
            Integer value = entry.getValue();
            System.out.println(key + " => " + value);
        }
        //forach
        map.forEach((key, value) -> {
            System.out.println(key + " => " + value);
        });
        //stream
        map.entrySet().stream()
                .forEach(entry -> {
                    String key = entry.getKey();
                    Integer value = entry.getValue();
                    System.out.println(key + " => " + value);
                });
        // stream for keys
        map.keySet().stream().iterator().forEachRemaining(System.out::println);
        System.out.println("-----------------------------------------------------");
        // stream for values
        map.values().stream().forEach(a -> System.out.println(a));
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
/*---------------------------------------------------------------------------*/
//3. Second highest salary from map where salary value may duplicate
  Map<String, Integer> emap = new HashMap<>();
        emap.put("Ram", 1000);
        emap.put("Raju", 2000);
        emap.put("Ramaan", 3000);
        emap.put("JD", 3000);

        int secondHighestSalary = emap.values().stream()
                .distinct()
                .sorted((a, b) -> b - a)
                .skip(1)
                .findFirst()
                .orElse(Integer.MIN_VALUE);

        Map<String, Integer> result = emap.entrySet().stream()
                .filter(e -> e.getValue() == secondHighestSalary)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        System.out.println(result);//{Raju=2000}
```
## Second or nth most frequent, frequncey, counting occurrence in word
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

//2. Find the second or nth most frequent occurrence in the word it will give result as LinkedHashMap 
  String st = "aaababdddeee";
        Map<String, Long> collect = Arrays.stream(st.split("")).collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        collect.forEach((k, v) -> System.out.println(k + ": " + v));//a: 4 b: 2 d: 3


        LinkedHashMap<String, Long> collect1 = collect.entrySet().stream().sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .limit(2)
                .skip(1)
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        collect1.forEach((k,v) -> System.out.println("collect1 :->"+ k +" : "+v));//collect1 :->d : 3
/*---------------------------------------------------------------------------*/

//3. How to count occurrences of each character of a String in Java 8? WAP uses stream to find frequency of each character in a given string
        String someString1 = "Jitendra Birla";
        String[] arrstr = someString1.replaceAll("\\W", "").split("");
        Stream s1 = Arrays.stream(arrstr);
        Map<String, Long> collectjd = (Map<String, Long>) s1
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        System.out.println(collectjd);//{a=2, B=1, r=2, d=1, t=1, e=1, i=2, J=1, l=1, n=1}
/*---------------------------------------------------------------------------*/

//4. Count the no of occurance of words in given string using java 8
        String input = "welcome to code decode and code decode welcome you";

        List<String> list = Arrays.asList(input.split(" "));

        Map<String, Long> collect = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
        Map<String, Long> collect1 = list.stream().collect(Collectors.groupingBy(a -> a, Collectors.counting()));

        System.out.println(collect1);//{code=2, and=1, to=1, decode=2, welcome=2, you=1}


```
## Find duplicate
```java
//1. Find duplicate integers from list and delete them
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 2, 3, 1);

        Map<Integer, Long> counted = list.stream()
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        List<Integer> result = counted.entrySet().stream()
                .filter(entry -> entry.getValue() == 1)
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
        System.out.println(result);//[4]
/*---------------------------------------------------------------------------*/
//2. How to find duplicate elements in a given integers list in java using Stream
        List<Integer> myList2 = Arrays.asList(10, 15, 8, 10, 25, 15, 32, 15);
        HashSet<Integer> s = new HashSet<Integer>();
        myList2.stream().filter(a -> !s.add(a)).distinct().forEach(System.out::println);//10 15
```
## Mapping , MAP , flatmap
```java
//1. FlatMap example
         List<List<Address>> collect = EmployeeDatabase.getEmployees()
                .stream()
                .map(Employee::getAddress)
                .collect(Collectors.toList());
        collect.forEach(System.out::println);//[Address [city=Indore, country=India], Address [city=Pune, country=India]] ....

        System.out.println("----------------------------------");
        List<Address> collect1 = EmployeeDatabase.getEmployees()
                .stream()
                .map(Employee::getAddress)
                .flatMap(List::stream)
                .collect(Collectors.toList());
        collect1.forEach(System.out::println);//Address [city=Indore, country=India] ...

        System.out.println("----------------------------------");
        List<Address> collect2 = EmployeeDatabase.getEmployees()
                .stream()
                .flatMap(e -> e.getAddress().stream())
                .collect(Collectors.toList());
        collect2.forEach(System.out::println);//Address [city=Bangalore, country=India] ...

```
## Filtring 
/1. Given a list of integers, find out all the even numbers exist in the list using Stream functions?
```java
 List<Integer> myList = Arrays.asList(10, 15, 8, 49, 25, 98, 32);
        myList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);//10 8 98 32
        myList.stream().filter(n -> n % 2 == 0).iterator().forEachRemaining(System.out::println);
```
## Max , Min

```java
//1. Given a list of integers, find the maximum value element present in it using Stream functions?

        List<Integer> myList3 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        myList3.stream().max(Comparator.comparing(Integer::intValue)).ifPresent(System
                .out::println);//98
        myList3.stream().distinct().collect(Collectors.maxBy(Comparator.comparing(Integer::intValue)))
                .ifPresent(System.out::println);//98
```

## Sorting
```java
//1. Given a list of integers, sort all the values present in it using Stream functions
       List<Integer> myList4 = Arrays.asList(10, 15, 8, 49, 25, 98, 98, 32, 15);
        //Ascending
        List<Integer> collect = myList4.stream().sorted().collect(Collectors.toList());
        System.out.println(collect);
        System.out.println("--------------------------------------------------------------");

        Comparator<Integer> com = (a1, a2) -> a1.compareTo(a2);
        myList4.sort(com);
        System.out.println(myList4);
        System.out.println("--------------------------------------------------------------");

        Collections.sort(myList4);
        System.out.println(myList4);

        System.out.println("--------------------------------------------------------------");

        Comparator<Integer> com2 = (a1, a2) -> {
            if (a1 < a2)
                return -1;
            else if (a1 > a2)
                return +1;
            else
                return 0;
        };

        Collections.sort(myList4, com2);
        System.out.println(myList4);

        System.out.println("--------------------------------------------------------------");
        //Descending
        Comparator<Integer> com3 = (a1, a2) -> {
            if (a1 < a2)
                return +1;
            else if (a1 > a2)
                return -1;
            else
                return 0;
        };

        Collections.sort(myList4, com3);
        System.out.println(myList4);
        System.out.println("--------------------------------------------------------------");

        Comparator<Integer> com1 = (a1, a2) -> -a1.compareTo(a2);
        Collections.sort(myList4, com1);
        System.out.println(myList4);
        System.out.println("--------------------------------------------------------------");

        myList4.stream().sorted(Collections.reverseOrder()).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");

        myList4.stream().sorted(Comparator.comparing(Integer::intValue).reversed()).forEach(System.out::println);
        System.out.println("--------------------------------------------------------------");
/*---------------------------------------------------------------------------*/
//2. sort the employee based on ID 
  List<Employee> empList = EmployeeDatabase.getEmployees();
//By ID
        List<Employee> empsortbyid = empList.stream().sorted((e1, e2) -> e1.getId().compareTo(e2.getId()))
                .collect(Collectors.toList());
        System.out.println("Sort by id: " + empsortbyid);

```
## Group by , grouping by
```java
//1. Assume you have a list of employees in various dept, WAP to find the highest paid employee from each dept?

        Map<String, Optional<Employee>> collect = EmployeeDatabase.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.maxBy(Comparator.comparing(e -> e.getSalary()))));
        collect.forEach((k, v) -> System.out.println(k + ": " + v.get()));
        System.out.println("--------------------------------------------------------------");

        Map<String, Employee> collect1 = EmployeeDatabase.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept,
                        Collectors.collectingAndThen(Collectors.maxBy(Comparator.comparing(e -> e.getSalary())), Optional::get))
                );
        collect1.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("--------------------------------------------------------------");


        BinaryOperator<Employee> be = (a, b) -> a.getSalary() > b.getSalary() ? a : b;

        Map<String, Optional<Employee>> collect2 = EmployeeDatabase.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.reducing(be)));
        collect2.forEach((k, v) -> System.out.println(k + ": " + v.get()));
        System.out.println("--------------------------------------------------------------");

        Map<String, Employee> collect3 = EmployeeDatabase.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.collectingAndThen(Collectors.reducing(be), Optional::get)));
        collect3.forEach((k, v) -> System.out.println(k + ": " + v));
        System.out.println("--------------------------------------------------------------");

//2. WAP to a program to collect the employees by department and sort them by salary
List<Employee> employees = EmployeeDatabase.getEmployees();

        LinkedHashMap<String, List<Employee>> employeesByDeptSortedBySalary = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDept,
                        LinkedHashMap::new,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary))
                                        .collect(Collectors.toList())
                        )
                ));

        employeesByDeptSortedBySalary.forEach((department, deptEmployees) -> {
            System.out.println("Department: " + department);
            deptEmployees.forEach(employee -> System.out.println("  " + employee.getName() + " - Salary: " + employee.getSalary()));
        });
//using another approach
 List<Employee> employees = EmployeeDatabase.getEmployees();

        Map<String, List<Employee>> departmentToEmployees = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDept));

        Map<String, List<Employee>> sortedDepartmentToEmployees = new LinkedHashMap<>();

        departmentToEmployees.forEach((department, departmentEmployees) -> {
            List<Employee> sortedEmployees = departmentEmployees.stream()
                    .sorted(Comparator.comparing(Employee::getSalary))
                    .collect(Collectors.toList());
            sortedDepartmentToEmployees.put(department, sortedEmployees);
        });

        sortedDepartmentToEmployees.forEach((department, sortedEmployees) -> {
            System.out.println("Department: " + department);
            sortedEmployees.forEach(employee -> System.out.println("  " + employee.getName() + " - Salary: " + employee.getSalary()));
        });

/*
        Department:
        Manager
        Gajanand - Salary: 70000.0
        Ram - Salary: 120000.0
        Department: IT
        Sunil - Salary: 80000.0
        Raju - Salary: 120000.0
        Department: DEV
        Mrp - Salary: 60000.0
        Abhijit - Salary: 110000.0
        Department: BAU
        Bhupendra - Salary: 10000.0
        Department: Lead
        Niranjan - Salary: 90000.0
        */
//3. WAP to a program to collect the employees by department and sort them by dep
        LinkedHashMap<String, List<Employee>> collect9 = EmployeeDatabase.getEmployees().stream()
                .collect(Collectors.groupingBy(Employee::getDept, Collectors.toList())).entrySet().stream()
                .sorted(Map.Entry.comparingByKey((c1, c2) -> c1.compareTo(c2)))
                .collect(Collectors.toMap(a -> a.getKey(), b -> b.getValue(), (es1, es2) -> es1, LinkedHashMap::new));

        collect9.forEach((department, sortedEmployees) -> {
            System.out.println("Department: " + department);
            sortedEmployees.forEach(employee -> System.out.println("  " + employee.getName() + " - Salary: " + employee.getSalary()));
        });
/*
      Department: BAU
        Bhupendra - Salary: 10000.0
      Department: DEV
        Abhijit - Salary: 110000.0
        Mrp - Salary: 60000.0
      Department: IT
        Raju - Salary: 120000.0
        Sunil - Salary: 80000.0
      Department: Lead
        Niranjan - Salary: 90000.0
      Department: Manager
        Ram - Salary: 120000.0
        Gajanand - Salary: 70000.0
*/
```
## Reducing
```java
//1. Reduce operation practice
 List<Integer> numbers = Arrays.asList(3, 7, 8, 1, 5, 9);

        Optional<Integer> reduce = numbers.stream().reduce((a, b) -> a + b);
        if (reduce.isPresent())
            System.out.println(reduce.get());
        Optional<Integer> reduce1 = numbers.stream().reduce(Integer::sum);
        if (reduce1.isPresent())
            System.out.println(reduce1.get());

        Integer maxval = numbers.stream().reduce(0, (a, b) -> a > b ? a : b);
        System.out.println(maxval);

        Integer maxval2 = numbers.stream().reduce(Integer::max).get();
        System.out.println(maxval2);

        List<String> words = Arrays.asList("corejava", "spring", "hibernate");
        Optional<String> reduce2 = words.stream().reduce((a, b) -> a.length() > b.length() ? a : b);
        System.out.println(reduce2.get());
```
