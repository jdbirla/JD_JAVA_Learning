package synchronizeds.reentrance;

/**
 * Created by jd birla on 11-07-2023 at 18:39
 */
public class Reentrance {
    private int count = 0;

    public synchronized void inc() {
        this.count++;
    }

    public synchronized int intAntGet() {
        inc();
        return this.count;
    }
}
