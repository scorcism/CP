class Node{
	int data;
	Node next;

	Node(int data){
		this.data= data;
		this.next = null;
	}
}

public class LinkedList {
   
    // reverse a linked list
    public static Node reverseIteratv(Node head){
        Node prev = null;
        Node curr = head;

        while(curr != null){
            Node tmp = curr.next;
            curr.next  = prev;
            prev  = curr;
            curr = tmp;
        }
        return prev;
    }

    public static Node reverseRecrsive(Node head){
        if(head == null || head.next == null){
            return head;
        }

        Node newHeadNode = reverseRecrsive(head.next);
        Node newhead = head.next;
        newhead.next = head;
        head.next = null;

        return newHeadNode;
    }

    private static Node midOfLL(Node head){
        Node slow = head;;
        Node fast = head;
        while(fast != null && fast.next  != null){
            slow = slow.next;
            fast = fast.next.next;            
        }
        return slow;
    }


    public static void main(String[] args) {
        
    }
}
