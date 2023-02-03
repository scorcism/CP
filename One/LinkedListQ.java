// class Node{
// 	int data;
// 	Node next;

// 	Node(int data){
// 		this.data= data;
// 		this.next = null;
// 	}
// }
class Node{
	int data;
	Node next;
    Node random;

	Node(int data){
		this.data= data;
		this.next = null;
		this.random = null;
	}
}

public class LinkedListQ {
   
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
        Node headnext = head.next;
        headnext.next = head;
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

    // remove the cycle from the linekd list
    public static void removeLoop(Node head){
        Node meet = detectCycle(head);

        Node ptr1 = meet;
        Node ptr2 = meet;
        
        Node prevNode = ptr1;
        while(ptr1.next != ptr2){
            prevNode = ptr1;
            ptr1 = ptr1.next;
        }
        prevNode.next = null;
        
    }

    // clone a linked list with nect and random pointer
    /*
     *  Node{
     *      int data;
     *      Node next;
     *      Node random;
     *    }
     */
    public static Node cloneLL(Node head){
        Node curr = head;

        // creating new node and puttingg it in between
        while(curr!= null){
            Node tmp = curr.next;
            curr.next =new Node(curr.data);
            curr.next.next = tmp;
            curr =tmp;
        }
        curr = head;

        // setting up random pointer of new node
        while(curr!= null){
            if(curr.next!=null){
                curr.next.random = (curr.random != null) ? curr.random.next : null;
            }
            curr = curr.next.next;
        }

        // seperate both the linked list
        Node original = head;
        Node copy = head.next;
        Node tmp = copy;

        while(original != null){
            original.next  = original.next.next;
            copy.next = copy.next.next;

            original = original.next;
            copy = copy.next;
        }
        return tmp;
    }

    public static void main(String[] args) {
        
    }
}