package volatiledemo;

/**
 * Created by jd birla on 12-07-2023 at 11:55
 */
public class Exchanger {
    private Object object = null;
    private volatile boolean hasNewObject = false;

    public Object getObject() {
        while (!this.hasNewObject) {
            //busy wait
        }
        Object returnVal = this.object;
        this.hasNewObject = false;
        return returnVal;
    }

    public void setObject(Object object) {
        this.object = object;
        this.hasNewObject = true;
    }

}
