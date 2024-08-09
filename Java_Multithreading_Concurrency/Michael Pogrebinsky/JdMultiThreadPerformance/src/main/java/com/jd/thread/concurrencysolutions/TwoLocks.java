package com.jd.thread.concurrencysolutions;

public class TwoLocks {
    public static void main(String[] args) throws InterruptedException {
        SharedClass sharedObject = new SharedClass();

        Thread thread1 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedObject.incrementCounter1();
            }
        });

        Thread thread2 = new Thread(() -> {
            for (int i = 0; i < 10000; i++) {
                sharedObject.incrementCounter2();
            }
        });

        thread1.start();
        thread2.start();

        thread1.join();
        thread2.join();

        System.out.println(sharedObject.getItems());
        System.out.println(sharedObject.getItems2());

    }

    static class SharedClass {
        private int counter1 = 0;
          private int counter2 = 0;

        private Object lock1 = new Object();
        private Object lock2 = new Object();

        public void incrementCounter1() {
            synchronized (lock1) {
                this.counter1++;
            }
        }

        public void incrementCounter2() {
            synchronized (lock2) {
                this.counter2++;
            }
        }

        public synchronized int getItems() {
            synchronized (lock1) {
                return counter1;
            }
        }
        public synchronized int getItems2() {
            synchronized (lock1) {
                return counter2;
            }
        }
    }
}
