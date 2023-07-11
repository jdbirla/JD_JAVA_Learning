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


## 





























