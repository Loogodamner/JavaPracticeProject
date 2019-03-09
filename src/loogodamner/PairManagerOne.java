package loogodamner;

public class PairManagerOne extends PairManager {
    public synchronized void increment(){
        p.incrementX();
        p.incrementY();
        store(getPair());
    }
}
