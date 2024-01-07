package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockExamples {
    public static void main(String[] args){
        //lockBasics();
        //            lockInterruptibly();
        //tryLock();
        ReentrantLock lock = new ReentrantLock();
        int holdCount = lock.getHoldCount();
        int queueLength = lock.getQueueLength();
        boolean hasQueueThisThread = lock.hasQueuedThread(Thread.currentThread());
        boolean hasQueuedThreads = lock.hasQueuedThreads();
        boolean isFair = lock.isFair();
        boolean isLocked = lock.isLocked();
        boolean isHeldByCurrentThread = lock.isHeldByCurrentThread();
        /*
        1. Synchronized blocks must be contained withing a single method.
        lock.lock() and lock.unlock() can be called from different methods.

        2. lock.lock() and lock.unlock() provide the same visibility and happens before
        guarantee that synchronized block provides.

        3. Synchronized blocks are always re-entrant. Locks can choose to not be so.

        4. Synchronized blocks do not guarantee fairness. Locks can.
         */
    }

    public static void lockBasics(){
        Lock lock = new ReentrantLock();
        Runnable runnable = () -> {
            lockSleepUnlock(lock,1080);
        };

        Thread thread1 = new Thread(runnable, "Thread 1");
        Thread thread2 = new Thread(runnable, "Thread 2");
        Thread thread3 = new Thread(runnable, "Thread 3");

        thread1.start();
        thread2.start();
        thread3.start();
    }

    private static void lockSleepUnlock(Lock lock, long timeMilis){
        try{
            lock.lock();
            printThreadMsg(" Holds the lock ");
            sleep(timeMilis);
        }finally {
            lock.unlock();
        }
    }

    private static void lockInterruptibly(){
        Lock lock = new ReentrantLock();
        Thread.currentThread().interrupt();
        try {
            lock.lockInterruptibly();
            lock.unlock();
        }catch (InterruptedException e){
            System.out.println("Thread Interrupted");
        }
    }

    private static void tryLock(){
        Lock lock = new ReentrantLock();
        try{
            boolean lockSuccessful = lock.tryLock();
            System.out.println("Lock successful: " + lockSuccessful);
        }finally {
            lock.unlock();
        }
    }

    private static void printThreadMsg(String msg){
        System.out.println(Thread.currentThread().getName() + msg);
    }

    private static void sleep(long timeMilis){
        try {
            Thread.sleep(timeMilis);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }
}
