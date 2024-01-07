package executer.service;

import java.util.concurrent.*;

public class ExecutorServiceExample8 {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(1);
        Future future = executorService.submit(newCallable("Task 1.1"));

        System.out.println(future.isDone());

        boolean mayInterrupt = true;
        boolean wasCancelled = future.cancel(mayInterrupt); //you can only cancel a thread if it has not already started
        System.out.println(wasCancelled);
        try{
            String result = (String) future.get();
            System.out.println(result);
        }catch (InterruptedException e){

        }catch (ExecutionException e1){

        }catch(CancellationException e2){
            String msg = "Cannot call Future() since task was cancelled";
            System.out.println(msg);
        }

        System.out.println(future.isDone());
        System.out.println(future.isCancelled());
        executorService.shutdown();
    }

    private static Callable<String> newCallable(String msg){
        return new Callable() {
            @Override
            public Object call() throws Exception {
                String completeMsg = Thread.currentThread().getName() + " : " + msg;
                return completeMsg;
            }
        };
    }
}
