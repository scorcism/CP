class Node {
    Node links[] = new Node[26];

    boolean containsKey(char ch) {
        return (links[ch - 'a'] != null);
    }

    Node get(char ch) {
        return links[ch - 'a'];
    }

    void put(char ch, Node node) {
        links[ch - 'a'] = node;
    }

}

public class TrieQ2 {

    static int countDistinctSubstring(String s) {
        int count = 0;
        // initial root as a new node
        Node root = new Node();

        for (int i = 0; i < s.length(); i++) {
            Node node = root;
            for (int j = i; j < s.length(); j++) {
                if (!node.containsKey(s.charAt(i))) {
                    count++;
                    node.put(s.charAt(i), new Node());
                }
                node = node.get(s.charAt(i));
            }
        }
        return count + 1;
    }

    public static void main(String[] args) {

    }
}
