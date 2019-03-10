package Wax;

import java.util.concurrent.TimeUnit;

public class WaxOff implements Runnable {
    private Car car;
    public WaxOff(Car car){
        this.car = car;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                car.waitForWaxing();
                System.out.print("Wax off! ");
                TimeUnit.MILLISECONDS.sleep(200);
                car.buffed();
            }
        }catch (InterruptedException e){
            System.out.println("Force to wax off!");
            System.out.println("Exiting via interrupt.");
        }
        System.out.println("Ending wax off task.");
    }
}