
class LL{

    private Node head;
    private Node tail;

    public LL(){
        this.size = 0;
    }


    private class Node{
        private int value;
        private Node next;
    }

    public Node(int value){
        this.value = value;
        // Node object always points to null
    }
    
    public Node(int value, Node next){
        this.value = value;
        this.next = next;
    }


}


public class LinkedList {
    LL list  = new LL();
    


}