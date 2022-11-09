import java.util.PriorityQueue;
import java.util.Queue;

public class PQ {
    public static void main(String[] args) {
        Queue<Integer> pq = new PriorityQueue<>();
        pq.add(12);
        pq.add(2);
        pq.add(56);
        pq.add(90);
        pq.add(34);

        // System.out.println(pq);
        
        System.out.println(pq.peek());

        pq.remove();
        System.out.println(pq);
        
        System.out.println(pq.peek());

        pq.remove();
        System.out.println(pq);
        
    }
}
