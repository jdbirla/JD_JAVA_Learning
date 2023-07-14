package creating.threads;

/**
 * Created by jd birla on 11-07-2023 at 14:55
 */
public class ThreadExample3 {

    public static class MyThread implements Runnable {
        @Override
        public void run() {
            System.out.println("MyThread is running");
            System.out.println("MyThread is finished");
        }
    }


    public static void main(String[] args) {
        ThreadExample2.MyThread thread = new ThreadExample2.MyThread();
        thread.start();

    }
}
