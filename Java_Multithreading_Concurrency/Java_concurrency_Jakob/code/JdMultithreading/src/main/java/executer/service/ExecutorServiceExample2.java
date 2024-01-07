package executer.service;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ExecutorServiceExample2 {
    public static void main(String[] args){

        ExecutorService executorService = Executors.newFixedThreadPool(10);

        /*executorService.execute(newRunnable("Task 1.1"));
        executorService.execute(newRunnable("Task 1.2"));
        executorService.execute(newRunnable("Task 1.3"));*/

        for(int i = 0;i < 200;i++){
            executorService.execute(newRunnable("Task 1." + (i + 1)));
        }

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
