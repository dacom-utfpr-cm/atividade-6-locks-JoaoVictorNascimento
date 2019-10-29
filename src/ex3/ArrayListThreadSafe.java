package ex3;

import java.util.ArrayList;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.Lock;


public class ArrayListThreadSafe {

    private ReentrantReadWriteLock rrwLock = new ReentrantReadWriteLock();
    private Lock rLock = rrwLock.readLock();
    private Lock wLock = rrwLock.writeLock();
    private ArrayList items = new ArrayList<Object>(50);

    public void put(Object object){
        wLock.lock();
        try{
            items.add(object);
        }finally {
            wLock.unlock();
        }
    }

    public Object get(int index){
        rLock.lock();
        try{
            return items.get(index);
        }finally {
            rLock.unlock();
        }
    }
}