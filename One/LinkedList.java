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

    // Pallindrome linkedlist
    public static boolean Pallindrome(Node head){
        if(head == null){
            return true;
        }
        Node mid = midOfLL(head);
        
        Node prev = null;
        Node currNode = mid.next;
        
        while(currNode != null || currNode.next != null){
            Node tmp = currNode.next;
            currNode.next = prev;
            prev = currNode;
            currNode = tmp;
        }
        Node last = prev;
        Node start = head;
        while(last != null){
            if(start.data != last.data){
                return false;
            }
            start = start.next;
            last = last.next;
        }
        return true;
    }
    
    // Detect cycle and return the node if not return null
    public static Node detectCycle(Node head){
        Node slow = head;
        Node fast = head;

        while(fast != null && fast.next != null){
            slow = slow.next;
            fast = fast.next.next;

            if(slow == fast){
                return slow;
            }
        }

        return null;
    }

    // detect a cycle and return the first node
    public static Node firstCycleNode(Node head){
        Node start = head;
        Node meet = detectCycle(head);

        while(start != meet){
            start = start.next;
            meet = meet.next;
        }
        return start;
    }


    public static void main(String[] args) {
        
    }
}