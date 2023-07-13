# Java_concurrency_Jakob
Source: Java Concurrency and Multithreading - Introduction(# https://www.youtube.com/watch?v=mTGdtC9f4EU&list=PLL8woMHwr36EDxjUoCzboZjedsnhLP1j4)
- https://jenkov.com/tutorials/java-concurrency/index.html
## Java Concurrency and Multithreading - Introduction
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/a4a715d2-e7bb-4fb1-8494-71cf6aa8b460)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/a374c303-d957-4d2d-9de0-857131891320)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/38a14a20-7884-4f29-8069-c1371cbb17c7)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/37ace1f0-7763-499a-b146-0f6c0a8db09a)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/3c4d25e2-75d3-4693-801a-1ab6f1edb3dc)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/1cad516f-af76-4f69-8a04-1c85b9f268d0)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/99cffb38-1577-4576-a282-67cde5247a2a)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/5074b050-9e5f-46b3-96d7-d394a4d57278)

##  Java Threads - Creating, starting and stopping threads in Java 
### How to Stop a thread
```java
package creating.threads;

/**
 * Created by jd birla on 11-07-2023 at 15:09
 */
public class ThreadExample8 {
    public static class MyRunnable implements Runnable {

        private boolean doStop = false;

        public synchronized void doStop() {
            this.doStop = true;
        }

        private synchronized boolean isStopRequested() {
            return this.doStop;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable running");
            while (!isStopRequested()) {
                // keep doing what this thread should do.

                try {
                    Thread.sleep(1000);
                    System.out.println("...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("StoppableRunnable stopped");

        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable, "The Thread JD");

        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Requesting stop");
        myRunnable.doStop();
        System.out.println("stop requested");

    }
}

```
### Join and deamon
- **deamon** : when we set a threadd as deamon it will stop when main thread will stop
- **join** :  join method will join the thread with the current running thread , in below example main thread is waiting to complete for thread 
```java
package creating.threads;

/**
 * Created by jd birla on 11-07-2023 at 15:27
 */
public class ThreadExample9 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println("running");
            }
        };

        Thread thread = new Thread(runnable);
        thread.setDaemon(true);
        thread.start();

        try {
            thread.join(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void sleep(int i) {
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

```

###  The Java Memory Model - The Basics 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/1cfaeeed-1497-4d4c-96dc-4e29bdc4dc43)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/22786ad1-a4f1-40a4-8fca-ff32b6514732)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/9e813f5b-7bb4-46cf-8d8e-18fbb296bd42)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/dae5195d-4016-4964-b78e-e878bb83090f)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/69fa64cb-cca7-427c-8674-f33713f884d6)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/c7b45e29-76da-45d3-9ad4-0f54b3218f05)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/605687b4-7bcf-42d3-969f-d5a8f88fef7e)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/5f5ed209-c9e2-4035-b5ab-efe6d6ba3423)

- MyRunnable
```java
package memory.model;

/**
 * Created by jd birla on 11-07-2023 at 15:50
 */
public class MyRunnable implements Runnable {

    private int  count = 0;
    private  PassingObject passingObject = null;

    public MyRunnable(PassingObject passingObject) {
        this.passingObject = passingObject;
    }

    @Override
    public void run() {
        MyObject myObject = new MyObject();
        System.out.println(" myObject : "+myObject);
        System.out.println(" passingObject : "+passingObject);

        for (int i = 0; i < 1_000_000; i++) {
         synchronized (this)
            {
                this.count++;

          }

        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }

}

```
- SeprateObjects
```java
package memory.model;

/**
 * Created by jd birla on 11-07-2023 at 15:49
 */
public class SeprateObjects {

    public static void main(String[] args) {
        PassingObject passingObject = new PassingObject();
        Runnable runnable1 = new MyRunnable(passingObject);
        Runnable runnable2 = new MyRunnable(passingObject);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

//        myObject : memory.model.MyObject@5d9c386
//        passingObject : memory.model.PassingObject@591e7753
//        myObject : memory.model.MyObject@2024773f
//        passingObject : memory.model.PassingObject@591e7753
//        Thread-1 : 1000000
//        Thread-0 : 1000000
    }
}

```
- SharedObjects
```java
package memory.model;

/**
 * Created by jd birla on 11-07-2023 at 15:53
 */
public class SharedObjects {

    public static void main(String[] args) {
        PassingObject passingObject = new PassingObject();
        Runnable runnable = new MyRunnable(passingObject);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable );

        thread1.start();
        thread2.start();
// Before synchronization
//        myObject : memory.model.MyObject@5d9c386
//        passingObject : memory.model.PassingObject@591e7753
//        myObject : memory.model.MyObject@3ff9a510
//        passingObject : memory.model.PassingObject@591e7753
//        Thread-0 : 886372
//        Thread-1 : 1868476

//After applying only synchronization
//        myObject : memory.model.MyObject@1648f0de
//        passingObject : memory.model.PassingObject@4c8f3013
//        myObject : memory.model.MyObject@65738596
//        passingObject : memory.model.PassingObject@4c8f3013
//        Thread-0 : 1954068
//        Thread-1 : 2000000




    }
}

```

