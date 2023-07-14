package executer.service;

import java.util.concurrent.*;

/**
 * Created by jd birla on 12-07-2023 at 16:45
 */
public class ExecuterSubmitMethodCallable {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(newCallable("task 1.0"));

        System.out.println(future.isDone());
        try {
            String result = (String) future.get();
            System.out.println(result);
        } catch (InterruptedException e) {
        } catch (ExecutionException e) {
        }
        System.out.println(future.isDone());
        executorService.shutdown();

    }

    private static Callable newCallable(String msg) {
        return new Callable() {
            @Override
            public Object call() throws Exception {
                String s = Thread.currentThread().getName() + " : " + msg;
                return s;
            }
        };
    }
}
