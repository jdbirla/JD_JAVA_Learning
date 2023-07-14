package synchronizeds.multiple.monitor;

/**
 * Created by jd birla on 11-07-2023 at 18:03
 */
public class MultipleMonitorObjects {

    private Object monitor1 = new Object();
    private Object monitor2 = new Object();
    private int counter1 = 0;
    private int counter2 = 0;

    public void incCounter1() {
        synchronized (this.monitor1) {
            this.counter1++;
        }
    }

    public void incCounter2() {
        synchronized (this.monitor2) {
            this.counter2++;
        }
    }
}
