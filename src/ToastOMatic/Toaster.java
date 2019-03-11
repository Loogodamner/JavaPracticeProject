package ToastOMatic;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Toaster implements Runnable {
    /*
        create toast
    */
    private ToastQueue toastQueue;
    private int count = 0;
    private Random rand = new Random(1122);
    public Toaster(ToastQueue tq){
        toastQueue = tq;
    }
    public void run(){
        try{
            while (!Thread.interrupted()){
                TimeUnit.MILLISECONDS.sleep(100+rand.nextInt(500));
                Toast t = new Toast(count++);
                System.out.println(t);
                toastQueue.put(t);
            }
        }catch(InterruptedException e){
            System.out.println("Toaster interrupted.");
        }
        System.out.println("Toaster off.");
    }
}
