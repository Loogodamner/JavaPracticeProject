package ToastOMatic;

public class Toast {
    public enum Status {
        DRY,BUTTERED,JAMMED
    }
    private Status status = Status.DRY;
    private final int id;
    public Toast(int id){
        this. id = id;
    }
    public void butter(){
        status = Status.BUTTERED;
    }
    public void jam(){
        status = Status.JAMMED;
    }
    public Status getStatus(){
        return status;
    }
    public int geiId(){
        return id;
    }
    public String toString(){
        return "Toast " + id +": " + status;
    }
}
