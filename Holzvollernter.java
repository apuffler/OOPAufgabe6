
public abstract class Holzvollernter{

    private static int num = 0;
    public int id;
    private int betriebsstunden;
    private Arbeitskopf aKopf;

    //ASSERT: int betriebsstunden muss >= 0 sein, Arbeitskopf arbeitskopf muss nicht NULL sein!
    public Holzvollernter(int betriebsstunden, Arbeitskopf arbeitskopf){

    	if (betriebsstunden < 0)
			throw new IllegalArgumentException("Holzvollernter, Holzvollernter: betriebsstunden müssen positiv sein!");
		if (arbeitskopf == null)
			throw new IllegalArgumentException("Holzvollernter, Holzvollernter: arbeitskopf darf nicht NULL sein!");

        this.id = this.num++;
        this.betriebsstunden = betriebsstunden;
        this.aKopf = arbeitskopf;
    }

    public int getID(){
    	return this.id;
    }
    
    public int getBetriebsstunden(){
        return this.betriebsstunden;
    }
	
	//ASSERT: int amount muss >= 0 sein!
    public void incBetriebsstunden(int amount){
    	if (amount < 0)
			throw new IllegalArgumentException("Holzvollernter, incBetriebsstunden: amount muss positiv sein!");

        this.betriebsstunden += amount;
    }

    //ASSERT: Arbeitskopf akopf muss nicht NULL sein!
    protected void neuerEinsatz(Arbeitskopf akopf){

		if (akopf == null)
			throw new IllegalArgumentException("Holzvollernter, incBetriebsstunden: amount muss positiv sein!");


        this.aKopf = akopf;
        this.betriebsstunden = 0;
    }

    public Arbeitskopf getArbeitskopf(){
        return this.aKopf;
    }

    public double getArbeitskopfDetails(){
        return this.aKopf.getDetail();
    }
}
