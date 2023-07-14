package race;

/**
 * Created by jd birla on 12-07-2023 at 13:27
 */
public class RaceConditionWriteOneThreadReadOneThreadExam {
    public static void main(String[] args) {
        Counter counter = new Counter();

        Thread thread1 = new Thread(getIncrementingRunnable(counter, "Thread1 final count"));
        Thread thread2 = new Thread(getReadingRunnable(counter, "Thread2 final count"));
        thread1.start();
        thread2.start();

    }

    public static Runnable getIncrementingRunnable(Counter counter, String message) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incAndGet();
            }
            System.out.println(message +" : "+ counter.get());
        };
    }
    public static Runnable getReadingRunnable(Counter counter, String message) {
        return () -> {
            for (int i = 0; i < 5; i++) {
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            System.out.println(message +" : "+ counter.get());
            }
        };
    }
}
