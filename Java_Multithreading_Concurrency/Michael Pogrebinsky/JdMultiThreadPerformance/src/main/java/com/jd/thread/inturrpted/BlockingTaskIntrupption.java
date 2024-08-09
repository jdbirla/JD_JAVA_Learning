package com.jd.thread.inturrpted;

public class BlockingTaskIntrupption {
    public static void main(String [] args) {
        Thread thread = new Thread(new BlockingTask());

        thread.start();
        thread.interrupt();  //without this method call thread will never stop and program will
    }

    private static class BlockingTask implements Runnable {

        @Override
        public void run() {
            //do things
            try {
                Thread.sleep(500000);
            } catch (InterruptedException e) {
                System.out.println("Existing blocking thread");
            }
        }
    }
}
