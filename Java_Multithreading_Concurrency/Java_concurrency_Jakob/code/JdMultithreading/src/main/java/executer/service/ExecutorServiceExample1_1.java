package executer.service;

import java.util.concurrent.*;

public class ExecutorServiceExample1_1 {
    public static void main(String[] args){
        int corePoolSize = 10;
        int maxPoolSize = 20;
        long keepAliveTime = 3000;

        ExecutorService threadPoolExecutor =
                new ThreadPoolExecutor(
                        corePoolSize,
                        maxPoolSize,
                        keepAliveTime,
                        TimeUnit.MILLISECONDS,
                        new ArrayBlockingQueue<>(128)
                );

        threadPoolExecutor = (ThreadPoolExecutor) Executors.newFixedThreadPool(3);

        // threadPoolExecutor.execute(); use this method to execute tasks as defined in run method of Runnable object

        ScheduledExecutorService scheduledExecutorService =
                new ScheduledThreadPoolExecutor(corePoolSize);

        scheduledExecutorService =
                Executors.newScheduledThreadPool(10);
    }

}
