
public class Node {
	private Object element;
    private Node next;


    //ASSERT: Object element und Node next dürfen nicht NULL sein!
    public Node(Object element, Node next){
    	if (element == null)
			throw new IllegalArgumentException("MyList, remove: Object n darf nicht NULL sein!");

		if (next == null)
			throw new IllegalArgumentException("MyList, remove: Object n darf nicht NULL sein!");

    	this.element = element;
    	this.next = next;
    }
    //ASSERT: Object element darf nicht NULL sein!
    public Node(Object element){
    	if (element == null)
			throw new IllegalArgumentException("MyList, remove: Object n darf nicht NULL sein!");

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

    //ASSERT: Node next darf nicht null sein!
    public void setNext(Node next){

    	if (next == null)
			throw new IllegalArgumentException("MyList, remove: Object n darf nicht NULL sein!");

    	this.next = next;
    }
}