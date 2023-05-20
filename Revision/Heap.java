import java.util.*;

public class Heap {
    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        System.out.println(kthSmallest(arr, 3));
    }


    

    // k largest -> k + largest => create min heap

    // kth smallest element
    static int kthSmallest(int arr[], int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());

        for (int n : arr) {
            pq.add(n);
            if (pq.size() > k) {
                pq.remove();
            }
        }
        return pq.peek();
    }
}
