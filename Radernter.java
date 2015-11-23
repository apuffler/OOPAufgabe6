
public class Radernter extends Holzvollernter{

    private double wegstrecke;

    // TODO: check for negative input?
    public Radernter(int betriebsstunden, Arbeitskopf akopf, double wegstrecke){
        super(betriebsstunden, akopf);
        this.wegstrecke = wegstrecke;
    }

    public double getWegstrecke(){
        return this.wegstrecke;
    }

    // TODO: check for negative input?
    public void incWegstrecke(double amount){
        this.wegstrecke += amount;
    }

    public void aendereEinsatz(Arbeitskopf akopf){
        this.neuerEinsatz(akopf);
        this.wegstrecke = 0;
    }
}
