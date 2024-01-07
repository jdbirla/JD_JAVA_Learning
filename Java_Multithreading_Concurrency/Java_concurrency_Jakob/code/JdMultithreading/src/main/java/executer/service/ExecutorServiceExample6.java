package executer.service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.*;

public class ExecutorServiceExample6 {
    public static void main(String[] args){
        ExecutorService executorService = Executors.newFixedThreadPool(3);
        List<Callable<String>> callables = new ArrayList<>();
        callables.add(newCallable("Task 1.1"));
        callables.add(newCallable("Task 1.2"));
        callables.add(newCallable("Task 1.3"));

        try{
            List<Future<String>> result = executorService.invokeAll((Collection<Callable<String>>) callables);

         for( Future<String> f: result)
            {
                System.out.println(f.get());

            }
        }catch (InterruptedException e){

        } catch (ExecutionException e) {
            throw new RuntimeException(e);
        }

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
