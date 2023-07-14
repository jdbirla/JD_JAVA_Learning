package race;

/**
 * Created by jd birla on 12-07-2023 at 13:29
 */
public class CounterSynchronized {

    private long count = 0;

    public long incAndGet() {

        synchronized (this)
        {
        this.count++;
        return this.count;
        }
    }

    public long get() {
        return this.count;
    }
}
