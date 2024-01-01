# Java_New_Features_Guide

## Java8
### 1. **Lambda Expressions:**
   - **Explanation:** Lambda expressions provide a concise syntax for writing anonymous methods (implementations of functional interfaces). They introduce a way to express instances of single-method interfaces more compactly.
   - **Example:**
     ```java
     // Without Lambda
     Runnable runnable = new Runnable() {
         @Override
         public void run() {
             System.out.println("Hello, World!");
         }
     };

     // With Lambda
     Runnable lambdaRunnable = () -> System.out.println("Hello, World!");
     ```

### 2. **Functional Interfaces:**
   - **Explanation:** A functional interface is an interface with a single abstract method. Lambda expressions can be used to provide the implementation for the abstract method, making it easier to work with functional programming concepts.
   - **Example:**
     ```java
     @FunctionalInterface
     public interface MyFunctionalInterface {
         void myMethod();
     }
     ```

### 3. **Stream API:**
   - **Explanation:** The Stream API provides a powerful and expressive way to process collections of objects. It allows developers to write functional-style code for operations such as filtering, mapping, and reducing.
   - **Example:**
     ```java
     List<String> myList = Arrays.asList("Java", "Python", "JavaScript");

     List<String> result = myList.stream()
                                .filter(s -> s.startsWith("J"))
                                .map(String::toUpperCase)
                                .collect(Collectors.toList());
     ```

### 4. **Default Methods in Interfaces:**
   - **Explanation:** Default methods allow interface authors to add new methods to interfaces without breaking existing implementations. They provide a way to extend interfaces over time.
   - **Example:**
     ```java
     public interface MyInterface {
         void myMethod();

         default void myDefaultMethod() {
             System.out.println("Default Implementation");
         }
     }
     ```

### 5. **Static Methods in Interfaces:**
   - **Explanation:** Java 8 introduced static methods in interfaces, providing a way to include utility methods directly in interfaces. These methods are not tied to a specific instance.
   - **Example:**
     ```java
     public interface MyInterface {
         void myMethod();

         static void myStaticMethod() {
             System.out.println("Static Method");
         }
     }
     ```

### 6. **Method References:**
   - **Explanation:** Method references provide a shorthand notation for lambda expressions when calling a method. They make the code more readable and concise.
   - **Example:**
     ```java
     // Using Lambda
     list.forEach(s -> System.out.println(s));

     // Using Method Reference
     list.forEach(System.out::println);
     ```

### 7. **Optional:**
   - **Explanation:** `Optional` is a container object that may or may not contain a non-null value. It is designed to reduce the occurrence of `NullPointerException` and encourage more explicit handling of potential null values.
   - **Example:**
     ```java
     Optional<String> name = Optional.ofNullable(getName());
     String result = name.orElse("Default Name");
     ```

### 8. **New Date and Time API:**
   - **Explanation:** The java.time package introduces a modern, comprehensive, and immutable date and time API. It addresses many shortcomings of the legacy `Date` and `Calendar` classes.
   - **Example:**
     ```java
     LocalDateTime now = LocalDateTime.now();
     System.out.println(now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
     ```

### 9. **Nashorn JavaScript Engine:**
   - **Explanation:** Nashorn is a lightweight and high-performance JavaScript engine introduced in Java 8. It allows seamless integration of JavaScript code with Java applications.
   - **Example:**
     ```java
     ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
     engine.eval("print('Hello, JavaScript!')");
     ```

### 10. **Collectors:**
   - **Explanation:** The `Collectors` utility class provides a set of static factory methods for creating collectors. Collectors are used with the Stream API to perform mutable reduction operations on the elements of a stream.
   - **Example:**
     ```java
     List<String> myList = Arrays.asList("Java", "Python", "JavaScript");
     Map<Integer, List<String>> groupedByLength = myList.stream()
                                                      .collect(Collectors.groupingBy(String::length));
     ```

### 11. **Parallel Streams:**
   - **Explanation:** Parallel streams allow the processing of collections concurrently, leveraging multiple threads to potentially improve performance for computationally intensive operations.
   - **Example:**
     ```java
     List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
     int sum = numbers.parallelStream().mapToInt(Integer::intValue).sum();
     ```

These features collectively brought significant improvements to the Java language, making it more expressive, readable, and aligned with modern programming paradigms. They laid the foundation for subsequent Java versions and continue to be widely used in contemporary Java development.
## Java9

## Java11

## Java17

## Java21
