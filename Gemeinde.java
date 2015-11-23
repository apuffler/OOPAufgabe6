
public class Gemeinde {

    public final String name;
    public MyList forstbetrieb;

    public Gemeinde(String name){
        this.name = name;
        this.forstbetrieb = new MyList();
    }

    public void addForstbetrieb(Forstbetrieb fb){
        this.forstbetrieb.add(fb);
    }

    public void removeForstbetrieb(){
        //todo
    }

    public String toString(){
        return "";
    }
}
