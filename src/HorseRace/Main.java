package HorseRace;

public class Main {
    public static void main(String[] args){
        int nHorses = 7;
        int pause = 200;
        if(args.length > 0){
            int n = new Integer(args[0]);
            nHorses = n > 0 ? n : nHorses;
        }
        if(args.length > 1){
            int p = new Integer(args[1]);
            pause = p > -1 ? p : pause;
        }
        new HorseRace(nHorses,pause);
    }
}
