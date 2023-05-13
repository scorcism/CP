package Leetcode;

import java.util.HashSet;

public class Main {

    public static void main(String[] args) {

    }





    
    // Biweekly Contest 104
    // https://leetcode.com/contest/biweekly-contest-104/problems/number-of-senior-citizens/
    public int countSeniors(String[] details) {
        int n = 0;
        for (String s : details) {
            int first = s.charAt(11) - '0';
            int second = s.charAt(12) - '0';
            // System.out.println("f: " + first);
            // System.out.println("s: " + second);
            //
            int age = (first * 10) + second;
            // System.out.println(age);
            // System.out.println(age + " age");

            if (age >= 60) {
                n++;
            }
        }
        return n;
    }

    public int matrixSum(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        long ans = 0;

        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, nums[j][i]);
            }
            ans += max;
        }
        return (int) ans;
    }

    public int matrixSum2(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        long ans = 0;
        HashSet<Integer> set = new HashSet<>();
        for (int i = 0; i < m; i++) {
            int max = 0;
            for (int j = 0; j < n; j++) {
                max = Math.max(max, nums[j][i]);
            }
            set.add(max);
            // ans+=max;
        }
        for (int i : set) {
            ans += i;
        }
        return (int) ans;
    }

    public long maximumOr(int[] nums, int k) {
        long ans = 0;

        long curr_ans = 0;
        for (int i = 0; i < nums.length; i++) {

            int num = nums[i];
            int num_choosen = nums[i];
            int t_k = k;
            while (t_k >= 0) {
                num *= 2;
            }

            curr_ans |= num;
            for (int nu = 0; nu < nums.length; nu++) {
                if (nums[nu] != num_choosen) {
                    curr_ans |= nums[nu];
                }
            }
            ans = Math.max(curr_ans, ans);
        }
        return ans;
    }

    public long maximumOrdp(int[] nums, int k) {
        return getmaxOr(nums, 0, 0, k, 0);
    }

    private long getmaxOr(int[] nums, int i, int prek, int k, long a) {
        if (i == nums.length) {
            return a;
        }
        while(prek<k){
            nums[i]*=2;
            prek++;
        }
        // long localans = 0;
        for(int p = 0; p< nums.length; p++){
            a|=nums[p];
        }

        long one= getmaxOr(nums, i, prek+1, k, a);
        long two= getmaxOr(nums, i+1, prek, k, a);
        return Math.max(one, two);
    }
}
