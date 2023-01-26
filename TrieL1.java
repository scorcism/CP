class Node {
    Node links[] = new Node[26];
    boolean flag = false;

    Node() {

    }

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void setEnd() {
        flag = true;
    }

    boolean isEnd() {
        return flag;
    }

}

public class TrieL1 {

    private Node root;

    TrieL1() {
        root = new Node();
    }

    // Insert a word into the trie
    void insert(String word) {
        // while inserting with always started with the root
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // Check if the character exist or not in the trie
            if (!node.containsKey(word.charAt(i))) {
                // if the char is not present then we will put that into the links
                // at this point suppose the word is apple so apple's a will point to the new
                // node trie
                node.put(word.charAt(i), new Node());
            }
            // now goto that node
            // move to the reference trie
            node = node.get(word.charAt(i));
        }
        // at this time the node will be standing at the last refence trie
        // set end flag to true
        node.setEnd();
    }

    // Return if the word is in the trie
    boolean search(String word) {
        // start with the root node
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            // if it does bot contain word i means it does't exist
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        // At thsi point we are at the last node
        // now how to determine if thsi node is word
        // simple, the last flag has to be true
        return node.isEnd();
    }

    // Return if there is any word in the tree that startwtih
    boolean startswith(String prefix) {
        Node node = root;

        for (int i = 0; i < prefix.length(); i++) {
            // if it does bot contain word i means it does't exist
            if (!node.containsKey(prefix.charAt(i))) {
                return false;
            }
            node = node.get(prefix.charAt(i));
        }
        // if reached at this level return true, means there will be a word starting
        // with the prefix
        return true;
    }

    public static void main(String[] args) {

    }
}
