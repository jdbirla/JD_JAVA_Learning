package race;

/**
 * Created by jd birla on 12-07-2023 at 13:27
 */
public class RaceConditionSynchronizedExam {
    public static void main(String[] args) {
        CounterSynchronized counter = new CounterSynchronized();

        Thread thread1 = new Thread(getRunnable(counter, "Thread1 final count"));
        Thread thread2 = new Thread(getRunnable(counter, "Thread2 final count"));
        thread1.start();
        thread2.start();

    }

    public static Runnable getRunnable(CounterSynchronized counter, String message) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter.incAndGet();
            }
            System.out.println(message +" : "+ counter.get());
        };
    }
}
