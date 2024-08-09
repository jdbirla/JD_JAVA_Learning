package com.jd.thread.creation;

import java.util.ArrayList;
import java.util.List;

public class MultiExecutor {
    // Add any necessary member variables here
    List<Thread> allTasks = new ArrayList<>();

    /*
     * @param tasks to executed concurrently
     */
    public MultiExecutor(List<Runnable> tasks) {
        // Complete your code here
        for (Runnable r : tasks) {
            allTasks.add(new Thread(r));

        }


    }

    /**
     * Starts and executes all the tasks concurrently
     */
    public void executeAll() {
        // complete your code here
        for (Thread t : allTasks) {
            t.start();
        }
    }
}
