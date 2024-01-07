# Java Multithreading,Parallel & Asynchronous Coding in Modern Java
- https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/tree/final

  - sequetial callto product service and review service both take 1 sec then final result will take 2 sec
  - first solution
      - we can call these service in different threads using runnable and the combine the result as both services ar caaling in different thread will take final result only 1 sec
          - ex: ProductServiceUsingThread.java
          - problesm, code is very verbose nad runnable not retruing anything so that we need to create class variables
          - hanle to creat threads and 
  - **threadpool**: Now threadpool is solution for above issue using executersrvice
     - 
