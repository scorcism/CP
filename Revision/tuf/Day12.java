import java.util.*;

public class Day12 {

    public static void main(String[] args) {
        int[] A = { 1, 4, 2, 3 };
        int[] B = { 2, 5, 1, 6 };
        int C = 4;
        // System.out.println(Arrays.toString(maximumSumCombination(A, B, C)));
        int K = 3;
        // int arr[][] = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };
        // System.out.println(mergeKArrays(arr, K));

    }

    
    // Function to merge k sorted arrays.
    public static ArrayList<Integer> mergeKArrays(int[][] arr, int K) {
        // Write your code here.
        PriorityQueue<mk> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        for (int i = 0; i < K; i++) {
            pq.add(new mk(arr[i][0], 0, i));
        }

        ArrayList<Integer> ans = new ArrayList<>();

        while (!pq.isEmpty()) {
            mk curr = pq.poll();
            ans.add(curr.val);
            if (curr.i + 1 < (arr[curr.array].length)) {
                pq.add(new mk(arr[curr.array][curr.i + 1], curr.i + 1, curr.array));
            }
        }

        return ans;
    }

    static class mk {
        int val;
        int i;
        int array;

        mk(int val, int i, int a) {
            this.val = val;
            this.i = i;
            this.array = a;
        }
    }

    class MedianFinder {

        PriorityQueue<Integer> smallNumbers = new PriorityQueue<>(Collections.reverseOrder()); // max heap
        PriorityQueue<Integer> largeNumbers = new PriorityQueue<>(); // min heap

        public MedianFinder() {

        }

        public void addNum(int num) {
            if (smallNumbers.isEmpty() || smallNumbers.peek() >= num) {
                smallNumbers.add(num);
            } else {
                largeNumbers.add(num);
            }

            // comparing size coz both should have same number of elements or max heap that
            // is smallnumber shoud have 1 more then large numbers
            if (smallNumbers.size() > largeNumbers.size() + 1) {
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

    // Maximum Sum Combination
    public static int[] maximumSumCombination(int[] A, int[] B, int C) {
        Arrays.sort(A);
        Arrays.sort(B);
        int[] ans = new int[C];
        PriorityQueue<msc> pq = new PriorityQueue<>((a, b) -> b.sum - a.sum);
        HashSet<mscij> set = new HashSet<>();

        pq.offer(new msc(A[C - 1] + B[C - 1], C - 1, C - 1));
        set.add(new mscij(C - 1, C - 1));
        int p = 0;
        while (p < C) {
            msc val = pq.poll();
            int sum = val.sum;
            int i = val.i;
            int j = val.j;
            ans[p++] = sum;
            // i-1,j && i,j-1 not already in pq i.e set
            if (i > 0 && !set.contains(new mscij(i - 1, j))) {
                pq.offer(new msc(A[i - 1] + B[j], i - 1, j));
                set.add(new mscij(i - 1, j));
            }
            if (j > 0 && !set.contains(new mscij(i, j - 1))) {
                pq.offer(new msc(A[i] + B[j - 1], i, j - 1));
                set.add(new mscij(i, j - 1));
            }
        }
        System.out.println();
        return ans;
    }

    static class mscij {
        int i;
        int j;

        mscij(int i, int j) {
            this.i = i;
            this.j = j;
        }
    }

    static class msc {
        int sum;
        int i;
        int j;

        msc(int s, int i, int j) {
            this.sum = s;
            this.i = i;
            this.j = j;
        }
    }
}