##  Java Happens Before Guarantee - Java Memory Model - Part 2 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/6177b383-f9b3-4529-890a-6e7bf6f75377)

- The Java "happens-before" guarantee is a concept that defines the ordering of actions in a multi-threaded program. It ensures that the results of one thread's actions are visible to another thread in a consistent and predictable manner.

- In easy language, the happens-before guarantee can be understood as a set of rules that determine when changes made by one thread become visible to other threads. These rules help prevent unexpected and inconsistent behavior in concurrent programs.

- Here are a few key points to understand about the happens-before guarantee:

1. Program order: Actions within a single thread are guaranteed to occur in the order specified by the program. This means that if you have a sequence of operations in your code, they will be executed in the same order.

2. Volatile variables: If a write operation is performed on a volatile variable by one thread, and a read operation is performed on the same variable by another thread, the read operation is guaranteed to see the updated value.

3. Synchronization: Actions performed within a synchronized block or method have a happens-before relationship with subsequent actions in another synchronized block or method. This ensures that changes made within a synchronized block are visible to other threads when they subsequently acquire the same lock.

4. Thread start and termination: The start of a thread guarantees that all actions in the thread's constructor happen before any actions performed by that thread. Similarly, any actions performed by a thread happen before any actions performed by a thread that detects the first thread has terminated (either by joining or by using the `isAlive()` method).

5. Thread interruptions: If one thread interrupts another thread, the interrupting thread is guaranteed to see the effects of all actions performed by the interrupted thread before the interruption.

- These are just a few examples of the happens-before rules. The happens-before guarantee ensures that threads can safely communicate and coordinate their actions, providing consistency and predictability in concurrent programs.
- By following these rules, developers can write correct and reliable multi-threaded programs in Java, ensuring that shared data is accessed and modified safely by multiple threads.

![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/44f6e2d9-3a65-4b86-ab9d-c905b8a5eb70)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/bfe2aa34-0995-403a-9b1f-200103e151c1)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/212dc344-b1b1-4163-8304-d8de03e0e706)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/a97ebdc8-b316-49e5-bfaa-6a8716e941af)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/1bd94f87-7b36-4cf0-84af-e4ee2f78b2eb)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/65e3458b-2fd5-4c56-ad14-6932acd6b0af)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/df9b5a2c-eca1-455c-b957-c5ca6f84187b)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/2473cc9b-cf76-4355-9448-0159fd72bbc3)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/5048bc39-5967-4104-8a42-3bc2e3d03066)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/5c5066dc-3d68-4509-aeeb-44887f6fb4c3)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/c0ab7ba2-05f9-4e60-b20f-d75adbbf3eda)


##  Java Synchronized - The synchronized keyword in Java and Java synchronized blocks and methods 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/bdd9ff16-0de4-4201-baf5-18b005be2e34)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/485dd79d-8ad8-4f94-ad6f-a3a5612ace0f)


### Reentrance 
```java
package synchronizeds.reentrance;

/**
 * Created by jd birla on 11-07-2023 at 18:39
 */
public class Reentrance {
    private int count = 0;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized int intAntGet() {
        inc();
        return this.count;
    }
}

```
### java synchronized Visibility guarantee 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/999686ab-c4fc-4410-a3d9-dd8d8b37f513)

### Limitation
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/419ecdab-7061-4a35-82d9-bd9e3f37b718)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/2717d501-eb86-4686-9a52-8dfc23490579)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/12b8c2cf-dafe-4a43-84c3-25b924519b4c)


## Volatile
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/26bcf7d3-487f-461a-b854-9acda758d489)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/f2ed6020-07e9-4ec0-bb45-d135b4d6d65a)

##  CPU Cache Coherence + Java Concurrency 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/42b8d95d-b2ec-477b-922f-fa551bb52a19)

##  Java ThreadLocal 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/a5df514a-86a2-4eb8-8736-1b18dbfa0aa3)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/f94e55ba-84f5-4b58-be68-388c758bb03d)

### InheritableThreadLocal : can share values to child threads


