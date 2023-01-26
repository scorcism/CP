class Node {
    Node links[] = new Node[26];
    boolean flag;

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

class Trie {
    private Node root;

    Trie() {
        root = new Node();
    }

    public void insert(String word){
        Node node = root;
        for(int i = 0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
        }
        node.setEnd();
    }

    public boolean checkIfPrefixExists(String word) {
        boolean flag = true;
        Node node  = root;

        for(int i = 0; i< word.length() && flag; i++){
            if(node.containsKey(word.charAt(i))){
                node = node.get(word.charAt(i));
                flag = flag & node.isEnd();
            }else{
                return false;
            }
        }
        return flag;
    }
}

public class TrieQ1 {

    // Longest Word With All Prefixes | Complete String | Trie

    static String completeString(int n, String[] a) {
        Trie obj = new Trie();
        for (int i = 0; i < n; i++) {
            obj.insert(a[i]);
        }
        String longesString = "";

        for (int i = 0; i < n; i++) {
            if (obj.checkIfPrefixExists(a[i])) {

                if (a[i].length() > longesString.length()) {
                    longesString = a[i];
                } else if (a[i].length() == longesString.length() && a[i].compareTo(longesString) < 0) {
                    longesString = a[i];
                }
            }
        }
        if(longesString == ""){
            return "None";
        }

        return longesString;
    }

    public static void main(String[] args) {

    }
}
