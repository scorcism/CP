import java.util.ArrayDeque;
import java.util.Queue;

public class Questions {

    class NodeF{
        int data;
        NodeF next;
        NodeF child;

        NodeF(int n){
            this.data = n;
            this.next = null;
            this.child = null;
        }
    }    


    // Flattening a linked list
    // TC-SC-O(n)
    static NodeF flatLL(NodeF head){
        NodeF curr = head;
        Queue<NodeF> qq = new ArrayDeque<>();

        while(curr!=null){

            // last node in the row is reached
            if(curr.next == null){
                curr.next = qq.poll();
            }

            // if child node is presnet
            if(curr.child != null){
                qq.add(curr.child);
            }
            curr = curr.next;
        }

        return head;
    }

    public static void main(String[] args) {
        
    }
}
