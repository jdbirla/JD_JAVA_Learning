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
### 12. **Java 8 StringJoiner**
  - Joining multiple strings in a very common task in day-to-day programming activity. There was no direct way to join multiple String in Java (Other than using the third-party API’s). Java 8 Introduced a new class StringJoiner which is useful to join multiple Strings.StringJoiner is a kind of a Collector.
```java
public static void joinerWithDelimiterWithPrefixAndSuffix(){
    StringJoiner joiner = new StringJoiner(",", "Prefix-", "-Suffix");
    joiner.add("Sunday");
    joiner.add("Monday");
    joiner.add("Tuesday");
    joiner.add("Wednesday");

    //display output
    System.out.println(joiner.toString());//Prefix-Sunday-Monday-Tuesday-Wednesday-Suffix

}
```

### 13. **Type Annotations**
  - Type annotations are one more feature introduced in Java 8. Even though we had annotations available before, now we can use them wherever we use a type. This means that we can use them on
     -  a local variable definition
     -  constructor calls
     -  type casting
     -  generics
     -  throw clauses and more
```java
public class TypeAnnotations {

    public static void main(String[] args) {
        @NotNull String userName = args[0];
    }
}

public class TypeAnnotations {

    public static void main(String[] args) {
        List<String> request =
                new @NotEmpty ArrayList<>(Arrays.stream(args).collect(
                        Collectors.toList()));
    }
}

public class TypeAnnotations {

    public static void main(String[] args) {
        List<@Email String> emails;
    }
}
```

### 14. **Repeating Annotations**
  - Let us imagine we have an application with fully implemented security. It has different levels of authorization. Even though we implemented everything carefully, we want to make sure that we log every unauthorized action. On each unauthorized action, we are sending an email to the owner of the company and our security admin group email. Repeating annotations are our way to go on this example.

```java
public class RepeatingAnnotations {
    
    @Repeatable(Notifications.class)
    public @interface Notify {
        String email();
    }

    public @interface Notifications {
        Notify[] value();
    }
}
```
---
## Java9

### 1. **Module System (Project Jigsaw):**
   - **Use Case:** Modularizes the Java SE Platform to improve scalability, maintainability, and security.
   - **Example:** Creating a module-info.java file to define a module.

   ```java
   module com.example.myapp {
       requires java.base;
       exports com.example.mypackage;
   }
   ```

### 2. **JShell (Interactive REPL):**
   - **Use Case:** Provides an interactive shell for evaluating Java expressions and statements.
   - **Example:** Launching JShell and executing Java code interactively.

   ```java
   jshell> int sum = 5 + 7;
   sum ==> 12
   ```

### 3. **HTTP/2 Client:**
   - **Use Case:** Provides a new HTTP client to support HTTP/2 and WebSocket, with improved performance and features.
   - **Example:** Making a simple HTTP GET request.

   ```java
   HttpClient httpClient = HttpClient.newHttpClient();
   HttpRequest request = HttpRequest.newBuilder()
                                   .uri(URI.create("https://www.example.com"))
                                   .build();
   HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
   ```

### 4. **Improved Stream API:**
   - **Use Case:** Introduces new methods to the Stream API for better functionality and performance.
   - **Example:** Using `takeWhile` to create a stream while a condition is true.

   ```java
   List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
   List<Integer> result = numbers.stream().takeWhile(n -> n < 5).collect(Collectors.toList());
   ```

### 5. **Multi-Release JAR Files:**
   - **Use Case:** Allows packaging different versions of class files for different Java releases into a single JAR.
   - **Example:** Including classes for both Java 8 and Java 9 in the same JAR.

   ```
   META-INF/
       versions/
           9/
               com/example/MyClass.class (for Java 9)
           8/
               com/example/MyClass.class (for Java 8)
   ```

### 6. **Process API Updates:**
   - **Use Case:** Enhances the Process API to control and manage native processes.
   - **Example:** Running a process and obtaining its PID.

   ```java
   ProcessBuilder processBuilder = new ProcessBuilder("echo", "Hello, World!");
   Process process = processBuilder.start();
   ProcessHandle handle = process.toHandle();
   long pid = handle.pid();
   ```

