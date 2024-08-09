package com.jd.thread.datasharing.stack;

public class StackMemory {
    public static void main(String[] args) {
        int x = 1;
        int y = 2;
        int result = sum(x,y);
    }

    private static int sum(int a, int b) {
        int s = a + b;
        return s;
    }
}
