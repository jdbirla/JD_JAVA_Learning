package lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by jd birla on 12-07-2023 at 16:10
 */
public class CalculationReentranceLock {
    public static final int UNSPECIFIED = -1;
    public static final int ADDITION = 0;
    public static final int SUBTRACTION = 1;
    int type = UNSPECIFIED;
    public double value;

    public CalculationReentranceLock(int type, double value) {
        this.type = type;
        this.value = value;
    }

    private double result = 0.0;
    Lock lock = new ReentrantLock();

    public void add(double value)
    {
        try {
            lock.lock();
            this.result += value;
        }finally {
            lock.unlock();
        }
    }
    public void substract(double value)
    {
        try {
            lock.lock();
            this.result -= value;
        }finally {
            lock.unlock();
        }
    }
    public void calculate(CalculationReentranceLock... calculations){
        try{
            lock.lock();
            for (CalculationReentranceLock cal : calculations)
            {
                switch (cal.type){
                    case CalculationReentranceLock.ADDITION -> {
                        add(cal.value);
                        break;
                    }
                    case CalculationReentranceLock.SUBTRACTION -> {
                        add(cal.value);
                        break;
                    }

                }
            }
        }finally {
            lock.unlock();
        }
    }

}
