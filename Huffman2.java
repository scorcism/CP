import java.util.*;

public class Huffman2 {
    static class Node{
        int data;
        char c;
        Node left = null;
        Node right = null;
    }

    static class MyCMP implements Comparator<Node>{
        public int compare(Node x, Node y){
            return x.data - y.data;
        }
    }

    public static void main(String[] args) {
        int n = 6;
        char[] charArray = { 'a', 'b', 'c', 'd', 'e', 'f' };
        int[] charfreq = { 5, 9, 12, 13, 16, 45 };

        PriorityQueue<Node> q = new PriorityQueue<>(n, new MyCMP());

        for(int i = 0; i< n; i++){
            Node node =  new Node();
            node.data = charfreq[i];
            node.c = charArray[i];

            node.left = null;
            node.right = null;

            q.add(node);
        }
        Node root = null;

        while(q.size() >1){
            Node x = q.peek();
            q.poll();

            Node y = q.peek();
            q.poll();

            Node d = new Node();
            d.data = x.data + y.data;
            d.c = '-';

            d.left = x;
            d.right = y;

            root = d;

            q.add(d);
        }
        printCode(root,"");
    }

    public static void printCode(Huffman2.Node root, String s) {
        // check if it is root node or not
        if(root.left == null && root.right==null && Character.isLetter(root.c)){
            System.out.println(root.c + " : " + s);
            return;
        }
        // if not leaf
        printCode(root.left,s  +"0"); // 0 for left
        printCode(root.right, s+"1");
    }
}