### 7. **Try-With-Resources Enhancement:**
   - **Use Case:** Simplifies resource management by allowing effectively final resources to be used in the try-with-resources statement.
   - **Example:** Using try-with-resources with a resource declared outside the statement.

   ```java
   BufferedReader reader = new BufferedReader(new FileReader("file.txt"));
   try (reader) {
       // Read from the file
   } catch (IOException e) {
       // Handle exception
   }
   ```

### 8. **Private Methods in Interfaces:**
   - **Use Case:** Allows the definition of private methods in interfaces, aiding code organization and reuse.
   - **Example:** Adding a private helper method to an interface.

   ```java
   public interface MyInterface {
       default void publicMethod() {
           privateHelperMethod();
       }

       private void privateHelperMethod() {
           // Implementation
       }
   }
   ```

### 9. **Diamond Operator Enhancements:**
   - **Use Case:** Enables the diamond operator (`<>`) to be used with anonymous classes.
   - **Example:** Using the diamond operator with an anonymous class.

   ```java
   List<String> myList = new ArrayList<>() {
       {
           add("Java");
           add("Python");
           add("JavaScript");
       }
   };
   ```

### 10. **Reactive Streams API:**
   - **Use Case:** Introduces a standardized API for asynchronous stream processing with non-blocking backpressure.
   - **Example:** Working with reactive streams using `Publisher`, `Subscriber`, and `Subscription`.

   ```java
   Publisher<String> publisher = /* ... */;
   Subscriber<String> subscriber = /* ... */;
   publisher.subscribe(subscriber);
   ```
---
## Java10
### Local Variable Type Inference
- Java always needed explicit types on local variables.
When writing and reading code, we always know which type we expect. On the other hand, a lot of the code is just types with no usability.
The var type allows us to omit type from the left-hand side of our statements.
```java
public class LocalTypeVar {

    public void varTypes() {
        var Roland = new Person("Roland", "Deschain");
        var Susan = new Person("Susan", "Delgado");
        var Eddie = new Person("Eddie", "Dean");
        var Detta = new Person("Detta", "Walker");
        var Jake = new Person("Jake", "Chambers");

        var persons = List.of(Roland, Susan, Eddie, Detta, Jake);

        for (var person : persons) {
            System.out.println(person.name + " - " + person.lastname);
        }
    }
}
```
---
## Java11
Java 11 introduced several features and enhancements to the language and platform. Here are the key features, along with existing enhancements, and their use cases with examples:

### 1. **Local-Variable Syntax for Lambda Parameters:**
   - **Use Case:** Allows using `var` in lambda expressions.
   - **Example:**
     ```java
     BiFunction<Integer, Integer, Integer> add = (var a, var b) -> a + b;
     ```

### 2. **HTTP Client (Standard):**
   - **Use Case:** A standardized HTTP client that replaces the old `HttpURLConnection` with a more modern and flexible API.
   - **Example:**
     ```java
     HttpClient httpClient = HttpClient.newHttpClient();
     HttpRequest request = HttpRequest.newBuilder()
                                   .uri(URI.create("https://www.example.com"))
                                   .build();
     HttpResponse<String> response = httpClient.send(request, HttpResponse.BodyHandlers.ofString());
     ```

### 3. **JEP 321: HTTP Client (Upgrade):**
   - **Use Case:** The HTTP client supports WebSocket communication.
   - **Example:**
     ```java
     WebSocket webSocket = httpClient.newWebSocketBuilder()
                                     .buildAsync(URI.create("wss://example.com"), listener)
                                     .join();
     ```

### 4. **JEP 329: ChaCha20 and Poly1305 Cryptographic Algorithms:**
   - **Use Case:** Adds support for the ChaCha20 and Poly1305 cryptographic algorithms.
   - **Example:** Using ChaCha20 and Poly1305 for encryption and authentication.

### 5. **JEP 333: ZGC: A Low-Latency Garbage Collector:**
   - **Use Case:** Introduces the Z Garbage Collector (ZGC), designed for low-latency applications.
   - **Example:** Enabling ZGC in Java applications.

     ```
     java -XX:+UnlockExperimentalVMOptions -XX:+UseZGC -jar myapp.jar
     ```

