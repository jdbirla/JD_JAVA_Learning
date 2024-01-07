package executer.service;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceExample3 {
    public static void main(String[] args){
        ExecutorService executorService =
                Executors.newFixedThreadPool(1);

        Future future = executorService.submit(newRunnable("Task 1.1"));

        System.out.println(future.isDone());

        try{
            future.get();
        }catch (InterruptedException e){

        }catch (ExecutionException e1){

        }

        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Runnable newRunnable(String msg){
        return new Runnable() {
            @Override
            public void run() {
                String completeMsg = Thread.currentThread().getName() + " : " + msg;
                System.out.println(completeMsg);
            }
        };
    }
}
