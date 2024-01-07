# Java Multithreading,Parallel & Asynchronous Coding in Modern Java
- https://github.com/dilipsundarraj1/parallel-asynchronous-using-java/tree/final

  - sequetial callto product service and review service both take 1 sec then final result will take 2 sec
  - first solution
      - we can call these service in different threads using runnable and the combine the result as both services ar caaling in different thread will take final result only 1 sec
          - ex: ProductServiceUsingThread.java
          - problesm, code is very verbose nad runnable not retruing anything so that we need to create class variables
          - hanle to creat threads and 
  - threadpool:  Now threadpool is solution for above issue using executersrvice
     - this will take also 1 sec for final result
     - no need to manage thread creation and can leverage future
     - ProductServiceUsingExecutor.java
     - blocking call , no bettwr way to combine result and no exceptionhnadling
  - fork/join framwork : used for data parallelism meainf chunking data nd combijne the result : ForkJoinUsingRecursion.java
  - ParallelStreamAPI : used fork/join framwork
              - ParallelStreamsExample.ajva
              - sequntail() and parallel() : for converting in between for operation form squentail to parallel
              -  modygin default parallelism in parallelstream default is no of cors - 1 but we can update using property
 - Common forkjoin pool : used by ParallelStream and CompetableFuture
 - CompetableFuture and reactive programming : CompletableFutureHelloWorld.java
     - supplyAsync
     - thenApply
     - thenCombine
     - thenCompose
     - Productservice using compatablefuture  ProductServiceUsingCompletableFuture.java
     - Combining stream with competableFuture: ProductServiceUsingCompletableFuture.updateInventoryToProductOption_approach2()
     - exceptionhandling: CompletableFutureHelloWorldException
          - handle() :  this gets invoked for both success and failure
          - exceptionally() : takeing only exception as areguemtn this call only have exception
          - whenComplete() : It throws the exception to next whencomplete in pipline and go to caller 
    - userdefine threadpool in copetablefuture
        - We need to use userdefinethreadpool in completable future when we use parallelstream and competable future together because both uses same commonforkjoinpool if in that thread may blocked by each other
          ![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/4337041b-3f05-4ba3-988b-041c982843fd)
       - each operation for different thread using async
         ![image](https://github.com/jdbirla/JD_JAVA_Learning/assets/69948118/0d215f91-102c-44f2-8515-e3742e0c251a)
     - Improve performance for api blocking call using comptable future wrapper
         - MoviesClient.ajva
    - allOf() : get all future and use allof and the apply join on that inside competalblefuture list
    - anyOf() : anyof will complete any of the competablefuture 