### 6. **JEP 330: Launch Single-File Source-Code Programs:**
   - **Use Case:** Enables running a single-file Java source code program directly.
   - **Example:**
     ```java
     // Hello.java
     public class Hello {
         public static void main(String[] args) {
             System.out.println("Hello, World!");
         }
     }
     ```

     Run using:
     ```
     java Hello.java
     ```

### 7. **JEP 335: Deprecate the Nashorn JavaScript Engine:**
   - **Use Case:** Deprecates the Nashorn JavaScript engine in favor of GraalVM.
   - **Example:** Moving to alternative JavaScript engines for better performance.

### 8. **Epsilon: A No-Op Garbage Collector (Experimental):**
   - **Use Case:** Introduces the Epsilon GC, a no-op garbage collector for performance testing.
   - **Example:** Disabling garbage collection for testing.

     ```
     java -XX:+UnlockExperimentalVMOptions -XX:+UseEpsilonGC -jar myapp.jar
     ```

### 9. **JEP 338: MacOS/OS X Rendering Pipeline:**
   - **Use Case:** Introduces a new rendering pipeline for macOS.
   - **Example:** Improved rendering of Java applications on macOS.

### 10. **JEP 332: Transport Layer Security (TLS) 1.3:**
   - **Use Case:** Adds support for the TLS 1.3 protocol.
   - **Example:** Using TLS 1.3 for secure communication.

### 11. **JEP 336: Deprecate the Pack200 Tools and API:**
   - **Use Case:** Deprecates the Pack200 tools and API in preparation for removal.
   - **Example:** Moving away from Pack200 compression.

### 12. **JEP 342: The JVM Constant API:**
   - **Use Case:** Provides an API for creating and accessing constants in a more standardized way.
   - **Example:** Defining constants using the new API.

     ```java
     class MyConstants {
         @Native
         static final int VALUE = 42;
     }
     ```

---
## Java14
Java 14 introduced several features and enhancements to the language and platform. Here are the key features, along with existing enhancements, and their use cases with examples:


### 3. **JEP 366: Deprecate the ParallelScavenge + SerialOld GC Combination:**
   - **Use Case:** Deprecates the combination of ParallelScavenge and SerialOld garbage collectors.
   - **Example:** Switching to other garbage collector combinations for better performance.

### 4. **JEP 367: Remove the Pack200 Tools and API:**
   - **Use Case:** Removes the Pack200 tools and API from the Java SE Platform.
   - **Example:** Transitioning away from Pack200 compression.

### 6. **JEP 358: Helpful NullPointerExceptions:**
   - **Use Case:** Improves the clarity of NullPointerException error messages.
   - **Example:**
     ```java
     String name = user.getAddress().getCity().toUpperCase();
     ```

     In case of a NullPointerException, the error message will be more informative about which variable was null.

### 7. **JEP 362: Deprecate the Solaris and SPARC Ports:**
   - **Use Case:** Deprecates the Solaris and SPARC ports for future removal.
   - **Example:** Migrating to other supported platforms.

### 8. **JEP 363: Remove the Concurrent Mark Sweep (CMS) Garbage Collector:**
   - **Use Case:** Removes the deprecated CMS garbage collector.
   - **Example:** Transitioning to other garbage collectors like G1.

### 9. **JEP 357: Migrate from Mercurial to Git:**
   - **Use Case:** Migrates the source code repository from Mercurial to Git for better collaboration and development.
   - **Example:** Cloning the OpenJDK repository from the new Git repository.

     ```
     git clone https://github.com/openjdk/jdk.git
     ```

### 10. **JEP 365: ZGC on macOS:**
   - **Use Case:** Enables Z Garbage Collector (ZGC) on macOS.
   - **Example:** Using ZGC for low-latency garbage collection on macOS.

These features and enhancements in Java 14 focused on improving developer productivity, code readability, and removing outdated components. They aimed to keep Java up-to-date with modern development practices and provide better support for new features in the language.


## Java17

## Java21
