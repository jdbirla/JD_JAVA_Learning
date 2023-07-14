package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jd birla on 12-07-2023 at 15:28
 */
public class LockExample {
    public static void main(String[] args) {
        Lock lock = new ReentrantLock(true);

        lock.lock();

        //do somthing critical section

        lock.unlock();
    }
}
