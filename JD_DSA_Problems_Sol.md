# JD_DSA_Problems_Solutions

- JavaTPoint:
    - All Programs: https://www.javatpoint.com/java-programs
- Java2Blog
    - https://java2blog.com/java-coding-interview-questions/
      
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
