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

class StackArray {
    int[] array;
    int size;
    int top;

    StackArray(int n) {
        array = new int[n];
        size = n;
        top = -1;
    }

    public void push(int data) {
        if (size - 1 == top) {
            System.out.println("Stack FULL");
        }
        top++;
        array[top] = data;
    }

    public int pop() {
        if (top == -1) {
            System.out.println("Stack is EMPTY");
        }
        int ans = array[top];
        top--;
        return ans;
    }
    
    public int peek(){
        if (top == -1) {
            System.out.println("Stack is EMPTY");
        }
        return array[top];
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void printStackArray(){
        for(int i = 0; i< top; i++){
            System.out.print(array[i] + " ");
        }
    }

}

public class StackImplement {
    public static void main(String[] args) {

        /*
         * 
         * // Stack using Linked list implementation
         * StackLL s = new StackLL();
         * 
         * s.push(10);
         * s.push(1);
         * s.push(54);
         * s.push(89);
         * 
         * s.printStackLL();
         * System.out.println();
         * 
         * try {
         * System.out.println(s.pop());
         * } catch (Exception e) {
         * System.out.println(e);
         * }
         * 
         * s.printStackLL();
         * System.out.println();
         */


        //  Stack using array
        StackArray s = new StackArray(15);
        
        s.push(10);
        s.push(65);
        s.push(43);
        s.push(1);
        
        s.printStackArray();
        System.out.println();

        System.out.println(s.pop() );
        s.printStackArray();
    }
}
