
public class Schneidkopf implements Arbeitskopf {

    private double maxLaenge;


    //ASSERT: double laenge darf nicht negativ sein!
    public Schneidkopf(double laenge){
    	if (laenge < 0)
			throw new IllegalArgumentException("Schneidkopf, Schneidkopf: double laenge darf nicht negativ sein!");

        this.maxLaenge = laenge;
    }

    public double getDetail(){
        return this.maxLaenge;
    }
}
