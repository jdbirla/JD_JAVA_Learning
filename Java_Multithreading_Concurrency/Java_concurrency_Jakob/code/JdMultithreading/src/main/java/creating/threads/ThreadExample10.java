package creating.threads;

public class ThreadExample10 {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " -> " + "finished");

        Runnable runnable = () -> {
            for (int i = 0; i < 5; i++) {
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " -> " + "Running" + i);
            }
        };

        Runnable runnable1 = () -> {
            for (int i = 0; i < 15; i++) {
                sleep(1000);
                System.out.println(Thread.currentThread().getName() + " -> " + "Running" + i);
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();

        Thread thread1 = new Thread(runnable1);
        thread1.start();

        try {
            thread.join();
          //  thread1.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " -> " + "finished");

    }

    public static void sleep(long milis) {
        try {
            Thread.sleep(milis);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
