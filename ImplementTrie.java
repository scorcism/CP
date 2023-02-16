class Node{
    Node[] links = new Node[26];
    boolean flag = false;

    Node(){

    }

    boolean containsKey(char ch){
        return (links[ch - 'a'] != null);
    }

    void put(char ch, Node node){
        links[ch - 'a'] = node;
    }

    Node get(char ch){
        return links[ch-'a'];
    }

    void setEnd(){
        flag  = true;
    }

    boolean isEnd(){
        return flag;
    }
}

class Trie {
    // we require root node
    private static Node root;
    public Trie() {
        // When new object is created create new root node for each one
        root = new Node();

    }
    
    static public void insert(String word) {
        Node node = root; // tmp node for traversing the trie
        for(int i = 0; i< word.length(); i++){
            // check if current char is already presen or not
            if(!node.containsKey(word.charAt(i))){
                // if not present 
                // put the current character which reference to new refence
                node.put(word.charAt(i), new Node());
            }
            // move to the next referenc one
            node = node.get(word.charAt(i));
        }
        // at the end set the node set the reference of the last node flag to true as the word is done
        node.setEnd();
    }
    
    public boolean search(String word) {
        Node node= root;
        for(int i = 0; i< word.length(); i++){
            if(!node.containsKey(word.charAt(i))){
                return false;
            }
            node = node.get(word.charAt(i));
        }
        // check if the last refence node is true or node
        return node.isEnd();
    }
    
    public boolean startsWith(String prefix) {
        Node node = root;
        for(int i  = 0; i< prefix.length() ; i++){
            if(node.containsKey(prefix.charAt(i))){
                return false;
            }
            node = node.get(prefix.charAt(i));
        }    
        return true;
    }
}

public class ImplementTrie{
    public static void main(String[] args) {
        
    }
}