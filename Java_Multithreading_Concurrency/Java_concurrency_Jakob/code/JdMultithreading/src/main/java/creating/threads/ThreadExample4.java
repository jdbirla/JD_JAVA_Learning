package creating.threads;

/**
 * Created by jd birla on 11-07-2023 at 14:56
 */
public class ThreadExample4 {


    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("MyThread is running");
                System.out.println("MyThread is finished");
            }
        };
        Thread thread = new Thread(runnable);
        thread.start();


    }
}