
public class Schnitzelkopf implements Arbeitskopf {

    private int maxDicke;
    //ASSERT: int dicke darf nicht negativ sein!
    public Schnitzelkopf(int dicke){
    	if (dicke < 0)
			throw new IllegalArgumentException("Schnitzelkopf, Schnitzelkopf: int dicke darf nicht negativ sein!");


        this.maxDicke = dicke;
    }

    public double getDetail(){
        return (double)this.maxDicke;
    }
}