```java
package threadlocal;

/**
 * Created by jd birla on 12-07-2023 at 12:44
 */
public class ThreadLocalBasicExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread thread1 = new Thread(
                () -> {
                    threadLocal.set("Thread1");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    String val = threadLocal.get();
                    System.out.println(val);
                }
        );

        Thread thread2 = new Thread(
                () -> {
                    threadLocal.set("Thread2");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    String val = threadLocal.get();
                    System.out.println(val);
                }
        );
        thread1.start();
        thread2.start();
    }
}

```

##  Race Conditions in Java Multithreading 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/c5902fab-082e-4334-9cb9-54312e072ac3)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/9b54affa-501f-47f9-b6ec-a840d57d9ba5)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/d5b3354d-5ee9-4982-8191-312caf3c146a)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/3f29962a-ce86-44e4-866f-d87c65e08f7c)
### Check and Act
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/2b3c894f-e78a-4990-a7df-db80048d7b73)

```java
package race;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jd birla on 12-07-2023 at 14:38
 */
public class RaceConditionCheckAndAct {

    public static void main(String[] args) {
        Map<String, String> sharedMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap));
        Thread thread2 = new Thread(getRunnable(sharedMap));
        thread1.start();
        thread2.start();


    }

    public static Runnable getRunnable(Map<String, String> sahredMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (sahredMap) {
                    if (sahredMap.containsKey("key")) {
                        String val = sahredMap.remove("key");
                        if (val == null) {
                            System.out.println("Iteration: " + i + ": Value for 'key' was null");
                        }
                    } else {
                        sahredMap.put("key", "value");
                    }
                }
            }
        };
    }
}

```
##  Concurrency vs Parallelism 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/0add8417-72b0-4813-bb4b-3f3d9bbae7cf)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/1b6eaaf4-b49f-478d-8e6a-537e43932c56)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/ffa8df67-37ea-47eb-b483-8f2136183139)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/409a2aa1-079c-47d1-90b2-63d706665208)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/c9c6e8e2-68fb-41e0-a58a-dbf2f237d196)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/c0e4a4f5-7bbc-49d9-b6ea-92c0b71a1bae)

##  Thread Pools in Java 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/7c24b7a5-54fc-42f7-8063-97fec49b436b)

##  Java Lock 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/da934f74-06f1-4c7b-826b-5c8b16990c71)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/983d9a76-8d28-4a09-8406-3a3a39a5f368)

##  Java ExecutorService - Part 1 
### Future Methods

| Method Name             | Description                                                             | Code Snippet                                                                                                    |
|-------------------------|-------------------------------------------------------------------------|-----------------------------------------------------------------------------------------------------------------|
| `cancel()`              | Attempts to cancel the execution of the associated task.                 | `future.cancel()`                                                                                               |
| `cancel(may_interrupt_if_running)` | Attempts to cancel the execution of the associated task.             | `future.cancel(True)`                                                                                           |
| `done()`                | Returns `True` if the task has completed, whether successfully or not.   | `if future.done():\n    print("Task is done")`                                                                   |
| `result()`              | Waits for the task to complete and returns its result.                   | `result = future.result()`                                                                                      |
| `result(timeout)`       | Waits for the task to complete and returns its result within a timeout.  | `result = future.result(5)`                                                                                     |
| `exception()`           | Returns the exception raised by the task (if any) or `None`.             | `exception = future.exception()`                                                                                |
| `add_done_callback(fn)` | Adds a callback function to be called when the task is complete.          | `future.add_done_callback(callback_function)`                                                                   |
| `set_result(result)`    | Sets the result of the task to the provided value.                        | `future.set_result(result_value)`                                                                               |
| `set_exception(exception)` | Sets the exception of the task to the provided value.                    | `future.set_exception(exception_value)`                                                                         |
| `running()`             | Returns `True` if the task is currently running.                         | `if future.running():\n    print("Task is running")`                                                            |
| `timeout(seconds)`      | Sets a timeout value for the task to complete within the given seconds.   | `future.timeout(10)`                                                                                            |
| `wait(timeout=None)`    | Waits for the task to complete, with an optional timeout.                 | `future.wait()` or `future.wait(5)`                                                                             |
| `result_at_timeout(default=None)` | Returns the task's result if available, or a default value if timeout occurs. | `result = future.result_at_timeout()` or `result = future.result_at_timeout(default_value)`                   |
| `exception_at_timeout(default=None)` | Returns the task's exception if available, or a default value if timeout occurs. | `exception = future.exception_at_timeout()` or `exception = future.exception_at_timeout(default_value)`    |
| `running_or_done()`     | Returns `True` if the task is currently running or has completed.          | `if future.running_or_done():\n    print("Task is running or done")`                                           |
| `done_and_not_cancelled()` | Returns `True` if the task has completed and was not cancelled.           | `if future.done_and_not_cancelled():\n    print("Task is done and not cancelled")`                              |
| `cancelled()`           | Returns `True` if the task was successfully cancelled.                    | `if future.cancelled():\n    print("Task was cancelled")`                                                       |

