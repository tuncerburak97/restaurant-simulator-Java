package org.kodluyoruz;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Waiter implements Runnable {

    Customer customer;
    int id;
    Chef chef;


    Waiter(Customer customer, int id) {

        this.customer = customer;
        this.id = id;
        this.chef = chef;

    }


    @Override
    public void run() {


        System.out.println("Waiter "+(id+1) +"take the order from customer "+(customer.id+1));

        try {
            Thread.sleep(250);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("************Waiter " + (id + 1) + " served a order for customer " + (customer.id+ 1) + "************");


    }

}

