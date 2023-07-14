package synchronizeds.sahred.monitor;

/**
 * Created by jd birla on 11-07-2023 at 18:08
 */
public class SharedMonitorObject {

    private Object monitor = null;
    private int counter = 0;

    public SharedMonitorObject(Object monitor) throws IllegalAccessException {
        if (monitor == null) {
            throw new IllegalAccessException("Monitor obj can't be null");
        }
        this.monitor = monitor;
    }

    public void incCounter() {
        synchronized (this.monitor) {
            this.counter++;
        }
    }

}
