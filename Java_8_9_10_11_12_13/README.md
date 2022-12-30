# Java_8_9_10_11_12_13
- URL : https://www.udemy.com/course/java-latest-programming-from-zero-java13-java12-java11-java10-java9-j8/learn/lecture/17818988#overview
- Common SQL Clauses and Their Equivalents in Java 8 Streams https://dzone.com/articles/common-sql-clauses-and-their-equivalents-in-java-8-1

|SQL  |JAVA API
|---  |--- 
|FROM	|of(),stream()
|WHERE	|filter()
|	SELECT RESULT	|	Collect(Collector.toList()) //toSet(),toCollection(Supplier<C> collectionFactory)
|	Concatinate all the colums	|productList.stream().map(Product::getName).collect(Collectors.joining("", "", ""["", ""]""));"
|	Sum	|int summingPrice = productList.stream() .collect(Collectors.summingInt(Product::getPrice));"
|	Average	|double averagePrice = productList.stream()  .collect(Collectors.averagingInt(Product::getPrice));
|	Collecting statistical information	|	"IntSummaryStatistics statistics = productList.stream().collect(Collectors.summarizingInt(Product::getPrice));"
|	Group BY	|Map<Integer, List<Product>> collectorMapOfLists=productList.stream()  .collect(Collectors.groupingBy(Product::getPrice));"
|	PartitionBy	|	"Map<Boolean, List<Product>> mapPartioned = productList.stream().collect(Collectors.partitioningBy(element -> element.getPrice() > 15));"
|	Group BY and select from Outer Query	|	Set<Product> unmodifiableSet = productList.stream() .collect(Collectors.collectingAndThen(Collectors.toSet(), Collections::unmodifiableSet));

- ![Browser](Images/Java8FunctionalInterfaces_withMethods.png)

## Section 1: Introduction

![Browser](Images/Screenshot_01.png)
![Browser](Images/Screenshot_02.png)
![Browser](Images/Screenshot_03.png)
![Browser](Images/Screenshot_04.png)
![Browser](Images/Screenshot_05.png)
![Browser](Images/Screenshot_06.png)
![Browser](Images/Screenshot_07.png)
![Browser](Images/Screenshot_08.png)
![Browser](Images/Screenshot_09.png)
![Browser](Images/Screenshot_10.png)
![Browser](Images/Screenshot_11.png)
![Browser](Images/Screenshot_12.png)

---

## Section 2: Lambda Expressions


* Example 
https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/lambda/SumOfNumbersUsingCallable.java

---
## Section 3: Functional Interfaces and Lambda

![Browser](Images/Screenshot_13.png)
![Browser](Images/Screenshot_14.png)
![Browser](Images/Screenshot_15.png)
![Browser](Images/Screenshot_16.png)

* Consumer example 
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/ConsumerExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/ConsumerExample2.java
3. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/ConsumerExample3.java

### Biconsumer 
![Browser](Images/Screenshot_17.png)

* Biconsumer Examples
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/BiConsumerExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/ConsumerExample3.java

### Predicate         
 
