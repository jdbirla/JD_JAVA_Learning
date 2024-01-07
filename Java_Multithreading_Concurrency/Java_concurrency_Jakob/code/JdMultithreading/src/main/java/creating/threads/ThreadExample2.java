package creating.threads;

/**
 * Created by jd birla on 11-07-2023 at 14:52
 */
public class ThreadExample2 {

    public static class MyThread extends Thread {
        @Override
        public void run() {
            System.out.println("MyThread is running");
            System.out.println("MyThread is finished");
        }
    }


    public static void main(String[] args) {
        System.out.println("MyThread is running");

        MyThread thread = new MyThread();
        thread.start();

    }
}
