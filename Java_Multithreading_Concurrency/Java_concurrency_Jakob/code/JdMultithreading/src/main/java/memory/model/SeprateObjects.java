package memory.model;

/**
 * Created by jd birla on 11-07-2023 at 15:49
 */
public class SeprateObjects {

    public static void main(String[] args) {
        PassingObject passingObject = new PassingObject();
        Runnable runnable1 = new MyRunnable(passingObject);
        Runnable runnable2 = new MyRunnable(passingObject);
        Thread thread1 = new Thread(runnable1);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();

        //Before synchronization
//        myObject : memory.model.MyObject@75e8f4d
//        myObject : memory.model.MyObject@1e5b17c2
//        passingObject : memory.model.PassingObject@6c014956
//        passingObject : memory.model.PassingObject@6c014956
//        Thread-1 : 1000000
//        Thread-0 : 1000000
        //After synchronization

//        myObject : memory.model.MyObject@5d9c386
//        passingObject : memory.model.PassingObject@591e7753
//        myObject : memory.model.MyObject@2024773f
//        passingObject : memory.model.PassingObject@591e7753
//        Thread-1 : 1000000
//        Thread-0 : 1000000
    }
}
