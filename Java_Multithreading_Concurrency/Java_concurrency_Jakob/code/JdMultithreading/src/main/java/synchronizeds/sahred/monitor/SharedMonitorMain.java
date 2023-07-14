package synchronizeds.sahred.monitor;

/**
 * Created by jd birla on 11-07-2023 at 18:10
 */
public class SharedMonitorMain {
    public static void main(String[] args) throws IllegalAccessException {
        Object monitor1 = new Object();
        SharedMonitorObject smo1 = new SharedMonitorObject(monitor1);
        SharedMonitorObject smo2 = new SharedMonitorObject(monitor1);
        smo1.incCounter();
        smo2.incCounter();
        Object monitor2 = new Object();
        SharedMonitorObject smo3 = new SharedMonitorObject(monitor2);
        smo3.incCounter();
    }
}
