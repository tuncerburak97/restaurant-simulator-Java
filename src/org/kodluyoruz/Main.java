package org.kodluyoruz;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        ExecutorService customerExecuter = Executors.newFixedThreadPool(5);
        ExecutorService waiterExecuter = Executors.newFixedThreadPool(3);
        ExecutorService chefExecuter = Executors.newFixedThreadPool(2);


        for(int i=0;i<10;i++){

            Thread.sleep(50);
            customerExecuter.execute(new Customer(i));
            Thread.sleep(200);
            waiterExecuter.submit(new Waiter(new Customer(i),i%3));
            Thread.sleep(200);
            chefExecuter.submit(new Chef(i%2,new Waiter(new Customer(i),i%3)));
            Thread.sleep(300);


        }

        customerExecuter.shutdown();
        waiterExecuter.shutdown();
        chefExecuter.shutdown();

        try{
            customerExecuter.awaitTermination(30, TimeUnit.MINUTES);
            waiterExecuter.awaitTermination(5,TimeUnit.MINUTES);
            chefExecuter.awaitTermination(45,TimeUnit.MINUTES);


        }catch (InterruptedException e){
            e.printStackTrace();
        }

        System.out.println("All customer is leaved");


    }
    }

