package race;

public class RaceConditionsExample4 {
    public static void main(String[] args){

        Counter counter1 = new Counter();
        Counter counter2 = new Counter();

        Thread thread1 = new Thread(getRunnable(counter1,counter2,"Thread1 Final Count: "));
        Thread thread2 = new Thread(getRunnable(counter2,counter1,"Thread2 Final Count: "));

        thread1.start();
        thread2.start();
    }

    public static Runnable getRunnable(Counter counterA, Counter counterB, String runnableName){
        return () -> {
            for(int i = 0; i < 1_000_000;i++){
                counterA.incAndGet();
            }
            System.out.println(runnableName + " final count - CounterA:  " + counterA.get());
            System.out.println(runnableName + " final count - CounterB:  " + counterB.get());
        };

    }
}
