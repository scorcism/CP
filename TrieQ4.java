import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

class Node{
    Node links[] = new Node[2];


    boolean containsKey(int bit){
        return (links[bit] != null);
    }

    void put(int bit, Node node){
        links[bit] = node;
    }

    Node get(int bit){
        return links[bit];
    }
}   

class Trie{
    private static Node root;
    Trie(){
        root = new Node();
    }

    void insert(int num){
        Node node = root;

        for(int i = 31; i>= 0; i--){
            int bit = (num >> i) & 1;
            if(!node.containsKey(bit)){
                node.put(bit, new Node());
            }
            node = node.get(bit);
        }
    }

    int getMax(int num){
        Node node  = root;
        int maxNum = 0;
        for(int i  =31; i>= 0; i--){
            int bit = (num >> i) &1;
            if(node.containsKey(1-bit)){
                maxNum = maxNum | (1<<i);
            }else{
                node = node.get(bit);
            }
        }
        return maxNum;
    } 
}


public class TrieQ4 {
    
    static ArrayList<Integer> maxXorQueries(ArrayList<Integer> arr, List<List<Integer>> queries){
        Collections.sort(arr);
        
        ArrayList<ArrayList<Integer>> offlineQueies = new ArrayList<ArrayList<Integer>>();

        int m = queries.size();

        for(int i = 0; i< m ; i++){
            ArrayList<Integer> q = new ArrayList<>();
            q.add(queries.get(i).get(1));
            q.add(queries.get(i).get(0));
            q.add(i);
            offlineQueies.add(q);
        }
        Collections.sort(offlineQueies, new Comparator<ArrayList<Integer>>() {
            public int compare(ArrayList<Integer> a , ArrayList<Integer> b){
                return a.get(0).compareTo((b.get(0)));
            }
        });

        ArrayList<Integer> ans = new ArrayList<>(m);
        int ind = 0;
        int n = arr.size();
        Trie trie = new Trie();

        for(int i = 0; i< m; i++){
            ans.add(-1);
        }
        for(int i = 0 ; i<m ; i++){
            while(ind < n && arr.get(ind) <= offlineQueies.get(i).get(0)){
                trie.insert(arr.get(ind));
                ind++;
            }
            int queryInd = offlineQueies.get(i).get(2);
            if(ind != 0) {
                ans.set(queryInd, trie.getMax(offlineQueies.get(i)));
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        
    }
}
