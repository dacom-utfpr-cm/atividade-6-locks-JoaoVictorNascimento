
package ex2;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class SharedFifoQueue {
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition notFull  = lock.newCondition();
    private final Condition notEmpty = lock.newCondition();

    private final Object[] items = new Object[100];

    private int countValue = 0;

    public void put(Object value) throws InterruptedException{
        lock.lock();
        try{
            while(countValue == items.length){
                notFull.await();
            }
            items[countValue] = value;
            if(++countValue == items.length) countValue = 0;
            System.out.println("Size Queue: " + countValue);
            countValue++;
            notEmpty.signal();
        } finally {
            lock.unlock();
        }
    }

    public Object take() throws InterruptedException {
        lock.lock();
        try {
            while(countValue == 0){
                notEmpty.await();
            }
            if(--countValue == -1) countValue = 1;
            System.out.println("Size Queue: " + countValue);
            countValue--;
            notFull.signal();
            return items[countValue];
        }finally {
            lock.unlock();
        }
    }
}
