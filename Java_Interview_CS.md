# Java 7 Interview CS

## Durga Core java Concept
###  Abstract 
- Abstract for class and method,  Abstract class can't initaited.
- Abstract class can have final method but final class can't have abstract method
### Member level and Method Level 


### What are the important things to consider when implementing equals method?
Any equals implementation should satisfy these properties:
1. Reflexive. For any reference value x, x.equals(x) returns true.
2. Symmetric. For any reference values x and y, x.equals(y) should return true if and only if
y.equals(x) returns true.
3. Transitive. For any reference values x, y, and z, if x.equals(y) returns true and y.equals(z) returns
true, then x.equals(z) must return true.
4. Consistent. For any reference values x and y, multiple invocations of x.equals(y) consistently
return true or consistently return false, if no information used in equals is modified.
5. For any non-null reference value x, x.equals(null) should return false.
Java

Our earlier implementation of equals method will not satisfy condition 5. It would throw an exception if an
object of different class (other than Client) is used for comparison.
Let's now provide an implementation of equals which satisfy these properties:
```java
//Client class
@Override
public boolean equals(Object obj) {
if (this == obj)
return true;
if (obj == null)
return false;
if (getClass() != obj.getClass())
return false;
Client other = (Client) obj;
if (id != other.id)
return false;
return true;
}
```
### What is the hashCode method used for in Java?
A good hashCode method should have the following properties
• If obj1.equals(obj2) is true, then obj1.hashCode() should be equal to obj2.hashCode()
• obj.hashCode() should return the same value when run multiple times, if values of obj used in
equals() have not changed.
• If obj1.equals(obj2) is false, it is NOT required that obj1.hashCode() is not equal to
obj2.hashCode(). Two unequal objects MIGHT have the same hashCode.
A sample hashcode implementation of Client class which meets above constraints is given below:
```java
//Client class
@Override
public int hashCode() {
final int prime = 31;
int result = 1;
result = prime * result + id;
return result;
}
```

### What is a Default Constructor?
Will this code compile?
```java
class Animal {
String name;
public Animal() {
this.name = "Default Name";
}
// This is called a one argument constructor.
public Animal(String name) {
this.name = name;
}
public static void main(String[] args) {
Animal animal = new Animal();
}
}
```
Answer is no. Since we provided a constructor, compiler does not provide a default constructor


### What is Coupling?
Coupling is a measure of how much a class is dependent on other classes. There should minimal
dependencies between classes. So, we should always aim for low coupling between classes.

### What is Cohesion?
Cohesion is a measure of how related the responsibilities of a class are. A class must be highly cohesive
i.e. its responsibilities (methods) should be highly related to one another


### Can you explain about try with resources?
Consider the example below. When the try block ends the resources are automatically released. We do
not need to create a separate finally block.
```java
try (BufferedReader br = new BufferedReader(new FileReader("FILE_PATH")))
{
String line;
while ((line = br.readLine()) != null) {
System.out.println(line);
}
} catch (IOException e) {
e.printStackTrace();
}
```
How does try with resources work?
try-with-resources is available to any class that implements the AutoCloseable interface. In the above
example BufferedReader implements AutoCloseable interface.
```java
public interface AutoCloseable {
void close() throws Exception;
}
```
### Explain about the new concurrent collections in Java?
Post Java 5, collections using new approaches to synchronization are available in Java. These are called
concurrent collections. Examples of new approaches are :
• Copy on Write
• Compare and Swap
• Locks
### Explain about CopyOnWrite concurrent collections approach?
Important points about Copy on Write approach
• All values in collection are stored in an internal immutable (not-changeable) array. A new array
is created if there is any modification to the collection.
• Read operations are not synchronized. Only write operations are synchronized.
Copy on Write approach is used in scenarios where reads greatly out number write’s on a collection.
CopyOnWriteArrayList & CopyOnWriteArraySet are implementations of this approach. Copy on Write
collections are typically used in Subject – Observer scenarios, where the observers very rarely change.
Most frequent operations would be iterating around the observers and notifying them.

