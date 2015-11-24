
public class Radernter extends Holzvollernter{

    private double wegstrecke;

    // ASSERT: double wegstrecke muss positiv sein!
    public Radernter(int betriebsstunden, Arbeitskopf akopf, double wegstrecke){

        super(betriebsstunden, akopf);

        if (wegstrecke < 0)
			throw new IllegalArgumentException("Radernter, Radernter: wegstrecke muss positiv sein!");

        this.wegstrecke = wegstrecke;
    }

    public double getWegstrecke(){
        return this.wegstrecke;
    }

     // ASSERT: double amount muss positiv sein!
    public void incWegstrecke(double amount){
    	 if (amount < 0)
			throw new IllegalArgumentException("Radernter, incWegstrecke: wegstrecke muss positiv sein!");


        this.wegstrecke += amount;
    }
      // ASSERT: Arbeitskopf akopf darf nicht NULL sein!
    public void aendereEinsatz(Arbeitskopf akopf){

    	if (akopf == null)
			throw new IllegalArgumentException("Radernter, aendereEinsatz: Arbeitskopf akopf muss nicht NULL sein!");


        this.neuerEinsatz(akopf);
        this.wegstrecke = 0;
    }
}
