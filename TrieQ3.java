
class Node{

    Node links[]  = new Node[2];
    Node(){

    }

    boolean containKey(int index){
        return (links[index] != null);
    }

    Node get (int index){
        return links[index];
    }

    void put(int index, Node node){
        links[index] = node;
    }
}

class Trie{
    private static Node root;
    Trie(){
        root = new Node();
    }

    // insert
    void insert(int num){
        Node node  = root;
        for(int i = 31; i>= 0; i--){
            int bit = (num >>i) & 1;
            if(!node.containKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int getMax(int num){
        Node node = root;
        int maxNum = 0;
        for(int i  = 31; i>=0; i--){
            int bit = (num >> i) & 1;
            if(node.containKey(1-bit)){
                maxNum = maxNum | (1<<i);
                node = node.get(1-bit);
            }else{
                node = node.get(bit);
            }
        }
        return maxNum;
    }
}


public class TrieQ3 {
    public static void main(String[] args) {
        
    }

    static int maxXor(int n, int m, int[] ar1, int[] ar2){
        Trie trie = new Trie();

        for(int i = 0 ; i< n; i++){
            trie.insert(ar1[i]);
        }
        int maxi = 0;
        for(int i = 0; i< m ; i++){
            maxi = Math.max(maxi, trie.getMax(ar2[i]));
        }

        return maxi;
    }
}
