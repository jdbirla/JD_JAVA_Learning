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


## 










![image](https://user-images.githubusercontent.com/69948118/215028932-6c28a184-f537-473a-a9ae-76634bdb8215.png)
![image](https://user-images.githubusercontent.com/69948118/215028942-446d2197-b78f-476a-96fa-0e31a57d2406.png)
![image](https://user-images.githubusercontent.com/69948118/215028950-e671afa2-be3e-4be2-b3ba-0d347816598a.png)
![image](https://user-images.githubusercontent.com/69948118/215035921-50c754ee-ddcb-407e-aa6b-79151460532b.png)
![image](https://user-images.githubusercontent.com/69948118/215035928-38397d6c-d0d6-455d-98bc-97309c646bde.png)
![image](https://user-images.githubusercontent.com/69948118/215035903-c9a0ea3f-0428-4bb2-8d85-4f1bc0672a3d.png)
![image](https://user-images.githubusercontent.com/69948118/215035935-ac95f25d-498a-4307-9c08-34c9d628a202.png)
![image](https://user-images.githubusercontent.com/69948118/215035943-7c14db96-e6e7-4bb8-9b89-0af54b2f44b1.png)
![image](https://user-images.githubusercontent.com/69948118/215035949-3152a2a0-5965-4132-9c3f-32f223c780b7.png)
![image](https://user-images.githubusercontent.com/69948118/215035957-79567fa1-1228-4d10-8ac8-90c5d5bfb695.png)
![image](https://user-images.githubusercontent.com/69948118/215035966-38655fb3-7a18-41f0-a2da-ffc4a6d11878.png)
![image](https://user-images.githubusercontent.com/69948118/215035983-0643f3e8-487c-4e28-94fb-c17c0c2a7a65.png)
![image](https://user-images.githubusercontent.com/69948118/215035998-fdc4f4a8-c17d-4247-8559-6ad43e6d2e48.png)
![image](https://user-images.githubusercontent.com/69948118/215036005-13cc6b62-31c7-402a-a7eb-a11dc709944a.png)
![image](https://user-images.githubusercontent.com/69948118/215036013-87e0639c-25de-4904-a9c1-dc1d37ccf37b.png)
![image](https://user-images.githubusercontent.com/69948118/215036025-e9354313-1120-444a-b8e8-4f302192f2ac.png)
![image](https://user-images.githubusercontent.com/69948118/215036034-68322978-3fbf-4db9-a217-8ae19243b3bb.png)
![image](https://user-images.githubusercontent.com/69948118/215036043-389b17c7-beb1-401e-bd31-cc65dd597368.png)
![image](https://user-images.githubusercontent.com/69948118/215036055-8e7d9b4f-2b2f-4e51-b997-ce60957833f1.png)
![image](https://user-images.githubusercontent.com/69948118/215036068-205e3f75-13df-43e7-8ed4-0165829109fe.png)
![image](https://user-images.githubusercontent.com/69948118/215036075-f67f34a7-7b9a-4da9-83a5-a1fecc12e926.png)
![image](https://user-images.githubusercontent.com/69948118/215036092-00e3e8ea-77ca-4f93-9527-905e420acb93.png)
![image](https://user-images.githubusercontent.com/69948118/215036102-a0f41a1b-16cd-4ee3-81b8-662ed63d6196.png)
![image](https://user-images.githubusercontent.com/69948118/215036111-ef3568a7-499b-40f9-99bc-b4106d8abb02.png)
![image](https://user-images.githubusercontent.com/69948118/215036141-115f1e66-0694-4ab7-af04-45ca61c6ad06.png)
![image](https://user-images.githubusercontent.com/69948118/215036148-88889d8a-952f-4bba-8f7d-648253b05771.png)
![image](https://user-images.githubusercontent.com/69948118/215036164-1d3e6e3d-3cb7-4f7a-b067-d6497bc4de78.png)
![image](https://user-images.githubusercontent.com/69948118/215036169-650f5808-2c0c-4228-b7a2-17562ec9dc59.png)
![image](https://user-images.githubusercontent.com/69948118/215036179-8f6be924-8d04-4098-941a-afa8a6c59989.png)
![image](https://user-images.githubusercontent.com/69948118/215036195-e0fbf885-59ce-4d63-b4da-2c34ddb4ee55.png)
![image](https://user-images.githubusercontent.com/69948118/215036210-331b3dfe-7990-4957-8dc7-d4c7457d05a8.png)
![image](https://user-images.githubusercontent.com/69948118/215036285-0c1aa3f9-e2dc-4ef0-9aa5-f3532f1ef309.png)
![image](https://user-images.githubusercontent.com/69948118/215036294-89a08117-8af5-4e27-9827-83ac03825eab.png)
![image](https://user-images.githubusercontent.com/69948118/215036309-0c8d4382-07a2-47cb-a536-364c86cff000.png)
![image](https://user-images.githubusercontent.com/69948118/215036317-d27d3413-1e5a-4550-86ae-ac6bb0c25cd4.png)
![image](https://user-images.githubusercontent.com/69948118/215036327-b737749e-c2fb-4b4a-95f8-527e6a04c76d.png)
![image](https://user-images.githubusercontent.com/69948118/215036338-bd0439fd-459c-49b9-9fe8-27df949de963.png)
![image](https://user-images.githubusercontent.com/69948118/215036357-f186f1a5-4c73-429c-b847-289041a47293.png)
![image](https://user-images.githubusercontent.com/69948118/215036373-49099d6a-9661-49d6-a03a-e4983afabb4f.png)
![image](https://user-images.githubusercontent.com/69948118/215036389-00d35e45-ebd5-41a3-a165-7b34b755725d.png)
![image](https://user-images.githubusercontent.com/69948118/215036402-f9af7b7e-0417-4ae9-9206-981139e57dd4.png)
![image](https://user-images.githubusercontent.com/69948118/215036414-b4b1fa63-3629-4bb5-9bb5-636d6ea1dc3e.png)
![image](https://user-images.githubusercontent.com/69948118/215036422-8bd95342-159c-4053-98ba-7a79f35cdbad.png)
![image](https://user-images.githubusercontent.com/69948118/215036430-0daf9816-cdef-40e4-ab96-d6b102d8381c.png)
![image](https://user-images.githubusercontent.com/69948118/215036450-5d0ba0a6-3d00-422a-b9e8-78691c4e4fe6.png)
![image](https://user-images.githubusercontent.com/69948118/215036458-6115cfc4-3878-4e0b-918e-c95636382ef9.png)
![image](https://user-images.githubusercontent.com/69948118/215036466-3b5605c0-b088-4517-910a-e4c3893cda70.png)
![image](https://user-images.githubusercontent.com/69948118/215036474-e686cc7c-8cfc-4bb7-829c-13ddd640362d.png)
![image](https://user-images.githubusercontent.com/69948118/215036487-fa9e706c-c1b2-4c02-ac82-7bed87df9e9f.png)
![image](https://user-images.githubusercontent.com/69948118/215036495-b41b4986-e7d4-4a18-90f7-e124c8434a19.png)
![image](https://user-images.githubusercontent.com/69948118/215036504-45bf4b52-4b7f-4f3f-9140-01886c39f1b8.png)
![image](https://user-images.githubusercontent.com/69948118/215036530-c2d2466f-ffb7-4b26-ae13-0275a7843bbc.png)
![image](https://user-images.githubusercontent.com/69948118/215036549-00cc651d-7401-4d51-bc09-7ffc1e2981b3.png)
![image](https://user-images.githubusercontent.com/69948118/215036554-96ae19d8-80dc-4d71-8fc3-6bd2ae61f58d.png)
![image](https://user-images.githubusercontent.com/69948118/215036558-8950b53b-f36d-4d1b-96c4-5d6a9edb7047.png)
![image](https://user-images.githubusercontent.com/69948118/215036567-713e9ae0-faf5-4e6d-9e96-f6ad119f9a9c.png)
![image](https://user-images.githubusercontent.com/69948118/215036573-449da44b-08cc-4cb6-9417-c6ec12ab04f4.png)
![image](https://user-images.githubusercontent.com/69948118/215036582-ad96c308-67a3-4c1b-9d7b-78dd127629b9.png)
![image](https://user-images.githubusercontent.com/69948118/215036590-d09e1767-4952-40ad-af40-4d703143e57f.png)
![image](https://user-images.githubusercontent.com/69948118/215036597-3f0121e9-8621-4106-bf1d-1858c698e328.png)
![image](https://user-images.githubusercontent.com/69948118/215036604-c67c9305-1068-4f3b-8787-e05bfebe41f2.png)
![image](https://user-images.githubusercontent.com/69948118/215036613-bc6756e0-5b82-469b-b7e7-b64016a8cd96.png)
![image](https://user-images.githubusercontent.com/69948118/215036634-35502af6-97f3-4b55-bf95-d11c7346d8f6.png)
![image](https://user-images.githubusercontent.com/69948118/215036645-7390a247-bf0c-4eb0-a966-80c156f6840e.png)
![image](https://user-images.githubusercontent.com/69948118/215036655-1b5f53ee-1c24-4c57-9718-49b8c307b47c.png)
![image](https://user-images.githubusercontent.com/69948118/215036666-6aa6342d-4879-46f6-823a-887a418cf0a8.png)
![image](https://user-images.githubusercontent.com/69948118/215036673-d827a2a7-a91d-477b-b663-0059aad9f4bc.png)



