Please note that not all the methods listed here are necessarily available in every implementation of the `Future` class. The examples provided are based on common conventions and usage patterns in asynchronous programming libraries. Make sure to refer to the documentation specific to your programming language or library to find the available methods and their usage.
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/900d2355-dc23-476e-9c94-712a1f7e40e2)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/7907a260-8567-4837-9ec6-408543879483)
- invokeAny(), invokeAll()

##  Java ExecutorService - Part 2 
- **shutdown** : Shutdown will wait for all tasks will to be completed and main thread will wait
- **shutdownnow** : Shutdown all task immediately

### CompetableFuture Methods

| Method Name                             | Description                                                               | Code Snippet                                                                                           |
|-----------------------------------------|---------------------------------------------------------------------------|--------------------------------------------------------------------------------------------------------|
| `cancel(boolean mayInterruptIfRunning)` | Attempts to cancel the completion of this future.                          | `future.cancel(true)`                                                                                  |
| `isCancelled()`                         | Returns `true` if the future was cancelled before its completion.          | `if (future.isCancelled()) { /* Handle cancellation */ }`                                              |
| `isCompletedExceptionally()`            | Returns `true` if the future completed exceptionally.                      | `if (future.isCompletedExceptionally()) { /* Handle exceptional completion */ }`                      |
| `isDone()`                              | Returns `true` if the future completed, either normally or exceptionally.   | `if (future.isDone()) { /* Handle completion */ }`                                                      |
| `get()`                                 | Waits if necessary for the future to complete, and then returns its result. | `T result = future.get();`                                                                              |
| `get(long timeout, TimeUnit unit)`      | Waits if necessary for at most the given time for the future to complete.  | `T result = future.get(5, TimeUnit.SECONDS);`                                                           |
| `join()`                                | Waits if necessary for the future to complete and returns its result.       | `T result = future.join();`                                                                             |
| `obtrudeValue(T value)`                  | Completes the future with the given value, regardless of its current state.| `future.obtrudeValue(resultValue);`                                                                     |
| `obtrudeException(Throwable ex)`         | Completes the future with the given exception, regardless of its current state. | `future.obtrudeException(exception);`                                                                |
| `complete(T value)`                      | Completes the future with the given value, if it was not already completed. | `future.complete(resultValue);`                                                                         |
| `completeExceptionally(Throwable ex)`    | Completes the future exceptionally with the given exception, if not completed. | `future.completeExceptionally(exception);`                                                            |
| `obtrudeValue(T value)`                  | Completes the future with the given value, regardless of its current state.| `future.obtrudeValue(resultValue);`                                                                     |
| `thenApply(Function<? super T,? extends U> fn)` | Returns a new `CompletableFuture` that is completed with the value obtained by applying the given function to the result of this future. | `CompletableFuture<U> newFuture = future.thenApply(result -> /* Apply function to result */);`    |
| `thenAccept(Consumer<? super T> action)`    | Returns a new `CompletableFuture` that is completed with `null` after the action is performed on the result of this future. | `CompletableFuture<Void> newFuture = future.thenAccept(result -> /* Perform action on result */);` |
| `thenRun(Runnable action)`                 | Returns a new `CompletableFuture` that is completed with `null` after the given action is performed. | `CompletableFuture<Void> newFuture = future.thenRun(() -> /* Perform action */);`              |
| `thenCompose(Function<? super T, ? extends CompletionStage<U>> fn)` | Returns a new `CompletableFuture` that is the result of applying the given function to the result of this future. | `CompletableFuture<U> newFuture = future.thenCompose(result -> /* Apply function to result */);` |
| `thenCombine(CompletionStage<? extends U> other, BiFunction<? super T, ? super U, ? extends V> fn)` | Returns a new `CompletableFuture` that is the result of applying the given function to the results of this future and another future. | `CompletableFuture<V> newFuture = future.thenCombine(otherFuture, (result1, result2) -> /* Combine results */);` |
| `thenAcceptBoth(CompletionStage<? extends U> other, BiConsumer<? super T, ? super U> action)` | Returns a new `CompletableFuture` that is completed with `null` after the given action is performed with the results of this future and another future. | `CompletableFuture<Void> newFuture = future.thenAcceptBoth(otherFuture, (result1, result2) -> /* Perform action */);` |
| `runAfterBoth(CompletionStage<?> other, Runnable action)` | Returns a new `CompletableFuture` that is completed with `null` after both this future and another future have completed. | `CompletableFuture<Void> newFuture = future.runAfterBoth(otherFuture, () -> /* Perform action */);` |
| `applyToEither(CompletionStage<? extends T> other, Function<? super T, U> fn)` | Returns a new `CompletableFuture` that is completed with the result of either this future or another future, whichever completes first. | `CompletableFuture<U> newFuture = future.applyToEither(otherFuture, result -> /* Apply function to result */);` |
| `acceptEither(CompletionStage<? extends T> other, Consumer<? super T> action)` | Returns a new `CompletableFuture` that is completed with `null` after the given action is performed on the result of either this future or another future, whichever completes first. | `CompletableFuture<Void> newFuture = future.acceptEither(otherFuture, result -> /* Perform action */);` |
| `runAfterEither(CompletionStage<?> other, Runnable action)` | Returns a new `CompletableFuture` that is completed with `null` after either this future or another future completes. | `CompletableFuture<Void> newFuture = future.runAfterEither(otherFuture, () -> /* Perform action */);` |
| `exceptionally(Function<Throwable, ? extends T> fn)` | Returns a new `CompletableFuture` that is completed with the result of applying the given function to the exception thrown by this future, if it completed exceptionally. | `CompletableFuture<T> newFuture = future.exceptionally(exception -> /* Handle exception and return result */);` |
| `handle(BiFunction<? super T, Throwable, ? extends U> fn)` | Returns a new `CompletableFuture` that is completed with the result of applying the given function to the result and exception (if any) of this future. | `CompletableFuture<U> newFuture = future.handle((result, exception) -> /* Handle result and exception and return value */);` |

