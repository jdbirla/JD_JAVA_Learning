package deadlock.synchronize;

/**
 * Created by jd birla on 13-07-2023 at 08:19
 */
public class DeadlockExampleSyncMain {
    public static void main(String[] args) {
        Object lock1 = new Object();
        Object lock2 = new Object();

        RunnableSync1 runnable1 = new RunnableSync1(lock1, lock2);
        RunnableSync2 runnable2 = new RunnableSync2(lock1, lock2);

        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
