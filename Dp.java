import java.util.*;

public class Dp {

    // Tabulation
    public static int CS_solve2(int n, int[] dp) {
        dp[0] = 0;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];
    }

    // Memoization
    public static int CS_solve1(int n, int[] dp) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return 1;
        }
        if (dp[n] != -1) {
            return dp[n];
        }

        return dp[n] = CS_solve1(n - 1, dp) + CS_solve1(n - 2, dp);
    }

    public static int climbStairs(int n) {
        int[] dp = new int[n + 1];
        ArraysQ.fill(dp, -1);
        // return CS_solve1(n, dp);
        return CS_solve2(n, dp);
    }

    static public int f(int index, int[] coins, int amount) {

        if (index == 0) {
            if ((amount % coins[index]) == 0) {
                return (amount / coins[index]);
            } else {
                return -1;
            }
        }
        // if(amount == 0){
        // return 1;
        // }
        // if(amount < 0){
        // return 0;
        // }

        // if(index <= 0){
        // return 0;
        // }
        int nottake = 0 + f(index - 1, coins, amount);
        int take = Integer.MAX_VALUE;
        if (coins[index - 1] <= amount) {
            take = 1 + f(index, coins, amount - coins[index - 1]);
        }

        return Math.min(take, nottake);

    }

    static public int coinChange(int[] coins, int amount) {
        return f(coins.length, coins, amount);
    }

    public static void brute_LIS(int[] nums, int size) {
        // This is to print all the subsequence

        int count = 0;
        // Getting all the row of length nums

        for (int i = 0; i < (1 << size); i++) {
            // to store value at each level measn row
            String value = "";
            // Iterating through the columns
            for (int j = 0; j < size; j++) {
                // check if the bit is set or not
                // for that row at that columns positon
                if ((i & (1 << j)) != 0) {
                    value = value + nums[j];
                    count++;
                }
            }
            System.out.println(value);
        }
        System.out.println("Count: " + count + " array size " + size);
    }

    public static int memoization_LIS(int index, int[] nums, int n, int prev_ind, int[][] dp) {
        // Base Case
        if (index == n) {
            return 0; // no element in the array
        }
        if (dp[index][index + 1] != 0) {
            return dp[index][index + 1];
        }
        // Not Take
        int len = 0 + memoization_LIS(index + 1, nums, n,
                prev_ind, dp);
        // Take
        if (prev_ind == -1 || nums[index] > nums[prev_ind]) {
            len = Math.max(len, 1 + memoization_LIS(index + 1, nums, n, index, dp));
        }
        return dp[index][index + 1] = len;
    }

    public static int recursion_LIS(int index, int[] nums, int n, int prev_ind) {
        // Base Case
        if (index == n) {
            return 0; // no element in the array
        }

        // Not Take
        int len = 0 + recursion_LIS(index + 1, nums, n,
                prev_ind);
        // Take
        if (prev_ind == -1 || nums[index] > nums[prev_ind]) {
            len = Math.max(len, 1 + recursion_LIS(index + 1, nums, n, index));
        }
        return len;
    }

    // Longest Increasing Subsequence
    static public void lengthOfLIS(int[] nums) {
        int size = nums.length;
        // brute_LIS(nums, size);

        // System.out.println(recursion_LIS(0, nums, size, -1));

        // for memozation
        int[][] dp = new int[nums.length][nums.length + 1];
        for (int row[] : dp)
            ArraysQ.fill(row, -1);

        System.out.println(memoization_LIS(0, nums, size, -1, dp));

        // return 10;
    }

    public static int LCS(int ind1, int ind2, String t1, String t2, int[][] dp) {
        if (ind1 < 0 || ind2 < 0) {
            return 0; // No character left
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        // Take the element at that index both inclusive
        if (t1.charAt(ind1) == t2.charAt(ind2)) {
            // Take that characters
            return dp[ind1][ind2] = 1 + LCS(ind1 - 1, ind2 - 1, t1, t2, dp);
        }
        return dp[ind1][ind2] = 0 + Math.max(LCS(ind1 - 1, ind2, t1, t2, dp), LCS(ind1, ind2 - 1, t1, t2, dp));
    }

    public static int LCS_coordinateShift(int ind1, int ind2, String t1, String t2, int[][] dp) {

        /*
         * int[][] dp = new int[text1.length()+1 ][text2.length() +1];
         * for (int[] arr : dp) {
         * Arrays.fill(arr,-1);
         * }
         * 
         * return LCS(text1.length() , text2.length(), text1, text2,dp);
         */

        if (ind1 == 0 || ind2 == 0) {
            return 0; // No character left
        }
        if (dp[ind1][ind2] != -1) {
            return dp[ind1][ind2];
        }

        // Take the element at that index both inclusive
        if (t1.charAt(ind1 - 1) == t2.charAt(ind2 - 1)) {
            // Take that characters
            return dp[ind1][ind2] = 1 + LCS(ind1 - 1, ind2 - 1, t1, t2, dp);
        }
        return dp[ind1][ind2] = 0 + Math.max(LCS(ind1 - 1, ind2, t1, t2, dp), LCS(ind1, ind2 - 1, t1, t2, dp));
    }

    public static int LCS_tabulation(String t1, String t2) {
        // If anyone of the character of that row either of t1 or t2 is 0 then return 0
        int[][] dp = new int[t1.length() + 1][t2.length() + 1];

        int ind1 = t1.length();
        int ind2 = t2.length();

        for (int i = 0; i <= ind1; i++)
            dp[i][0] = 0;
        for (int j = 0; j <= ind2; j++)
            dp[0][j] = 0;

        // iteratre in the matrix
        for (int i = 1; i <= ind1; i++) {
            for (int j = 1; j <= ind2; j++) {
                if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 0 + Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[ind1][ind2];
    }

    public static int LCS_spaceopt(String t1, String t2) {
        // If anyone of the character of that row either of t1 or t2 is 0 then return 0

        int ind1 = t1.length();
        int ind2 = t2.length();

        int[] prev = new int[ind1 + 1];
        int[] curr = new int[ind2 + 1];
        ArraysQ.fill(prev, -1);
        ArraysQ.fill(curr, -1);

        for (int j = 0; j < ind2; j++)
            prev[j] = 0;

        // iteratre in the matrix
        for (int i = 1; i <= ind1; i++) {
            for (int j = 1; j <= ind2; j++) {
                if (t1.charAt(i - 1) == t2.charAt(j - 1)) {
                    curr[j] = 1 + prev[j - 1];
                } else {
                    curr[j] = 0 + Math.max(prev[j], curr[j - 1]);
                }
            }
            prev = curr;
        }

        return prev[ind2];
    }

    // Longest Common Subsequence
    public static int longestCommonSubsequence(String text1, String text2) {

        int[][] dp = new int[text1.length()][text2.length()];

        for (int[] arr : dp) {
            ArraysQ.fill(arr, -1);
        }

        return LCS(text1.length() - 1, text2.length() - 1, text1, text2, dp);
    }

    static public boolean wordBreak(String s, List<String> wordDict) {

        Set<String> wordset = new HashSet(wordDict);
        boolean isWord[] = new boolean[s.length() + 1];
        isWord[0] = true;

        for (int i = 1; i < s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (isWord[j] && wordset.contains(s.substring(j, i))) {
                    isWord[i] = true;
                    break;
                }
            }
        }
        return isWord[s.length() + 1];
    }

    public static void CS(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base
        if (index == arr.length) {
            if (target == 0) {
                // add that ds at each level to our main answer
                ans.add(new ArrayList<>(ds));
            }
            return;
            // after adding that ds return form that level

        }

        // take the element
        // check if the element at that index is less then target if less then target
        // then only we can take that
        if (arr[index] <= target) {
            // take that element
            ds.add(arr[index]);
            CS(index, arr, target - arr[index], ans, ds);
            // remove the added element from the ds comming back from the recursion call
            ds.remove(ds.size() - 1);
        }
        // Do not take the element
        CS(index + 1, arr, target, ans, ds);
    }

    static public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        CS(0, candidates, target, ans, new ArrayList<>());
        // Here new ArrayList is used to store the localanser at that level
        // ans is used to store the final anser
        return ans;
    }

    static public int r1_space(int[] nums){

        int prev = nums[0];
        int prev2 = 0; // initially for the negative values

        for (int i = 1; i < nums.length; i++) {
            int take = nums[i];
            if(i>1){
                take += prev2;
            }
            int nottake = 0 + prev;

            int curri = Math.max(take,nottake);
            prev2 = prev;
            prev = curri;
        }
        return prev;
    }

    static public int r1_tabulation(int[] nums){
        int[] dp = new int[nums.length +1];

        dp[0] = nums[0];
        for(int i = 1; i< nums.length; i++){
            int take = nums[i];
            if(i>1){
                take  = take + dp[i-2];
            }
            int nottake = 0 + dp[i-1];

            dp[i] = Math.max(take,nottake);
        }

        return dp[0];
    }

    static public int r1(int[] nums, int index, int[] dp){
        // Base case
        if(index==0){
            return nums[index];
        } 
        if(index < 0){
            return 0;
        }
        if(dp[index] != -1){
            return dp[index] ;
        }

        // Pick
        int pick = nums[index] + r1(nums,index-2,dp);
        // Not Pick
        int notpick = 0 + r1(nums,index-1,dp);

        return dp[index] = Math.max(pick,notpick);

    }

    static public int rob1(int[] nums) {
        int[] dp = new int[nums.length +1];
        ArraysQ.fill(dp,-1);
        return r1(nums, nums.length-1,dp);
    }

    // House Robber II
    
    public static int r2(int[] nums){
        int[] dp = new int[nums.length];
        // Base
        dp[0] = nums[0];

        for(int i= 1; i< nums.length ; i++){
            int take = nums[i];
            // after taking the element move index 2 position behind
            // If the i encounters less thne 0 then skip
            if(i > 1){
                take += dp[i-2];
            }

            int nottake = 0 + dp[i-1];
            
            dp[i] = Math.max(take,nottake);

        }

        return dp[nums.length -1];

    }

    public static int rob(int[] nums) {

        if(nums.length == 1){
            return nums[0];
        }

        int[] dp = new int[nums.length];
        ArraysQ.fill(dp, -1);

        int[] tmp1 = new int[nums.length];    
        int[] tmp2 = new int[nums.length];   
        
        for(int i = 0; i< nums.length ; i++){
            if(i !=0) {
                tmp1[i-1] = nums[i];
            }
            if(i != nums.length-1){
                tmp2[i]  =nums[i];
            }
        }
        // System.out.println(Arrays.toString(tmp1));
        // System.out.println(Arrays.toString(tmp2));
        return Math.max(r2(tmp1),r2(tmp2));
    }

    public static int uP2(int i, int j, int m, int n, int[][] dp){
        // Base
        if(i >= n || j>=m){
            return 0;
        }
        if(i == n-1 || j == m-1){
            return 1;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        // Left call
        int left = uP2(i+1, j,m,n,dp);
        // Right call
        int right  = uP2(i, j+1,m,n,dp);

        return dp[i][j] = left +  right;
    }

    public static int uP1(int i, int j, int m, int n){
        // Base
        if(i >= n || j>=m){
            return 0;
        }
        if(i == n-1 || j == m-1){
            return 1;
        }

        // Left call
        int left = uP1(i+1, j,m,n);
        // Right call
        int right  = uP1(i, j+1,m,n);

        return left +  right;
    }

    static public int uniquePaths(int m, int n) {
        int[][] dp = new int[m+1][n+1];
        
        for(int[] ar:dp){
            ArraysQ.fill(ar,-1);
        }

        // return uP1(0,0,m,n);
        return uP2(0,0,m,n,dp);
    }
    
    public static boolean canCross(int[] stones) {
//         hashmap will store the index array values 
//         hashset will store all the possibel steps which are used to reach the current index
        
        HashMap<Integer, HashSet<Integer>> map = new HashMap<>();
        
//         Putting array values in hashmap and initinizinf it all with a empty hashmap
        for(int i = 0; i< stones.length; i++){
            map.put(stones[i], new HashSet<Integer>());        
        }
//         0th position can only take 1 jump so makeing it by default
        map.get(stones[0]).add(1);
        
//         traversing the hashmap
        
        for(int i = 0; i<stones.length; i++){
//             getting the current stone
            int currStone  = stones[i];
//             geting all the vales whcih are assicoated with the current stone in hashmap like all the jump which has saved on the hashset respective of that element
            HashSet<Integer> jumps = map.get(currStone);
//             iterating through the values in the set and storing all the possible jumps to respective values in the array at that element position
            
            for(int jump: jumps){
//                 here three jump will take k-1, k, k+1
//                 check if stone exist or not if jump take place
//                     K-1 jump present or not 
//                 and if present stor the jump value to that element set
//                 all the position that the current element can jump
                int pos = currStone  + jump;
                
//                 if the next jump contains the last index element the return true
                if(pos == stones[stones.length -1]){
                    return true;
                }
                    if(map.containsKey(pos) == true){
//                         to avid negative jump
                        if(jump-1 > 0){
                            map.get(pos).add(jump-1);
                        }
                        map.get(pos).add(jump);
                        map.get(pos).add(jump+1);
                    }
                
            }
            
        }
        return false;
    }
    
    public static void main(String[] args) {
        // int[] nums = { 7, 5, 1 };
        // int n = 44;
        // System.out.println(climbStairs(n));
        // int [] nums = {10,9,2,5,3,7,101,18};
        // lengthOfLIS(nums);
        // String t1 = "abcde";
        // String t2 = "ace";
        // System.out.println(longestCommonSubsequence(t1, t2));

        // String s = "catsandog";
        // String[] wordDict = {"cats", "dog", "sand", "and", "cat"};
        // System.out.println(wordBreak(s, WordDict));
        // int[] r = {1,2,3,1};
        // System.out.println(rob(r));
        System.out.println(uniquePaths(3, 2));
    }
}
