package synchronizeds;

/**
 * Created by jd birla on 11-07-2023 at 17:43
 */
public class SynchronizedExchanger {

    protected Object object = null;


    public synchronized void setObject(Object object) {
        this.object = object;
    }

    public synchronized Object getObject() {
        return object;
    }


    public void setObj(Object o) {
        synchronized (this) {
            this.object = o;
        }
    }

    public Object getObj() {
        synchronized (this) {
            return this.object;
        }
    }


}
