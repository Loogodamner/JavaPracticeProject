package HorseRace;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class HorseRace {
    static final int FINISH_LINE = 75;
    private List<Horse> horses = new ArrayList<Horse>();
    private ExecutorService exec = Executors.newCachedThreadPool();
    private CyclicBarrier barrier;
    public HorseRace(int nHorses, final int pause){
        barrier = new CyclicBarrier(nHorses, new Runnable() {
            @Override
            public void run() {
                StringBuffer s = new StringBuffer();
                for(int i = 0; i < FINISH_LINE; i++){
                    s.append("=");
                }
                System.out.println(s);
                for(Horse horse:horses){
                    System.out.println(horse.tracks());
                }
                for(Horse horse:horses){
                    if(horse.getStrides() >= FINISH_LINE){
                        System.out.println(horse + " won!");
                        exec.shutdownNow();
                        return;
                    }
                }
                try{
                    TimeUnit.MILLISECONDS.sleep(pause);
                }catch (InterruptedException e){
                    System.out.println("barrier-action sleep interrupted");
                }
            }
        });
        for(int i = 0; i < nHorses; i++){
            Horse horse = new Horse(barrier);
            horses.add(horse);
            exec.execute(horse);
        }
    }
}
