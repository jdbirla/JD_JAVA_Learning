package executer.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by jd birla on 12-07-2023 at 16:29
 */
public class ExecutorServiceExample {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(newRunnable("task 1"));
        executorService.execute(newRunnable("task 2"));
        executorService.execute(newRunnable("task 3"));

        executorService.shutdown();

    }

    private static Runnable newRunnable(String msg) {
        return new Runnable() {
            @Override
            public void run() {
                String s = Thread.currentThread().getName() + " : " + msg;
                System.out.println(s);
            }
        };
    }
}
