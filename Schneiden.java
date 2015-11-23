
public class Schneiden implements Arbeitskopf {

    private double maxLaenge;

    public Schneiden(double laenge){
        this.maxLaenge = laenge;
    }

    public double getDetail(){
        return this.maxLaenge;
    }
}
