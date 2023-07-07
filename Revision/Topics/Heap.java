import java.util.*;

public class Heap {
    public static void main(String[] args) {
        int[] arr = { 7, 10, 4, 3, 20, 15 };
        System.out.println(kthSmallest(arr, 3));
    }

    // K Closest points to origin
    public int[][] kClosest(int[][] points, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>(
                (p1, p2) -> (p2[0] * p2[0]) + (p2[1] * p2[1]) - (p1[0] * p1[0]) + (p1[1] * p1[1]));

        for (int[] p : points) {
            pq.offer(p);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[][] ans = new int[k][2];
        while (k > 0) {
            ans[--k] = pq.poll();
        }
        return ans;
    }

    // Frequency sort
    /*
     * store in hashmap with n and count
     * then store that in max heap so max freq will be on the top
     * and iterate through the map and run another loop
     */

    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int n : map.keySet()) {
            pq.add(n);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        int[] ans = new int[2];
        ans[0] = pq.poll();
        ans[1] = pq.poll();
        return ans;
    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> ans = new ArrayList<>();

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) {
            if (k > 0) {
                pq.offer(n);
                k--;
            } else if (Math.abs(pq.peek() - x) > Math.abs(n - x)) {
                pq.poll();
                pq.offer(n);
            }
        }

        while (!pq.isEmpty()) {
            ans.add(pq.poll());
        }

        return ans;
    }

    // Sort a nearly sorted (or K sorted) array
    // Function to return the sorted array.
    ArrayList<Integer> nearlySorted(int arr[], int num, int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int n : arr) {
            pq.add(n);
            if (pq.size() > k) {
                ans.add(pq.poll());
            }
        }
        while (!pq.isEmpty()) {
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
