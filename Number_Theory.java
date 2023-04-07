import java.util.ArrayList;

public class Number_Theory {
    public static void main(String[] args) {
        // half in CP4.java

    }

}

class NumberTheory {

    long binaryExponentiationRecur(int a, int b) {
        /*
         *if(b==0) return 1;
         *  if((b&1)!=0){
         * // if b is odd
         * return a * binaryExponentiationRecur(a, b/2) * binaryExponentiationRecur(a,
         * b/2);
         * }else{
         * return binaryExponentiationRecur(a, b/2) * binaryExponentiationRecur(a, b/2);
         * }
         */

        if(b==0){
            return 1;
        }

        long res = binaryExponentiationRecur(a, b/2);
        if((b&1)!=0){
            return a * res * res;
        }else{
            return res * res;
        }
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return ((a * b) / gcd(a, b));
    }

    public int minFraction(int a, int b) {
        return (a / gcd(a, b) / b / gcd(a, b));
    }

    public void swapsingXor(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + "b: " + b);
    }

    // Generate subset
    public static ArrayList<ArrayList<Integer>> subsets(int[] a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = a.length;
        int subset_count = (1 << n); // 2^n

        for (int mask = 0; mask < subset_count; mask++) {
            ArrayList<Integer> subset = new ArrayList<>();

            // check for mask and ith value
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(a[i]);
                }
            }
            ans.add(subset);
        }

        return ans;
    }
}
