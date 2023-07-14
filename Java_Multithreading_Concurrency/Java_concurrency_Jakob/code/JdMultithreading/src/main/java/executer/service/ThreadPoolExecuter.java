package executer.service;

import java.util.concurrent.*;

/**
 * Created by jd birla on 12-07-2023 at 16:39
 */
public class ThreadPoolExecuter {
    public static void main(String[] args) {
        int corePoolSize = 10;
        int maxPoolSize = 20;
        int keppAliveTimeForIdel = 3000;

        ExecutorService threadPoolExecutor = new ThreadPoolExecutor(corePoolSize, maxPoolSize, keppAliveTimeForIdel, TimeUnit.MILLISECONDS, new ArrayBlockingQueue<>(128));

        threadPoolExecutor = Executors.newFixedThreadPool(3);

    }
}
