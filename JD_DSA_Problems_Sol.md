# JD_DSA_Problems_Solutions

- JavaTPoint:
    - All Programs: https://www.javatpoint.com/java-programs
- Java2Blog
    - https://java2blog.com/java-coding-interview-questions/

# Table of contents

- [JD_DSA_Problems_Solutions](#jd_dsa_problems_solutions)
  - [How do you reverse a string in Java?](#how-do-you-reverse-a-string-in-java)
  - [Write a Java program to print a Fibonacci sequence using recursion.](#write-a-java-program-to-print-a-fibonacci-sequence-using-recursion)
  - [How do you check whether a string is a palindrome in Java?](#how-do-you-check-whether-a-string-is-a-palindrome-in-java)
  - [How can you find the factorial of an integer in Java?](#how-can-you-find-the-factorial-of-an-integer-in-java)
  - [How do you reverse a linked list in Java?](#how-do-you-reverse-a-linked-list-in-java)
  - [How do you implement a binary search in Java?](#how-do-you-implement-a-binary-search-in-java)
  - [Write Java program that checks if two arrays contain the same elements.](#write-java-program-that-checks-if-two-arrays-contain-the-same-elements)
  - [Write a java program to check if two Strings are anagram in java?](#write-a-java-program-to-check-if-two-strings-are-anagram-in-java)
  - [How to check if one String is rotation of another String in java?](#how-to-check-if-one-string-is-rotation-of-another-string-in-java)
  - [Find first non repeated character in String in java?](#find-first-non-repeated-character-in-string-in-java)
  - [Java program to find missing number in an array](#java-program-to-find-missing-number-in-an-array)
  - [Rotate an array by K positions.](#rotate-an-array-by-k-positions)
  - [Implement a stack using array.](#implement-a-stack-using-array)
  - [implement a stack using Linked List.](#implement-a-stack-using-linked-list)
  - [Implement Stack using two Queues in java](#implement-stack-using-two-queues-in-java)
  - [Sort a Stack using another stack](#sort-a-stack-using-another-stack)
  - [Queue implementation in java](#queue-implementation-in-java)
  - [Implement Queue using Linked List in java](#implement-queue-using-linked-list-in-java)
  - [Implement singly linked list in java](#implement-singly-linked-list-in-java)
  - [Reverse a linked list in java](#reverse-a-linked-list-in-java)
  - [Find the middle element of a linked list in java](#find-the-middle-element-of-a-linked-list-in-java)
  - [Find nth element from end of linked list](#find-nth-element-from-end-of-linked-list)
  - [How to check if linked list is palindrome in java](#how-to-check-if-linked-list-is-palindrome-in-java)
  - [Doubly Linked List in java](#doubly-linked-list-in-java)
  - [Array Problems](#array-problems)
    - [Java code to find Smallest and Largest Element in an Array :](#java-code-to-find-smallest-and-largest-element-in-an-array-)
    - [Java program to find missing number in an array:](#java-program-to-find-missing-number-in-an-array)
    - [Java program to find minimum element in a sorted and rotated array :](#java-program-to-find-minimum-element-in-a-sorted-and-rotated-array-)
    - [Find second largest number in an array](#find-second-largest-number-in-an-array)
    - [Find the number occurring odd number of times in an array](#find-the-number-occurring-odd-number-of-times-in-an-array)
    - [Find a Pair Whose Sum is Closest to zero in Array](#find-a-pair-whose-sum-is-closest-to-zero-in-array)
    - [find sum of two pairs equals to given number in given arrays values.](#find-sum-of-two-pairs-equals-to-given-number-in-given-arrays-values)
    - [Find Common elements in two array using java8](#find-common-elements-in-two-array-using-java8)
    - [Find Different values in Two Arrays](#find-different-values-in-two-arrays)
    - [Separate 0s and 1s in an array](#separate-0s-and-1s-in-an-array)
    - [Find First repeating element in array](#find-first-repeating-element-in-array)
    - [Check if Array Elements are Consecutive](#check-if-array-elements-are-consecutive)
    - [Rotate an Array left and right by k position](#rotate-an-array-left-and-right-by-k-position)
      
##  How do you reverse a string in Java?
- Output: hello world
StringBuilder : dlrow olleh
```java
package com.jd.interviewprep.dsa.prob;

public class ReverseString {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str = "hello world";
		System.out.println(str);
		// using string builder

		System.out.println("StringBuilder : " + stringBuilder(str));
		System.out.println("usingLoop : " + usingLoop(str));
		System.out.println("reverseString : " + reverseString(str));

	}

	public static String stringBuilder(String str) {
		StringBuilder sb = new StringBuilder(str);
		sb.reverse();
		String reversedStr = sb.toString();
		return reversedStr;
	}

	public static String usingLoop(String str) {
		StringBuilder reversed = new StringBuilder();
		for (int i = str.length() - 1; i >= 0; i--) {
			reversed.append(str.charAt(i));
		}
		String result = reversed.toString();
		return result;
	}

	public static String reverseString(String str) {
		if (str.isEmpty()) {
			return str;
		}
		return reverseString(str.substring(1)) + str.charAt(0);

	}
}
```
## Write a Java program to print a Fibonacci sequence using recursion.
- output : Fibonacci Sequence of 10 numbers:
0 1 1 2 3 5 8 13 21 34
```java
package com.jd.interviewprep.dsa.prob;

public class FabonacciNumber {

	public static void main(String[] args) {
		System.out.println("using Array : ");
		usingArray(10);
		System.out.println("using Loop : ");
		usingLoop(10);
		System.out.println("using Recursion : ");
		usingRecursion(10);
	}

	/**
	 * @param num
	 */
	/**
	 * @param num
	 */
	public static void usingArray(int num) {
		int count = num; // Number of Fibonacci numbers to generate

		System.out.println("Fibonacci Sequence of " + count + " numbers:");

		int[] fibonacciNumbers = new int[count];
		fibonacciNumbers[0] = 0; // First Fibonacci number
		fibonacciNumbers[1] = 1; // Second Fibonacci number

		// Generate Fibonacci sequence
		for (int i = 2; i < count; i++) {
			fibonacciNumbers[i] = fibonacciNumbers[i - 1] + fibonacciNumbers[i - 2];
		}

		// Print Fibonacci sequence
		for (int number : fibonacciNumbers) {
			System.out.print(number + " ");
		}
	}

	public static void usingLoop(int n) {
		int firstTerm = 0, secondTerm = 1;
		System.out.print("Fibonacci Series of " + n + " terms:\n");

		for (int i = 1; i <= n; i++) {
			System.out.print(firstTerm + " ");

			int nextTerm = firstTerm + secondTerm;
			firstTerm = secondTerm;
			secondTerm = nextTerm;
		}
	}

	public static void usingRecursion(int count) {

		System.out.println("Fibonacci Sequence of " + count + " numbers:");

		// Generate and print Fibonacci sequence
		for (int i = 0; i < count; i++) {
			System.out.print(fibonacci(i) + " ");
		}
	}

	public static int fibonacci(int n) {
		if (n <= 1) {
			return n;
		} else {
			return fibonacci(n - 1) + fibonacci(n - 2);
		}
	}

}

```

##  How do you check whether a string is a palindrome in Java?
- A palindrome string is the same string backwards or forwards
- Output: madam is a palindrome.

```java
package com.jd.interviewprep.dsa;

public class PalindromeString {

	public static void main(String[] args) {
		String str = "madam"; // Example string

		if (isPalindrome(str)) {
			System.out.println(str + " is a palindrome.");
		} else {
			System.out.println(str + " is not a palindrome.");
		}

	}

	public static Boolean isPalindrome(String input) {

		int length = input.length();
		for (int i = 0; i < length / 2; i++) {
			if (input.charAt(i) != input.charAt(length - 1 - i)) {
				return false;
			}
		}
		return true;

	}
}

```

## How can you find the factorial of an integer in Java?
- OutPut: Factorial of 5 is: 120

```java
package com.jd.interviewprep.dsa.prob;

public class Factorial {
	public static void main(String[] args) {
		int number = 5; // Example number

		long factorial = calculateFactorialIterative(number);

		System.out.println("Factorial of " + number + " is: " + factorial);
		 factorial = calculateFactorialRecursive(number);

		System.out.println("Factorial of " + number + " is: " + factorial);
	}

	public static long calculateFactorialIterative(int number) {
		long factorial = 1;
		for (int i = 1; i <= number; i++) {
			factorial *= i;
		}
		return factorial;
	}

	public static long calculateFactorialRecursive(int number) {
		if (number <= 1) {
			return 1;
		} else {
			return number * calculateFactorialRecursive(number - 1);
		}
	}
}

```
## How do you reverse a linked list in Java?
```java
package com.jd.interviewprep.dsa.prob;

import java.util.LinkedList;

public class LinkedListReverse {
public static void main(String[] args) {
	LinkedList<Integer> ll = new LinkedList<>();

	ll.add(1);
	ll.add(2);
	ll.add(3);

	System.out.println(ll);

	LinkedList<Integer> ll1 = new LinkedList<>();

	ll.descendingIterator().forEachRemaining(ll1::add);

	System.out.println(ll1);
}
}

```

## How do you implement a binary search in Java?
- If the key is less than the middle element, then you now need to search only in the first half of the array.
- If the key is greater than the middle element, then you need to search only in the second half of the array.
- If the key is equal to the middle element in the array, then the search ends.
- Finally, if the key is not found in the whole array, then it should return -1. This indicates that the element is not present.
```java
package com.jd.interviewprep.dsa.prob;

public class BinarySearch {
	public static void main(String[] args) {
		int[] arr = {2, 4, 6, 8, 10, 12, 14, 16, 18, 20};
        int target = 12;

        int result = binarySearch(arr, target);

        if (result == -1) {
            System.out.println("Element not found in the array.");
        } else {
            System.out.println("Element found at index " + result);
        }
	}
	
    public static int binarySearch(int[] arr, int target) {
		int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (arr[mid] == target) {
                return mid;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return -1; // Element not found
    
	}
}

```

## Write Java program that checks if two arrays contain the same elements.

```java
package com.jd.interviewprep.dsa.prob;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class ArraySameElements {

	public static void main(String[] args) {
		Integer[] a1 = { 1, 2, 3, 2, 1 };
		Integer[] a2 = { 1, 2, 3 };
		Integer[] a3 = { 1, 2, 3, 4 };

		System.out.println(sameElements(a1, a2));
		System.out.println(sameElements(a1, a3));
	}

	static boolean sameElements(Object[] array1, Object[] array2) {
		Set<Object> uniqueElements1 = new HashSet<>(Arrays.asList(array1));
		Set<Object> uniqueElements2 = new HashSet<>(Arrays.asList(array2));

		// if size is different, means there will be a mismatch
		if (uniqueElements1.size() != uniqueElements2.size())
			return false;

		for (Object obj : uniqueElements1) {
			// element not present in both?
			if (!uniqueElements2.contains(obj))
				return false;
		}

		return true;
	}
}
```

## Write a java program to check if two Strings are anagram in java?
- Two string are anagrams if they have same characters but in different order. For example: Angel and Angle are anagrams
- String word = "java2blog";       String anagram = "aj2vabgol";
```java
package com.jd.interviewprep.dsa.prob;

import java.util.Arrays;

public class StringAnagram {
  public static void main(String[] args) {

      String word = "java2blog";
      String anagram = "aj2vabgol";

      System.out.println("java2blog and aj2vabgol are anagrams :" + isAnagramUsingStringMethods(word, anagram));
      System.out.println("java2blog and aj2vabgol are anagrams using sort:" + isAnagramUsingArraySort(word, anagram));

}
  public static boolean isAnagramUsingStringMethods(String word, String anagram) {
      if (word.length() != anagram.length())
          return false;

      for (int i = 0; i < word.length(); i++) {
          char c = word.charAt(i);
          int index = anagram.indexOf(c);
          // If index of any character is -1, then two strings are not anagrams
          // If index of character is not equal to -1, then remove the chacter from the
          // String
          if (index != -1) {
              anagram = anagram.substring(0, index) + anagram.substring(index + 1, anagram.length());
          } else
              return false;
      }
      return anagram.isEmpty();
  }
  public static boolean isAnagramUsingArraySort(String word, String anagram) {
	  
      String sortedWord = sortChars(word);
      String sortedAnagram = sortChars(anagram);

      return sortedWord.equals(sortedAnagram);
  }

  public static String sortChars(String word) {
      char[] wordArr = word.toLowerCase().toCharArray();
      Arrays.sort(wordArr);
      return String.valueOf(wordArr);
  }
}

```

## How to check if one String is rotation of another String in java?
- OutPut: java2blog and blogjava2 are rotation of each other : true
java2blog and avablog2j are rotation of each other : false

```java
package com.jd.interviewprep.dsa.prob;

public class StringRotation {
	 public static void main(String[] args) {
		 
	        System.out.println(
	                "java2blog and blogjava2 are rotation of each other : " + isRotation("java2blog", "blogjava2"));
	        System.out.println(
	                "java2blog and avablog2j are rotation of each other : " + isRotation("java2blog", "avablog2j"));
	 
	    }
	 
	    public static boolean isRotation(String str, String rotation) {
	        String str2 = str + str;
	 
	        if (str2.contains(rotation)) {
	            return true;
	        }
	        return false;
	 
	    }
}

```

## Find first non repeated character in String in java?
- One of the interview question is “How will you find first non repeating character in String.”
For example:
If input string is “analogy”,  then program should return ‘n’
If input string is “easiest”, then program should return ‘a’
- Algorithm:
Get character while looping over String
Put this character in LinkedHashMap with count. If character is already there, increase count by 1.
Get count from LinkedHashMap while iterating. If count is 1,return that character as LinkedHashMap maintains insertion order.

```java
package com.jd.interviewprep.dsa.prob;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class GetFirstNonRepeatingCharacter {
	public static void main(String[] args) {
		System.out
				.println("First non repeated character for String analogy is : " + getNonRepeatedCharacter("analogy"));
		System.out
				.println("First non repeated character for String easiest is : " + getNonRepeatedCharacter("easiest"));
	}

	public static Character getNonRepeatedCharacter(String str) {
		Map<Character, Integer> countCharacters = new LinkedHashMap<Character, Integer>();
		for (int i = 0; i < str.length() - 1; i++) {
			Character c = str.charAt(i);
			if (!countCharacters.containsKey(c)) {
				countCharacters.put(c, 1);
			} else {
				countCharacters.put(c, countCharacters.get(c) + 1);
			}
		}
		// As LinkedHashMap maintains insertion order, first character with
		// count 1 should return first non repeated character
		for (Entry<Character, Integer> e : countCharacters.entrySet()) {
			if (e.getValue() == 1)
				return e.getKey();

		}
		return null;

	}
}

```

## Java program to find missing number in an array

- int[] arr1={7,5,6,1,4,2};
Missing numner : 3

```java
package com.jd.interviewprep.dsa.prob;

public class MissingNumber {
	public static void main(String[] args) {
		 
        int[] arr1={7,5,6,1,4,2};
        System.out.println("Missing number from array arr1: "+missingNumber(arr1));
        int[] arr2={5,3,1,2};
        System.out.println("Missing number from array arr2: "+missingNumber(arr2));
 
    }
 
    public static int missingNumber(int[] arr)
    {
        int n=arr.length+1;
        int sum=n*(n+1)/2;
        int restSum=0;
        for (int i = 0; i < arr.length; i++) {
            restSum+=arr[i];
        }
        int missingNumber=sum-restSum;
        return missingNumber;
    }
}

```

## Rotate an array by K positions.
```
N=6 and k=2
If Arr[] = {1, 2, 3, 4, 5, 6} and k=2
then rotated array will be  {5, 6, 1, 2,  3,  4}
 ```
- Array rotation after 1 step
6 1 2 3 4 5 
- Array rotation after 2 step
5 6 1 2 3 4 

```java
package com.jd.interviewprep.dsa.prob;

public class RotateArrayByKPoition {
	public static void main(String[] args) {

		int arr[] = { 1, 2, 3, 4, 5, 6 };

		rotateBruteForce(arr, 2);

	}

	public static int[] rotateBruteForce(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j > 0; j--) {
				// move each number by 1 place
				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
			}
			System.out.println("Array rotation after " + (i + 1) + " step");
			printArray(nums);
			System.out.println();
		}
		return nums;
	}
	public static void printArray(int []arr)
    {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]+" ");
        }
    }
}

```

##  Implement a stack using array.
- https://java2blog.com/implement-stack-using-array-in-java/


## implement a stack using Linked List.
- https://java2blog.com/implement-stack-using-linked-list-in-java/


## Implement Stack using two Queues in java

- https://java2blog.com/implement-stack-using-two-queues-in-java/


## Sort a Stack using another stack

- https://java2blog.com/sort-stack-using-another-stack/

## Queue implementation in java
- https://java2blog.com/implement-queue-using-array-in-java/

## Implement Queue using Linked List in java

- https://java2blog.com/implement-queue-using-linked-list-in-java/

## Implement singly linked list in java
- https://java2blog.com/implement-singly-linked-list-in-java/

## Reverse a linked list in java
- https://java2blog.com/how-to-reverse-linked-list-in-java/

## Find the middle element of a linked list in java
- https://java2blog.com/find-middle-element-of-linkedlist-in/

## Find nth element from end of linked list
- https://java2blog.com/find-nth-element-from-end-of-linked-list/

## How to check if linked list is palindrome in java
- https://www.java2blog.com/how-to-check-if-linked-list-is/
## Doubly Linked List in java
- https://java2blog.com/doubly-linked-list-java/

--- 
## Array Problems
### Java code to find Smallest and Largest Element in an Array :
```java
package com.jd.interviewprep.dsa.prob;

import java.util.Arrays;
import java.util.OptionalInt;

public class LargestSmallestNumberInArray {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int arr[] = new int[] { 12, 56, 76, 89, 100, 343, 21, 234 };

		// Using Stream
		int max = Arrays.stream(arr).max().getAsInt();
		int min = Arrays.stream(arr).min().getAsInt();
		System.out.println(max + " " + min);
		System.out.println("-----------------------------");

		// array of 10 numbers
		int arr1[] = new int[] { 12, 56, 76, 89, 100, 343, 21, 234 };

		// assign first element of an array to largest and smallest
		int smallest = arr1[0];
		int largest = arr1[0];

		for (int i = 1; i < arr1.length; i++) {
			if (arr1[i] > largest)
				largest = arr1[i];
			else if (arr1[i] < smallest)
				smallest = arr1[i];

		}
		System.out.println("Smallest Number is : " + smallest);
		System.out.println("Largest Number is : " + largest);

	}

}

```
### Java program to find missing number in an array:

```java
package com.jd.interviewprep.dsa.prob;

import java.util.Arrays;

public class FindMissingNumberInArray {
	public static void main(String[] args) {

		int[] arr1 = { 7, 5, 6, 1, 4, 2 };
		System.out.println("Missing number from array arr1: " + missingNumber(arr1));
		System.out
				.println("Missing number from array arr1 missingNumberUsingStream: " + missingNumberUsingStream(arr1));
	}

	public static int missingNumber(int[] arr) {
		int n = arr.length + 1;
		int sum = n * (n + 1) / 2;
		int restSum = 0;
		for (int i = 0; i < arr.length; i++) {
			restSum += arr[i];
		}
		int missingNumber = sum - restSum;
		return missingNumber;
	}

	public static int missingNumberUsingStream(int[] arr) {
		int n = arr.length + 1;
		int sum = n * (n + 1) / 2;
		int restSum = Arrays.stream(arr).sum();

		int missingNumber = sum - restSum;
		return missingNumber;
	}
}

```

### Java program to find minimum element in a sorted and rotated array :
- Use Binary Seach Algo
```java
package com.jd.interviewprep.dsa.prob;

public class MinimumElementSortedAndRotatedArray {
	public static void main(String[] args) {
		int arr[] = { 16, 19, 21, 25, 3, 5, 8, 10 };
		System.out.println(
				"Minimum element in the array : " + findMinimumElementRotatedSortedArray(arr, 0, arr.length - 1));
	}

	public static int findMinimumElementRotatedSortedArray(int[] arr, int low, int high) {
		int mid;
		while (low < high) {
			mid = low + ((high - low) / 2);

			if (arr[mid] > arr[high]) {
				low = mid + 1;
			} else {
				high = mid;
			}
		}
		return arr[low];
	}

}

```

### Find second largest number in an array

```java
package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Stream;

public class SecondLargestArray {
	
	public static void main(String[] args) {
        int[] arr1={7,5,6,1,4,2};
        
       System.out.println("Using Stream on Arrays : "+usingStream(arr1));
       System.out.println("Using Iterator on Arrays : "+findSecondLargestNumberInTheArray(arr1));

	}
	
	public static int usingStream(int arr[])
	{
		
		Integer integer = Arrays.stream(arr)
		.boxed()
		.sorted(Comparator.comparing(Integer::intValue).reversed())
		.limit(2)
		.skip(1)
		.findFirst()
		.get();
		
		return integer;
		
	}
	
	public static int findSecondLargestNumberInTheArray(int array[])
    {
        // Initialize these to the smallest value possible
        int highest = Integer.MIN_VALUE;
        int secondHighest = Integer.MIN_VALUE;
 
        // Loop over the array
        for (int i = 0; i < array.length; i++) { 
            // If current element is greater than highest 
            if (array[i] > highest) {
 
                // assign second highest element to highest element 
                secondHighest = highest;
 
                // highest element to current element
                highest = array[i];
            } else if (array[i] > secondHighest && array[i]!=highest)
                // Just replace the second highest
                secondHighest = array[i];
        }
 
        // After exiting the loop, secondHighest now represents the second
        // largest value in the array
        return secondHighest;
    }

}

```

### Find the number occurring odd number of times in an array

```java
package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map.Entry;
import java.util.function.Function;
import java.util.stream.Collectors;

public class OddTimesElementInArray {
	public static void main(String[] args) {
		int array[] = new int[] { 20, 40, 50, 40, 50, 20, 30, 30, 50, 20, 40, 40, 20 };

		System.out.println("getOddTimesElementHashing :" + getOddTimesElementHashing(array));
		System.out.println("Get odd time lelemt in array uding stream :" + getOddTimesElementUsingStream(array));

	}

	public static int getOddTimesElementHashing(int ar[]) {
		int i;

		HashMap<Integer, Integer> elements = new HashMap<Integer, Integer>();
		for (i = 0; i < ar.length; i++) {
			int element = ar[i];
			if (elements.get(element) == null) {
				elements.put(element, 1);

			} else
				elements.put(element, elements.get(element) + 1);
		}
		for (Entry<Integer, Integer> entry : elements.entrySet()) {
			if (entry.getValue() % 2 == 1) {
				return entry.getKey();
			}

		}
		return -1;
	}
	public static int getOddTimesElementUsingStream(int arr[]) {
		
         Integer key = Arrays.stream(arr)
         .boxed()
         .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()))
         .entrySet()
         .stream()
         .filter(e->e.getValue()%2!=0)
         .findFirst()
         .get()
         .getKey();
	
		return key;
	}
	
	
}

```

### Find a Pair Whose Sum is Closest to zero in Array

```java
package com.jd.interviewprep.dsa.prob.array;

public class FindPairWithMinSum {

	public static void main(String[] args) {
		int array[] = { 1, 30, -5, 70, -8, 20, -40, 60 };
		findPairWithMinSumBruteForce(array);
		findPairWithClosestToXBruteForce(array, 31);
	}

	public static void findPairWithMinSumBruteForce(int arr[]) {
		if (arr.length < 2)
			return;
		// Suppose 1st two element has minimum sum
		int minimumSum = arr[0] + arr[1];
		int pair1stIndex = 0;
		int pair2ndIndex = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tempSum = arr[i] + arr[j];
				if (Math.abs(tempSum) < Math.abs(minimumSum)) {
					pair1stIndex = i;
					pair2ndIndex = j;
					minimumSum = tempSum;
				}
			}
		}
		System.out.println(" The pair whose sum is closest to zero : " + arr[pair1stIndex] + " " + arr[pair2ndIndex]);
	}

	public static void findPairWithClosestToXBruteForce(int arr[], int X) {
		if (arr.length < 2)
			return;
		// Suppose 1st two element has minimum diff with X
		int minimumDiff = Math.abs(arr[0] + arr[1] - X);
		int pair1stIndex = 0;
		int pair2ndIndex = 1;
		for (int i = 0; i < arr.length; i++) {
			for (int j = i + 1; j < arr.length; j++) {
				int tempDiff = Math.abs(arr[i] + arr[j] - X);

				if (tempDiff < minimumDiff) {
					pair1stIndex = i;
					pair2ndIndex = j;
					minimumDiff = tempDiff;
				}
			}
		}
		System.out.println(" The pair whose sum is closest to X using brute force method: " + arr[pair1stIndex] + " "
				+ arr[pair2ndIndex]);
	}

}


```

### find sum of two pairs equals to given number in given arrays values.
```java
package com.jd.interviewprep.dsa.prob.array;

public class FindPairWithTargetSum {
	public static void main(String[] args) {
		int arr[] = { 1, 5, 7, -1, 5 };
		int n = arr.length;
		int sum = 6;
		printPairs(arr, n, sum);
	}

	static void printPairs(int arr[], int n, int sum) {
		// int count = 0;

		// Consider all possible pairs
		// and check their sums
		for (int i = 0; i < n; i++)
			for (int j = i + 1; j < n; j++)
				if (arr[i] + arr[j] == sum)
					System.out.println("(" + arr[i] + ", " + arr[j] + ")");
	}
}
```
### Find Common elements in two array using java8

```java
package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class FindCommonValuesInJava8 {

	public static void main(String[] args) {
		int arr1[] = { 5, 7, 2, 8, 9 };
		int arr2[] = { 6, 10, 2, 8, 4 };

		System.out.println(" find comman value in two arrays :" + findCommonValues(arr1, arr2));
	}

	public static Set<Integer> findCommonValues(int arr1[], int arr2[]) {
		Set<Integer> set1 = Arrays.stream(arr1).boxed().collect(Collectors.toSet());
		Set<Integer> set2 = Arrays.stream(arr2).boxed().collect(Collectors.toSet());
		set1.retainAll(set2);

		return set1;

	}
}

```
### Find Different values in Two Arrays
```java
package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FindDifferentValuesInTwoArrays {
	public static void main(String[] args) {
		Integer[] array1 = { 1, 2, 3, 4, 5 };
		Integer[] array2 = { 4, 5, 6, 7, 8,10,12 };

		Set<Integer> differentValues = 
				Stream.concat(Arrays.stream(array1), Arrays.stream(array2))
				.filter(x -> !Arrays.asList(array1).contains(x) || !Arrays.asList(array2).contains(x))
				.collect(Collectors.toSet());

		System.out.println(differentValues);
	}
}

```

### Separate 0s and 1s in an array


```java
package com.jd.interviewprep.dsa.prob.array;

public class Separate0s1sSolution1 {

	public static void main(String[] args) {
		int arr[]={0,1,0,0,1,1,1,0,1};
		  System.out.println("Original Array: ");
		  for (int i = 0; i < arr.length; i++) {
		   System.out.print(arr[i]+" ");
		  }
		  arr=separate0s1sSolution1(arr);
		  System.out.println("n===========================");
		  System.out.println("Solution 1");
		  System.out.println("nArray after separating 0's and 1's : ");
		  for (int i = 0; i < arr.length; i++) {
		   System.out.print(arr[i]+" ");
		  }
	}
	public static int[] separate0s1sSolution1(int arr[])
	 {
	  int count=0;
	  for (int i = 0; i < arr.length; i++) {
	   if(arr[i]==0)
	   {
	    count++;
	   }
	  }
	  for (int i = 0; i < count; i++) {
	   arr[i]=0;
	  }
	  for (int i = count; i < arr.length; i++) {
	   arr[i]=1;
	  }
	  return arr;
	 }
	 
}
```
### Find First repeating element in array
```java
package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

public class FindFirstRepeatingElementInArray {
public static void main(String[] args) {
	Integer[] array = {1, 2, 3, 4, 2, 5};

    Set<Integer> set = new HashSet<>();
    Optional<Integer> firstRepeatingElement = Arrays.stream(array)
            .filter(x -> !set.add(x))
            .findFirst();

    if (firstRepeatingElement.isPresent()) {
        System.out.println(firstRepeatingElement.get());
    } else {
        System.out.println("No repeating element found");
    }
}
}

```
### Check if Array Elements are Consecutive

```java
package com.jd.interviewprep.dsa.prob.array;

import java.util.Arrays;

public class ConsecutiveElementsInArray {
public static void main(String[] args) {
	int[] array = {5, 3, 4, 1, 2};

    int min = Arrays.stream(array).min().getAsInt();
    int max = Arrays.stream(array).max().getAsInt();

    if (max - min == array.length - 1) {
        System.out.println("The elements are consecutive");
    } else {
        System.out.println("The elements are not consecutive");
    }
}
}

```
### Rotate an Array left and right by k position
```java
package com.jd.interviewprep.dsa.prob.array;

public class RotateAnArrayByKPosition {
	public static void main(String[] args) {
		int Array[] = { 1, 2, 3, 4, 5 };

		int K = 2;
		rightRotateBruteForce(Array, K);
		leftRotateBruteForce(Array, K);

	}

	public static int[] rightRotateBruteForce(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = nums.length - 1; j > 0; j--) {
				// move each number by 1 place
				int temp = nums[j];
				nums[j] = nums[j - 1];
				nums[j - 1] = temp;
			}
			System.out.println("Array rotation after " + (i + 1) + " step");
			printArray(nums);
			System.out.println();
		}
		return nums;
	}
	public static int[] leftRotateBruteForce(int[] nums, int k) {
		for (int i = 0; i < k; i++) {
			for (int j = 0 ; j <nums.length -1; j++) {
				// move each number by 1 place
				int temp = nums[j];
				nums[j] = nums[j + 1];
				nums[j + 1] = temp;
			}
			System.out.println("Array rotation after " + (i + 1) + " step");
			printArray(nums);
			System.out.println();
		}
		return nums;
	}
	public static void printArray(int[] arr) {
		for (int i = 0; i < arr.length; i++) {
			System.out.print(arr[i] + " ");
		}
	}
}
```
