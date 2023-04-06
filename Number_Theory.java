import java.util.ArrayList;

public class Number_Theory {
    public static void main(String[] args) {
        // half in CP4.java

    }

}

class NumberTheory{

    public void swapsingXor(int a, int b){
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + "b: " + b);
    }


    // Generate subset
    public static ArrayList<ArrayList<Integer>> subsets(int[] a){
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = a.length;
        int subset_count = (1<<n); // 2^n

        for(int mask = 0; mask < subset_count; mask++){
            ArrayList<Integer> subset = new ArrayList<>();

            // check for mask and ith value
            for(int i = 0; i< n; i++){
                if((mask & (1<<i))!=0){
                    subset.add(a[i]);
                }
            }
            ans.add(subset);
        }

        return ans;
    }
}
