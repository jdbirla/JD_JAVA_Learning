# JD_DSA_Problems_Solutions


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

