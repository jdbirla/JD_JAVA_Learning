package streams.world;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ShortCircuitMethods {
 public static void main(String[] args) {
	 List<String> nameList = new ArrayList<>();
     nameList.add("Amitabh");
     nameList.add("Shekhar");
     nameList.add("Aman");
     nameList.add("Rahul");
     nameList.add("Shahrukh");
     nameList.add("Salman");
     nameList.add("Yana");
     nameList.add("Lokesh");

     /*
      * This will return true once a condition passed as predicate
      * satisfy. It will not process any more elements.
      */
     boolean matched = nameList.stream()
             .anyMatch((s) -> s.startsWith("S"));

     System.out.println(matched);
     
     String firstMatchedName = nameList.stream()
             .filter((s) -> s.startsWith("S")).findFirst().get();

     System.out.println(firstMatchedName);
     
     List<Integer> numberList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);

     /*
      * Returns:true if either all elements of the stream match the
      * provided predicate or the stream is empty, otherwise false
      */
     boolean isAllNumbersLargerThanFive = numberList.stream()
                                                     .allMatch(i -> i > 5);
     System.out.println(isAllNumbersLargerThanFive); // false

     /*
      * Returns:true if any elements of the stream match the
      * provided predicate, otherwise false
      */
     boolean hasNumberLargerThanFive = numberList.stream()
                                                 .anyMatch(i -> i > 5);
     System.out.println(hasNumberLargerThanFive); // true

     /*
      * Returns:true if either no elements of the stream match the
      * provided predicate or the stream is empty, otherwise false
      */
     boolean isNoneNumberLargerThanTen = numberList.stream()
                                                   .noneMatch(i -> i > 10);
     System.out.println(isNoneNumberLargerThanTen); // true
}
}
