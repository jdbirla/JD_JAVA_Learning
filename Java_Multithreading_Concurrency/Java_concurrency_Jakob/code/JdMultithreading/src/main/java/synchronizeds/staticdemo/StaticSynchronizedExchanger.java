package synchronizeds.staticdemo;

/**
 * Created by jd birla on 11-07-2023 at 17:43
 */
public class StaticSynchronizedExchanger {

    protected static Object object = null;


    public static synchronized void setObject(Object object) {
        object = object;
    }

    public static synchronized Object getObject() {
        return object;
    }


    public static void setObj(Object o) {

        synchronized (StaticSynchronizedExchanger.class) {
            object = o;
        }
    }

    public static Object getObj() {
        synchronized (StaticSynchronizedExchanger.class) {
            return object;
        }
    }


}
