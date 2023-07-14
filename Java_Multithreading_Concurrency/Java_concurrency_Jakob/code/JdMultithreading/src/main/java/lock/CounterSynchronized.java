package lock;

/**
 * Created by jd birla on 12-07-2023 at 15:30
 */
public class CounterSynchronized {
    private long count = 0;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized long getCount() {
        return this.count;
    }
}
