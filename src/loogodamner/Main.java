package loogodamner;

public class Main {
    public static void main(String[] args){
        PairManager pman1 = new PairManagerOne();
        PairManager pman2 = new PairManagerTwo();
        CriticalSection.testApproaches(pman1,pman2);
    }
}
