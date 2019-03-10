package Wax;

import java.util.concurrent.TimeUnit;

public class WaxOn implements Runnable{
    private Car car;
    public WaxOn(Car car){
        this.car = car;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                System.out.println("Wax on! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.waxed();
                car.waitForBuffed();
            }
        }catch (InterruptedException e){
            System.out.println("Exiting via interrupt");
        }
        System.out.println("Ending wax on task.");
    }
}
