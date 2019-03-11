package ToastOMatic;

public class Butterer implements Runnable {
    /*
        Butter machine
     */
    private ToastQueue dryQueue,butterQueue;
    public Butterer(ToastQueue dryQueue,ToastQueue butterQueue){
        this.dryQueue = dryQueue;
        this.butterQueue = butterQueue;
    }
    public void run(){
        try{
            while(!Thread.interrupted()){
                Toast t = dryQueue.take();
                t.butter();
                System.out.println(t);
                butterQueue.put(t);
            }
        }catch(InterruptedException e){
            System.out.println("Buttered interrupted.");
        }
        System.out.println("Butter off.");
    }
}
