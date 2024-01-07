package threadlocal;

public class ThreadLocalRemovalExample {
    public static void main(String[] args){

        ThreadLocal<String> threadLocal =
                new ThreadLocal<>();

        Thread thread1 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        threadLocal.set("Thread 1");
                        String value = threadLocal.get();
                        System.out.println(value);

                        threadLocal.remove();
                        value = threadLocal.get();
                        System.out.println(value);
                    }
                }
        );

        Thread thread2 = new Thread(
                new Runnable() {
                    @Override
                    public void run() {
                        threadLocal.set("Thread 2");
                        String value = threadLocal.get();
                        System.out.println(value);

                        threadLocal.remove();
                        value = threadLocal.get();
                        System.out.println(value);
                    }
                }
        );

        thread1.start();
        thread2.start();

    }
}
