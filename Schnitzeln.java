
public class Schnitzeln implements Arbeitskopf {

    private int maxDicke;

    public Schnitzeln(int dicke){
        this.maxDicke = dicke;
    }

    public double getDetail(){
        return (double)this.maxDicke;
    }
}