![Browser](Images/Screenshot_18.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/PredicateExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/PredicateExample2.java
3. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/PredicateExample3.java
* PredicateAndBiConsumerExample
4. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/PredicateAndBiConsumerExample.java
* BiPredicateExample
5. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/BiPredicateExample.java

### Function Interface

![Browser](Images/Screenshot_19.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/FunctionExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/FunctionExample2.java

### BiFunction Interface
![Browser](Images/Screenshot_20.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/BiFunctionExample.java

### Unary Operator

![Browser](Images/Screenshot_21.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/UnaryOperatorExample.java

### Binary Operator
![Browser](Images/Screenshot_22.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/BinaryOperatorExample.java

### Supplier Interface
![Browser](Images/Screenshot_23.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/SupplierExample.java

### Method Reference
![Browser](Images/Screenshot_24.png)
![Browser](Images/Screenshot_25.png)
![Browser](Images/Screenshot_26.png)
![Browser](Images/Screenshot_27.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/MethodReferenceExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/ConvertToMethodReferenceExample.java

## Java8 FunctionalInterfaces with Methods



---
## Section 4: Lambda Variable Scope

![Browser](Images/Screenshot_28.png)
![Browser](Images/Screenshot_29.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/VariableScope.java

---
## Section 5: Bank Transfer
![Browser](Images/Screenshot_30.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/tree/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/funcprogramming/realexample

---
## Section 6: Streams

![Browser](Images/Screenshot_31.png)
![Browser](Images/Screenshot_32.png)
![Browser](Images/Screenshot_33.png)
![Browser](Images/Screenshot_34.png)
![Browser](Images/Screenshot_35.png)
![Browser](Images/Screenshot_36.png)
![Browser](Images/Screenshot_37.png)
![Browser](Images/Screenshot_38.png)
![Browser](Images/Screenshot_39.png)

### Debug Stream using peek method
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamExample.java

![Browser](Images/Screenshot_40.png)
![Browser](Images/Screenshot_41.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamVsCollectionExample.java

---
## Section 7: Streams Operations

### Map
![Browser](Images/Screenshot_42.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/MapExample.java

### FlatMap

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/FlatMapExample.java

### distinct,count,sorted, allmatch
![Browser](Images/Screenshot_43.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamsOperations.java

### customized sort using comparator

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamComparatorExample.java

### filter

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/FilterExample.java

### Reduce

![Browser](Images/Screenshot_44.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamReduceExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamReduceExample2.java

### map + filter + reduce

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamMapFilterReduceExample.java

### Max 
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamMaxExample.java

### Min 
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamMinExample.java

### limit and skip
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamLimitAndSkipExample.java

### findAny() and findFirst()
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamFindAnyAndFirstExample.java

---
## Section 8: Streams Generators

![Browser](Images/Screenshot_45.png)
![Browser](Images/Screenshot_46.png)
![Browser](Images/Screenshot_47.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/StreamFactoryMethodExample.java

---
## Section 9: Numeric Streams

### intStream,LongStream,DoubleStream
1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/IntStreamExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/LongStreamExample.java
3. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/DoubleStreamExample.java

### Numeric Stream Aggregate Functions

![Browser](Images/Screenshot_48.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/NumericStreamAggregateExample.java

### Boxing and Unboxing

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/BoxingUnBoxingExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/MapToObjLongDoubleExample.java

---
## Section 10: Collectors Operations

### joining
![Browser](Images/Screenshot_49.png)
![Browser](Images/Screenshot_50.png)

1.  https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/JoiningExample.java

### counting
![Browser](Images/Screenshot_51.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/CountingExample.java


### mapping
![Browser](Images/Screenshot_52.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/CollectorMappingExample.java

### minby() and maxBy()

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/CollectorsMinMaxExample.java

### summingInt() and averagingInt()

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/CollectorSummingAveragingExample.java

### groupingBy
![Browser](Images/Screenshot_53.png)
![Browser](Images/Screenshot_54.png)
![Browser](Images/Screenshot_55.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/GroupingByExample1.java

![Browser](Images/Screenshot_56.png)

2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/GroupingExample2.java

![Browser](Images/Screenshot_57.png)

3. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/GroupingExample3.java

### GroupingMinMaxAvgExample

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/GroupingMinMaxAvgExample.java

#### partitioningBy()
![Browser](Images/Screenshot_58.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/streams/PartitioningByExample.java

---
## Section 11: Parallel Stream

![Browser](Images/Screenshot_59.png)

![Browser](Images/Screenshot_60.png)

![Browser](Images/Screenshot_61.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/parallelstream/ParallelStreamExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/parallelstream/StreamPerformanceExample.java
3. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/parallelstream/StreamPerformanceExample1.java

---
## Section 12: Optional java8+

![Browser](Images/Screenshot_62.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/optional/OptionalExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/optional/OptionalIfIsExample.java
3. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/optional/OptionalOfEmptyExample.java
4. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/optional/OptionalOrElseThrowExample.java

---
## Section 13: Default and Static Methods ot Interfaces 

![Browser](Images/Screenshot_63.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/tree/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/defaults

---
## Section 14: New DateTime APIs

---
## Section 15:Java Shell(REPL)- Java9+
![Browser](Images/Screenshot_64.png)

![Browser](Images/Screenshot_65.png)

![Browser](Images/Screenshot_66.png)

![Browser](Images/Screenshot_67.png)

![Browser](Images/Screenshot_68.png)


---
## Section 16 : Module System- Java9+

![Browser](Images/Screenshot_69.png)

![Browser](Images/Screenshot_70.png)

![Browser](Images/Screenshot_71.png)

---
## Section 17: Factory Methods for Collection - Java9+

![Browser](Images/Screenshot_72.png)

![Browser](Images/Screenshot_73.png)

![Browser](Images/Screenshot_74.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/factorymethods/FactoryMethodsExample.java

---
## Section 18: Try-with-resources - Java9+

![Browser](Images/Screenshot_75.png)

![Browser](Images/Screenshot_76.png)

![Browser](Images/Screenshot_77.png)



1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/java9improvements/TryWithResourcesExample.java

---
## Section 19: Try Interference with var - Java10+

![Browser](Images/Screenshot_78.png)

![Browser](Images/Screenshot_79.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/javaimprovements/TypeInterferenceExample.java


---
## Section 20: GC1 Improvements- Java 10+

---
## Section 21: var with Lambda - Java11+

![Browser](Images/Screenshot_80.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/javaimprovements/VarWithLambdaExample.java

---
## Section 22: Epsilon GC - Java11+

![Browser](Images/Screenshot_81.png)

![Browser](Images/Screenshot_82.png)


---
## Section 23: New Http Client - Java11+

![Browser](Images/Screenshot_83.png)

![Browser](Images/Screenshot_84.png)

![Browser](Images/Screenshot_85.png)

![Browser](Images/Screenshot_86.png)

![Browser](Images/Screenshot_87.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/javaimprovements/HttpClientExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/javaimprovements/AsyncHttpClient.java


---
## Section 24: Switch Expression - Java12+

![Browser](Images/Screenshot_88.png)

![Browser](Images/Screenshot_89.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/java9improvements/SwitchStatementExample.java
2. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/java9improvements/SwitchExpressionsExample1.java
3. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/java9improvements/SwitchExpressionExample2.java
---
## Section 25: Switch Expression Enhancements- Java13+

![Browser](Images/Screenshot_90.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/java9improvements/SwitchExpressionEnhancementExample.java
---
## Section 26: Text Blocks - Java13+

![Browser](Images/Screenshot_91.png)

![Browser](Images/Screenshot_92.png)

1. https://github.com/jdbirla/JD_JAVA_Learning/blob/master/Java_8_9_10_11_12_13/LambdaExpression/src/com/modernjava/java9improvements/MultiLineTextBlockExample.java

---






