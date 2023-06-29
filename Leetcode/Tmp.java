import java.util.*;

public class Tmp {
    
    public static void main(String[] args) {
        
        HashSet<Node> set = new HashSet<>();
        HashSet<Character> set2 = new HashSet<>();
        HashMap<Character, Integer> map = new HashMap<>();

        set.add(new Node('c',2));
        set.add(new Node('a',5));
        set.add(new Node('d',4));

        set2.add('c');
        set2.add('a');
        set2.add('d');

        map.put('c',2);
        map.put('a',5);
        map.put('d',4);

        System.out.println(set);
        if(set.contains('c')){
            System.out.println("YES + 1");
        }

        if(set2.contains('c')){
            System.out.println("YES + 2");
        }

        if(map.containsKey('c')){
            System.out.println("YES + 3");
        }

    }

    static class Node{
        char character;
        int pos;
        Node(char c, int p){
            this.character = c;
            this.pos = p;
        }
    }

}

