package creating.threads;


import java.util.concurrent.TimeUnit;

/**
 * Created by jd birla on 11-07-2023 at 15:04
 */
public class ThreadExample7 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " running");
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println(name + " finished");

        };
        Thread thread = new Thread(runnable, "The jd thread 1");
        thread.start();


        System.out.println(Thread.currentThread().getName() + " is running");


    }
}
