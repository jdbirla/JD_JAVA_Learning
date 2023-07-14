package executer.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Created by jd birla on 12-07-2023 at 16:45
 */
public class ExecuterSubmitMethod {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(newRunnable("task 1.0"));

        System.out.println(future.isDone());
        try {
            future.get(); //get will be null
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
        System.out.println(future.isDone());
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
