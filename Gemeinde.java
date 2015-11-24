
public class Gemeinde {

    public final String name;
    public MyList forstbetrieb;



    //ASSERT: String name darf nicht NULL sein!
    public Gemeinde(String name){
    	if (name == null)
			throw new IllegalArgumentException("Gemeinde, Gemeinde: String name darf nicht NULL sein!");
        this.name = name;
        this.forstbetrieb = new MyList();
    }
   
    public String getName(){
        return this.name;
    }

     //ASSERT: Forstbetrieb fb darf nicht NULL sein!
    public void addForstbetrieb(Forstbetrieb fb){
    	if (fb == null)
			throw new IllegalArgumentException("Gemeinde, addForstbetrieb: Forstbetrieb fb darf nicht NULL sein!");
        this.forstbetrieb.add(fb);
    }

    //ASSERT: String name darf nicht NULL sein!
    public void removeForstBetrieb(String name){
    	if (name == null)
			throw new IllegalArgumentException("Gemeinde, removeForstBetrieb: String name darf nicht NULL sein!");
        Forstbetrieb toBeRemoved = this.getForstBetrieb(name);
        forstbetrieb.remove(toBeRemoved);
    }
    //ASSERT: String name darf nicht NULL sein!
    public Forstbetrieb getForstBetrieb(String name){
    	if (name == null)
			throw new IllegalArgumentException("Gemeinde, getForstBetrieb: String name darf nicht NULL sein!");
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

    //TODO!
    public String toString(){
        return "";
    }

    public int getForstbetriebCount(){
        return this.forstbetrieb.size();
    }
}
