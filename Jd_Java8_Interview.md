# Java 8 Interview

### Coding Interview Question: https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8/Java_8_In_Action/Java8InAction-master/src/main/java/lambdaasinaction/jd/JavaCodingInterview.java

### Example Instructor
```java
public static List<Instructor> getAll(){
        Instructor instructor1 = new Instructor("Mike", 10, "Software Developer"
         , "M", true, Arrays.asList("Java Programming", "C++ Programming", "Python Programming"));

        Instructor instructor2 = new Instructor("Jenny", 5, "Engineer"
                , "F", false, Arrays.asList("Multi-Threaded Programming", "CI/CD", "Unit Testing"));

        Instructor instructor3 = new Instructor("Gene", 6, "Manager"
                , "M", false, Arrays.asList("C++ Programming", "C Programming", "React Native"));

        Instructor instructor4 = new Instructor("Anthony", 15, "Senior Developer"
                , "M", true, Arrays.asList("Java Programming", "Angular Programming", "React Native"));

        Instructor instructor5 = new Instructor("Syed", 15, "Principal Engineer"
                , "M", true, Arrays.asList("Java Programming", "Java Multi-Threaded Programming", "React Native"));

        List<Instructor> list = Arrays.asList(instructor1,instructor2,instructor3,instructor4,instructor5);
        return list;

    }
```
### Consumer
```java
void accept(T t);
default Consumer<T> andThen(Consumer<? super T> after)


 List<Instructor> instructors = Instructors.getAll();
        Consumer jdprint = (s1) -> System.out.print("   ::  -->");
        Consumer jdprint1 = (s1) -> System.out.print("\n");
	
  instructors.forEach(s1->{ 
			  if(s1.yearsOfExperience > 5 && s1.isOnlineCourses())
			  {
		  c1.andThen(jdprint).andThen(c2).andThen(jdprint1).accept(s1); } }
		  );
```
### Predictate
```java
boolean test(T t);
default Predicate<T> and(Predicate<? super T> other)
default Predicate<T> negate()
default Predicate<T> or(Predicate<? super T> other)

List<Instructor> instructors = Instructors.getAll();
        BiPredicate<Boolean, Integer> p3 = (online, experience) -> online==true && experience>10;

        //Biconsumer print name and courses
        BiConsumer<String, List<String>> biConsumer = (name, courses) ->
                System.out.println("name is: " + name + " courses : " + courses);

        instructors.forEach(instructor -> {
            if(p3.test(instructor.isOnlineCourses(), instructor.getYearsOfExperience()))
                biConsumer.accept(instructor.getName(), instructor.getCourses());
        });
```
 ### Function
 ```java
 R apply(T t);
default <V> Function<V, R> compose(Function<? super V, ? extends T> before)
default <V> Function<T, V> andThen(Function<? super R, ? extends V> after)
static <T> Function<T, T> identity()


   //Map of instructors with name and years of experience
        //Function which will List<Instructors> and return a Map<String, Integer>
        //Predicate will return true if instructor has online courses
        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses()==true;
        Function<List<Instructor>, Map<String,Integer>> mapFunction = (instructors -> {
            Map<String,Integer> map = new HashMap<>();
            instructors.forEach(instructor -> {
                if(p1.test(instructor)) {
                    map.put(instructor.getName(), instructor.getYearsOfExperience());
                }
            });
            return map;
        });

        System.out.println(mapFunction.apply(Instructors.getAll()));
    }
    
   //BiFunction
    //Bifuction 2 inputs List<Instructors> and second is predicate which will filter if instructor has online
        //courses and return a map of <String,Integer> string is name and Integer is the years of experience

        Predicate<Instructor> p1 = (i) -> i.isOnlineCourses()==true;
        BiFunction<List<Instructor>, Predicate<Instructor>, Map<String,Integer>> mapBiFunction =
                ((instructors, instructorPredicate) -> {
                    Map<String, Integer> map = new HashMap<>();
                    instructors.forEach(instructor -> {
                        if(instructorPredicate.test(instructor)){
                            map.put(instructor.getName(), instructor.getYearsOfExperience());
                        }
                    });
                    return map;
                });
        System.out.println(mapBiFunction.apply(Instructors.getAll(), p1));
   
```
### Supplier
```java
T get();
 Supplier<Integer> supplier = () -> (int) (Math.random() * 1000);
        System.out.println(supplier.get());
```
### MethodReferenceExample 
```java
 Predicate<Instructor> p2 = ConvertToMethodReferenceExample::greaterThanTenYearsOfExperience;

        Instructors.getAll().forEach(instructor -> {
                if (p2.test(instructor)){
                    System.out.println(instructor);
                }
        });
    }
    public static boolean greaterThanTenYearsOfExperience(Instructor instructor) {
        if (instructor.getYearsOfExperience()>10)
            return true;
        return false;
    }
```
### VariableScope
```java
 static int l=0;
    public static void main(String[] args) {
        //Case1
    	//int a =10; //local variable
       // IntConsumer intConsumer = (a) -> System.out.println(a*10); //Compile time Error {Lambda expression's parameter a cannot redeclare another local variable defined in an enclosing scope. }

    	int b =10; //local variable
        IntConsumer intConsumer = (a) -> System.out.println(a*10); //

        //Case 2
        int k=0;
        List<Instructor> instructors =  Instructors.getAll();
        instructors.forEach(instructor  ->{
       //  	System.out.println( k++); //Compile time Error  {Local variable k defined in an enclosing scope must be final or effectively final}
        });
        
        //Case 3
     
        List<Instructor> instructors1 =  Instructors.getAll();
        instructors1.forEach(instructor  ->{
        	System.out.println( instructor + " " +l); //No error as variable define as class level and its static
            l++;
        });
        		
        
    }
```
## Stream
#### Map

