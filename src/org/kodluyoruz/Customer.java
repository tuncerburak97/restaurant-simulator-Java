package org.kodluyoruz;
public class Customer extends Thread{

    int id;

    public Customer (int numberOfCustomer){

        this.id=numberOfCustomer;


    }


    @Override
    public void run() {

        System.out.println("Customer "+(id+1)+" coming in restaurant and sitting table:"+(id+1)%6);

        try {
            Thread.sleep(600);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("************Customer "+(id+1)+" stand up table from :"+(id+1)%6+  " and leaved in restaraunt************");

    }


}
