package loogodamner;

public class PairManagerTwo extends PairManager {
    public void increment(){
        Pair temp;
        synchronized (this){
            p.incrementX();
            p.incrementY();
            temp=getPair();
        }
        store(temp);
    }
}