### What is CompareAndSwap approach?
Compare and Swap is one of the new approaches (Java 5) introduced in java to handle synchronization.
In traditional approach, a method which modifies a member variable used by multiple threads is
completely synchronized – to prevent other threads accessing stale value.
In compare and swap approach, instead of synchronizing entire method, the value of the member
variable before calculation is cached. After the calculation, the cached value is compared with the
Java Interview Questions and Answers – www.in28Minutes.com 89
current value of member variable. If the value is not modified, the calculated result is stored into the
member variable. If another thread has modified the value, then the calculation can be performed
again. Or skipped – as the need might be.
ConcurrentLinkedQueue uses this approach.

### What is a Lock? How is it different from using synchronized approach?
CopyOnWriteArrayList : final ReentrantLock lock = this.lock;
When 10 methods are declared as synchronized, only one of them is executed by any of the threads at
any point in time. This has severe performance impact.
Another new approach introduced in Java 5 is to use lock and unlock methods. Lock and unlock methods
are used to divide methods into different blocks and help enhance concurrency. The 10 methods can be
divided into different blocks, which can be synchronized based on different variables.

### What is difference between fail-safe and fail-fast iterators?
Fail Fast Iterators throw a ConcurrentModificationException if there is a modification to the underlying
collection is modified. This was the default behavior of the synchronized collections of pre Java 5 age.
```java
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
public class FailFast {
public static void main(String[] args) {
Map<String, String> map = new HashMap<String, String>();
map.put("key1", "value1");
map.put("key2", "value2");
map.put("key3", "value3");
Iterator<String> iterator = map.keySet().iterator();
while (iterator.hasNext()) {
System.out.println(map.get(iterator.next()));
map.put("key4", "value4");
}
}
}
```
Fail Safe Iterators do not throw exceptions even when there are changes in the collection. This is the
default behavior of the concurrent collections, introduced since Java 5.
Fail Safe Iterator makes copy of the internal data structure (object array) and iterates over the copied
data structure.
Fail Safe is efficient when traversal operations vastly outnumber mutations
```java
package com.in28minutes.java.collections;
import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;
public class FailSafe {
public static void main(String[] args) {
ConcurrentHashMap<String, String> map = new ConcurrentHashMap<String, String>();
map.put("key1", "value1");
map.put("key2", "value2");
map.put("key3", "value3");
Java Interview Questions and Answers – www.in28Minutes.com 91
Iterator<String> iterator = map.keySet().iterator();
while (iterator.hasNext()) {
System.out.println(map.get(iterator.next()));
map.put("key4", "value4");
}
}
}
```

### What are atomic operations in Java?
Atomic Access Java Tutorial states “In programming, an atomic action is one that effectively happens all
at once. An atomic action cannot stop in the middle: it either happens completely, or it doesn't happen
at all. No side effects of an atomic action are visible until the action is complete”.
Let’s assume we are writing a multi threaded program. Let’s create an int variable i. Even a small
operation, like i++ (increment), is not thread safe. i++ operation involves three steps.
1. Read the value which is currently stored in i
2. Add one to it (atomic operation).
3. Store it in i
In a multi-threaded environment, there can be unexpected results. For example, if thread1 is reading
the value (step 1) and immediately after thread2 stores the value (step 3).
To prevent these, Java provides atomic operations. Atomic operations are performed as a single unit
without interference from other threads ensuring data consistency.
A good example is AtomicInteger. To increment a value of AtomicInteger, we use the
incrementAndGet() method. Java ensures this operation is Atomic.


### What is ExecutorService?
The java.util.concurrent.ExecutorService interface is a new way of executing tasks asynchronously in the
background. An ExecutorService is very similar to a thread pool.
Can you give an example for ExecutorService?
Below example shows how to create an Executor Service and use it to run a task implementing the
Runnable interface.
```jav
ExecutorService executorService = Executors.newSingleThreadExecutor();
executorService.execute(new Runnable() {
public void run() {
System.out .println("From ExecutorService");
}
});
System.out .println("End of Main");
executorService.shutdown();

```


### Explain different ways of creating Executor Services.
There are three ways of creating executor services. Below example shows the three different ways.
```java
executorService1 can execute one task at a time. executorService2 can execute 10 tasks at a time.
executorService3 can execute tasks after certain delay or periodically.
// Creates an Executor that uses a single worker thread operating off an
// unbounded queue.
ExecutorService executorService1 = Executors.newSingleThreadExecutor();

// Creates a thread pool that reuses a fixed number of threads
// operating off a shared unbounded queue. At any point, the parameter
// specifies the most threads that will be active processing tasks.
ExecutorService executorService2 = Executors.newFixedThreadPool(10);
// Creates a thread pool that can schedule commands to run after a
// given delay, or to execute periodically.
ExecutorService executorService3 = Executors.newScheduledThreadPool(10);
```

