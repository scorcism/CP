import java.util.Comparator;
import java.util.PriorityQueue;

class Huffman {

    static class Node{
        int data;
        char c;

        Node left;
        Node right;
    }

    // comparator class helps to compare the node
    // on the basis of one of its attribute.
    // Here we will be compared
    // on the basis of data values of the nodes.
    public static class MyComparator implements Comparator<Node> {
        public int compare(Node x, Node y)
        {
    
            return x.data - y.data;
        }
    }

    public static void printCode(Node root, String s){
        // base case
        // If the left and right node are null
        // means it is the leaf node
        
        if(root.left == null && root.right == null && Character.isLetter(root.c)){

            // c is the character in the node
            System.out.println(root.c  + ": "  + s);
            return;
        }
        // if we go to the left we will add 0 
        // if we go to the right we will add 1
        
        // recursiverly call for the left and right 
        printCode(root.left,s+"0");
        printCode(root.right,s+"1");
    }

    public static void main(String[] args) {
        // number of characters.
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        // creating a priority queue q.
        // makes a min-priority queue(min-heap).
        PriorityQueue<Node> q
        = new PriorityQueue<Node>(n, new MyComparator());

        for(int i = 0; i< n; i++){

            // Creating a huffman node object and addingg it to the priority queue.

            Node node = new Node();

            node.c = charArray[i];
            node.data = charfreq[i];
            
            node.left = null;
            node.right = null;

            // add functions adds the huffman node to the queue.
            q.add(node);
        }
        Node root = null;
    
        // Here we will extract the two minimum value
        // from the heap each time until
        // its size reduces to 1, extract until
        // all the nodes are extracted.

        while(q.size() > 1){
         
            // first min extract.
            Node x = q.peek();
            q.poll();

            // second min extract.
            Node y = q.peek();
            q.poll();

            // new node which will be the sum of the frequncy of the two min values
            Node f = new Node();
            f.data = x.data + y.data;

            f.c = '-';

            f.left = x;
            f.right = y;

            // making f as the root node
            root = f;

            // adding this node to the queue
            q.add(f);
        }

        // print the codes by traversing the tree
        printCode(root,"");

    }
}