```java
 //return only instructor names from the instructor list
        Set<String> instructorNames = Instructors.getAll().stream()
                                        .map(Instructor::getName)
                                        .map(String::toUpperCase)
                                        .collect(Collectors.toSet());
        System.out.println(instructorNames);
```
###  FlatMap

```java
 //Get a list of all the courses which instructors offers
        Set<String> instructorsCourses = Instructors.getAll().stream()
                                        .map(Instructor::getCourses)
                                        .flatMap(List::stream)
                                        .collect(Collectors.toSet());
        System.out.println(instructorsCourses);
```
### distinct,count,sorted, allmatch and NoneMatch
```java
//count   distinct :: Returns the count of elements in this stream.

        Long count = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .count();

        System.out.println(count);
        //distinct Returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.

        List<String> courses = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .distinct()
                .sorted()
                .collect(Collectors.toList());
        System.out.println(courses);

        //anymatch,  true if any elements of the stream match the provided predicate, otherwise false


        boolean match = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .anyMatch(s-> s.startsWith("J"));
        
        System.out.println(match);
        // allmatch : true if either all elements of the stream match the provided predicate or the stream is empty, otherwise false

        boolean allmatch = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .allMatch(s-> s.startsWith("J"));
        
        System.out.println(allmatch);
        
        //None mathc : true if either no elements of the stream match the provided predicate or the stream is empty, otherwise false

        boolean nonematch = Instructors.getAll().stream()
                .map(Instructor::getCourses)
                .flatMap(List::stream)
                .noneMatch(s-> s.startsWith("J"));
   //an Optional describing some element of this stream, or an empty Optional if the stream is empty     
	Optional<T> findAny()
	
  // findFirst :: an Optional describing the first element of this stream, or an empty Optional if the stream is empty

  Optional<T> findFirst()
  
  
  //limit :: Returns a stream consisting of the elements of this stream, truncated to be no longer than maxSize in length.
  Stream<T>	limit(long maxSize)
	
	///
	Comparator<Developer> salaryComparator = (o1, o2)->o1.getSalary().compareTo(o2.getSalary());
	listDevs.sort(salaryComparator);
///
// max :: Returns the maximum element of this stream according to the provided Comparator. This is a special case of a reduction.
Optional<T> max(Comparator<? super T> comparator)

// min: Returns the minimum element of this stream according to the provided Comparator. This is a special case of a reduction.

Optional<T> min(Comparator<? super T> comparator)

//skip ::Returns a stream consisting of the remaining elements of this stream after discarding the first n elements of the stream. If this stream contains fewer than n elements then an empty stream will be returned.
Stream<T> skip(long n)

// sorted :: Returns a stream consisting of the elements of this stream, sorted according to natural order. If the elements of this stream are not Comparable, a java.lang.ClassCastException may be thrown when the terminal operation is executed
Stream<T> sorted()

//  sorted :: Returns a stream consisting of the elements of this stream, sorted according to the provided Comparator.
For ordered streams, the sort is stable. For unordered streams, no stability guarantees are made.
Stream<T> sorted(Comparator<? super T> comparator)

ex. customized sort using comparator
 //retuning all instructors sorted by their name
        List<Instructor> list = Instructors.getAll().stream()
                            .sorted(Comparator.comparing(Instructor::getName).reversed())
                            .collect(Collectors.toList());

        list.forEach(System.out::println);


// 

```
### Reduce repeated process for each elements with give operation like csum,multipication, comparison
```java
 List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8,9);
        int results = numbers.stream()
                     //0 +1 = 1        //10+5= 15    //36+9=45
                    //1 + 2 = 3        //15+ 6= 21
                    //3 + 3 = 6        //21+7 = 28
                    //6+ 4 = 10        //28+8 = 36
                    .reduce(0,(a,b) -> a +b);

        //1 * 1 = 1     //0*1 = 0
        //1 * 2 = 2     //0*2=0
        int results1 = numbers.stream().reduce(1,(a,b) -> a* b);
        System.out.println(results);
        System.out.println(results1);

        Optional result2 = numbers.stream().reduce((a, b) -> a + b);
        System.out.println("--------");
        if(result2.isPresent())
            System.out.println(result2.get());
	    ----
	      //printing the instructor who has the highest years of experience
        Optional instructor = Instructors.getAll().stream()
                .reduce((s1,s2)-> s2.getYearsOfExperience()
                        >s1.getYearsOfExperience()?s2:s1);
        if(instructor.isPresent())
            System.out.println(instructor.get());

    }
```
#### Max using 3 different approaches
```java
List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        //max using stream max function
        Optional result = numbers.stream().max(Integer::compareTo);
        if(result.isPresent())
            System.out.println(result.get());
        //(0,1) - 1   // return 0
        //(1,2) - 2
        //(2,3) - 3
        int result2 = numbers.stream().reduce(0,(a,b)-> a>b?a:b);
        Optional result3 = numbers.stream().reduce((a,b)->a>b?a:b);
        if(result3.isPresent())
            System.out.println(result3.get());

        Optional result4 = numbers.stream().reduce(Integer::max);
        if(result4.isPresent())
            System.out.println(result4.get());


    }
```
#### Min using 3 different approaches

