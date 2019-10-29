package ex1;

import java.util.concurrent.locks.ReentrantLock;

public class CounterThread extends Thread {
    Counter counter;
    Boolean operation;
    String name;
    Integer value;

    CounterThread(Counter counter, Boolean operation, String name, Integer value){
        this.counter = counter;
        this.operation = operation;
        this.name = name;
        this.value = value;
    }

    @Override
    public void run() {
        while(true) {
            try{
                if(operation == Boolean.FALSE){
                    Thread.sleep(1000);
                    System.out.println(this.name + " " + "Increment Thread: " + counter.getValue());
                    counter.increment(this.value);
                } else {
                    Thread.sleep(1000);
                    System.out.println(this.name + " " + "Decrement Thread: " + counter.getValue());
                    counter.decrement(this.value);
                }
            } catch (InterruptedException error){
                error.printStackTrace();
            }

        }
    }

}
