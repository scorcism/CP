
class QueueLL {

    class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    Node front, rare;

    public void enque(int data) {
        Node newNode = new Node(data);

        if (front == null) { // Empty queue check
            front = rare = newNode;
        }

        rare.next = newNode;
        rare = newNode;
    }

    public int dequeue() {
        if (rare == null) {
            System.out.println("Queue is Empty");
        }

        int ans = front.data;
        front = front.next;

        return ans;
    }

}

class QueueArray {
    int array[];
    int size;
    int rare;
    // front will always be array[0]

    QueueArray(int n) {
        array = new int[n];
        size = n;
        rare = -1;
    }

    public void enqueue(int n) {
        if (rare == size - 1) {
            System.out.println("Queue FULL");
        }
        rare++;
        array[rare] = n;
    }

    public int dequeue() {
        if (rare == -1) {
            System.out.println("Stack is empty");
        }
        int ans = array[0];

        for (int i = 0; i < rare; i++) {
            array[i] = array[i + 1];
        }
        rare--;
        return ans;
    }
}

class CircularQueue {

    int[] array;
    int n;
    int rare = -1;
    int front = -1;

    CircularQueue(int n) {
        this.n = n;
        array = new int[n];
    }

    public void enqueue(int n) {
        // check for array full
        if ((rare + 1) % n == front) {
            return;
        }
        if (front == -1)
            front = 0;
        rare = (rare + 1) % n;
        array[rare] = n;
    }

    public int dequeue() {
        if (front == -1) {
            System.out.println("Q is Empty");
        }
        int result = array[front];
        if (front == rare) {
            front = rare = -1;
        } else {
            front = (front + 1) % n;
        }
        return result;
    }

}

public class QueueImplement {
    public static void main(String[] args) {

    }
}
