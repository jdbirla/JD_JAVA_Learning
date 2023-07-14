package creating.threads;

/**
 * Created by jd birla on 11-07-2023 at 15:09
 */
public class ThreadExample8 {
    public static class MyRunnable implements Runnable {

        private boolean doStop = false;

        public synchronized void doStop() {
            this.doStop = true;
        }

        private synchronized boolean isStopRequested() {
            return this.doStop;
        }

        private void sleep(long millis) {
            try {
                Thread.sleep(millis);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        @Override
        public void run() {
            System.out.println("StoppableRunnable running");
            while (!isStopRequested()) {
                // keep doing what this thread should do.

                try {
                    Thread.sleep(1000);
                    System.out.println("...");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
            System.out.println("StoppableRunnable stopped");

        }
    }

    public static void main(String[] args) {
        MyRunnable myRunnable = new MyRunnable();

        Thread thread = new Thread(myRunnable, "The Thread JD");

        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Requesting stop");
        myRunnable.doStop();
        System.out.println("stop requested");

    }
}
