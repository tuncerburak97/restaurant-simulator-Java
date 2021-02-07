package org.kodluyoruz;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Chef implements Runnable{

    int id;

    Waiter waiter;
    Customer customer;

    public Chef(int id,Waiter waiter){

        this.id=id;
        this.waiter=waiter;


    }


    @Override
    public void run() {



        System.out.println("Chef "+(id+1)+" preparing the order from waiter "+(waiter.id+1));

        try {
            Thread.sleep(400);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("************Chef " +(id+1) +" made a order for customer "+(customer.id + 1) + "************");

    }




}
