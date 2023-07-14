package synchronizeds.staticdemo;

/**
 * Created by jd birla on 11-07-2023 at 17:59
 */
public class MixedSynchronization {
    protected static Object StaticObject = null;


    public static synchronized void setStaticObject(Object staticObject) {
        staticObject = staticObject;
    }

    protected Object instanceObj = null;


    public synchronized void setInstanceObj(Object obj) {
        this.instanceObj = obj;
    }


}