```java
 public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1,2,3,4,5,6,7,8);
        //Stream min function
        Optional result = numbers.stream().min(Integer::compareTo);
        if(result.isPresent())
        System.out.println(result.get());

        //reduce function
        //(0,1) - 0  //(0,3) - 0
        //(0,2) - 0
        int result1 = numbers.stream().reduce(0,(a,b) -> a<b?a:b);
        System.out.println(result1);

        Optional result2 = numbers.stream().reduce((a,b) -> a<b?a:b);
        if(result2.isPresent())
            System.out.println(result2.get());

        Optional result3 = numbers.stream().reduce(Integer::min);
        if(result3.isPresent())
            System.out.println(result3.get());


    }
```
###  Streams Generators
```java
//of
        Stream<Integer> stream = Stream.of(1,2,3,4,5,6,7,8);
        stream.forEach(System.out::println);

        System.out.println("-----------");
        //iterate generate a stream of 10 even numbers
        Stream<Integer> stream1 = Stream.iterate(0,i->i+2).limit(10);
        stream1.forEach(System.out::println);

        System.out.println("--------------");
        //generate 10 random numbers
        Stream<Integer> stream2 = Stream.generate(new Random()::nextInt).limit(10);
        stream2.forEach(System.out::println);
```
### intStream,LongStream,DoubleStream
```java
    //using of
        IntStream numbers = IntStream.of(1,2,3,4,5);
        numbers.forEach(System.out::println);

        System.out.println("-----------");
        //iterate
        numbers = IntStream.iterate(0, i-> i+2).limit(5);
        numbers.forEach(System.out::println);

        System.out.println("-----------");
        //Random Generator
        numbers=IntStream.generate(new Random()::nextInt).limit(5);
        numbers.forEach(System.out::println);

        System.out.println("-----------");
        //range

        numbers = IntStream.range(1,5);
        numbers.forEach(System.out::println);

        System.out.println("-----------");

        //rangeClosed
        numbers = IntStream.rangeClosed(1,5);
        numbers.forEach(System.out::println);
```
## Collectors Operations
```java
 //Implementations of Collector that implement various useful reduction operations, such as accumulating elements into collections, summarizing elements according to  //various criteria, etc.
// Accumulate names into a List
     List<String> list = people.stream().map(Person::getName).collect(Collectors.toList());

     // Accumulate names into a TreeSet
     Set<String> set = people.stream().map(Person::getName).collect(Collectors.toCollection(TreeSet::new));

     // Convert elements to strings and concatenate them, separated by commas
     String joined = things.stream()
                           .map(Object::toString)
                           .collect(Collectors.joining(", "));

     // Compute sum of salaries of employee
     int total = employees.stream()
                          .collect(Collectors.summingInt(Employee::getSalary)));

     // Group employees by department
     Map<Department, List<Employee>> byDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment));

     // Compute sum of salaries by department
     Map<Department, Integer> totalByDept
         = employees.stream()
                    .collect(Collectors.groupingBy(Employee::getDepartment,
                                                   Collectors.summingInt(Employee::getSalary)));

     // Partition students into passing and failing
     Map<Boolean, List<Student>> passingFailing =
         students.stream()
                 .collect(Collectors.partitioningBy(s -> s.getGrade() >= PASS_THRESHOLD));
		 
   //mapping 
   
    //mapping
        namesList= Instructors.getAll().stream()
                .collect(Collectors.mapping(Instructor::getName, Collectors.toList()));

        namesList.forEach(System.out::println);

        //Instructors by their years of experience
        System.out.println("-----------------------------");
        System.out.println(Instructors.getAll());
        Map<Integer, List<String>> mapYearsOfExperienceAndNames = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience,
                        Collectors.mapping(Instructor::getName, Collectors.toList())));
        Map<Integer, List<Instructor>> mapYearsOfExperienceAndNames1 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience, Collectors.toList()));
        Map<Integer, List<Instructor>> mapYearsOfExperienceAndNames2 = Instructors.getAll().stream()
                .collect(Collectors.groupingBy(Instructor::getYearsOfExperience));
        mapYearsOfExperienceAndNames.forEach((key,value) ->{
            System.out.println("key = " + key + " value = " + value);
        });
        System.out.println("-----------------------------");
	
	//minby() and maxBy()
	//instructor with minimum years of experience
        Optional<Instructor> instructor = Instructors.getAll().stream()
                .collect(Collectors.minBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        System.out.println("instructor = " + instructor);
        System.out.println("---------------");

        instructor = Instructors.getAll().stream()
                .min(Comparator.comparing(Instructor::getYearsOfExperience));
        System.out.println("instructor = " + instructor);

       instructor = Instructors.getAll().stream()
                .collect(Collectors.maxBy(Comparator.comparing(
                        Instructor::getYearsOfExperience)));
        System.out.println("instructor = " + instructor);
        System.out.println("---------------");

        instructor = Instructors.getAll().stream()
                .max(Comparator.comparing(Instructor::getYearsOfExperience));
        System.out.println("instructor = " + instructor);
	
//Grouping BY
   //grouping by instructors by their gender
        Map<String, List<Instructor>> instructorByGender = Instructors.getAll()
                .stream().collect(Collectors.groupingBy(Instructor::getGender));

 //grouping by length of string and also checking that the names contains e
        //and only return those name which has e in it
        List<String> name = List.of("Sid", "Mike", "Jenny", "Gene", "Rajeev");
        Map<Integer, List<String>> result = name.stream()
                .collect(Collectors.groupingBy(String::length, Collectors
                        .filtering(s-> s.contains("e"),Collectors.toList())));
//grouping by length of string and also checking that the names contains e
        //and only return those name which has e in it
        List<String> name = List.of("Sid", "Mike", "Jenny", "Gene", "Rajeev");
        LinkedHashMap<Integer, List<String>> result = name.stream()
                .collect(Collectors.groupingBy(String::length, LinkedHashMap::new, Collectors
                        .filtering(s-> s.contains("e"),Collectors.toList())));
			
 //partition but return is set instead of list

        Map<Boolean, Set<Instructor>> partitionSet = Instructors.getAll()
                .stream().collect(Collectors.partitioningBy(experiencePredicate,
                        Collectors.toSet()));
        partitionSet.forEach((key,value) -> {
            System.out.println("key = " + key + " value: " + value);
        });

```
### Parallel Stream
```java
public static int sumParallelStream(){
        return IntStream.rangeClosed(0,50000).parallel().sum();
    }
    

```
### Optional
```java
//A container object which may or may not contain a non-null value. If a value is present, isPresent() will return true and get() will return the value.
    static <T> Optional<T>	empty()
```
![image](https://user-images.githubusercontent.com/69948118/175802247-d46a7199-b684-417c-bd86-864ac29d0172.png)

```java
    

```

```java
    

```

```java
    

```

```java
    

```

