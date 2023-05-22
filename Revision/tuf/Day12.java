import java.util.*;

public class Day12 {

    public static void main(String[] args) {
        int[] A = { 1, 4, 2, 3 };
        int[] B = { 2, 5, 1, 6 };
        int C = 4;
        // System.out.println(Arrays.toString(maximumSumCombination(A, B, C)));

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
