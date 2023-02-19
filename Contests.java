import java.util.*;

public class Contests {

    public static long findTheArrayConcVal(int[] nums) {
        int n = nums.length ;
        int start = 0;
        int end = n-1;
        long ans = 0;

        while (start < end) {
            int first = nums[start++];
            int last = nums[end--];

            String first_s = Integer.toString(first);
            String last_s = Integer.toString(last);

            String concat_string = first_s + last_s;

            int newNum = Integer.parseInt(concat_string);
            System.out.println("New Num:" + newNum);
            ans = ans + newNum;
        }
        // System.out.println(start + " " +end);

        if(start == end){
            ans  = ans + nums[start];
        }
        return ans;
    }

    public static long countFairPairs(int[] nums, int lower, int upper) {
        Arrays.sort(nums);
        long ans = 0;

        for (int i = 0; i < nums.length - 1; i++) {
            for (int j = 1; j < nums.length ; j++) {
                if (i < j) {
                    int index_sum = nums[i] + nums[j];
                    if(index_sum >= lower && index_sum <= upper){
                        // System.out.println(i + " "+j);
                        ans++;
                    }
                }
            }
        }
        return ans;
    }
    
    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {
        

    }
    
    public static void main(String[] args) {
        // int[] n = {0,1,7,4,4,5};
        // System.out.println(countFairPairs(n, 3, 6));
    
        // int[] n1= {7,52,2,4};
        // int[] n2 = {5,14,13,8,12};
        // System.out.println(findTheArrayConcVal(n3));
        // System.out.println(findTheArrayConcVal(n2));
        int[][] nums1 = {{1,2},{2,3},{4,5}}; 
        int[][] nums2 = {{1,4},{3,2},{4,1}};

        System.out.println();
    }

}