### How do you check whether an ExecutionService task executed successfully?
We can use a Future to check the return value. Below example shows how it can be done. Future get
method would return null if the task finished successfully.
Future future = executorService1.submit(new Runnable() {
public void run() {
System.out .println("From executorService1");
}
});
future.get(); // returns null if the task has finished correctly.

### What is Callable? How do you execute a Callable from ExecutionService?
Runnable interface's run method has a return type void. So, it cannot return any result from executing a
task. However, a Callable interface's call method has a return type. If you have multiple return values
possible from a task, we can use the Callable interface. Example shows how to create a Callable
interface and execute it using an executor service. The return value is printed to the output.
```java
Future futureFromCallable = executorService1.submit(new Callable() {
public String call() throws Exception {
return "RESULT";
}
});
System.out .println("futureFromCallable.get() = "
+ futureFromCallable.get());
```

### Join method example
Look at the example code below:
thread3.start();
thread2.start();
thread3.join();//wait for thread 3 to complete
System.out.println("Thread3 is completed.");
thread4.start();
thread3.join() method call force the execution of main method to stop until thread3 completes
execution. After that, thread4.start() method is invoked, putting thread4 into a Runnable State.

### Overloaded Join method
Join method also has an overloaded method accepting time in milliseconds as a parameter.
thread4.join(2000);
In above example, main method thread would wait for 2000 ms or the end of execution of thread4,
whichever is minimum.

### Thread yield method
Yield is a static method in the Thread class. It is like a thread saying " I have enough time in the limelight.
Can some other thread run next?".
102 Java Interview Questions and Answers – www.in28Minutes.com
A call to yield method changes the state of thread from RUNNING to RUNNABLE. However, the
scheduler might pick up the same thread to run again, especially if it is the thread with highest priority.
Summary is yield method is a request from a thread to go to Runnable state. However, the scheduler
can immediately put the thread back to RUNNING state.

### Thread sleep method
sleep is a static method in Thread class. sleep method can throw a InterruptedException. sleep method
causes the thread in execution to go to sleep for specified number of milliseconds.

----

