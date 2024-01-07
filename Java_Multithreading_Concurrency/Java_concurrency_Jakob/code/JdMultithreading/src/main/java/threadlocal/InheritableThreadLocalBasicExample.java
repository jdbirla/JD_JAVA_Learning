package threadlocal;

public class InheritableThreadLocalBasicExample {
    public static void main(String[] args){
        ThreadLocal<String> threadLocal = new ThreadLocal<>();
        InheritableThreadLocal<String> inheritableThreadLocal =
                new InheritableThreadLocal<>();

        Thread thread1 = new Thread(
                ()-> {
                    System.out.println("=== Thread 1===");
                    threadLocal.set("Thread 1 - ThreadLocal");
                    inheritableThreadLocal.set("Thread 1 - Inheritable Thread Local");

                    System.out.println(threadLocal.get());
                    System.out.println(inheritableThreadLocal.get());

                    Thread childThread = new Thread(() -> {
                        System.out.println("======== Child Thread =======");
                        System.out.println(threadLocal.get());
                        System.out.println(inheritableThreadLocal.get());
                    });

                    childThread.start();
                }

        );

        thread1.start();

        Thread thread2 = new Thread(
                () -> {
                    try {
                        Thread.sleep(3000);
                    }catch(InterruptedException e){
                        e.printStackTrace();
                    }

                    System.out.println("===== Thread 2 ======");
                    System.out.println(threadLocal.get());
                    System.out.println(inheritableThreadLocal.get());
                }
        );
        thread2.start();
    }
}
