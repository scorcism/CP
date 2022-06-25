import java.util.*;

public class ArraysQuestions {
    public static void main(String[] args) {
        int[] array = {1,2,3,4,5,6};
        int[] array2 = {7,1,5,3,6,4};
        int[] array3 = {1,2,3};
        int[] array4 = {1,2,3,4};
        // System.out.println(Arrays.toString(twoSum(array, 9)));
        // System.out.println(maxProfitM1(array2));
        // System.out.println(maxProfitM2(array2));
        // containsDuplicate(array3);
        System.out.println(Arrays.toString(productExceptSelf(array4)));
    }

    // Two sum
    public static int[] twoSum(int[] arr, int target){
        // Here we will be using a hash map 
        Map<Integer,Integer> hm = new HashMap<>();

        for(int i = 0; i < arr.length ; i++){
            int diff = target - arr[i];
            if(hm.containsKey(diff)){
                return new int[] {};
            }
            else{
                hm.put(arr[i],i);
            }
        }
        return new int[] {0,0};
    }
    
    // Q:121 
    // Best time to buy stock
    // Brute force
    // Method 1
    // BUGGY
    public static int maxProfitM1(int[] prices) {
        int maxProfit = 0;
        int localMaxProfit = 0;
        for(int i = 0; i< prices.length ; i++){
            for(int j = 1 + i ; j < prices.length; j++){

                if(prices[j] > localMaxProfit){
                    localMaxProfit = prices[j];
                }
            }
            
            if(maxProfit < localMaxProfit){
                maxProfit = localMaxProfit;
            }

        }
    return maxProfit;
    }
    // Method 2
    public static int maxProfitM2(int[] prices) {
        // Assuming 1st element in the lowest
        int buy = prices[0];
        int maxProfit = 0;

        for(int i = 0; i< prices.length; i++){
            // setting the buy value to the smallest element
            if(buy > prices[i]){
                buy = prices[i];

            // Buy is the smallest value and prices[i] we are assuming that it is greater then by form the above condition.
            }else if(prices[i] - buy > maxProfit){
                maxProfit = prices[i] - buy;
            }
        }
        return maxProfit;
    }
    
    // Optimized
    public static int maxProfitM3(int[] prices) {
        int buyS = prices[0];
        int maxProfit = 0;
        for(int i = 0;  i < prices.length ; i++){
            // Getting the min buy value 
            buyS = Math.min(buyS,prices[i]);
            // Getting the local profit
            int profit = prices[i] - buyS;
            maxProfit = Math.max(profit,maxProfit);
        }
        return maxProfit;
    }

    // Q: 217
    // Using hashset to check
    public boolean containsDuplicate(int[] nums) {
        
        Set<Integer> set  = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(set.contains(nums[i])){
                return true;
            }
            set.add(nums[i]);
        }
        return false;
    }    

    // 238. Product of Array Except Self
    public static int[] productExceptSelf(int[] nums) {
        int[] b = new int[nums.length];

        int mul = 1;
        
        for(int i = 0; i< nums.length; i++){
            for(int j = 0; j< nums.length; j++){
                if(nums[j] != nums[i]){
                    mul = mul * nums[j];
                }
            }
            
            b[i] = mul;   
            mul = 1;         
        }        
        return b;
    }
 
    public static int[] productExceptSelfM2(int[] nums) {

       done
    }
}
