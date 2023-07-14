package memory.model;

/**
 * Created by jd birla on 11-07-2023 at 15:53
 */
public class SharedObjects {

    public static void main(String[] args) {
        PassingObject passingObject = new PassingObject();
        Runnable runnable = new MyRunnable(passingObject);
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable );

        thread1.start();
        thread2.start();
// Before synchronization
//        myObject : memory.model.MyObject@5d9c386
//        passingObject : memory.model.PassingObject@591e7753
//        myObject : memory.model.MyObject@3ff9a510
//        passingObject : memory.model.PassingObject@591e7753
//        Thread-0 : 886372
//        Thread-1 : 1868476

//After applying only synchronization
//        myObject : memory.model.MyObject@1648f0de
//        passingObject : memory.model.PassingObject@4c8f3013
//        myObject : memory.model.MyObject@65738596
//        passingObject : memory.model.PassingObject@4c8f3013
//        Thread-0 : 1954068
//        Thread-1 : 2000000




    }
}
