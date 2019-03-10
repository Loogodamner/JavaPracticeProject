package ThreadLocalDemo;

import java.util.Random;

public class ThreadLocalVariableHolder {
    private static ThreadLocal<Integer> value =
            new ThreadLocal<Integer>(){
                private Random rand = new Random(1122);
                protected synchronized Integer initialValue(){
                    return rand.nextInt(1000);
                }
            };

    public static void increment(){
        value.set(value.get()+1);
    }
    public static int get(){
        return value.get();
    }
}
