# JavaDateTime_A-Z

## Classical Date Time API Classes

The primary classes before Java 8 release were:

### Java.lang.System:
- The class provides the currentTimeMillis() method that returns the current time in milliseconds. It shows the current date and time in milliseconds from January 1st 1970.

### java.util.Date: 
- It is used to show specific instant of time, with unit of millisecond.

### java.util.Calendar:
- It is an abstract class that provides methods for converting between instances and manipulating the calendar fields in different ways.

### java.text.SimpleDateFormat:
- It is a class that is used to format and parse the dates in a predefined manner or user defined pattern.

### java.util.TimeZone: 
- It represents a time zone offset, and also figures out daylight savings.

### Drawbacks of existing Date/Time API's
- Thread safety: The existing classes such as Date and Calendar does not provide thread safety. Hence it leads to hard-to-debug concurrency issues that are needed to be taken care by developers. The new Date and Time APIs of Java 8 provide thread safety and are immutable, hence avoiding the concurrency issue from developers.
- Bad API designing: The classic Date and Calendar APIs does not provide methods to perform basic day-to-day functionalities. The Date and Time classes introduced in Java 8 are ISO-centric and provides number of different methods for performing operations regarding date, time, duration and periods.
- Difficult time zone handling: To handle the time-zone using classic Date and Calendar classes is difficult because the developers were supposed to write the logic for it. With the new APIs, the time-zone handling can be easily done with Local and ZonedDate/Time APIs.

## New Date Time API in Java 8
- The new date API helps to overcome the drawbacks mentioned above with the legacy classes. It includes the following classes:

### java.time.LocalDate: 
- It represents a year-month-day in the ISO calendar and is useful for representing a date without a time. It can be used to represent a date only information such as a birth date or wedding date.
```java
LocalDate date = LocalDate.now();    
LocalDate yesterday = date.minusDays(1); 
System.out.println("Today date: "+date);    // Today date: 2017-01-13
System.out.println("Yesterday date: "+yesterday);    //Yesterday date: 2017-01-12

LocalDate date1 = LocalDate.of(2017, 1, 13);    
System.out.println(date1.isLeapYear());     // false

//Formatting
LocalDate d1 = LocalDate.now();  
String d1Str = d1.format(DateTimeFormatter.ISO_DATE);  
System.out.println("Date1 in string :  " + d1Str);  //Date1 in string :  2021-09-13

String dInStr = "2011-09-01";  
LocalDate d1 = LocalDate.parse(dInStr);  
System.out.println("String to LocalDate : " + d1);  //String to LocalDate : 2011-09-01

```
### java.time.LocalTime: 
- It deals in time only. It is useful for representing human-based time of day, such as movie times, or the opening and closing times of the local library.
```java
LocalTime time = LocalTime.now();  
System.out.println(time);  //15:19:47.459
LocalTime time = LocalTime.of(10,43,12);  
System.out.println(time);  //10:43:12

LocalTime time1 = LocalTime.of(10,43,12);  
System.out.println(time1);  //10:43:12

LocalTime time2=time1.minusHours(2);  
LocalTime time3=time2.minusMinutes(34);  
System.out.println(time3);  //08:09:12

ZoneId zone1 = ZoneId.of("Asia/Kolkata");  
ZoneId zone2 = ZoneId.of("Asia/Tokyo");  
LocalTime time1 = LocalTime.now(zone1);  
System.out.println("India Time Zone: "+time1);  //India Time Zone: 14:56:43.087

LocalTime time2 = LocalTime.now(zone2);  
System.out.println("Japan Time Zone: "+time2);   //Japan Time Zone: 18:26:43.103

long hours = ChronoUnit.HOURS.between(time1, time2);  
System.out.println("Hours between two Time Zone: "+hours);   //Hours between two Time Zone: 3

long minutes = ChronoUnit.MINUTES.between(time1, time2);  
System.out.println("Minutes between two time zone: "+minutes);  //Minutes between two time zone: 210


```
### java.time.LocalDateTime: 
- It handles both date and time, without a time zone. It is a combination of LocalDate with LocalTime.
```java
 LocalDateTime now = LocalDateTime.now();  
 System.out.println("Before Formatting: " + now);  
 DateTimeFormatter format = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");  //Before Formatting: 2017-01-13T17:09:
 String formatDateTime = now.format(format);  
 System.out.println("After Formatting: " + formatDateTime);  //After Formatting: 13-01-2017 17:09:42

LocalDateTime a = LocalDateTime.of(2017, 2, 13, 15, 56);    
System.out.println(a.get(ChronoField.DAY_OF_WEEK));  //1
System.out.println(a.get(ChronoField.DAY_OF_YEAR));  //44

```
### java.time.ZonedDateTime: 
- It combines the LocalDateTime class with the zone information given in ZoneId class. It represent a complete date time stamp along with timezone information.
```java
LocalDateTime  ldt = LocalDateTime.of(2017, Month.JANUARY,  19,   15,   26);  
ZoneId  india = ZoneId.of("Asia/Kolkata");   
ZonedDateTime zone1  = ZonedDateTime.of(ldt, india);   
System.out.println("In India Central Time Zone: " + zone1);  //In India Central Time Zone: 2017-01-19T15:26+05:30[Asia/Kolka
ZoneId  tokyo = ZoneId.of("Asia/Tokyo");   
ZonedDateTime zone2   = zone1.withZoneSameInstant(tokyo);   
System.out.println("In Tokyo Central Time Zone:"  + zone2);  //In Tokyo Central Time Zone:2017-01-19T18:56+09:00[Asia/Tokyo]

```
### java.time.OffsetTime: 
- It handles time with a corresponding time zone offset from Greenwich/UTC, without a time zone ID.
```java
OffsetTime offset = OffsetTime.now();  
int h = offset.get(ChronoField.HOUR_OF_DAY);  
System.out.println(h);  /16
int m = offset.get(ChronoField.MINUTE_OF_DAY);  
System.out.println(m);  //970
int s = offset.get(ChronoField.SECOND_OF_DAY);  
System.out.println(s);  //58224
```

### java.time.OffsetDateTime: 
- It handles a date and time with a corresponding time zone offset from Greenwich/UTC, without a time zone ID.
```java
OffsetDateTime offsetDT = OffsetDateTime.now();  
System.out.println(offsetDT);  //2023-03-16T11:29:47.678630300+05:30
  
 LocalDateTime now = LocalDateTime.now();  
 System.out.println("Before Formatting: " + now); //Before Formatting: 2023-03-16T11:29:47.679628900
 
```
### java.time.Clock : 
- It provides access to the current instant, date and time in any given time-zone. Although the use of the Clock class is optional, this feature allows us to test your code for other time zones, or by using a fixed clock, where time does not change.

### java.time.Instant : 
- It represents the start of a nanosecond on the timeline (since EPOCH) and useful for generating a timestamp to represent machine time. An instant that occurs before the epoch has a negative value, and an instant that occurs after the epoch has a positive value.

### java.time.Duration : 
- Difference between two instants and measured in seconds or nanoseconds and does not use date-based constructs such as years, months, and days, though the class provides methods that convert to days, hours, and minutes.

### java.time.Period : 
- It is used to define the difference between dates in date-based values (years, months, days).
AD

### java.time.ZoneId : 
- It states a time zone identifier and provides rules for converting between an Instant and a LocalDateTime.

### java.time.ZoneOffset : 
- It describe a time zone offset from Greenwich/UTC time.

### java.time.format.DateTimeFormatter : 
- It comes up with various predefined formatter, or we can define our own. It has parse() or format() method for parsing and formatting the date time values.
