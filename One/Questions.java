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

    static NodeF flatLL2(NodeF head){
        
        NodeF curr = head;
        NodeF last = head;

        // move the last pointer to the last of the current list
        while(last.next != null){
            last = last.next;
        }
        // while the current node is brefore the last node
        while(curr != last){

            // if the current node has a child node then point ths last ndeo next to the child node
            if(curr.child != null){
                last.next= curr.child;

                // move the last to the last element of the current child.
                NodeF tmp = curr.child;
                while(last.next != null){
                    tmp = tmp.next;
                }
                last = tmp;
            }
            curr = curr.next;
        }


        return curr;
    }


    public static void main(String[] args) {
        
    }
}
