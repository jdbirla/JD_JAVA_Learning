package executer.service;

import java.util.concurrent.*;

public class ExecutorServiceExample4 {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(1);

        Future future = executorService.submit(newCallable("Task 1.1"));

        System.out.println(future.isDone());

        try{
            String result = (String) future.get();
            System.out.println(result);
        }catch (InterruptedException e){

        }catch (ExecutionException e1){

        }

        System.out.println(future.isDone());
        executorService.shutdown();
    }

    private static Callable newCallable(String msg){
        return new Callable() {
            @Override
            public Object call() throws Exception {
                String completeMsg = Thread.currentThread().getName() + " : " + msg;
                return completeMsg;
            }
        };
    }
}
