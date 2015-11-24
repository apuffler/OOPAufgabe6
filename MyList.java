
public class MyList {

    private Node head;
    private Node tail;
    int size;

    public MyList(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }


    public Node getHead(){
    	return this.head;
    }



    public void add (Object n){
    	if(n == null)
    		return;

        if(this.head == null){
            this.head = new Node(n);
            this.tail = this.head;
        }else{	
            this.tail.setNext(new Node(n));
            this.tail = this.tail.getNext();
        }
        this.size++;
    }

    
    //ASSERT: Object n darf nicht NULL sein!
    public void remove(Object n){
    	
    	if (n == null)
			throw new IllegalArgumentException("MyList, remove: Object n darf nicht NULL sein!");
		


    	if(this.head.getElement() == n){
    		if(this.head == null){
    			return;
    		}else{
                this.size--;
    			this.head = this.head.getNext();
    		}
    	}

    	Node previousNode = null;
    	Node currentNode = this.head;

    	while(currentNode != null){
    		if(currentNode.getElement() == n){
    			previousNode.setNext(currentNode.getNext());
    			this.size--;
    			break;
    		}

    		previousNode = currentNode;
    		currentNode = currentNode.getNext();
    	}
    }

    public int size(){
    	return this.size;
    }
}
