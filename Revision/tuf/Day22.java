import java.util.*;

public class Day22 {

    public static void main(String[] args) {
        // int[] A = { 1, 2, 1, 3, 4, 2, 3 };
        // int B = 4;
        // System.out.println(Arrays.toString(dNums(A, B)));

    }

    // Distinct Numbers in Window
    public static int[] dNums(int[] A, int B) {
        int i = 0;
        int j = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        ArrayList<Integer> ans = new ArrayList<>();
        while (j < A.length) {

            // calculations
            map.put(A[j], map.getOrDefault(A[j], 0) + 1);
            // if window size not achieved
            if ((j - i + 1) < B) {
                j++;
            }
            // after window size is acheived
            else if (j - i + 1 == B) {
                ans.add(map.size());
                map.put(A[i], map.get(A[i]) - 1);
                if (map.get(A[i]) == 0) {
                    map.remove(A[i]);
                }
                i++;
                j++;
            }
        }

        int[] arr = new int[ans.size()];
        for (int p = 0; p < arr.length; p++) {
            arr[p] = ans.get(p);
        }
        return arr;
    }

}

class KthLargest {

    PriorityQueue<Integer> pq;
    int K;

    public KthLargest(int k, int[] nums) {
        K = k;
        pq = new PriorityQueue<>();
        for (int n : nums) {
            pq.add(n);
        }
    }

    public int add(int val) {
        pq.add(val);
        if (pq.size() > K) {
            pq.poll();
        }
        return pq.peek();
    }
}

class MedianFinder {
    // max Heap
    PriorityQueue<Integer> smallNumbers = new PriorityQueue<>(Collections.reverseOrder());

    // min heap
    PriorityQueue<Integer> largeNumbers = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (smallNumbers.isEmpty() || smallNumbers.peek() >= num) {
            smallNumbers.add(num);
        } else {
            largeNumbers.add(num);
        }

        if (smallNumbers.size() > largeNumbers.size()) {
            largeNumbers.add(smallNumbers.poll());
        } else if (smallNumbers.size() < largeNumbers.size()) {
            smallNumbers.add(largeNumbers.poll());
        }
    }

    public double findMedian() {
        if (smallNumbers.size() == largeNumbers.size()) {
            return smallNumbers.peek() / 2.0 + largeNumbers.peek() / 2.0;
        }
        return smallNumbers.peek();
    }
}
