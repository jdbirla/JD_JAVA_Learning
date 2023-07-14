package memory.model;

/**
 * Created by jd birla on 11-07-2023 at 15:50
 */
public class MyRunnable implements Runnable {

    private int  count = 0;
    private  PassingObject passingObject = null;

    public MyRunnable(PassingObject passingObject) {
        this.passingObject = passingObject;
    }

    @Override
    public void run() {
        MyObject myObject = new MyObject();
        System.out.println(" myObject : "+myObject);
        System.out.println(" passingObject : "+passingObject);

        for (int i = 0; i < 1_000_000; i++) {
         synchronized (this)
            {
                this.count++;

          }

        }
        System.out.println(Thread.currentThread().getName() + " : " + this.count);
    }

}
