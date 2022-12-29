
// using array
class ArrayStack{

    int array[]; // to store all the values
    int top; // Points towards the top eleme
    int capacity; // Capacity of the stack

    ArrayStack(int capacity){
        this.capacity = capacity;
        top = -1; // has in the start there will be no element
        array = new int[capacity];
    }

    // Basic methods of stack
    // push, pop, peek, isEmpty, size

    void push(int ele) throws Exception{
        // check if the array is already full or not
        // Overflow condition
        if(top == capacity -1 ){
            throw new Exception("Out of storage");
        }
        top++;
        array[top] = ele;
    }

    // return element which is removed (popped)
    int pop() throws Exception{
        // check if the array is empty or not
        // Underflow condition
        if(top == -1){
            throw new Exception("Stack is empty");
        }
        int ans = array[top];
        top--;
        return ans;
    }

    int peek(int index) throws Exception{
        // check if the array is empty or not
        // Underflow condition
        if(top == -1){
            throw new Exception("Stack is empty");
        }

        // return the top element of the stack
        return array[top];
    }

    boolean isEmpty(){
        return top == -1;
    }

    int size(){
        return top +1;
    }
}

// using Linked list
class Node{
    int data;
    Node next;
    Node(int data){
        this.data = data;
        this.next =null;
    }
}

class LLStack{
    Node head ;
    int size;

    LLStack(int data){
        head= null;
        size = 0;
    }

    void push(int data){
        Node newNode = new Node(data);
        newNode.next  = head;
        size++;
        head = newNode;
    }
    
    int pop() throws Exception{
        if(head == null){
            throw new Exception("Stack is empty");
        }
        int ans = head.data;
        head = head.next;
        return ans;
    }

    int peek() throws Exception{
        if(head == null){
            throw new Exception("Stack is Empty");
        }
        return head.data;
    }

    int size(){
        return size;
    }

}

class CustomStack{
    public static void main(String[] args) {
        
    }

    
}