### How many threads should be available in thread pool
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/65095313-db59-4fcd-9dd8-d8faca2b0afe)

## Java ExecutorService Using Virtual Threads 
- Virtual thread introduced in java 19
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/c4650bd0-38a9-4a83-8a38-49fc497622b6)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/41dfcf4d-7e95-4daa-b721-b5ab16f66cbf)

##  Deadlock in Java 
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/b08800f6-403f-483b-ae1e-1187d6a1da56)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/fbf5b7ef-048b-40c4-a444-d6049324cdcc)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/97945f7a-8d83-4700-916b-efb9dd4e0907)
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/d30e1d51-c617-43fd-bd8a-f2d8e667769c)
### Deadlock reason
- **Mutual Exclusion** : Mutual exclusion means only one thread can get a lock at time, if both threads can get a lock at same time then no deadlock
- **No Preemption** : It refers to the idea that resources cannot be forcefully taken away or preempted from a thread that currently holds them  In other words, once a thread acquires a resource, it has exclusive control over that resource until it voluntarily releases it.
- To understand "No Preemption," let's consider an example involving two threads, Thread A and Thread B, and a shared resource, Resource X:
   - Thread A acquires a lock on Resource X.
   - Thread B wants to acquire the lock on Resource X but finds that it is already held by Thread A.
   - In a system without preemption, Thread B cannot forcibly take away the lock from Thread A. It must wait until Thread A voluntarily releases the lock.
- **Hold and Wait** :  It refers to the situation where a process or thread holds at least one resource while waiting to acquire additional resources.
   - To understand "Hold and Wait," let's consider an example involving two threads, Thread A and Thread B, and two resources, Resource X and Resource Y:

   - Thread A acquires a lock on Resource X.
   - Thread A requires Resource Y to proceed but does not release the lock on Resource X.
   - Thread A goes into a waiting state, expecting to acquire Resource Y in the future.
   - Meanwhile, Thread B acquires a lock on Resource Y.
   - Thread B requires Resource X to proceed but does not release the lock on Resource Y.
   - Thread B goes into a waiting state, expecting to acquire Resource X in the future.
- **Circular Wait** : There must be a circular chain of two or more threads, each holding a resource that the next thread in the chain is waiting for.

##  Deadlock Prevention in Java 
- **Resource Ordering**: Acquire resources in a predefined order to avoid circular wait situations.
- **Lock Timeout**: Use timeouts when acquiring locks to avoid indefinite blocking.
- **Deadlock Detection and Recovery**: Implement algorithms to detect and resolve deadlocks when they occur.
- **Avoiding Hold and Wait**: Acquire all necessary resources upfront before starting critical sections of code.
- **Limit Resource Usage**: Limit the number of resources each thread can acquire to reduce the chances of circular wait.

### Deadlock Detection
![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/b82f5007-b928-4f61-bc01-af68e6f3be04)

