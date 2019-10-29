package ex1;

import java.util.concurrent.locks.ReentrantLock;

public class Counter {
    int counterValue = 0;
    final ReentrantLock lock = new ReentrantLock();

    public void increment(int value) {
        lock.lock();
        try {
            counterValue+=value;
        } finally {
            lock.unlock();

        }
    }
    public void decrement(int value) {
        lock.lock();
        try {
            counterValue-=value;
        } finally {
            lock.unlock();
        }
    }

    public int getValue(){
        return counterValue;
    }
}
