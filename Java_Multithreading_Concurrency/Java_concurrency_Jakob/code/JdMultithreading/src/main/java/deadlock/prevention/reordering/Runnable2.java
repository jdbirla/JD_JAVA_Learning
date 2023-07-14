package deadlock.prevention.reordering;

import java.util.concurrent.locks.Lock;

/**
 * Created by jd birla on 13-07-2023 at 08:12
 */
public class Runnable2 implements Runnable {
    private Lock lock1 = null;
    private Lock lock2 = null;

    public Runnable2(Lock lock1, Lock lock2) {
        this.lock1 = lock1;
        this.lock2 = lock2;
    }

    @Override
    public void run() {
        String threadName = Thread.currentThread().getName();
        System.out.println(threadName + " attempting to lock lock 1");
        lock1.lock();
        System.out.println(threadName + " locked lock 1");
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {

        }

        System.out.println(threadName + " attempting to lock lock 2");
        lock2.lock();
        System.out.println(threadName + " locked Lock 3");

        //do the wrok - now that both lock have been acqired
        System.out.println(threadName + " unlocking lock1");
        lock1.unlock();
        System.out.println(threadName + " unlocking lock2");
        lock2.unlock();
    }
}
