
public class Schnitzelkopf implements Arbeitskopf {

    private int maxDicke;

    public Schnitzelkopf(int dicke){
        this.maxDicke = dicke;
    }

    public double getDetail(){
        return (double)this.maxDicke;
    }
}
