
public class Schreiter extends Holzvollernter {

    private int schritte;

    // TODO: check for negative input?
    public Schreiter(int betriebsstunden, Arbeitskopf akopf, int schritte){
        super(betriebsstunden, akopf);
        this.schritte = schritte;
    }

    public int getSchritte(){
        return this.schritte;
    }

    // TODO: check for negative input?
    public void incSchritte(int amount){
        this.schritte += amount;
    }

    public void aendereEinsatz(Arbeitskopf akopf){
        this.neuerEinsatz(akopf);
        this.schritte = 0;
    }
}
