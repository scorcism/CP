import java.util.ArrayList;

public class BinarySearchTreeRecap {

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node buildTree(Node root, int data) {
        if (root == null) {
            root = new Node(data);
            return root;
        }
        if (data < root.data) {
            root.left = buildTree(root.left, data);
        } else {
            root.right = buildTree(root.right, data);
        }
        return root;
    }

    static void inOrder(Node root) {
        if (root == null) {
            return;
        }
        inOrder(root.left);
        System.out.print(root.data + " ");
        inOrder(root.right);
    }

    static boolean search(Node root, int value) {
        if (root == null) {
            return false;
        }
        if (value < root.data) {
            return search(root.left, value);
        } else if (value > root.data) {
            return search(root.right, value);
        } else if (root.data == value) {
            return true;
        }
        return false;
    }

    public static Node delete(Node root, int data) {
        // reach to theat node aka find that elemet
        if (data < root.data) {
            root.left = delete(root.left, data);
        } else if (data > root.data) {
            root.right = delete(root.right, data);
        }
        // at this point we are at that node

        else {

            // case 1
            // Node is the leaf node
            if (root.left == null && root.right == null) {
                return null;
            }

            // case 2
            // one of the side is empty and we have to delete that node only
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }

            // case 3
            // Root is the parent node so we have to replace the data with the inorder
            // successor of that node
            // In order successor is the lefit most child in the right side of that node

            // This funtion will return the left most child
            Node IS = inorderSuccesor(root.right);
            // replace the data of the node to the data of the inorder successor
            root.data = IS.data;
            // delete that in order successor node
            delete(root.right, IS.data);
        }
        return root;

    }

    private static Node inorderSuccesor(Node root) {
        while (root.left != null) {
            root = root.left;
        }
        return root;
    }

    public static void printInRange(Node root, int X, int Y) {
        if (root == null) {
            return;
        }
        if (root.data >= X && root.data <= Y) {
            printInRange(root.left, X, Y);
            System.out.println(root.data + " ");
            printInRange(root.right, X, Y);
        } else if (X >= root.data) {
            printInRange(root.right, X, Y);
        } else {
            printInRange(root.left, X, Y);
        }
    }

    public static void root2Leaf(Node root, ArrayList<Integer> path) {
        if (root == null) {
            return;
        }
        path.add(root.data);
        if (root.left == null && root.right == null) { // Leaf Node
            System.out.println(path);
        } else {
            // Non-Leaf Node
            root2Leaf(root.left, path);
            root2Leaf(root.right, path);
        }
        path.remove(path.size() - 1);
    }

    // Method 1
    // will check with the max and min range
    static boolean isBST(Node root) {
        return isBSTUtil(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    static boolean isBSTUtil(Node root, int min, int max) {
        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }

        return isBSTUtil(root.left, min, root.data - 1) && isBSTUtil(root.right, root.data + 1, max);
    }

    // Method 2
    // using a previous check
    static Node prev = null;

    static boolean isBST2(Node root) {
        if (root != null) {

            if (root.data <= prev.data && prev != null) {
                return false;
            }
            if (!isBST2(root.left)) {
                return false;
            }
            prev = root;
            return isBST2(root.right);
        }
        return true;
    }

    static int floor(Node root, int key) {
        Node tmp = root;
        int ans = Integer.MAX_VALUE;
        while (tmp != null) {
            if (tmp.data == key) {
                return tmp.data;
            }
            if (key < tmp.data) {
                // answe can be present here,
                tmp = tmp.left;
            } else {
                // if not in left side it will definatlry in the right side
                ans = tmp.data;
                tmp = tmp.right;
            }
        }
        return ans;
    }

    static int ceil(Node root, int key) {
        int ans = Integer.MIN_VALUE;

        while (root != null) {
            if (root.data == key) {
                return root.data;
            }
            if (root.data < key) {
                ans = root.data;
                root = root.right;
            } else {
                root = root.left;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] values = { 5, 1, 3, 4, 2, 7 };
        Node root = null;

        for (int i = 0; i < values.length; i++) {
            root = buildTree(root, values[i]);
        }

        inOrder(root);
        // System.out.println();

        // if (search(root, 4i)) {
        // System.out.println("Found");
        // } else {
        // System.out.println("NOT Found");
        // }
        System.out.println(isBST(root));
    }
}