## Design Pattern
![image](https://user-images.githubusercontent.com/69948118/172313772-21bf1902-2c87-4faa-89a5-7aa5fa772a1e.png)

### Quick Remind
|Type|Pattern Name |Example|
|---|---|---|
|Creational Design Pattern|Singleton Pattern|SingletonEagar,SingletonSynchronized | 
|Creational Design Pattern|Factory Pattern|```java class VehicleFactory {   public static Vehicle getInstance(String type, int wheel) {     if(type == "car") {       return new Car(wheel);     } else if(type == "bike") {       return new Bike(wheel);     }``` | 
|Creational Design Pattern|Prototype Pattern|```java   Vehicle b = (Vehicle) a.clone();``` | 
|Creational Design Pattern|Builder Pattern|```java  Vehicle car = new Vehicle.VehicleBuilder("1500cc", 4).setAirbags(4).build();     Vehicle bike = new Vehicle.VehicleBuilder("250cc", 2).build();``` |
|--------------------------|-----------------|-----------------|
|Structural Design Pattern|Adapter Pattern| ```java  ChromeDriver a = new ChromeDriver();     a.getElement();     a.selectElement();  	IEDriver e = new IEDriver();     e.findElement();     e.clickElement();         WebDriver wID = new WebDriverAdapter(e);     wID.getElement();     wID.selectElement(); ```| 
|Structural Design Pattern|Bridge Pattern| Row 2 Column 2|
|Structural Design Pattern|Composite Pattern| ```java  CompositeAccount component = new CompositeAccount();     component.addAccount(new DepositeAccount("DA001", 100));     component.addAccount(new DepositeAccount("DA002", 150));     component.addAccount(new SavingAccount("SA001", 200));```| 
|Structural Design Pattern|Facade Pattern|```java WebExplorerHelperFacade.generateReports("firefox", "html", test); WebExplorerHelperFacade.generateReports("firefox", "junit", test);```| 
|Structural Design Pattern|Proxy Pattern| ```java   DatabaseExecuter nonAdminExecuter = new DatabaseExecuterProxy("NonAdmin", "Admin@123");``` | 
|--------------------------|-----------------|-----------------|
|Behavioral Design Pattern|Observer Pattern| ```java     TV sonyOldRemote = new Sony(new OldRemote());  TV sonyNewRemote = new Sony(new NewRemote());```| 


---
### Code Quality 

sonar-example

What is sonar how to get start with it | Example
```
Plugins:
org.sonarsource.scanner.maven sonar-maven-plugin 3.4.0.905 org.jacoco jacoco-maven-plugin 0.8.1

jacoco cmd:

clean org.jacoco:jacoco-maven-plugin:prepare-agent install
sonar cmd:

mvn sonar:sonar

```

1.  Install the SonarQube plugin for Eclipse.

2.  Configure your SonarQube server.

3.  Link your workspace project to the copy on SonarQube.

4.  Add the SonarQube views to your current perspective.

---

### Logging
![image](https://user-images.githubusercontent.com/69948118/176835148-7c435a1c-3fd4-4647-97c3-0a358f600560.png)

---
### Unit Testing

#### Junit
```java 
@Test public void test() { boolean condn = true; assertEquals(true, condn); assertTrue(condn); // assertFalse(condn); }
```
#### Junit + Mockito
```java
    package com.in28minutes.business;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import com.in28minutes.data.api.TodoService;
public class TodoBusinessImplMockitoTest {
	@Test
	public void usingMockito() {
		TodoService todoService = mock(TodoService.class);
		List<String> allTodos = Arrays.asList("Learn Spring MVC",
				"Learn Spring", "Learn to Dance");
		when(todoService.retrieveTodos("Ranga")).thenReturn(allTodos);
		TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoService);
		List<String> todos = todoBusinessImpl
				.retrieveTodosRelatedToSpring("Ranga");
		assertEquals(2, todos.size());
	}
}
```
#### Spring Unit Testing and Mockito

```java
@RunWith(SpringRunner.class)/@RunWith(SpringJUnit4ClassRunner.class)
public class SpringIn5StepsBasicApplicationTests 
{ @Test public void contextLoads() { } }

@RunWith(SpringRunner.class) @ContextConfiguration(classes = SpringIn5StepsBasicApplication.class) 
public class BinarySearchTest { // Get this bean from the context @Autowired BinarySearchImpl binarySearch;

```
```java


import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class SomeCdiBusinessTest {

	// Inject Mock
	@InjectMocks
	SomeCdiBusiness business;

	// Create Mock
	@Mock
	SomeCdiDao daoMock;

	@Test
	public void testBasicScenario() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2, 4 });
		assertEquals(4, business.findGreatest());
	}

	@Test
	public void testBasicScenario_NoElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { });
		assertEquals(Integer.MIN_VALUE, business.findGreatest());
	}

	@Test
	public void testBasicScenario_EqualElements() {
		Mockito.when(daoMock.getData()).thenReturn(new int[] { 2,2});
		assertEquals(2, business.findGreatest());
	}

}

```

#### Spring boot Unit Testing and Mockito

```java
package com.in28minutes.mockito.mockitodemo;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
@RunWith(MockitoJUnitRunner.class)
public class SomeBusinessMockAnnotationsTest {
	@Mock
	DataService dataServiceMock;
	@InjectMocks
	SomeBusinessImpl businessImpl;
	@Test
	public void testFindTheGreatestFromAllData() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 24, 15, 3 });
		assertEquals(24, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	public void testFindTheGreatestFromAllData_ForOneValue() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] { 15 });
		assertEquals(15, businessImpl.findTheGreatestFromAllData());
	}
	@Test
	public void testFindTheGreatestFromAllData_NoValues() {
		when(dataServiceMock.retrieveAllData()).thenReturn(new int[] {});
		assertEquals(Integer.MIN_VALUE, businessImpl.findTheGreatestFromAllData());
	}
}
```
### TesNG
![image](https://user-images.githubusercontent.com/69948118/176839452-40ab761a-414b-4e37-81c8-b203368c35f3.png)
![image](https://user-images.githubusercontent.com/69948118/176839667-6b1ec809-0c78-4c99-acd1-896b81c3062f.png)


