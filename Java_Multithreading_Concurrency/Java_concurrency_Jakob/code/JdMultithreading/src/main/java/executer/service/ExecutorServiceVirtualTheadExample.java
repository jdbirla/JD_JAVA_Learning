package executer.service;

import java.util.concurrent.*;

public class ExecutorServiceVirtualTheadExample {
//    public static void main(String[] args){
//
//        ExecutorService executor = Executors.newVirtualThreadPerTaskExecutor();
//
//        executor.submit(() -> {
//            System.out.println("This is a Runnable that is executed by a virtual thread");
//        });
//
//        Callable<String> callable = new Callable<String>() {
//            @Override
//            public String call() throws Exception {
//                System.out.println("Callable executed by a virtual thread");
//                return "Result from a Callable";
//            }
//        };
//
//        Future<String> futureResult = executor.submit(callable);
//
//        try {
//            System.out.println(futureResult.get());
//        }catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }catch (ExecutionException e1){
//            throw new RuntimeException(e1);
//        }
//
//        executor.shutdown();
//
//        try{
//            executor.awaitTermination(10, TimeUnit.SECONDS);
//        }catch (InterruptedException e){
//            throw new RuntimeException(e);
//        }
//    }
}
