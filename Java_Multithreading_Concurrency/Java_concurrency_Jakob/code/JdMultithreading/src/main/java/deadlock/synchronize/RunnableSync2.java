package deadlock.synchronize;


/**
 * Created by jd birla on 13-07-2023 at 08:12
 */
public class RunnableSync2 implements Runnable {
    private Object lock1 = null;
    private Object lock2 = null;

    public RunnableSync2(Object lock1, Object lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " attempting to lock lock 2");
        synchronized (lock2) {
            System.out.println(threadName + " locked lock 2");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {

            }

            System.out.println(threadName + " attempting to lock lock 1");
            synchronized (lock1) {
                System.out.println(threadName + " locked Lock 1");

                //do the wrok - now that both lock have been acqired
            }
            System.out.println(threadName + " unlocking lock 1");

        }
        System.out.println(threadName + " unlocking lock 2");

    }
}
