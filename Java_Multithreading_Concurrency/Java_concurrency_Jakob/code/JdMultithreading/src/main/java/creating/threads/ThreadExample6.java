package creating.threads;

/**
 * Created by jd birla on 11-07-2023 at 15:00
 */
public class ThreadExample6 {
    public static void main(String[] args) {
        Runnable runnable = () -> {
            String name = Thread.currentThread().getName();
            System.out.println(name + " running");
        };
        Thread thread = new Thread(runnable, "The jd thread 1");
        thread.start();
        Thread thread2 = new Thread(runnable, "The jd thread 2");
        thread2.start();

        System.out.println(Thread.currentThread().getName() + " is running");


    }
}
