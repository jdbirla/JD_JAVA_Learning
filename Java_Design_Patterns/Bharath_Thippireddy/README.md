# Java Design Patterns By Bharath


- [Java Design Patterns By Bharath](#java-design-patterns-by-bharath)
    - [Singleton](#singleton)
  - [Factory Pattern](#factory-pattern)
  - [Abstract Factory Pattern](#abstract-factory-pattern)
    - [Prototype Pattern](#prototype-pattern)
    - [Builder Pattern](#builder-pattern)
  - [Adapter Pattern](#adapter-pattern)
  - [Flyweight Pattern](#flyweight-pattern)
  - [Decorator Pattern](#decorator-pattern)
    - [Proxy Pattern](#proxy-pattern)
    - [Facade Pattern](#facade-pattern)
    - [Composite Pattern](#composite-pattern)
    - [Bridge Pattern](#bridge-pattern)
  - [Template Pattern](#template-pattern)
  - [Command Pattern](#command-pattern)
  - [- UML](#--uml)
    - [Iterator Pattern](#iterator-pattern)
    - [Observer Pattern](#observer-pattern)
    - [Strategy Pattern Overview](#strategy-pattern-overview)
    - [Factory Pattern vs Strategy Pattern](#factory-pattern-vs-strategy-pattern)
  - [JEE Patterns](#jee-patterns)
  - [Inversion of Control Pattern](#inversion-of-control-pattern)
  - [Java EE Basics](#java-ee-basics)
  - [Presentation Tier - Patterns](#presentation-tier---patterns)
    - [Intercepting Filter](#intercepting-filter)
    - [Front Conroller](#front-conroller)
    - [Mini Project](#mini-project)
    - [Ajay-design-pattern](#ajay-design-pattern)
  - [spring-design-pattern](#spring-design-pattern)
    - [Tell me the Design pattern used inside the spring framework.](#tell-me-the-design-pattern-used-inside-the-spring-framework)
    - [How do factory design patterns work in terms of the spring framework?](#how-do-factory-design-patterns-work-in-terms-of-the-spring-framework)
    - [How the proxy design pattern is used in spring?](#how-the-proxy-design-pattern-is-used-in-spring)
    - 
---

<h2 id="creational-design-pattern">1.Creational Design Pattern</h2>

### Singleton


A singleton pattern is an object creational pattern that allows our application to create one and only one instance of a particular class, no matter how many times that class is used in our application.

For example a PropertyReader class that can read the properties from a file and it is used multiple times in our application by different classes. We will create only one object of the PropertyReader and not multiple saving a lot of memory using the singleton pattern. So all application classes will use the same property reader object to perform the property reading from a file.​

Another good example for singleton is a logger. Using logger's we can log different types of information errors debugging information and just general information from our application to a log file so that developers can read that log file later on to see what is happening with our application. So a logger can be a singleton the same logger object can be shared across our application classes.

Another good example in the JDBC world, the java database connectivity world is the data source class in the JDBC API the data source class is responsible for maintaining a connection pool and giving a connection from the pool to our application classes. We can have different classes in the application that need a database connection but there will be only one instance of the data source. So a DataSource is also an example of singleton.



- UML

![Singleton](https://user-images.githubusercontent.com/69948118/210053284-727b58b1-a22e-4430-b5e2-94e9754552ac.png)




- Sample Code:
```java
package com.bharath.patterns.singleton;

import java.io.Serializable;

public class DateUtil implements Serializable,Cloneable {

	private static final long serialVersionUID = 1L;
	private static volatile DateUtil instance;

	private DateUtil() {

	}

	public static DateUtil getInstance() {
		if (instance == null) {
			synchronized (DateUtil.class) {
				if (instance == null) {
					instance = new DateUtil();
				}
			}
		}
		return instance;

	}

	protected Object readResolve() {
		return instance;
	}
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		throw new CloneNotSupportedException();
	}

}

```
- singleton pattern break using reflection api and solution for this problem is ENUM becauce ENUM doesn't have consturctor
```java
package com.bharath.patterns.singleton;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class BreakSingletonUsingReflection {
	public static void main(String[] args) {
		DateUtil dateUtil = DateUtil.getInstance();
		DateUtil dateUtil1 = null;
		
		Constructor[] declaredConstructors = DateUtil.class.getDeclaredConstructors();
		  for (Constructor constructor : declaredConstructors) {
			constructor.setAccessible(true);
			try {
				dateUtil1 = (DateUtil) constructor.newInstance();
			} catch (InstantiationException | IllegalAccessException | IllegalArgumentException
					| InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		  System.out.println(dateUtil.hashCode());
		  System.out.println(dateUtil1.hashCode());

	}

}

```
## Factory Pattern

A factory pattern is a creational pattern that abstracts or hides the object creation process. When you think of factory you can think of a car factory a chocolate factory or a toy factory.A car factory is responsible for manufacturing the cars .A car dealer need not worry about how the car is manufactured. He simply asks the car factory to deliver him some cars. The car factory is responsible for manufacturing them and delivering them to the dealer.

Similarly the Chocolate Factory delivers different types of chocolates based on what the chocolate store asks them to deliver.

An example from the JDBC space when we use different databases like Oracle, MySql, SqlServer. In Java we use something called JDBC driver to connect to a database.

Driver is an interface in the JDBC API and the implementation for this driver is provided by different vendors. The responsibility of the driver is to connect to a particular database and execute sql statements against it.

To get a connection we need not remember each and every driver in how it works. For example if we want to connect to Oracle you need not deal with the Oracle driver and same for other databases.

You simply use DriverManager which is a class in the JDBC API to get connection and you pass in a connection string which is specific to a particular database where it is different for mysql, it's different for sql server.

The driver manager acts as a factory and it will return the connection for us by using the appropriate driver for Oracle it will use Oracle driver for my sql it will use the my sql driver and so on.

It hides all the details of finding a driver and creating a connection against the database for us. So give it a string it will give you a connection. So here the get connection is a static method on the factory class.

We need not create the instance of the driver manager to create objects of type connection.

We simply use the static method on the factory class and get the object we need.

- UML:
![Factory](https://user-images.githubusercontent.com/69948118/210121601-0e409e3e-61b2-4ecd-9309-3d814fbaeccd.png)

Another example is a pizza store .A pizza store delivers different types of pizzas.We will a parent interface which is implemented by the veg pizza cheese pizza and meat pizza.The pizza store need not worry about how to create each of these pizzas.It simply asked the pizza factory to deliver the type of pizza it wants or to create a type of pizza it wants.so that it can give it to the customer or it can deliver it to the customer.The pizza factory hides the complexity of creating the different types of pizzas from the pizza store.

- Code Design
![image](https://user-images.githubusercontent.com/69948118/210123051-248fe999-5a3a-482b-be7f-91a78e9b579b.png)

- Sample Code:
```java
package com.bharath.patterns.factory;

public class PizzaFactory {

	public static Pizza createPizza(String type) {
		Pizza p = null;

		if (type.equals("cheese")) {
			p = new CheesePizza();
		} else if (type.equals("chicken")) {
			p = new ChickenPizza();
		} else if (type.equals("veggie")) {
			p = new VeggiePizza();
		}

		return p;
	}

}

```


## Abstract Factory Pattern

Now that you have mastered the Factory design pattern learning and implementing the Abstract Factory pattern will be quite easy because an abstract factory is a factory of factories.That is a factory pattern was hiding the details of object creation and factory of factories or an abstract factory.hides the creation of the factory itself.

A good example in the Java space is the JAXP API . JAXP stands for Java API for xml parsing . Using this API we can read or write and update the elements in a xml file the key class in this API is the document class that represents a xml document in memory to create a document class.We use that document builder.So this document builder is a factory class and there is one more class document.Build a factory which is responsible for creating the document builder itself.So the document builder factory is a abstract factory because it is a factory of factories and the use case you are going to work on to give you

Another example is a DAO factory. DAO stands for data access object.We'll learn more about it in sections later on.It simply is a class that can read write create update data we can have different types of DAO'sDAO's that deal with xml data and DAO's that deal with DB data and within xml we can have employee information department information.

Similarly within that database we can have employ information and department information.So you can see that we can have a factory to deal with these separate DOA's we can have a DB DAO factory that can give us one of these classes here when our application needs them and we can have a xml DAO factory which can give one of the classes here.Now to get one of these factories themselves these factories will first implement a DAO abstract factory or they will extend DAO abstract factory class and we will have a producer which is responsible for creating one of these factories so abstract factory is a factory off factories.

It simply creates the factory we need. when we have multiple factories we see in our application.

- UML:
![Abstract Factory](https://user-images.githubusercontent.com/69948118/210122829-f46c621c-5fb8-491c-a228-813f746999d5.png)

- Code design
![image](https://user-images.githubusercontent.com/69948118/210123039-ff05d27b-c8f1-46cc-98ef-bdf9f1f9a8a2.png)
- Sample Code:

```java
package com.bharath.patterns.abstractfactory;

public class DaoFactoryProducer {

	public static DaoAbstractFactory produce(String factoryType) {
		DaoAbstractFactory daf = null;

		if (factoryType.equals("xml")) {
			daf = new XMLDaoFactory();
		} else if (factoryType.equals("db")) {
			daf = new DBDaoFactory();
		}

		return daf;

	}
}

```
### Prototype Pattern
![image](https://user-images.githubusercontent.com/69948118/210159699-f12f1a4f-e515-4c1e-b695-37e6dd6a8ca8.png)
![image](https://user-images.githubusercontent.com/69948118/210159703-9c172fd5-0dcb-4404-8203-ec8ad053e84e.png)
```java
package com.jd.patterns.prototype;

public class Game implements Cloneable {

	private int id;
	private String name;
	private Membership membership;
	
	@Override
	protected Game clone() throws CloneNotSupportedException {
		Game game= (Game) super.clone();
		game.setMembership(new Membership());
		return game;
	}
	
	public Game(Game game) {
		this.id = game.id;
		this.name = game.name;
		this.membership = new Membership();

	}
	public Game() {
		// TODO Auto-generated constructor stub
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Game [id=" + id + ", name=" + name + ", membership=" + getMembership() + "]";
	}

	public Membership getMembership() {
		return membership;
	}

	public void setMembership(Membership membership) {
		this.membership = membership;
	}



}

```

### Builder Pattern
- UML
![image](https://user-images.githubusercontent.com/69948118/210160769-0bd21549-270e-4a87-be83-6111407fccad.png)
-sample code
```java
package com.bharath.patterns.builder;

public class HttpClient {

	private String method;
	private String url;
	private String username;
	private String password;
	private String header;
	private String body;

	public HttpClient(HttpClientBuilder httpClientBuilder) {
		this.method = httpClientBuilder.method;
		this.url = httpClientBuilder.url;
		this.username = httpClientBuilder.username;
		this.password = httpClientBuilder.password;
		this.header = httpClientBuilder.header;
		this.body = httpClientBuilder.body;
		this.method = httpClientBuilder.method;
	}

	public static class HttpClientBuilder {
		private String method;
		private String url;
		private String username;
		private String password;
		private String header;
		private String body;

		public HttpClientBuilder method(String method) {
			this.method = method;
			return this;
		}

		public HttpClientBuilder url(String url) {
			this.url = url;
			return this;
		}

		public HttpClientBuilder username(String username) {
			this.username = username;
			return this;
		}

		public HttpClientBuilder password(String password) {
			this.password = password;
			return this;
		}

		public HttpClientBuilder header(String header) {
			this.header = header;
			return this;
		}

		public HttpClientBuilder body(String body) {
			this.body = body;
			return this;
		}

		public HttpClient build() {
			return new HttpClient(this);
		}
	}

	public String getMethod() {
		return method;
	}

	public String getUrl() {
		return url;
	}

	public String getUsername() {
		return username;
	}

	public String getPassword() {
		return password;
	}

	public String getHeader() {
		return header;
	}

	public String getBody() {
		return body;
	}

	@Override
	public String toString() {
		return "HttpClient [method=" + method + ", url=" + url + ", username=" + username + ", password=" + password
				+ ", header=" + header + ", body=" + body + "]";
	}

}

package com.bharath.patterns.builder;

public class Test {
	public static void main(String[] args) {
		//HttpClient httpClient = new HttpClient("GET", "asd", null, null, null, null);
		  HttpClient build = new HttpClient.HttpClientBuilder().method("GET").url("http//asdadad").username("aaa").password("asd")
		  .body("asd").build();
		  System.out.println(build);
	}
}

```
---
<h2 id="structural-design-pattern">2.Structural Design Pattern</h2>

## Adapter Pattern
If you have used a power adapter then you already know what an adapter pattern is .The job of a power adapter is to adapt it to a particular location and a particular switchboard.For example the same laptop plug pins that work in USA will not work in UK and in India.We will have to use appropriate power adapter that can take our laptop pins into it and on the other side of it it will have pins that can go into the local countries switchboard and it can also adapt to the appropriate range in that country.

Similarly in the world of programming when we have two applications communicating with each other or two objects using each other and one object invokes the method of another object.Then we have to adapt in some cases.

For example here we have a WeatherFinder class which has a findWeather. By passing in a city you can get the weather and we have an implementation of it which will return the weather back and there is a UI class that wants to use the weather finder . But the UI only knows the zip code of the city. It does not have the city information it only has the zip code but it wants to get the weather of it.

That is where an adapter comes in. We will implement an adapter which will take the zip code. The weather UI will invoke the findTemperature Method on the WeatherAdapter it will pass in the zip code. The weather adapter is responsible for looking up for the appropriate city that matches the zip code and hen invoke the weather finder, take the results and return the results back to the weather UI. So it exactly acts like a power adapter. It takes the inputs from the class that wants to use another class because the inputs here are different from what the other side of the relationship expects.

- UML
![Factory](https://user-images.githubusercontent.com/69948118/210124457-b5b18eeb-f696-4ccf-a6d4-e544c53cd3d1.png)

- Code Design
![image](https://user-images.githubusercontent.com/69948118/210124482-45d8ff82-868a-416b-89a7-3c2697d58cae.png)

- Sample code
```java
package com.bharath.patterns.adapter;

public class WeatherAdapter {

	public int findTemperature(int zipCode) {
		String city = null;
		if (zipCode == 19406) {
			city = "King Of Prussia";
		}
		WeatherFinder finder = new WeatherFinderImpl();
		int temperature = finder.find(city);

		return temperature;

	}

}

```

## Flyweight Pattern

A flyweight design pattern can be used to save memory. A flyweight is a structural design pattern instead of creating a large number of similar objects.We can reduce the number of objects that are created by reusing the objects and saving memory. Memory is a huge concern especially when it comes to mobile applications with limited memory.

Let's say we are working on a paint app that allows users to draw different shapes that is circles and rectangles.

Here we have a shape interface with a draw method on it.

When we have a circle class and the rectangle classes that implements that interface using a circle.

The user can draw a circle using a rectangle of course he can try her rectangle to do that.

He will have to create a circle and assign a radius for each circle he wants to create.

Similarly for each rectangle he will how to set the length and the breadth by creating a separate object by using the flyweight pattern.

You will do all that by creating one single circle and one single rectangle he will see what the problem is he will implement the problem first and then you will resolve that problem of multiple object creation by using the fly design pattern in the next few lectures.

- UML:
![FlyWeight](https://user-images.githubusercontent.com/69948118/210124618-44e6022d-a604-4c3a-9bd0-8ca866b0b55e.png)

- Code Design:
![image](https://user-images.githubusercontent.com/69948118/210124655-742194e3-331f-49ab-8c5a-facc7a0a94c0.png)
![image](https://user-images.githubusercontent.com/69948118/210124659-8383f27a-919e-490b-978c-224eac166098.png)
![image](https://user-images.githubusercontent.com/69948118/210124982-3acf2caf-63b8-4dc3-8533-3aee4c202472.png)

- Sample Code:
```java
package com.bharath.patterns.flyweight;

import java.util.HashMap;
import java.util.Map;

public class ShapeFactory {

	private static Map<String, Shape> shapes = new HashMap<>();

	public static Shape getShape(String type) {
		Shape shape = null;
		if (shapes.get(type) != null) {
			shape = shapes.get(type);
		} else {
			if (type.equals("circle")) {
				shape = new Circle();
			} else if (type.equals("rectangle")) {
				shape = new Rectangle();
			}
			shapes.put(type, shape);
		}
		return shape;

	}

}

```
## Decorator Pattern

A decorator pattern is a behavioural pattern that adds additional functionality to an object dynamically at runtime. A decorator wraps an object with additional behaviour without affecting other objects of the same type. The classes in the input output streams in Java use the decorator pattern to read and write files.

For example lets consider a pizza shop. We have a pizza and we have a base pizza. A plain pizza, pizza by itself doesn't mean anything it is very abstract. A plain pizza probably it is just the dove without any cheese or veggies or any meat on it. And now when the client wants a plain pizza or he can ask for a veggie pizza or a cheese pizza or meat pizza

At runtime we can dynamically add all these toppings using a pizza decorator as required. A pizza decorator will be implemented by veggie pizza decorator and a cheese pizza decorator. Each of these bring in additional functionality. So if the client asks for a veggie pizza we are going to use the veggie pizza decorator at run time.

The client ask for a cheese pizza. We can ask the cheese pizza decorator to decorate the plain base pizza with cheese and with veggies as required. The pizza here is the component the plain pizza is a concrete or a base component. The decorator is the pizza decorator and these two are concrete decorators. Both the veggie pizza decorator and the cheese pizza decorator are called concrete decorators so you are going to implement all of that in the next few lectures.

- UML:
![Decorator](https://user-images.githubusercontent.com/69948118/210126547-e209248b-81e1-4f9a-94cb-3e334c95d9f3.png)

- Code Design:
![image](https://user-images.githubusercontent.com/69948118/210126553-f51bf3fd-d128-429c-a807-4f8fc6f4cc2f.png)
![image](https://user-images.githubusercontent.com/69948118/210126558-dda0a0f9-91e4-4af9-965d-dd43ea7f7b8a.png)

- Samle Code:

```java
package com.jd.patterns.decorator;

public class PizzaDecorator implements Pizza {

	private Pizza pizza;

	public PizzaDecorator(Pizza pizza) {
		this.pizza = pizza;
	}

	@Override
	public void bake() {
		pizza.bake();
	}

}

package com.jd.patterns.decorator;

public class CheesePizzaDecorator2 extends PizzaDecorator {

	public CheesePizzaDecorator2(Pizza pizza) {
		super(pizza);
	}

	public void bake() {
		super.bake();
		System.out.println("Adding cheese toppings");
	}

}
package com.jd.patterns.decorator;

public class PizzaShop {

	public static void main(String[] args) {
		Pizza pizza = new VeggiePizzaDecorator(new CheesePizzaDecorator2(new PlainPizza()));
		pizza.bake();
	}

}

```
### Proxy Pattern
![image](https://user-images.githubusercontent.com/69948118/210158942-fe56be23-55f2-494b-8b33-23234a552bde.png)
![image](https://user-images.githubusercontent.com/69948118/210158948-06099b07-70bc-4258-8a43-f6247fcb0278.png)
![image](https://user-images.githubusercontent.com/69948118/210158958-2364bc15-3ddb-444b-937f-5d299222822c.png)
![image](https://user-images.githubusercontent.com/69948118/210158965-27c80057-3114-40cf-84dd-7a7aff5cda9f.png)
- sample code
```java
package com.jd.patterns.proxy;

import java.util.ArrayList;
import java.util.List;

public class CustomerProxyImpl implements Customer{

	CustomerImpl customerImpl = new CustomerImpl();
	
	@Override
	public int getId() {
		return customerImpl.getId();
	}

	@Override
	public List<Order> getOrders() {
		ArrayList<Order> arrayList = new ArrayList<Order>();
		Order order1 = new Order();
		order1.setId(1);
		order1.setProductName("Iphone");
		order1.setQuantity(100);

		arrayList.add(order1);
		
		Order order2 = new Order();
		order2.setId(2);
		order2.setProductName("Mac");
		order2.setQuantity(200);
		
		arrayList.add(order2);

		return arrayList;
	}

}
package com.jd.patterns.proxy;

public class Test {

	public static void main(String[] args) {
  Customer customer = new CustomerProxyImpl();
       System.out.println(customer.getId());
       System.out.println(customer.getOrders());
	}

}

```


### Facade Pattern
![image](https://user-images.githubusercontent.com/69948118/210161077-90b01979-91db-4a49-9c57-7664dd3c5248.png)
![image](https://user-images.githubusercontent.com/69948118/210161070-170344d6-723d-4cad-93b2-865977a91fbb.png)
- sample code
```java
package com.jd.patterns.facade;

public class OrderFacade {
	private OrderProcessor orderProcessor = new OrderProcessor();

	public void processOrder(String name , int quantity) {
		if (orderProcessor .checkStock(name)) {
			String orderId = orderProcessor .placrOrder(name, quantity);
			orderProcessor .shipOrder(orderId);
		}

	}

}


package com.jd.patterns.facade;

public class Test {

	public static void main(String[] args) {
//		OrderProcessor orderProcessor = new OrderProcessor();
//		if (orderProcessor.checkStock("Macbook")) {
//			String orderId = orderProcessor.placrOrder("mack", 5);
//			orderProcessor.shipOrder(orderId);
//		}
		OrderFacade orderFacade = new OrderFacade();
		orderFacade.processOrder("MacBook", 5);
	}

}

```

### Composite Pattern
![image](https://user-images.githubusercontent.com/69948118/172500727-69bd4e54-6c5e-44bf-98a7-43174e2888f7.png)
![image](https://user-images.githubusercontent.com/69948118/172501001-23a2c3ce-2f41-4ae3-90f0-c2111e318427.png)
```java
package composite;

import java.util.ArrayList;
import java.util.List;

abstract class Account {
  public abstract float getBalance();
}

class DepositeAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public DepositeAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }

}

class SavingAccount extends Account {
  private String accountNo;
  private float accountBalance;

  public SavingAccount(String accountNo, float accountBalance) {
    super();
    this.accountNo = accountNo;
    this.accountBalance = accountBalance;
  }

  public float getBalance() {
    return accountBalance;
  }
}

class CompositeAccount extends Account {
  private float totalBalance;
  private List<Account> accountList = new ArrayList<Account>();

  public float getBalance() {
    totalBalance = 0;
    for (Account f : accountList) {
      totalBalance = totalBalance + f.getBalance();
    }
    return totalBalance;
  }

  public void addAccount(Account acc) {
    accountList.add(acc);
  }

  public void removeAccount(Account acc) {
    accountList.add(acc);
  }
}

public class Client {

  public static void main(String[] args) {
    CompositeAccount component = new CompositeAccount();

    component.addAccount(new DepositeAccount("DA001", 100));
    component.addAccount(new DepositeAccount("DA002", 150));
    component.addAccount(new SavingAccount("SA001", 200));

    float totalBalance = component.getBalance();
    System.out.println("Total Balance : " + totalBalance);
  }

}
```
### Bridge Pattern
![image](https://user-images.githubusercontent.com/69948118/172505388-84ed0d19-924b-4413-bd7b-3ffb1fd46b6d.png)
![image](https://user-images.githubusercontent.com/69948118/172505541-7bd73d74-1586-4622-b9bb-09e7464a16b3.png)

```java
package bridge;

abstract class TV {
  Remote remote;
  
  TV(Remote r) {
    this.remote = r;
  }
  
  abstract void on();
  abstract void off();
}

class Sony extends TV {
  Remote remoteType;
  Sony(Remote r) {
    super(r);
    this.remoteType = r;
  }
  
  public void on(){
    System.out.print("Sony TV ON: ");
    remoteType.on();
  }
    
  public void off(){
    System.out.print("Sony TV OFF: ");
    remoteType.off();
  }
}
    
class Philips extends TV {
  Remote remoteType;
  
  Philips(Remote r) {
    super(r);
    this.remoteType = r;
  }
  
  public void on(){
    System.out.print("Philips TV ON: ");
    remoteType.on();
  }
    
  public void off(){
    System.out.print("Philips TV OFF: ");
    remoteType.off();
  }
}

interface Remote {
  public void on();
  public void off();
}

class OldRemote implements Remote {

  @Override
  public void on() {
    System.out.println("ON with Old Remote");
  }

  @Override
  public void off() {
    System.out.println("OFF with old Remote");
  }
  
}

class NewRemote implements Remote {

  @Override
  public void on() {
    System.out.println("ON with New Remote");
  }

  @Override
  public void off() {
    System.out.println("OFF with New Remote");
  }
  
}

public class Client {
  public static void main(String[] args) {
    TV sonyOldRemote = new Sony(new OldRemote());
    sonyOldRemote.on();
    sonyOldRemote.off();
    System.out.println();
    
    TV sonyNewRemote = new Sony(new NewRemote());
    sonyNewRemote.on();
    sonyNewRemote.off();
    System.out.println();
    
    TV philipsOldRemote = new Philips(new OldRemote());
    philipsOldRemote.on();
    philipsOldRemote.off();
    System.out.println();
    
    TV philipsNewRemote = new Philips(new NewRemote());
    philipsNewRemote.on();
    philipsNewRemote.off();
    
  }
}
```
---

<h2 id="behavioral-design-pattern">3. Behavioral Design Pattern</h2>

## Template Pattern

The template method pattern is a behavioural pattern. And as the name itself says it provides a base template method. When we are working with inheritance in our applications we provide a base template method that should be used by the child classes. The child classes can override certain methods but they should use the base template method as is.

For example we have a data renderer class which can read the data, process the data and then render or display that data to the end user.But in our application we want to render the data in the same way no matter in which format the data is coming in that is if it is xml data or if it is CSV data. We want to render it using the render method in the base class reading the data and processing that data is up to the child classes. The child classes can override the readData and the processData.But we want to provide a base template method with all the implementation in it in that data renderer superclass. This pattern is called template method ,as we are providing a template for a particular method from the parent class that should be used by the child classes.

- UML
![Template Method](https://user-images.githubusercontent.com/69948118/210122993-6402a96d-dddf-43eb-8dba-b3e970472a41.png)

-Code Design
![image](https://user-images.githubusercontent.com/69948118/210123096-61874573-20eb-4173-a02c-1a7028a581e5.png)

- Code Sample:
```java
package com.jd.patterns.templateMethod;

public abstract class DataRenderer {
	
	public void render()
	{
		String data = readData();
		String processData = processData(data);
		System.out.println(processData);
	}
	
	public abstract String readData();
	public abstract String processData(String data);
	

}

package com.jd.patterns.templateMethod;

public class Test {
	public static void main(String[] args) {
		DataRenderer dataRenderer = new XMLDataRenderer();
		dataRenderer.render();
		CSVDataRenderer csvdataRenderer = new CSVDataRenderer();
		csvdataRenderer.render();
	}

}


```



## Command Pattern


A command design pattern is a behavioural design pattern from that gang of four patterns. It is used to encapsulate a request as an object and pass it to an invoker the invoker doe not know how to service the request from the client. It will take the command and pass it to a receiver who knows how to perform the action typically.



There are five actors in the command design pattern. They are the command itself. The client the invoker the concrete command that implements the command and a receiver who knows how to perform all the actions.

Let's take a look at an example to see all these five actors in action. Let's consider a person who is using a television or is watching a television and he uses a remote control typically to perform several operations. But let's simply take the on and off operations and let's see how the command pattern fits in here.Here the person is the client who wants to execute the on and off command on it television, the remote control is the invoker so he uses remote control to invoke a particular command by pressing a button and the commands themselves are the on command and off command that implement a interface called Command which has a execute method.



So the person will wrap this on command passes it to the remote control the remote control will send that command to the television and the television knows how to perform that action based on the command that comes in when it is on.



It will execute the command which is passed in which is the on command execute method. And when it is off it will perform the Execute method of the off command to switch off the television.



Here person is the client remote control is the Invoker command is the command interface on command and off command are the concrete command classes. And finally television is the receiver who knows how to perform the action. The huge advantage of the command pattern is that the invoker which is the client and the remote control are completely decoupled from the receiver.



The person need not touch the television or he need not know how to perform the on and off command he simply uses the remote control and presses the button the remote control also doesn't care how the actions are performed. It simply passes the command to the television. That way they are completely decoupled the invoker does not know the details of the action that needs to be performed.

The receiver here the television can change the implementation of how the on and off should be performed without impacting the remote control and the person.

- UML
- 
![Command Pattern](https://user-images.githubusercontent.com/69948118/210125328-a3cff45f-2e01-46fd-98bd-191f5d3ffd0c.png)

- Code Design
 ![image](https://user-images.githubusercontent.com/69948118/210126194-75f9e23d-c9bd-4bb1-b610-41dd2c9471a3.png)
![image](https://user-images.githubusercontent.com/69948118/210126137-c9691a6d-91ca-4c22-b624-bfe5d6ab987b.png)

- Sample Code:
```java
package com.jd.patterns.command;

public class RemoteControl {

	private Command command;
	
	
	public void pressButton()
	{
		command.execute();
	}

	public Command getCommand() {
		return command;
	}

	public void setCommand(Command command) {
		this.command = command;
	}

}
package com.jd.patterns.command;

public class Person {

	public static void main(String[] args) {
		Television television = new Television();
		RemoteControl remoteControl = new RemoteControl();

		OnCommand onCommand = new OnCommand(television);
		remoteControl.setCommand(onCommand);
		remoteControl.pressButton();
		
		OffCommand offCommand = new OffCommand(television);
		remoteControl.setCommand(offCommand);
		remoteControl.pressButton();
	}

}


```

### Iterator Pattern
![image](https://user-images.githubusercontent.com/69948118/210161241-86c0da16-19e5-42b1-8241-57c3f86115b5.png)

### Observer Pattern
![image](https://user-images.githubusercontent.com/69948118/172506194-7a88df9f-6fa7-4d07-ac68-18157555362d.png)

```java
package observer;

import java.util.ArrayList;
import java.util.List;

interface Subject {
  void register(Observer obj);
  void unregister(Observer obj);
  void notifyObservers();
}

class DeliveryData implements Subject {

  private List<Observer> observers;
  private String location;
  
  public DeliveryData() {
    this.observers = new ArrayList<>();
  }
  
  @Override
  public void register(Observer obj) {
    observers.add(obj);
  }

  @Override
  public void unregister(Observer obj) {
      observers.remove(obj);
  }

  @Override
  public void notifyObservers() {
    for(Observer obj : observers) {
      obj.update(location);
    }
  }

  public void locationChanged() {
    this.location = getLocation();
    notifyObservers();
  }
  
  public String getLocation() {
    return "YPlace";
  }
}


interface Observer {
  public void update(String location);
}


class Seller implements Observer {
  private String location;
  
  @Override
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at Seller - Current Location: " + location);
  }
}

class User implements Observer {
  private String location;
  
  @Override
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at User - Current Location: " + location);
  }
}

class DeliveryWarehouseCenter implements Observer {
  private String location;
  
  @Override
  public void update(String location) {
    this.location = location;
    showLocation();
  }

  public void showLocation() {
    System.out.println("Notification at Warehouse - Current Location: " + location);
  }
}

public class ObserverPatternTest {

  public static void main(String[] args) {
    DeliveryData topic = new DeliveryData();
    
    Observer obj1 = new Seller();
    Observer obj2 = new User();
    Observer obj3 = new DeliveryWarehouseCenter();
    
    topic.register(obj1);
    topic.register(obj2);
    topic.register(obj3);
    
    topic.locationChanged();
    
    topic.unregister(obj3);
    
    System.out.println();
    topic.locationChanged();
    
  }
}
```

### Strategy Pattern Overview

- The **Strategy Pattern** is a behavioral design pattern that defines a family of algorithms, encapsulates each one, and makes them interchangeable. The strategy pattern lets the algorithm vary independently from the clients that use it. This pattern is particularly useful when you have multiple ways to perform an action and you want to switch between them dynamically at runtime.

#### Key Components of Strategy Pattern:

1. **Strategy Interface**: An interface that declares the common method that different algorithms (strategies) will implement.
2. **Concrete Strategies**: Different implementations of the strategy interface.
3. **Context**: The class that uses a `Strategy` to call the algorithm. It holds a reference to a `Strategy` object and delegates the work to the strategy.

#### Benefits:
- **Open/Closed Principle**: The strategy pattern allows the class behavior to be changed without modifying the class itself.
- **Dynamic Behavior**: Algorithms can be changed dynamically at runtime.

#### Implementation in Java

Here’s an example where the strategy pattern is implemented for a payment system, where different payment methods (e.g., CreditCard, PayPal) are strategies.

##### Step-by-Step Implementation

1. **Strategy Interface:**

```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

2. **Concrete Strategies:**

```java
// Credit Card payment strategy
public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String cardHolder;

    public CreditCardStrategy(String cardNumber, String cardHolder) {
        this.cardNumber = cardNumber;
        this.cardHolder = cardHolder;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using Credit Card: " + cardNumber);
    }
}

// PayPal payment strategy
public class PayPalStrategy implements PaymentStrategy {
    private String email;

    public PayPalStrategy(String email) {
        this.email = email;
    }

    @Override
    public void pay(double amount) {
        System.out.println("Paid " + amount + " using PayPal with email: " + email);
    }
}
```

3. **Context Class:**

```java
public class PaymentContext {
    private PaymentStrategy paymentStrategy;

    // Set the strategy at runtime
    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    // Call the strategy to execute payment
    public void executePayment(double amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment strategy selected!");
        }
    }
}
```

4. **Client Code:**

```java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        PaymentContext paymentContext = new PaymentContext();

        // Pay using Credit Card
        paymentContext.setPaymentStrategy(new CreditCardStrategy("1234-5678-9876-5432", "John Doe"));
        paymentContext.executePayment(100.00);

        // Pay using PayPal
        paymentContext.setPaymentStrategy(new PayPalStrategy("john@example.com"));
        paymentContext.executePayment(200.00);
    }
}
```

#### Output:
```
Paid 100.0 using Credit Card: 1234-5678-9876-5432
Paid 200.0 using PayPal with email: john@example.com
```

#### Conclusion:
The **Strategy Pattern** allows you to define different algorithms and choose them at runtime, and you can use this approach to dynamically select different behaviors in your application. Using **`CompletableFuture`**, we can make the strategy execution asynchronous in Java, simulating an `async/await`-like flow.

### Factory Pattern vs Strategy Pattern
Yes, the **Strategy Pattern** and the **Factory Pattern** can seem similar because both deal with object creation and behavior. However, there are important differences between the two patterns in terms of purpose, structure, and when to use them.

#### 1. **Purpose**:

- **Strategy Pattern**: 
  - Focuses on defining a family of algorithms or behaviors that can be swapped at runtime based on the specific needs of the client.
  - It's about enabling the client to choose **how** something gets done (i.e., different strategies to solve a problem).
  
- **Factory Pattern**:
  - Concerned with object creation. The factory pattern hides the creation logic and allows the client to request objects without knowing the exact instantiation details.
  - It's about creating **what** the client needs (i.e., different types of objects).

#### 2. **When to Use**:

- **Strategy Pattern**:
  - Use when you need to dynamically choose between different algorithms or behaviors at runtime.
  - Use when a class has multiple behaviors, and these behaviors should be interchangeable without modifying the class itself.
  
- **Factory Pattern**:
  - Use when object creation involves complex logic, and you want to centralize and encapsulate the logic of creating instances.
  - Use when the specific type of object created may vary based on some input, configuration, or condition, and you want to hide the instantiation process.

#### 3. **Structure**:

##### **Strategy Pattern** Structure:
- **Strategy Interface**: Defines the common method for all strategies.
- **Concrete Strategies**: Implementations of different strategies.
- **Context**: Holds a reference to a strategy and delegates the work to the current strategy.

##### **Factory Pattern** Structure:
- **Factory Interface (optional)**: May define methods for creating objects.
- **Concrete Factories**: Responsible for creating specific objects.
- **Products**: The objects being created by the factory.

#### Key Differences:

| Feature                  | Strategy Pattern                                                | Factory Pattern                                                |
|--------------------------|-----------------------------------------------------------------|----------------------------------------------------------------|
| **Primary Focus**         | Selecting and using different algorithms or behaviors.          | Creating objects (hides the instantiation details).             |
| **Client Interaction**    | The client decides which strategy to use and can change it.     | The client asks the factory for an object without knowing its creation process. |
| **Object Creation**       | The focus is not on creating objects but on encapsulating behavior. | The factory is explicitly responsible for creating objects.     |
| **Behavior vs Creation**  | Strategy deals with varying **behavior** at runtime.            | Factory deals with varying **object creation** based on conditions. |
| **Change Flexibility**    | Strategies can be swapped dynamically during runtime.           | The factory is used to create objects, but once created, the behavior is fixed. |
| **Design Goal**           | To provide flexibility to swap out algorithms or behavior.      | To encapsulate and centralize object creation logic.            |

#### Example for Strategy Pattern (Behavioral Focus):

Imagine you have a payment system, and the client needs to dynamically choose how they want to pay (CreditCard, PayPal, etc.).

```java
public interface PaymentStrategy {
    void pay(double amount);
}

public class CreditCardStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paying with credit card.");
    }
}

public class PayPalStrategy implements PaymentStrategy {
    public void pay(double amount) {
        System.out.println("Paying with PayPal.");
    }
}

public class PaymentContext {
    private PaymentStrategy strategy;
    
    public void setPaymentStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }
    
    public void processPayment(double amount) {
        strategy.pay(amount);
    }
}

// Client code
PaymentContext context = new PaymentContext();
context.setPaymentStrategy(new CreditCardStrategy());
context.processPayment(100.0);
```

#### Example for Factory Pattern (Creation Focus):

Imagine you have a system where you need to create different types of users (Admin, Customer, Guest).

```java
public interface User {
    void getRole();
}

public class AdminUser implements User {
    public void getRole() {
        System.out.println("Admin role.");
    }
}

public class CustomerUser implements User {
    public void getRole() {
        System.out.println("Customer role.");
    }
}

public class UserFactory {
    public User createUser(String type) {
        switch (type) {
            case "Admin":
                return new AdminUser();
            case "Customer":
                return new CustomerUser();
            default:
                throw new IllegalArgumentException("Unknown user type");
        }
    }
}

// Client code
UserFactory factory = new UserFactory();
User admin = factory.createUser("Admin");
admin.getRole();
```

#### Use Cases: When to Use Strategy vs Factory

##### Use **Strategy Pattern** When:
- You have multiple ways to perform an operation or algorithm (e.g., sorting algorithms, payment methods).
- You want to allow the client to choose the algorithm or behavior dynamically.
- You have classes that need to be open to behavior extension (new strategies) but closed to modification.

##### Use **Factory Pattern** When:
- Object creation logic is complex or may involve various steps that you want to encapsulate.
- You need to return different types of objects depending on the input.
- The exact type of object to create is determined at runtime.

#### Conclusion:
- **Strategy Pattern** focuses on choosing an algorithm or behavior, and allows for flexibility in selecting or changing behaviors at runtime.
- **Factory Pattern** focuses on creating objects and abstracts the instantiation process to handle complexity or variety in object creation.

If you're dealing with varying **behavior or algorithms**, the **Strategy Pattern** is the right choice. If you're dealing with the complexity of **object creation** or creating objects based on conditions, the **Factory Pattern** is more suitable.

---
## JEE Patterns

## Inversion of Control Pattern
![image](https://user-images.githubusercontent.com/69948118/210162136-04695fa1-48f4-48ce-a588-fa56b9d17630.png)

## Java EE Basics
![image](https://user-images.githubusercontent.com/69948118/210194819-ba8a9ba6-2bb4-4e8d-9423-08e1872289b0.png)
![image](https://user-images.githubusercontent.com/69948118/210194801-13bf94f7-462d-492d-9c83-d47357a86b45.png)
![image](https://user-images.githubusercontent.com/69948118/210194926-0dcfcb09-a52a-45a1-a3de-6a1411a84b16.png)

## Presentation Tier - Patterns
### Intercepting Filter
![image](https://user-images.githubusercontent.com/69948118/210195057-2c263a6f-a77d-43f8-b2d8-10876c985adf.png)
![image](https://user-images.githubusercontent.com/69948118/210195104-8d88f6af-7b7f-486e-b5fa-5dd951acd198.png)

```java
package com.bharath.patterns.interceptingfilter;

import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

@WebFilter("/*")
public class UserAgentFilter implements Filter {

	public void destroy() {
	}

	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {

		String userAgentHeader = ((HttpServletRequest) request).getHeader("User-Agent");
		System.out.println(userAgentHeader);
		if (userAgentHeader.contains("Chrome")) {
			chain.doFilter(request, response);
		} else {
			RequestDispatcher dispatcher = request.getRequestDispatcher("badBrowser.jsp");
			dispatcher.forward(request, response);
		}

	}

	public void init(FilterConfig fConfig) throws ServletException {
	}

}

```
### Front Conroller
![image](https://user-images.githubusercontent.com/69948118/210206380-0cf861c9-a0db-477d-b384-4c489b47d7ed.png)

### Mini Project
![image](https://user-images.githubusercontent.com/69948118/210209112-6494567d-8ba1-40d4-81ab-096516e9e559.png)


---
### Ajay-design-pattern

#### Adapter design pattern
- The Adapter design pattern is a structural pattern that allows two incompatible interfaces to work together. It converts the interface of one class into another interface that clients expect. This pattern is often used when an existing class's interface does not match the interface required by a client, or when a client needs to work with multiple classes that have different interfaces.
The Adapter pattern involves the following components:
- Target Interface: This is the interface that the client expects to work with.
- Adaptee: This is the class that has the interface that does not match the target interface.
- Adapter: This is the class that adapts the interface of the Adaptee to the Target Interface.
- The Adapter pattern can be implemented in two ways: Class Adapter and Object Adapter.
- In the Class Adapter approach, the Adapter class extends the Adaptee class and implements the Target Interface. The Adapter class inherits the behavior of the Adaptee - - class and adds the behavior required to match the Target Interface.
- In the Object Adapter approach, the Adapter class contains an instance of the Adaptee class and implements the Target Interface. The Adapter class delegates the requests - from the client to the Adaptee instance and adds the behavior required to match the Target Interface.

- Here's an example to illustrate how the Adapter pattern works:
- Suppose you have a client that expects a simple interface for a printer that only has a print() method. However, you have an existing class called AdvancedPrinter that has a complex interface with multiple methods. You can create an Adapter class that adapts the interface of the AdvancedPrinter to the simple interface expected by the client. The Adapter class would have a print() method that calls the appropriate methods on the AdvancedPrinter to accomplish the print operation. The client can then use the Adapter class to print documents without having to know about the complex interface of the AdvancedPrinter.

#### Proxy Design pattern:
- The Proxy design pattern is a structural pattern that provides a surrogate or placeholder for another object to control access to it. The Proxy pattern allows you to create a representative object that can act as an intermediary between a client and the real object. The proxy object can perform additional functionality such as security checks, caching, or remote communication.
- The Proxy pattern involves the following components:
- Subject: This is the interface that both the Real Subject and the Proxy implement. It defines the common interface for the Real Subject and the Proxy so that the client can work with both objects interchangeably.
- Real Subject: This is the object that the client wants to access. It implements the Subject interface and provides the real implementation of the operations.
- Proxy: This is the object that acts as a surrogate for the Real Subject. It also implements the Subject interface and forwards the requests from the client to the Real - Subject. In addition to forwarding requests, the Proxy may also perform additional functionality such as caching, logging, or security checks.
- The Proxy pattern can be implemented in several ways, including:
- Virtual Proxy: This is a type of Proxy that creates an object on demand. When the client requests an operation, the Virtual Proxy checks whether the Real Subject has been created, and if not, it creates it. This is useful when creating the Real Subject is expensive, and you want to delay its creation until it is actually needed.
Protection Proxy: This is a type of Proxy that checks whether the client has the necessary permissions to access the Real Subject. If the client has
the required permissions, the Proxy forwards the request to the Real Subject. Otherwise, it denies the request.
- Remote Proxy: This is a type of Proxy that acts as a local representative for a remote object. When the client requests an operation, the Remote Proxy forwards the request to the remote object and returns the result.
Here's an example to illustrate how the Proxy pattern works:
- Suppose you have a resource-intensive object that needs to be accessed frequently. You can create a Proxy object that acts as a surrogate for the real object. The Proxy object can cache the results of the operations and return the cached results to the client when the same operation is requested again. This can save time and resources by avoiding the need to recreate the object or perform expensive operations repeatedly.
Tell me about Decorator Pattern?

#### Decorator Pattern:
- The Decorator pattern is a design pattern in object-oriented programming that allows behavior to be added to an individual object, either statically or dynamically, without affecting the behavior of other objects from the same class. It is a structural pattern that allows objects to have additional behavior or responsibilities without the need to create a subclass of the original object.
- In the Decorator pattern, a set of decorator classes are created that add new functionality to the original object. These decorators conform to the same interface as the object being decorated, and they contain a reference to the object they are decorating. The decorators can add new behavior to the object by intercepting its method calls and modifying their behavior or adding new functionality.
- Here are some key features of the Decorator pattern:
- It is a way to extend the functionality of an object without sub classing.
- Decorators can be stacked on top of each other to add multiple layers of functionality.
- Decorators can be added and removed at runtime, which makes it easy to change an object's behaviour dynamically.
- The original object can remain unchanged, which helps to ensure that existing code and unit tests still work as expected.

- The Decorator pattern allows for a clear separation of concerns between the object being decorated and the code that adds new behaviour.
- A common real-world example of the Decorator pattern is with streaming services. For example, a user might have a basic streaming service that allows them to access a limited library of content. They can then choose to add a set of decorator services, such as one for high-definition video, another for access to live events, and yet another for access to an expanded library of content. Each decorator adds a layer of functionality to the basic streaming service, allowing the user to customize their experience and access additional features without needing to switch to a different service.

#### What is a facade design pattern?
- The facade design pattern is a structural design pattern that provides a unified interface to a set of interfaces in a subsystem. It defines a high-level interface that makes the subsystem easier to use and hides the complexity of the subsystem from the client.
- The facade pattern is often used in libraries and frameworks to provide a simplified interface to their functionality. For example, a facade could be used to provide a single method for starting a database connection, initializing a logging system, and configuring a web server.
- The facade pattern can also be used to decouple clients from the implementation of a subsystem. This can make the code more flexible and easier to maintain. For example, if a client needs to use multiple classes in a subsystem, the facade can provide a single interface that the client can use. This allows the client to be independent of the implementation of the subsystem.
```java
public class DatabaseFacade {
private DatabaseConnection connection;
private Logger logger;
public DatabaseFacade(DatabaseConnection connection, Logger logger) {
this.connection = connection;
this.logger = logger;
}
public void openConnection() {
connection.open();
logger.log("Database connection opened");
}
public void closeConnection() {
connection.close();
logger.log("Database connection closed");
}
public void executeQuery(String query) {
// Execute the query
logger.log("Query executed: " + query);
}
}
```
- The DatabaseFacade class provides a simplified interface to the database subsystem. It hides the complexity of the database subsystem from the client. To use the database, the client simply needs to create an instance of the DatabaseFacade class and call its methods.
The facade pattern is a useful design pattern for simplifying the use of complex subsystems and decoupling clients from the implementation of subsystems.

## spring-design-pattern
### Tell me the Design pattern used inside the spring framework.
The Spring Framework makes use of several design patterns to provide its functionality. Some of the key design patterns used in Spring are:
- Inversion of Control (IoC): This pattern is used throughout the Spring Framework to decouple the application code from the framework and its components. The IoC container is responsible for managing the lifecycle of beans and injecting dependencies between them.
- Singleton: A singleton pattern is used to ensure that there is only one instance of a bean created in the Spring IoC container. The singleton pattern is used to create a single instance of a class, which is shared across the entire application.
- Factory: The factory pattern is used in Spring to create objects of different classes based on the configuration. Spring provides a factory pattern to create beans, which is based on the factory method design pattern.
- Template Method: The template method pattern is used in Spring to provide a common structure for different types of operations. Spring provides several template classes such as JdbcTemplate, Hibernate Template, etc. that provide a common structure for performing database operations.
- Decorator: The decorator pattern is used in Spring to add additional functionality to existing beans. The Spring AOP (Aspect-Oriented Programming) module uses the decorator pattern to add additional functionality to existing beans through the use of proxies.
- Observer: The observer pattern is used in Spring to notify other beans of changes to the state of a bean. Spring provides the ApplicationEvent and ApplicationListener interfaces, which can be used to implement the observer pattern.
- Command: The command pattern is used in Spring to encapsulate the execution of a particular piece of code in a command object. This pattern is used in Spring to create reusable and testable code.
- Façade: The façade pattern is used in Spring to simplify the interface of a complex system. The Spring Framework uses the façade pattern to provide a simplified interface for interacting with its components.
### How do factory design patterns work in terms of the spring framework?
- In Spring, the factory design pattern is used to create objects of different classes based on the configuration. The Spring IoC container uses the factory pattern to create beans, which is based on the factory method design pattern.
-The factory method is a design pattern that provides a way to create objects of different classes based on a factory interface. In Spring, the IoC container acts as the factory, and the factory interface is represented by the BeanFactory or ApplicationContext interfaces.
-The IoC container is responsible for creating and managing the lifecycle of beans. When you define a bean in the configuration, the IoC container will use the factory pattern to create an instance of the bean. The IoC container will then manage the lifecycle of the bean, including injecting dependencies, initializing the bean, and destroying the bean when it is no longer needed.
Here's an example of how you can define a bean in Spring using the factory design pattern:
```
@Configuration
public class MyConfig {
@Bean
public MyService myService() {
return new MyService();
}
}
```
-In this example, the myService() method is annotated with @Bean. This tells Spring to create an instance of the MyService class when the IoC container is created. The IoC container will use the factory pattern to create the instance and manage its lifecycle.
Another way to use factory pattern in spring is to use FactoryBean interface, which allows you to create beans that are created by a factory method, it's a factory of bean. The FactoryBean interface defines a single method, getObject(), which returns the object that should be exposed as the bean in the Spring application context.
### How the proxy design pattern is used in spring?
- The proxy design pattern is used in Spring to add additional functionality to existing objects. The Spring Framework uses the proxy pattern to provide AOP (Aspect-Oriented Programming) functionality, which allows you to add cross-cutting concerns, such as logging, security, and transaction management, to your application in a modular and reusable way.
- In Spring, AOP proxies are created by the IoC container, and they are used to intercept method calls made to the target bean. This allows you to add
additional behaviour, such as logging or security checks, before or after the method call is made to the target bean.
- AOP proxies are created using one of three proxy types: JDK dynamic proxies, CGLIB proxies, or AspectJ proxies.
- JDK dynamic proxies: This is the default proxy type in Spring, and it is used to proxy interfaces.
- CGLIB proxies: This proxy type is used to proxy classes, and it works by creating a subclass of the target bean.
- AspectJ proxies: This proxy type uses the AspectJ library to create proxies, and it allows you to use AspectJ pointcuts and advice in your application.
Spring uses the proxy pattern to provide AOP functionality by generating a proxy object that wraps the target bean. The proxy object will intercept method calls made to the target bean, and it will invoke additional behavior, such as logging or security checks, before or after the method call is made to the target bean.
Here's an example of how you can use Spring AOP to add logging to a bean:
```java
@Aspect
@Component
public class LoggingAspect {
@Before("execution(* com.example.service.*.*(..))")
public void logBefore(JoinPoint joinPoint) {
log.info("Started method: " + joinPoint.getSignature().getName());
}
}
```
In this example, the LoggingAspect class is annotated with @Aspect and @Component to make it a Spring bean. The @Before annotation is used to specify that the logBefore() method should be executed before the method call is made to the target bean. The logBefore() method uses the JoinPoint argument to log the name of the method that is being called.
