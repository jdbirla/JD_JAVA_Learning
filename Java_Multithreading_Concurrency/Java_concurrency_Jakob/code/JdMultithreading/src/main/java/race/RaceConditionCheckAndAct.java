package race;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by jd birla on 12-07-2023 at 14:38
 */
public class RaceConditionCheckAndAct {

    public static void main(String[] args) {
        Map<String, String> sharedMap = new ConcurrentHashMap<>();

        Thread thread1 = new Thread(getRunnable(sharedMap));
        Thread thread2 = new Thread(getRunnable(sharedMap));
        thread1.start();
        thread2.start();


    }

    public static Runnable getRunnable(Map<String, String> sahredMap) {
        return () -> {
            for (int i = 0; i < 1_000_000; i++) {
                synchronized (sahredMap) {
                    if (sahredMap.containsKey("key")) {
                        String val = sahredMap.remove("key");
                        if (val == null) {
                            System.out.println("Iteration: " + i + ": Value for 'key' was null");
                        }
                    } else {
                        sahredMap.put("key", "value");
                    }
                }
            }
        };
    }
}
