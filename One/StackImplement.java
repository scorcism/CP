// Implement stack using linked list

class StackLL {
    class Node {
        int data;
        Node next;

        Node(int d) {
            this.data = d;
            this.next = null;
        }
    }

    int size;
    Node head;

    StackLL() {
        head = null;
        size = 0;
    }

    public void push(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        size++;
        head = newNode;
    }

    public int pop() throws Exception {
        if (head == null) {
            throw new Exception("No element in stack");
        }
        int ans = head.data;
        head = head.next;
        size--;
        return ans;
    }

    public void printStackLL() {
        Node tmp = head;
        while (tmp != null) {
            System.out.print(tmp.data);
            System.out.print(" -> ");
            tmp = tmp.next;
        }
    }
}

public class StackImplement {
    public static void main(String[] args) {

        StackLL s = new StackLL();

        s.push(10);
        s.push(1);
        s.push(54);
        s.push(89);

        s.printStackLL();
        System.out.println();

        try {
            System.out.println(s.pop());
        } catch (Exception e) {
            System.out.println(e);
        }

        s.printStackLL();
        System.out.println();
    }
}
