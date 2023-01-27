# Java 7 notes :
![image](https://user-images.githubusercontent.com/69948118/215025817-8561974c-5ec6-4d86-920c-1d1352006320.png)
![image](https://user-images.githubusercontent.com/69948118/215025942-6ef9469d-c880-4b07-a35d-a5e7505bd7c9.png)
![image](https://user-images.githubusercontent.com/69948118/215025898-a427a970-0343-4517-a073-9252cb5cd103.png)
![image](https://user-images.githubusercontent.com/69948118/215025953-aca1a77f-e566-42ac-9186-09806e56f2cf.png)
---
## Collection terminology

- List: Insertion odder present and duplicate are allowed
- 
♦ ArrayList : Resizable Array and default capacity 10 [new capacity= current capacity * (3/2)+1] / Frequent operation is retrieval

♦ Vector : Resizable Array and all methods are synchronized / Frequent operation is retrieval/ default capacity 10 [new capacity = current capacity * 2]

♦ LinkedList: Duble Linked list and Frequent operation insertion or deletion

♦ Stack :

- Set : No insertion order and duplicates are not allowed
♦ HashSet : Underlying DS hashtable and default capacity 16 [default fill ratio 0.75 (75%)] /
♦ LinkedHashSet: Child class of hashset and underlying DS is HashTable and Linked List
♦ Sortedset :
♦ TreeSet: Underlying DS is Balanced Tree and

- Map:
♦ HashMap : Underlygin DS HashTable and default capacity 16 [default fill ratio 0.75 (75%)]
♦ HashTable : All methods as synchonized and default capacity 11 [default fill ratio 0.7(70%)]
♦ LinkedHashMap : Child clas of hashMap and underlying DS is HashTable and Linked List
♦ IdentityMap :
---
![image](https://user-images.githubusercontent.com/69948118/215026377-1694a6ec-7904-4e15-bb82-649b2061bef7.png)
![image](https://user-images.githubusercontent.com/69948118/215026408-f1bd3fea-ca07-4f0a-a139-640e420c66c3.png)
♦ WeakHashMap:
![image](https://user-images.githubusercontent.com/69948118/215026419-07edbb3d-95fc-4e23-97cb-0666a769cad7.png)
♦ SortedMap:
♦ TreeMap: underlying DS RED-Black Tree
Queue: where objects are inserted into one end of the queue, and taken off the queue in the other end of the queue
Sorted*** : Some sorting order
Navigable*** : added methods for Navigation
Linked*** : Insertion order preserved

![image](https://user-images.githubusercontent.com/69948118/215026480-c10d95cd-4fac-4a99-9bb6-a085901a8ed3.png)

![image](https://user-images.githubusercontent.com/69948118/215026494-9078d4f2-da4f-4eea-858d-ac8329266507.png)

![image](https://user-images.githubusercontent.com/69948118/215026511-a4a3a1c3-422c-4302-991e-9721fa05fae4.png)
![image](https://user-images.githubusercontent.com/69948118/215026520-970a37fb-3845-4118-a311-bf4d18a86bc0.png)
![image](https://user-images.githubusercontent.com/69948118/215026529-1ed13917-9ccd-4e69-a2bc-a34fe4cc1818.png)
![image](https://user-images.githubusercontent.com/69948118/215026546-c9a6b0b5-175c-4fee-8310-98aaef181932.png)
![image](https://user-images.githubusercontent.com/69948118/215026553-95823cb7-b77b-4015-84ce-5c1afa94823d.png)
![image](https://user-images.githubusercontent.com/69948118/215026569-11e6f40d-f944-4a3f-bf43-aed6eb744efe.png)
![image](https://user-images.githubusercontent.com/69948118/215026577-efd1b478-8ceb-499c-80d4-0684818e325e.png)
![image](https://user-images.githubusercontent.com/69948118/215026587-b6ae3f0e-7e8c-4042-bfb6-3dd54a25224b.png)
![image](https://user-images.githubusercontent.com/69948118/215026595-15da49d0-d411-4bd6-9001-5fb2f7414d7d.png)
![image](https://user-images.githubusercontent.com/69948118/215026599-852a74b8-e30b-4bc5-965a-e5f4e4a9a0a9.png)
![image](https://user-images.githubusercontent.com/69948118/215026614-81103bad-4543-4704-a3d4-a69e1f9448ed.png)
![image](https://user-images.githubusercontent.com/69948118/215026623-6108bac8-f6a9-44c8-803c-b192b335dfde.png)
![image](https://user-images.githubusercontent.com/69948118/215026631-0285d7ea-99d1-4b9a-939a-3f011d20d494.png)
![image](https://user-images.githubusercontent.com/69948118/215026642-5c3d078b-a039-4221-a5fa-45eb54a7d84a.png)
![image](https://user-images.githubusercontent.com/69948118/215026650-c557f5b7-18d8-4f24-be45-0e90abdd9639.png)
![image](https://user-images.githubusercontent.com/69948118/215026658-2ac7f986-5bf0-4973-8cb9-0e0b898bd717.png)
![image](https://user-images.githubusercontent.com/69948118/215026667-dd149558-bc72-438e-b159-ad59c541a5de.png)
![image](https://user-images.githubusercontent.com/69948118/215026676-036f035a-ff0b-4324-b8e0-8522d80a8286.png)
![image](https://user-images.githubusercontent.com/69948118/215026692-eb410f4b-77f1-4a29-9738-eef15a117459.png)
![image](https://user-images.githubusercontent.com/69948118/215026700-91dfe1eb-5735-4b14-ac48-428d9d253963.png)
![image](https://user-images.githubusercontent.com/69948118/215026705-9993231e-be15-45e5-ac2c-774c9474b33c.png)
![image](https://user-images.githubusercontent.com/69948118/215026719-d4b619e4-86c5-4e0d-ae14-de50172c2d88.png)
![image](https://user-images.githubusercontent.com/69948118/215026726-87423112-7df9-4254-a0c5-27f3ccc49d4e.png)

## Inheritance ex.
1. When parent and child have different name methods (No Overriding)
```java
class Vehicle{
void run(){
System.out.println("Vehicle is running");
}
}
class Bike1 extends Vehicle{
void run1(){
System.out.println("Bike is running safely");
}
}
class Bike2 {
public static void main(String args[]){
Vehicle obj = new Bike1(); //Cases
obj.run(); //Cases
}
}
```
Case 1:
```
Vehicle obj = new Bike1(); obj.run();
Output: Vehicle is running
```
Case2 :
```
Vehicle obj = new Bike1(); obj.run1();
Output: Compile by: javac Bike2.java
122.93/Bike2.java:16: error: cannot find symbol obj.run1(); ^ symbol: method run1() location: variable obj of type Vehicle 1 error
```
2. When parent and child have same name methods (Overriding)
```java
class Vehicle{
void run(){
System.out.println("Vehicle is running");
}
}
class Bike1 extends Vehicle{
void run(){
System.out.println("Bike is running safely");
}
}
class Bike2 {
public static void main(String args[]){
Vehicle obj = new Vehicle(); //Cases
obj.run(); //cases
}
}
```
Case1:
```
Vehicle obj = new Vehicle();
obj.run();
Output: Vehicle is running
```
Case2:
```
Vehicle obj = new Bike1();
obj.run();
Output: Bike is running safely
```

