package com.jd.thread.virtualthread;

import java.util.ArrayList;
import java.util.List;

public class VirtualThreadsDemo {
    private static final int NUMBER_OF_VIRTUAL_THREADS = 5;

    public static void main(String[] args) throws InterruptedException {
        platformThread(); //Inside platform thread: Thread[#22,Thread-0,5,main]
        platformThread2(); //Inside platform 2 thread: Thread[#35,Thread-1,5,main]
        virtualThread(); //Inside Virtual thread: VirtualThread[#26]/runnable@ForkJoinPool-1-worker-2
    }

    public static void virtualThread() throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside Virtual thread: " + Thread.currentThread());

        List<Thread> virtualThreads = new ArrayList<>();

        for (int i = 0; i < NUMBER_OF_VIRTUAL_THREADS; i++) {
            Thread virtualThread = Thread.ofVirtual().unstarted(runnable);
            virtualThreads.add(virtualThread);
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.start();
        }

        for (Thread virtualThread : virtualThreads) {
            virtualThread.join();
        }
    }

    public static void platformThread() throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside platform thread: " + Thread.currentThread());
        Thread platformThread = new Thread(runnable);
        platformThread.start();
        platformThread.join();

    }

    public static void platformThread2() throws InterruptedException {
        Runnable runnable = () -> System.out.println("Inside platform 2 thread: " + Thread.currentThread());
        Thread platformThread = Thread.ofPlatform().unstarted(runnable);
        platformThread.start();
        platformThread.join();

    }
}
