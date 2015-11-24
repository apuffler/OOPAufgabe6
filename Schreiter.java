
public class Schreiter extends Holzvollernter {

    private int schritte;

    // TODO: check for negative input?
    public Schreiter(int betriebsstunden, Arbeitskopf akopf, int schritte){
        super(betriebsstunden, akopf);

        if (schritte < 0)
			throw new IllegalArgumentException("Schreiter, Schreiter: int schritte darf nicht negativ sein!");

        this.schritte = schritte;
    }

    public int getSchritte(){
        return this.schritte;
    }

    // ASSERT: int amount darf nicht < 0 sein!
    public void incSchritte(int amount){

    	if (amount < 0)
			throw new IllegalArgumentException("Schreiter, incSchritte: int amount darf nicht negativ sein!");

        this.schritte += amount;
    }
    //ASSERT: Arbeitskopf akopf darf nicht NULL sein!
    public void aendereEinsatz(Arbeitskopf akopf){
    	
    	if (akopf == null)
			throw new IllegalArgumentException("Schreiter, aendereEinsatz: int amount darf nicht negativ sein!");

        this.neuerEinsatz(akopf);
        this.schritte = 0;
    }
}
