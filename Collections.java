import java.util.HashMap;
import java.util.Map;

public class Collections{

    /* 
     * Arraylist
     * Linkedlist
     * Stack
     * 
     * Queue
     * LinkedList
     * PriorityQueue
     * ArrayDequeue
     * 
     * Set
     * HashSet
     * LinkedHashSet
     * TreeSet
     * 
     * Map
     * TreeMap
     * HashMap
     * 
     * Class
     * CollectionClass
     * ArrayClass
    */

    public static void main(String[] args) {
        hashMap();
    }


    public static void hashMap(){
        int[] array = {1,2,3,4,5,6,7,8,9,1,2,3};
        Map<Integer,Integer> hm = new HashMap<>();
        hm.put(1,1);
        hm.put(2,12);
        hm.put(3,3);
        hm.put(1,1);

        System.out.println("Hello");
        System.out.println(hm.get(2));


        // for (Map.Entry<Integer,Integer> data : hm.entrySet()) {
        //     System.out.println(data.getKey());
        //     System.out.println(data.getValue());
        // }

    }
}