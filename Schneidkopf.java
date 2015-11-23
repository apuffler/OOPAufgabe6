
public class Schneidkopf implements Arbeitskopf {

    private double maxLaenge;

    public Schneidkopf(double laenge){
        this.maxLaenge = laenge;
    }

    public double getDetail(){
        return this.maxLaenge;
    }
}
