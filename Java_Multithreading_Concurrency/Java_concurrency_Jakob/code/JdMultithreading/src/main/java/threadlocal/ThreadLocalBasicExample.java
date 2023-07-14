package threadlocal;

/**
 * Created by jd birla on 12-07-2023 at 12:44
 */
public class ThreadLocalBasicExample {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>();

        Thread thread1 = new Thread(
                () -> {
                    threadLocal.set("Thread1");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    String val = threadLocal.get();
                    System.out.println(val);
                }
        );

        Thread thread2 = new Thread(
                () -> {
                    threadLocal.set("Thread2");

                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    String val = threadLocal.get();
                    System.out.println(val);
                }
        );
        thread1.start();
        thread2.start();
    }
}
