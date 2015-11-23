
public abstract class Holzvollernter extends Node{

    private static int num = 0;
    public int id;
    private int betriebsstunden;
    private Arbeitskopf aKopf;

    // TODO: check for negative input?
    public Holzvollernter(int betriebsstunden, Arbeitskopf arbeitskopf){
        this.id = this.num++;
        this.betriebsstunden = betriebsstunden;
        this.aKopf = arbeitskopf;
    }

    public int getBetriebsstunden(){
        return this.betriebsstunden;
    }

    // TODO: check for negative input?
    public void incBetriebsstunden(int amount){
        this.betriebsstunden += amount;
    }

    protected void neuerEinsatz(Arbeitskopf akopf){
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
