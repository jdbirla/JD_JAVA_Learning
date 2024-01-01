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
### 1. **Switch Expressions**
  - Switch expressions allowed us to omit break calls inside every case block. It helps with the readability of the code and better understanding.
```java
public class SwitchExpression {

    public static void main(String[] args) {
        int days = 0;
        Month month = Month.APRIL;

        days = switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> 31;
            case FEBRUARY -> 28;
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> 30;
            default -> throw new IllegalStateException();
        };
    }
}
```

### 2. **The yield Keyword**
- The logic inside the case block can be a bit more complicated than just returning a value. For example, we want to log which month the user sent us:
```java
public class SwitchExpression {

    public static void main(String[] args) {
        int days = 0;
        Month month = Month.APRIL;

        days = switch (month) {
            case JANUARY, MARCH, MAY, JULY, AUGUST, OCTOBER, DECEMBER -> {
                System.out.println(month);
                yield 31;
            }
            case FEBRUARY -> {
                System.out.println(month);
                yield 28;
            }
            case APRIL, JUNE, SEPTEMBER, NOVEMBER -> {
                System.out.println(month);
                yield 30;
            }
            default -> throw new IllegalStateException();
        };
    }
}
```
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

---
## Java15
### 1. **Text Blocks**
```java
public class TextBlocks {
    
    public static void main(String[] args) {
        System.out.println(
        """
                <!DOCTYPE html>
                <html>
                    <head>
                        <title>Example</title>
                    </head>
                    <body>
                        <p>This is an example of a simple HTML 
                        page with one paragraph.</p>
                    </body>
                </html>      
                """
        );
    }
}
```
---
## Java16
### 1. **Pattern Matching of instanceof**
- Pattern matching on the instanceof allows us to cast our variable inline and use it inside the desired if-else block without explicitly casting it.
```java
public class PatternMatching {
    public static double price(Vehicle v) {
        if (v instanceof Car c) {
            return 10000 - c.kilomenters * 0.01 -
                    (Calendar.getInstance().get(Calendar.YEAR) -
                            c.year) * 100;
        } else if (v instanceof Bicycle b) {
            return 1000 + b.wheelSize * 10;
        } else throw new IllegalArgumentException();
    }
}
```
---
## Java17

### 1. **Sealed classes and interfaces**: 
- Sealed classes and interfaces are a preview feature that restricts which other classes or interfaces can extend or implement them. They enable more precise modeling of domain hierarchies and better encapsulation of implementation details¹.
```java
// A sealed class that can only be extended by Circle, Rectangle, and Triangle
public sealed abstract class Shape permits Circle, Rectangle, Triangle {
  // common fields and methods
}

// A final class that extends Shape
public final class Circle extends Shape {
  // specific fields and methods
}

// A non-sealed class that extends Shape and can be further extended
public non-sealed class Rectangle extends Shape {
  // specific fields and methods
}

// A sealed class that extends Shape and can only be extended by EquilateralTriangle
public sealed class Triangle extends Shape permits EquilateralTriangle {
  // specific fields and methods
}

// A final class that extends Triangle
public final class EquilateralTriangle extends Triangle {
  // specific fields and methods
}
```
### 1 **Pattern matching for switch**: 
- Pattern matching for switch is a preview feature that extends the switch statement and expression to support testing the type and structure of an expression. It simplifies the code by eliminating the need for instanceof checks and casts².
### 1**Text blocks**: 
- Text blocks are a standard feature that allows writing multi-line strings without the need for escape sequences or concatenation. They improve the readability and maintainability of code that deals with text, such as HTML, XML, JSON, or SQL³.
### 1 **Records**: 
- Records are a standard feature that provides a compact syntax for declaring classes that are transparent holders for immutable data. They reduce the boilerplate code for data classes and support pattern matching.
### 1 **Foreign-Memory Access API**: 
- Foreign-Memory Access API is an incubator feature that provides a low-level API for accessing memory outside of the Java heap, such as native memory or memory-mapped files. It offers better performance and safety than the Java Native Interface (JNI).
### 1 **Vector API**: 
- Vector API is an incubator feature that provides a platform-agnostic way to express vector computations that can be optimized by the JVM and the hardware. It enables writing high-performance code for data processing, machine learning, and multimedia applications.



- Sealed classes and interfaces:



- Pattern matching for switch:

```java
// A switch expression that uses pattern matching
public String getShapeType(Shape shape) {
  return switch (shape) {
    case Circle c -> "Circle with radius " + c.getRadius();
    case Rectangle r -> "Rectangle with width " + r.getWidth() + " and height " + r.getHeight();
    case Triangle t && t.isRightAngled() -> "Right-angled triangle";
    case Triangle t -> "Triangle";
    default -> "Unknown shape";
  };
}
```

- Text blocks:

```java
// A text block that contains HTML code
String html = """
  <html>
    <body>
      <p>Hello, world</p>
    </body>
  </html>
  """;
```

- Records:

```java
// A record that represents a person
public record Person(String name, int age) {
  // additional methods
}

// Creating and using a record
Person p = new Person("Alice", 25);
System.out.println(p.name()); // Alice
System.out.println(p.age()); // 25
System.out.println(p); // Person[name=Alice, age=25]
```

- Foreign-Memory Access API:

```java
// Allocating and accessing native memory
try (MemorySegment segment = MemorySegment.allocateNative(100)) {
  MemoryAccess.setIntAtOffset(segment, 0, 42); // write 42 at offset 0
  int x = MemoryAccess.getIntAtOffset(segment, 0); // read 42 from offset 0
  System.out.println(x); // 42
}
```

- Vector API:

```java
// Vector addition using Vector API
static void vectorAdd(int[] a, int[] b, int[] c) {
  int i = 0;
  // Use 256-bit vector if available
  if (Vector.isHardwareSupported(VectorSpecies.of(int.class, VectorShape.S_256_BIT))) {
    var species = VectorSpecies.of(int.class, VectorShape.S_256_BIT);
    int length = species.loopBound(a.length);
    for (; i < length; i += species.length()) {
      // Load vectors from arrays
      var va = IntVector.fromArray(species, a, i);
      var vb = IntVector.fromArray(species, b, i);
      // Add vectors
      var vc = va.add(vb);
      // Store vector to array
      vc.intoArray(c, i);
    }
  }
  // Handle remaining elements
  for (; i < a.length; i++) {
    c[i] = a[i] + b[i];
  }
}
```

I hope this helps you understand how to use Java 17 features and enhancements. If you want to learn more, you can check out these links:

- [New Features in Java 17 | Baeldung](^1^)
- [Java 17 new features - Javatpoint](^2^)
- [Java 17 New Features (with Examples) - HowToDoInJava](^3^)

Source: Conversation with Bing, 01/01/2024
(1) New Features in Java 17 | Baeldung. https://www.baeldung.com/java-17-new-features.
(2) Java 17 new features - Javatpoint. https://www.javatpoint.com/java-17-new-features.
(3) Java 17 New Features (with Examples) - HowToDoInJava. https://howtodoinjava.com/java/new-features/.
(4) New Features in Java 17 | Baeldung. https://www.baeldung.com/java-17-new-features.
(5) Java 17 new features - Javatpoint. https://www.javatpoint.com/java-17-new-features.
(6) Java 17 New Features (with Examples) - HowToDoInJava. https://howtodoinjava.com/java/new-features/.

## Java21
