package ThreadLocalDemo;

import java.util.concurrent.*;

public class Main {
    public static void main(String[] args){
        ExecutorService exec = Executors.newCachedThreadPool();
        for(int i = 0; i < 5; i++){
            exec.execute(new Accessor(i));
        }
        try{
            TimeUnit.MILLISECONDS.sleep(2);
        }catch(InterruptedException ignore){
            //ignore
        }
        exec.shutdownNow();
    }
}
