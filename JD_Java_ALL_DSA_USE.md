# JD_Java_ALL_DSA_USE

# Table of contents

- [JD_Java_ALL_DSA_USE](#jd_java_all_dsa_use)
  - [DSA Table](#dsa-table)
  - [Array](#array)
  - [ArrayList:](#arraylist)
  - [LinkedList](#linkedlist)
  - [Stack:](#stack)
  - [Queue:](#queue)
  - [Hashtable:](#hashtable)
  - [HashSet:](#hashset)
  - [TreeSet](#treeset)
  - [LinkedHashSet:](#linkedhashset)
  - [HashMap:](#hashmap)
  - [TreeMap:](#treemap)
  - [LinkedHashMap:](#linkedhashmap)
 
## DSA Table
| Data Structure | Complexity (Average Case) | Complexity (Worst Case) | Explanation and Use Cases |
|----------------|--------------------------|-------------------------|---------------------------|
| Array          | Access: O(1) <br> Search: O(n) <br> Insertion: O(n) <br> Deletion: O(n) | Access: O(1) <br> Search: O(n) <br> Insertion: O(n) <br> Deletion: O(n) | Arrays are used to store a fixed-size sequence of elements. They offer constant-time access by index but have linear-time complexity for search, insertion, and deletion. Suitable when the size is known in advance and frequent random access is required. |
| ArrayList      | Access: O(1) <br> Search: O(n) <br> Insertion: O(n) <br> Deletion: O(n) | Access: O(1) <br> Search: O(n) <br> Insertion: O(n) <br> Deletion: O(n) | ArrayList is an ordered dynamic array implementation. It offers constant-time access by index but has linear-time complexity for search, insertion, and deletion. Suitable when frequent random access and dynamic resizing are required. |
| LinkedList     | Access: O(n) <br> Search: O(n) <br> Insertion: O(1) <br> Deletion: O(1) | Access: O(n) <br> Search: O(n) <br> Insertion: O(1) <br> Deletion: O(1) | LinkedList is a linear data structure where elements are linked using pointers. It offers constant-time insertion and deletion at both ends but has linear-time complexity for access and search. Suitable when frequent insertions and deletions are required, but random access is less important. |
| Stack          | Access: O(n) <br> Search: O(n) <br> Insertion: O(1) <br> Deletion: O(1) | Access: O(n) <br> Search: O(n) <br> Insertion: O(1) <br> Deletion: O(1) | Stack is a last-in, first-out (LIFO) data structure. It offers constant-time insertion and deletion at one end but has linear-time complexity for access and search. Suitable for managing function calls, expression evaluation, and undo operations. |
| Queue          | Access: O(n) <br> Search: O(n) <br> Insertion: O(1) <br> Deletion: O(1) | Access: O(n) <br> Search: O(n) <br> Insertion: O(1) <br> Deletion: O(1) | Queue is a first-in, first-out (FIFO) data structure. It offers constant-time insertion and deletion at opposite ends but has linear-time complexity for access and search. Suitable for managing tasks in a sequential manner, such as message queues and process scheduling. |
| HashSet        | Access: N/A <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | Access: N/A <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | HashSet is an unordered collection of unique elements. It offers constant-time complexity for search, insertion, and deletion but does not provide direct access by index. Suitable for checking membership and eliminating duplicates. |
| PriorityQueue | Access: O(1) <br> Search: O(n) <br> Insertion: O(log n) <br> Deletion: O(log n) | Access: O(1) <br> Search: O(n) <br> Insertion: O(log n) <br> Deletion: O(log n) | PriorityQueue is an ordered collection of elements where the element with the highest priority is always at the front. It offers constant-time access to the highest-priority element but logarithmic time complexity for search, insertion, and deletion. Suitable for implementing priority-based algorithms like Dijkstra's algorithm and event scheduling. |
| TreeSet        | Access: O(log n) <br> Search: O(log n) <br> Insertion: O(log n) <br> Deletion: O(log n) | Access: O(log n) <br> Search: O(log n) <br> Insertion: O(log n) <br> Deletion: O(log n) | TreeSet is an ordered set implemented using a self-balancing binary search tree. It offers logarithmic time complexity for search, insertion, and deletion. Suitable when maintaining a sorted collection of unique elements is required. |
| LinkedHashSet  | Access: O(1) <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | Access: O(1) <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | LinkedHashSet is an ordered set that maintains the insertion order of elements. It offers constant-time complexity for search, insertion, and deletion. Suitable when the order of insertion is important, and uniqueness of elements is required. |
| HashMap        | Access: O(1) <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | Access: O(n) <br> Search: O(n) <br> Insertion: O(n) <br> Deletion: O(n) | HashMap is an unordered collection of key-value pairs. It offers constant-time complexity for search, insertion, and deletion, assuming a good hash function and uniform distribution of keys. Suitable for fast retrieval and storage of key-value pairs. |
| TreeMap        | Access: O(log n) <br> Search: O(log n) <br> Insertion: O(log n) <br> Deletion: O(log n) | Access: O(log n) <br> Search: O(log n) <br> Insertion: O(log n) <br> Deletion: O(log n) | TreeMap is an ordered map implemented using a self-balancing binary search tree. It offers logarithmic time complexity for search, insertion, and deletion. Suitable when maintaining a sorted collection of key-value pairs is required. |
| LinkedHashMap  | Access: O(1) <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | Access: O(1) <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | LinkedHashMap is an ordered map that maintains the insertion order of key-value pairs. It offers constant-time complexity for search, insertion, and deletion. Suitable when the order of insertion is important and fast access to key-value pairs is required. |
| Hashtable      | Access: N/A <br> Search: O(1) <br> Insertion: O(1) <br> Deletion: O(1) | Access: N/A <br> Search: O(n) <br> Insertion: O(n) <br> Deletion: O(n) | Hashtable is an implementation of a hash table that stores key-value pairs. It offers constant-time complexity for search, insertion, and deletion assuming a good hash function and uniform distribution of keys. Suitable for fast retrieval and storage of key-value pairs but has been largely replaced by HashMap in modern Java programming. |


## Array
- A fixed-size collection of elements of the same type, accessed by an index.
```java
import java.util.Arrays;

public class ArrayOperationsExample {
    public static void main(String[] args) {
        // Create an array
        int[] numbers = {10, 20, 30, 40, 50};

        // Insert an element
        int insertIndex = 2;
        int newValue = 60;
        numbers = insertElement(numbers, insertIndex, newValue);

        // Remove an element
        int removeIndex = 4;
        numbers = removeElement(numbers, removeIndex);

        // Sort the array
        Arrays.sort(numbers);

        // Search for an element
        int searchValue = 30;
        int foundIndex = searchElement(numbers, searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the array.");
        }

        // Update an element
        int updateIndex = 1;
        int updatedValue = 25;
        numbers = updateElement(numbers, updateIndex, updatedValue);

        // Print the array
        System.out.println("Array after all operations: " + Arrays.toString(numbers));
    }

    // Insert an element at a specific index in the array
    public static int[] insertElement(int[] array, int index, int value) {
        int[] newArray = new int[array.length + 1];
        System.arraycopy(array, 0, newArray, 0, index);
        newArray[index] = value;
        System.arraycopy(array, index, newArray, index + 1, array.length - index);
        return newArray;
    }

    // Remove an element at a specific index from the array
    public static int[] removeElement(int[] array, int index) {
        int[] newArray = new int[array.length - 1];
        System.arraycopy(array, 0, newArray, 0, index);
        System.arraycopy(array, index + 1, newArray, index, array.length - index - 1);
        return newArray;
    }

    // Search for an element in the array
    public static int searchElement(int[] array, int value) {
        for (int i = 0; i < array.length; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    // Update an element at a specific index in the array
    public static int[] updateElement(int[] array, int index, int value) {
        array[index] = value;
        return array;
    }
}

```
## ArrayList:
- A dynamically resizable array that can grow or shrink as needed.
- Internal Working of ArrayList:
   - In Java, an ArrayList is a dynamic array-like data structure that can grow or shrink dynamically. It internally uses an array to store elements. When the elements exceed the capacity of the internal array, a new larger array is created, and the elements from the old array are copied to the new array. This process is called resizing.
```java
package com.jd.interviewprep.dsa;

import java.util.ArrayList;
import java.util.Collections;

public class ArrayListDemo {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Insert an element
        int insertIndex = 2;
        int newValue = 60;
        numbers.add(insertIndex, newValue);

        // Remove an element
        int removeIndex = 4;
        numbers.remove(removeIndex);

        // Sort the ArrayList
        Collections.sort(numbers);

        // Search for an element
        int searchValue = 30;
        int foundIndex = numbers.indexOf(searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the ArrayList.");
        }

        // Update an element
        int updateIndex = 1;
        int updatedValue = 25;
        numbers.set(updateIndex, updatedValue);

        // Print the ArrayList
        System.out.println("ArrayList after all operations: " + numbers);
    }
}

```

## LinkedList
- A sequence of elements where each element has a reference to the next element.
- Internal Working of LinkedList:
  - In Java, a LinkedList is a linear data structure where elements are stored as nodes. Each node contains the element and a reference to the next node in the list. The LinkedList maintains a reference to the head (first node) and tail (last node) of the list.
```java
package com.jd.interviewprep.dsa;

import java.util.LinkedList;
import java.util.Collections;

public class LinkedListDemo {
    public static void main(String[] args) {
        // Create a LinkedList
        LinkedList<Integer> numbers = new LinkedList<>();
        numbers.add(10);
        numbers.add(20);
        numbers.add(30);
        numbers.add(40);
        numbers.add(50);

        // Insert an element
        int insertIndex = 2;
        int newValue = 60;
        numbers.add(insertIndex, newValue);

        // Remove an element
        int removeIndex = 4;
        numbers.remove(removeIndex);

        // Sort the LinkedList
        Collections.sort(numbers);

        // Search for an element
        int searchValue = 30;
        int foundIndex = numbers.indexOf(searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the LinkedList.");
        }

        // Update an element
        int updateIndex = 1;
        int updatedValue = 25;
        numbers.set(updateIndex, updatedValue);

        // Print the LinkedList
        System.out.println("LinkedList after all operations: " + numbers);
    }
}


```

## Stack:
- A Last-In-First-Out (LIFO) data structure that allows adding and removing elements from one end.
- Internal Working of Stack:
  - In Java, a Stack is an abstract data type that follows the Last-In-First-Out (LIFO) principle. It is implemented using a linear data structure where elements are added and removed from the top. The top represents the most recently added element, and new elements are always added on top.
```java
package com.jd.interviewprep.dsa;

import java.util.Stack;
import java.util.Collections;

public class StackDemo {
    public static void main(String[] args) {
        // Create a Stack
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);

        // Insert an element (Push)
        int newValue = 60;
        stack.push(newValue);

        // Remove an element (Pop)
        int removedValue = stack.pop();

        // Sort the Stack
        Collections.sort(stack);

        // Search for an element
        int searchValue = 30;
        int foundIndex = stack.search(searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + (stack.size() - foundIndex));
        } else {
            System.out.println("Element not found in the Stack.");
        }

        // Update an element (Replace)
        int updateIndex = 1;
        int updatedValue = 25;
        stack.set(updateIndex, updatedValue);

        // Print the Stack
        System.out.println("Stack after all operations: " + stack);
    }
}

```

## Queue: 
- A First-In-First-Out (FIFO) data structure that allows adding elements at one end and removing elements from the other end.
- Internal Working of Queue:
   - In Java, a Queue is an abstract data type that follows the First-In-First-Out (FIFO) principle. It is implemented using a linear data structure where elements are added to the back (enqueue) and removed from the front (dequeue). New elements are always added at the end of the queue, and removal occurs from the front.
```java
package com.jd.interviewprep.dsa;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Collections;

public class QueueDemo {
    public static void main(String[] args) {
        // Create a Queue
        Queue<Integer> queue = new LinkedList<>();
        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);

        // Insert an element (Enqueue)
        int newValue = 60;
        queue.add(newValue);

        // Remove an element (Dequeue)
        int removedValue = queue.poll();

        // Sort the Queue
        Queue<Integer> sortedQueue = sortQueue(queue);

        // Search for an element
        int searchValue = 30;
        int foundIndex = searchQueue(sortedQueue, searchValue);
        if (foundIndex != -1) {
            System.out.println("Element found at index: " + foundIndex);
        } else {
            System.out.println("Element not found in the Queue.");
        }

        // Update an element (Replace)
        int updateIndex = 1;
        int updatedValue = 25;
        queue.remove();
        queue.add(updatedValue);

        // Print the Queue
        System.out.println("Queue after all operations: " + queue);
    }

    // Sort the Queue using a temporary LinkedList
    public static Queue<Integer> sortQueue(Queue<Integer> queue) {
        LinkedList<Integer> tempList = new LinkedList<>(queue);
        Collections.sort(tempList);
        return tempList;
    }

    // Search for an element in the Queue
    public static int searchQueue(Queue<Integer> queue, int value) {
        int index = 0;
        for (int element : queue) {
            if (element == value) {
                return index;
            }
            index++;
        }
        return -1;
    }
}

```

## Hashtable: 
- A legacy synchronized implementation of the Map interface, similar to HashMap but thread-safe.
- Internal Working of Hashtable:
   - In Java, a Hashtable is a synchronized implementation of the Map interface that uses hashing to store key-value pairs. It internally uses an array of buckets, where each bucket represents a linked list of key-value pairs. When a key-value pair is inserted into the Hashtable, the hash code of the key is calculated, and the pair is stored in the corresponding bucket based on the hash code. Hashtable provides efficient insertion, deletion, and retrieval of key-value pairs, but it is slower than HashMap due to the added synchronization.
```java
package com.jd.interviewprep.dsa;

import java.util.Hashtable;

public class HashTableDemo {
    public static void main(String[] args) {
        // Create a Hashtable
        Hashtable<String, Integer> table = new Hashtable<>();

        // Insert key-value pairs
        table.put("Apple", 10);
        table.put("Banana", 5);
        table.put("Orange", 15);
        table.put("Grapes", 8);

        // Remove a key-value pair
        String removedKey = "Banana";
        table.remove(removedKey);

        // Sort the Hashtable (no direct sorting)

        // Search for a key
        String searchKey = "Orange";
        boolean isPresent = table.containsKey(searchKey);
        if (isPresent) {
            System.out.println("Key found in the Hashtable.");
        } else {
            System.out.println("Key not found in the Hashtable.");
        }

        // Update a value
        String updatedKey = "Apple";
        int oldValue = table.get(updatedKey);
        int updatedValue = 12;
        table.put(updatedKey, updatedValue);

        // Print the Hashtable
        System.out.println("Hashtable after all operations: " + table);
    }
}

```

## HashSet: 
- An unordered collection that does not allow duplicate elements.
- Internal Working of HashSet:
  - In Java, a HashSet is an implementation of the Set interface that uses hashing to store elements. It does not maintain the insertion order of elements. Internally, it uses a hash table to store elements, where each element is stored based on its hash code. This allows for efficient insertion, deletion, and search operations.
```java
package com.jd.interviewprep.dsa;

import java.util.HashSet;
import java.util.ArrayList;
import java.util.Collections;

public class HashSetDemo {
    public static void main(String[] args) {
        // Create a HashSet
        HashSet<Integer> set = new HashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        // Insert an element
        int newValue = 60;
        set.add(newValue);

        // Remove an element
        int removedValue = 30;
        set.remove(removedValue);

        // Sort the HashSet
        ArrayList<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        // Search for an element
        int searchValue = 20;
        boolean isPresent = set.contains(searchValue);
        if (isPresent) {
            System.out.println("Element found in the HashSet.");
        } else {
            System.out.println("Element not found in the HashSet.");
        }

        // Update an element
        int oldValue = 20;
        int updatedValue = 25;
        set.remove(oldValue);
        set.add(updatedValue);

        // Print the HashSet
        System.out.println("HashSet after all operations: " + set);
    }
}

```
## TreeSet
- A sorted set implementation based on a self-balancing binary search tree (Red-Black tree).
- Internal Working of TreeSet:
  - In Java, a TreeSet is an implementation of the SortedSet interface that uses a self-balancing binary search tree called a Red-Black Tree to store elements. The Red-Black Tree ensures that elements are stored in sorted order, allowing for efficient insertion, deletion, and search operations. The elements in a TreeSet are sorted based on their natural ordering or a custom comparator.
```java
package com.jd.interviewprep.dsa;

import java.util.TreeSet;

public class TreeSetDemo {
    public static void main(String[] args) {
        // Create a TreeSet
        TreeSet<Integer> set = new TreeSet<>();
        set.add(30);
        set.add(10);
        set.add(50);
        set.add(20);
        set.add(40);

        // Insert an element
        int newValue = 60;
        set.add(newValue);

        // Remove an element
        int removedValue = 30;
        set.remove(removedValue);

        // Sort the TreeSet (no need, already sorted)

        // Search for an element
        int searchValue = 20;
        boolean isPresent = set.contains(searchValue);
        if (isPresent) {
            System.out.println("Element found in the TreeSet.");
        } else {
            System.out.println("Element not found in the TreeSet.");
        }

        // Update an element
        int oldValue = 20;
        int updatedValue = 25;
        set.remove(oldValue);
        set.add(updatedValue);

        // Print the TreeSet
        System.out.println("TreeSet after all operations: " + set);
    }
}

```

## LinkedHashSet: 
- A hash table and linked list implementation of the Set interface, maintaining the insertion order.
- Internal Working of LinkedHashSet:
  - In Java, a LinkedHashSet is an implementation of the Set interface that combines the features of a HashSet and a LinkedList. It maintains a doubly-linked list of elements in addition to using a hash table to store elements. The doubly-linked list preserves the insertion order of elements, while the hash table ensures efficient insertion, deletion, and search operations.
```java
package com.jd.interviewprep.dsa;

import java.util.LinkedHashSet;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedHashSetDemo {
    public static void main(String[] args) {
        // Create a LinkedHashSet
        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        set.add(10);
        set.add(20);
        set.add(30);
        set.add(40);
        set.add(50);

        // Insert an element
        int newValue = 60;
        set.add(newValue);

        // Remove an element
        int removedValue = 30;
        set.remove(removedValue);

        // Sort the LinkedHashSet
        ArrayList<Integer> sortedList = new ArrayList<>(set);
        Collections.sort(sortedList);

        // Search for an element
        int searchValue = 20;
        boolean isPresent = set.contains(searchValue);
        if (isPresent) {
            System.out.println("Element found in the LinkedHashSet.");
        } else {
            System.out.println("Element not found in the LinkedHashSet.");
        }

        // Update an element
        int oldValue = 20;
        int updatedValue = 25;
        set.remove(oldValue);
        set.add(updatedValue);

        // Print the LinkedHashSet
        System.out.println("LinkedHashSet after all operations: " + set);
    }
}

```

## HashMap: 
- An unordered collection that stores key-value pairs, where each key is unique.
- Internal Working of HashMap:
   - In Java, a HashMap is an implementation of the Map interface that uses hashing to store key-value pairs. It internally uses an array of buckets to store these key-value pairs. When a key-value pair is inserted into the HashMap, the hash code of the key is calculated, and the pair is stored in the corresponding bucket based on the hash code. HashMap provides efficient insertion, deletion, and retrieval of key-value pairs.
```java
import java.util.HashMap;

public class HashMapOperationsExample {
    public static void main(String[] args) {
        // Create a HashMap
        HashMap<String, Integer> map = new HashMap<>();

        // Insert key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("Orange", 15);
        map.put("Grapes", 8);

        // Remove a key-value pair
        String removedKey = "Banana";
        map.remove(removedKey);

        // Sort the HashMap (no direct sorting)

        // Search for a key
        String searchKey = "Orange";
        boolean isPresent = map.containsKey(searchKey);
        if (isPresent) {
            System.out.println("Key found in the HashMap.");
        } else {
            System.out.println("Key not found in the HashMap.");
        }

        // Update a value
        String updatedKey = "Apple";
        int oldValue = map.get(updatedKey);
        int updatedValue = 12;
        map.put(updatedKey, updatedValue);

        // Print the HashMap
        System.out.println("HashMap after all operations: " + map);
    }
}

```
## TreeMap: 
- A sorted map implementation based on a self-balancing binary search tree (Red-Black tree).
- Internal Working of TreeMap:
  - In Java, a TreeMap is an implementation of the SortedMap interface that uses a Red-Black Tree to store key-value pairs. It maintains the elements in sorted order based on the natural ordering of the keys or a custom comparator. The Red-Black Tree ensures efficient insertion, deletion, and search operations.

```java
package com.jd.interviewprep.dsa;

import java.util.TreeMap;

public class TreeMapDemo {
    public static void main(String[] args) {
        // Create a TreeMap
        TreeMap<String, Integer> map = new TreeMap<>();

        // Insert key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("Orange", 15);
        map.put("Grapes", 8);

        // Remove a key-value pair
        String removedKey = "Banana";
        map.remove(removedKey);

        // Sort the TreeMap (no need, already sorted)

        // Search for a key
        String searchKey = "Orange";
        boolean isPresent = map.containsKey(searchKey);
        if (isPresent) {
            System.out.println("Key found in the TreeMap.");
        } else {
            System.out.println("Key not found in the TreeMap.");
        }

        // Update a value
        String updatedKey = "Apple";
        int oldValue = map.get(updatedKey);
        int updatedValue = 12;
        map.put(updatedKey, updatedValue);

        // Print the TreeMap
        System.out.println("TreeMap after all operations: " + map);
    }
}

```
## LinkedHashMap: 
- A hash table and linked list implementation of the Map interface, maintaining the insertion order.
- Internal Working of LinkedHashMap:
  - In Java, a LinkedHashMap is an implementation of the Map interface that combines the features of a HashMap and a LinkedList. It maintains a doubly-linked list of elements in addition to using a hash table to store key-value pairs. The doubly-linked list preserves the insertion order of elements, while the hash table ensures efficient insertion, deletion, and search operations.


```java
package com.jd.interviewprep.dsa;

import java.util.LinkedHashMap;
import java.util.ArrayList;
import java.util.Collections;

public class LinkedHashMapDemo {
    public static void main(String[] args) {
        // Create a LinkedHashMap
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();

        // Insert key-value pairs
        map.put("Apple", 10);
        map.put("Banana", 5);
        map.put("Orange", 15);
        map.put("Grapes", 8);

        // Remove a key-value pair
        String removedKey = "Banana";
        map.remove(removedKey);

        // Sort the LinkedHashMap (no direct sorting)

        // Search for a key
        String searchKey = "Orange";
        boolean isPresent = map.containsKey(searchKey);
        if (isPresent) {
            System.out.println("Key found in the LinkedHashMap.");
        } else {
            System.out.println("Key not found in the LinkedHashMap.");
        }

        // Update a value
        String updatedKey = "Apple";
        int oldValue = map.get(updatedKey);
        int updatedValue = 12;
        map.put(updatedKey, updatedValue);

        // Print the LinkedHashMap
        System.out.println("LinkedHashMap after all operations: " + map);
    }
}

```

