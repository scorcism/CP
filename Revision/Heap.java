import java.util.*;

public class Heap {
    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        System.out.println(kthSmallest(arr, 3));
    }


    // Sort a nearly sorted (or K sorted) array
    //Function to return the sorted array.
    ArrayList <Integer> nearlySorted(int arr[], int num, int k)
    {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int n: arr){
            pq.add(n);
            if(pq.size() > k){
                ans.add(pq.poll());
            } 
        }
        while(!pq.isEmpty()){
            ans.add(pq.poll());
        }
        return ans;
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
