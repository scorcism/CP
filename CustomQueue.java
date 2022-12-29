
// using LL
class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class LLQueue {
    Node rare;
    Node front;

    void enqueue(int data) {
        Node newNode = new Node(data);

        // check if the there is no nodes
        if (front == null) {
            // if there is only 1 element in the list then the single element will be the
            // front and rare

            front = newNode;
            rare = newNode;
        }
        // if we have some elements in the queue
        // then move the rare one
        rare.next = newNode;
        rare = newNode;
    }

    int dequeue() throws Exception {
        // check if there is no element in the queue
        if (front == null) {
            throw new Exception("No element in the queue");
        }
        int ans = front.data;
        // move the front one
        front = front.next;
        return ans;
    }

    boolean isEmpty() {
        return rare == front;
    }
}

// using Array
class ArrayQueue{
    int[] arr;
    int rare;
    int capacity;

    ArrayQueue(int capacity){
        this.capacity = capacity;
        arr = new int[capacity];
        rare = -1;
    }

    void enqueue(int data) throws Exception{
        if(rare == capacity -1){
            throw new Exception("Stack is full");
        }
        // if array is not full
        rare++;
        arr[rare] = data;
    }

    int dequeue() throws Exception{
        if(rare == -1){
            // stack is empty
            throw new Exception("Stack is Empty");
        }
        int ans = arr[0]; // this is the front ele
        // move eyery element 1 step back
        for(int i = 0; i < rare; i++){
            arr[i] = arr[i+1];
        }
        rare--;
        return ans;
    }

}

// using Circular Array


public class CustomQueue {

    public static void main(String[] args) {

        /*
         * FIFO -> First In First Out
         * ----------------
         * <- 2 3 4 5 6 ->
         * ----------------
         * | |
         * front rare
         * | |
         * dequeue enqueue
         * 
         * enqueue -> put element into queue
         * dequeue -> pop element from the queue
         * 
         * front -> used for dequeue operation
         * rare -> used for enqueue operation
         * 
         * 
         */
    }

}
