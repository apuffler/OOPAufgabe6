
public class MyList {

    public Node head;
    public Node tail;

    public MyList(){
        this.head = null;
        this.tail = null;
    }

    public MyList(Node n){
        this.head = n;
        this.tail = n;
    }

    public void add (Node n){
        if(this.head == null){
            this.head = n;
            this.tail = n;
        }else{
            // todo: check for datatype: Holzvollertner oder Forstbetrieb
            if((this.head instanceof Holzvollernter && n instanceof Forstbetrieb) || (this.head instanceof Forstbetrieb && n instanceof Holzvollernter)){
                throw new IllegalArgumentException("Holzvollernter und Forstbetriebe duerfen nicht in die selbe Liste eingetragen werden");
            }
            this.tail.next = n;
            this.tail = this.tail.next;
        }
    }
}
