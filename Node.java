
public class Node {
	private Object element;
    private Node next;

    public Node(Object element, Node next){
    	this.element = element;
    	this.next = next;
    }

    public Node(Object element){
    	this.element = element;
    	this.next = null;
    }

    public Object getElement(){
    	return this.element;
    }

    public Node getNext(){
    	return this.next;
    }

    public boolean hasNext(){
    	return this.next != null;
    }

    public void setNext(Node next){
    	this.next = next;
    }
}