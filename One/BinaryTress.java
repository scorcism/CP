import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.TreeMap;
import java.util.List;
import java.util.Map;

public class BinaryTress {

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

    static class BinaryTree {
        static int index = -1;

        Node buildTree(int[] nodes) {
            index++;

            if (nodes[index] == -1) {
                return null;
            }

            Node newNode = new Node(nodes[index]);

            newNode.left = buildTree(nodes);
            newNode.right = buildTree(nodes);

            return newNode;
        }
    }

    static void preOrder(Node root) {
        if (root == null) {
            return;
        }
        // Root Left Right

        System.out.print(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }

        // Left Root Right
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static void postOrder(Node root) {
        if (root == null) {
            return;
        }

        postOrder(root.left);
        postOrder(root.right);
        System.out.print(root.data + " ");
    }

    // Level order trversal
    static void levelOrder(Node root) {
        if (root == null) {
            // null Treee
            return;
        }
        Queue<Node> q = new LinkedList<>();
        // add the first root node to the queue and null for the next line as level will
        // end by adding 1st node as there will be only one node at level 1
        q.add(root);
        q.add(null);

        while (!q.isEmpty()) {
            // get the front element
            Node currNode = q.remove();
            // check if the current element is null
            if (currNode == null) {
                // print next line
                System.out.println();

                // if the null is the last elemnt in the queue then break the loop
                if (q.isEmpty()) {
                    break;
                } else {
                    // again add the null
                    q.add(null);
                }
            } else {
                // if thee current node i not null
                // print it
                System.out.print(currNode.data + " ");

                // if left of the currNode not is not null add it to the queu
                if (currNode.left != null) {
                    q.add(currNode.left);
                }
                if (currNode.right != null) {
                    q.add(currNode.right);
                }
            }
        }
    }

    static int countNodes(Node root) {
        if (root == null) {
            return 0;
        }

        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    static int sumOfNode(Node root) {
        if (root == null) {
            return 0;
        }

        int sumLeft = sumOfNode(root.left);
        int sumRight = sumOfNode(root.right);

        return sumLeft + sumRight + root.data;
    }

    static int height(Node root) {
        if (root == null) {
            return 0;
        }

        int leftHeight = height(root.left);
        int rightHeight = height(root.right);

        int maxHeight = Math.max(leftHeight, rightHeight) + 1;

        return maxHeight;
    }

    static int diameter(Node root) {
        if (root == null) {
            return 0;
        }
        // Left node
        int dim1 = diameter(root.left);
        // Right Node
        int dim2 = diameter(root.right);
        // Including root
        // get max height from the left node and get max height from the right node +
        // the root node itself
        int dim3 = height(root.left) + height(root.right) + 1;
        return Math.max(dim3, Math.max(dim1, dim2));
    }

    static class TreeInfo {
        int height;
        int diameter;

        TreeInfo(int h, int d) {
            this.height = h;
            this.diameter = d;
        }
    }

    static TreeInfo diameter2(Node root) {

        if (root == null) {
            return new TreeInfo(0, 0);
        }

        TreeInfo left = diameter2(root.left);
        TreeInfo right = diameter2(root.right);

        int currHeight = Math.max(left.height, right.height) + 1;

        int diam1 = left.diameter;
        int diam2 = right.diameter;
        int diam3 = left.height + right.height + 1;

        int mydiam = Math.max(Math.max(diam1, diam2), diam3);

        TreeInfo myInfo = new TreeInfo(currHeight, mydiam);

        return myInfo;
    }

    static int maxNode(Node root) {
        if (root == null) {
            return Integer.MIN_VALUE;
        }

        return Math.max(root.data, Math.max(maxNode(root.left), maxNode(root.right)));
    }

    static void leftView(Node root) {
        List<Integer> list = new ArrayList<>();
        leftViewUtil(root, list, 0);
    }

    static void leftViewUtil(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (list.get(level) == null) {
            list.set(level, root.data);
        }
        leftViewUtil(root.left, list, level + 1);
        leftViewUtil(root.right, list, level + 1);
    }

    static void rightView(Node root) {
        List<Integer> list = new ArrayList<>();

        rightViewUtil(root, list, 0);
    }

    static void rightViewUtil(Node root, List<Integer> list, int level) {
        if (root == null) {
            return;
        }
        if (list.get(level) == null) {
            list.set(level, root.data);
        }
        rightViewUtil(root.right, list, level + 1);
        rightViewUtil(root.left, list, level + 1);
    }

    static class TopView {
        int horizontal_distance;
        Node node;

        TopView(int hd, Node node) {
            this.horizontal_distance = hd;
            this.node = node;
        }
    }

    // Top view of a binary tree
    static ArrayList<Integer> topView(Node root) {

        // to store the ans
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TopView> q = new LinkedList<TopView>();

        q.add(new TopView(0, root));

        while (!q.isEmpty()) {
            TopView currNode = q.remove();
            int hd = currNode.horizontal_distance;
            Node n = currNode.node;

            if (map.get(hd) == null) {
                map.put(hd, n.data);
            }

            if (n.left != null) {
                q.add(new TopView(hd - 1, n.left));
            }

            if (n.right != null) {
                q.add(new TopView(hd + 1, n.right));
            }
        }

        // put all the value of the map to arraylist

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    // Bottom view of a binary tree
    static ArrayList<Integer> bottomiew(Node root) {

        // to store the ans
        ArrayList<Integer> ans = new ArrayList<>();

        if (root == null) {
            return ans;
        }
        Map<Integer, Integer> map = new TreeMap<>();

        Queue<TopView> q = new LinkedList<TopView>();

        q.add(new TopView(0, root));

        while (!q.isEmpty()) {
            TopView currNode = q.remove();
            int hd = currNode.horizontal_distance;
            Node n = currNode.node;

            map.put(hd, n.data);

            if (n.left != null) {
                q.add(new TopView(hd - 1, n.left));
            }

            if (n.right != null) {
                q.add(new TopView(hd + 1, n.right));
            }
        }

        // put all the value of the map to arraylist

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            ans.add(entry.getValue());
        }

        return ans;
    }

    // lowest common ancistors
    public static Node lca(Node root, int n1, int n2) {

        if(root == null){
            return null;
        }

        if (root.data == n1 || root.data == n2) {
            return root;
        }

        // call for left side and call for right side
        Node left = lca(root.left, n1, n2);
        Node right = lca(root.right, n1, n2);

        if (left == null) {
            return right;
        }
        if (right == null) {
            return left;
        }
        return root;
    }

    static int burnTree(Node root){
        int ans = 0;

        return ans;
    }

    static class Vertical{
        int hd;
        Node node;
        Vertical(int data, Node n){
            this.hd = data;
            this.node = n;
        }

    }


    // Vertical order traversal
    static void verticalTraversal(Node head){
        // using level order traveral and a queue
        // using horizontal distance 

        Queue<Vertical> q = new LinkedList<>();
        Map<Integer, ArrayList<Integer>> map = new TreeMap<>();

        q.add(new Vertical(0, head) );
        while(!q.isEmpty()){
            Vertical currNode = q.poll();

            if(map.containsKey(currNode.hd)){
                map.get(currNode.hd).add(currNode.node.data);
            }else{
                ArrayList<Integer> tmp = new ArrayList<>();
                tmp.add(currNode.node.data);
                map.put(currNode.hd, tmp);
            }

            if(currNode.node.left != null){
                q.add(new Vertical(currNode.hd -1 , currNode.node.left));
            }
            if(currNode.node.right != null){
                q.add(new Vertical(currNode.hd +1, currNode.node.right));
            }
        }
        ArrayList<Integer> ans = new ArrayList<>();
        for(Map.Entry<Integer, ArrayList<Integer>> entry: map.entrySet()){
            ans.addAll(entry.getValue());
        }
    }


    public static void main(String[] args) {

        int[] nodes = { 1, 2, 4, -1, -1, 5, -1, -1, 3, -1, 6, -1, -1 };

        BinaryTree b = new BinaryTree();
        Node root = b.buildTree(nodes);
        // System.out.println(root.data);

        // System.out.println("Pre order");
        // preOrder(root);
        // System.out.println("\nIn order");
        // inOrder(root);
        // System.out.println("\nPost order");
        // postOrder(root);

        // System.out.println("Level order traversal");
        // levelOrder(root);

        // System.out.println("Count number of Nodes: " );
        // System.out.println(countNodes(root));

        // System.out.println("Sum of Nodes");
        // System.out.println(sumOfNode(root));

        // System.out.println("Height of a Tree");
        // System.out.println(height(root));

        // System.out.println("Diameter of a Tree");
        // System.out.println(diameter(root));

    }
}
