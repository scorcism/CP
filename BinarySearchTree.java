import java.util.ArrayList;

public class BinarySearchTree {
    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public static Node insert(Node root, int val) {
        if (root == null) {
            root = new Node(val);
            return root;
        }

        if (root.data > val) {
            root.left = insert(root.left, val);
        } else {
            root.right = insert(root.right, val);
        }
        return root;
    }

    public static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    public static boolean search(Node root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data > key) {
            return search(root.left, key);
        } else if (root.data == key) {
            return true;
        } else {
            return search(root.right, key);
        }
    }

    public static Node delete(Node root, int val) {
        // first we will search the element
        if (root.data > val) {
            // After deleting that node we will attach the entire to the left side of the
            // Tree
            root.left = delete(root.left, val);

        } else if (root.data < val) {
            root.right = delete(root.right, val);

        } else { 
            // The Node we want to delete root.data == val
             // CASE 1
            if(root.left == null & root.right == null){
                return null;
            }
            //  CASE 2
            if (root.left == null){ // Element will ne pn right node
                return root.right;
            }
            else if(root.right == null){
                return root.left;
            }

            // CASE 3
            // Here, first of all we have to find our inorder successor
            // left most element in right subtree
            Node IS = inOrderSuccessor(root.right);
            root.data = IS.data;
            // root ke right me jana hai and inorder successor ko delete kar dena hai 
            // From here we will get our modified right sub Tree
            root.right = delete(root.right, IS.data);
        }
        return root;
    }

    public static Node inOrderSuccessor(Node root){
        // Loop jab tak chalega tab tak hume left most child nahi mil jata
        // Searching the extreme left element
        while(root.left != null){
            root  = root.left;
        }
        return root;
    }

    public static void searchInRange(Node root, int X, int Y){
        if(root==null){
            return;
        }
        if(root.data >= X && root.data <= Y){
            // Means we have elements in left side and right side
            searchInRange(root.left,X,Y);
            System.out.print(root.data + " ");
            searchInRange(root.right,X,Y);
        }
        else if(root.data < Y){
            searchInRange(root.left, X, Y);
        }else if( root.data > X){
            searchInRange(root.right, X, Y);
        }
    }

    public static void root2Leaf(Node root, ArrayList<Integer> paths){
        if(root == null ){
            return;
        }
        paths.add(root.data); // Add current element to the array list
        
        // If the current node is the last node
        if(root.left == null && root.right == null){
            printPath(paths); // Print the array lisy
        }
        // Non root element
        else{   
            root2Leaf(root.left, paths);
            root2Leaf(root.right, paths);
        }
        // Now we are backtracing as we reached to the last node and we also printed it
        //  Removee last element for the arrya list
        paths.remove(paths.size()-1);
    }
    public static void printPath(ArrayList<Integer> paths){
        for (int i = 0; i < paths.size(); i++) {
            System.out.print(paths.get(i) + "-> ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        System.out.println("Henlo");
        int[] values = { 8,5,3,6,10,11,14 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = insert(root, values[i]);
        }
        inOrder(root);
        System.out.println();
        // if (search(root, 10)) {
        //     System.out.println("Found");
        // } else {
        //     System.out.println("Not Found");
        // }
        // delete(root, 4);
        // inOrder(root);
        // searchInRange(root, 4, 7);
        root2Leaf(root, new ArrayList<>());
    }
}
