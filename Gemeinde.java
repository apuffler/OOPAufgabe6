
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

    public void removeForstBetrieb(String name){
        Forstbetrieb toBeRemoved = this.getForstBetrieb(name);
        forstbetrieb.remove(toBeRemoved);
    }

    public Forstbetrieb getForstBetrieb(String name){
    	Node currentNode = forstbetrieb.getHead();
    	while(currentNode != null){
    		Forstbetrieb element = (Forstbetrieb)currentNode.getElement();
    		if(element.getName().equals(name)){
    			return element;
    		}
    		currentNode = currentNode.getNext();
    	}
    	return null;
    }

    public String toString(){
        return "";
    }
}
