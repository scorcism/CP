import java.util.HashMap;
import java.util.PriorityQueue;

class ArraysQ {

    // Majority Elements in an Array
    static public void mj1(int[] array) {
        int element = 0;
        int maxCount = Integer.MIN_VALUE;

        for (int i = 0; i < array.length - 1; i++) {
            int count = 0;
            for (int j = 1 + 1; j < array.length - 1; j++) {
                if (array[j] == array[i]) {
                    count++;
                }
            }
            if (count > maxCount) {
                maxCount = count;
                element = array[i];
            }
        }
        System.out.println(element);
    }

    // majority using hashmap
    public static void mj2(int[] array) {
        // after hashmp
    }

    // majority using moore's voting
    public static void mj3(int[] array) {
        // after hashmp
        int ele = array[0];
        int count = 1;

        for (int i = 1; i < array.length - 1; i++) {
            if (ele == array[i]) {
                count++;
            } else {
                count--;
            }
            if (count == 0) {
                ele = array[i];
                count = 1;
            }
        }
        int maxCount = 0;
        for (int j = 0; j < array.length - 1; j++) {
            if (array[j] == ele) {
                maxCount++;
            }
        }
        if (maxCount > (array.length) / 2) {
            System.out.println(ele);
        }
        return;
    }

    // Kadane's Algorithm | Largest Sum Contiguous Subarray
    public static int sumSubarray(int[] array) {
        int Maxsum = 0;
        int currSum = 0;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            currSum = currSum + array[i];

            if (currSum > Maxsum) {
                Maxsum = currSum;
            }
            if (currSum < 0) {
                currSum = 0;
            }
        }

        return Maxsum;
    }

    // /Best time to buy and sell stock to Maximise Profit
    public static int getMaxprofit(int[] array) {
        int maxProfit = 0;
        int minSoFar = array[0];

        for (int i = 0; i < array.length; i++) {
            // get the minimum in the current iteration
            minSoFar = Math.min(minSoFar, array[i]);
            // get the profit suppose we are at index 5 then profit will be element at 5 -
            // element at 4
            int profit = array[i] - minSoFar;
            maxProfit = Math.max(profit, maxProfit);
        }

        return maxProfit;
    }

    // Best time to Buy and Sell Stock ii
    public static int leetcode122(int[] array) {
        int profit = 0;
        // here while iteratige throught the loop we are trying to sell with compare of
        // the previous day
        for (int i = 1; i < array.length; i++) {
            if (array[i] > array[i - 1]) {
                profit = profit + (array[i] - array[i - 1]);
            }
        }
        return profit;
    }

    // Trapping Rainwater Problem
    public static int rainwater(int[] array) {
        int ans = 0;
        int n = array.length;

        // This process is called preprocessing
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = array[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(array[i], left[i - 1]);
        }

        right[n - 1] = array[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], array[i]);
        }

        for (int i = 0; i < n; i++) {
            ans = ans + (Math.min(left[i], right[i]) - array[i]);
        }

        return ans;
    }

    private static int binarySearchIterative(int[] array, int target) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if (array[mid] == target) {
                return mid;
            } else if (target < array[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchRecursive(int[] array, int target, int low, int high) {

        if (low > high) {
            return -1;
        }

        int mid = (low + high) / 2;
        if (array[mid] == target) {
            return mid;
        }
        if (target < array[mid]) {
            return binarySearchRecursive(array, target, mid + 1, high);
        }
        return binarySearchRecursive(array, target, low, mid - 1);
    }

    // Search an element in an Infinite Sorted array
    private static int searchInInfinite(int[] array, int key) {
        int low = 0;
        int high = 1;

        while (array[high] < key) {
            low = high;
            high = 2 * high;
        }
        return binarySearchRecursive(array, key, low, high);
    }

    private static int rotateSorted(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(array[mid] == key){
                return mid;
            }
            if (array[low] < array[mid]) {
                // if left side of the array is sorted

                // if the left is sorted check if the key lies between the range
                if (key >= array[low] && key < array[mid]) {
                    // found the range
                    high = mid - 1;
                } else {
                    // not in that range
                    low = mid + 1;
                }
            } else {
                // if right side of the array is sorted
                if(key > array[mid] && key <= array[high]){
                    low  = mid +1;
                }else{
                    high = mid -1;
                }
            }
        }
        return -1;
    }

    // Allocate minimum number of pages
    public static int findPages(int[]A,int N,int M)
    {
        //Your code here
        int res = 0;
        return res;
    }

    private static void generateSum(int[] array, int key){
        for(int i = 0 ; i< array.length-1; i++){
            for(int j = 0; j< array.length; j++){
                for(int k = i; k<j; k++){
                    int sum = array[i] + array[j];
                    if(sum == key){
                        System.out.println(i  + " " + j);
                    }
                }           
            }
        }
    }
    // Find Subarray with the given sum k 
    private static void sebarraySum(int[] array, int sum){
        int start = 0;
        int end = -1;
        int currentSum = 0;

        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i = 0; i< array.length -1 ; i++){
            currentSum+=array[i];

            if(currentSum - sum == 0){
                start = 0;
                end = i;
                break;
            }

            if(map.containsKey(currentSum - sum)){
                start = map.get(currentSum -  sum ) + 1;
                end = i;
                break;
            }              
            map.put(currentSum, i);
        }
        System.out.println(start + " " + end);
    }

    static private void countDistint(int[] array, int k){
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i = 0; i< k; i++){
            map.put(array[i], map.getOrDefault(array[i], 0) + 1);
        }
        System.out.println(map.size());
        for(int i =k; i< array.length; i++){

            // for removing the previous one
            if(map.get(array[i-k]) == 1){
                // if the value of key to be remove is 1 then remove the entire key-value
                map.remove(array[i-k]);
            }
            else{
                // or else just decrease the value by 1
                map.put(array[i-k], map.getOrDefault(array[i-k],0 ) - 1);       
            }

            map.put(array[i], map.getOrDefault(array[i],0) +1);

            System.out.println(map.size());
        }
    }

    // Find Kth Largest Element in an Array
    public static int kthLarget(int[] array, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i< k ; i++){
            pq.add(array[i]);
        }

        for (int i = k; i < array.length; i++) {
            if(pq.peek() < array[i]){
                pq.poll();
                pq.add(array[i]);
            }
        }
        return pq.peek();
    }


    // Find Kth minimum Element in an Array
    // using max heap
    // if array[i] < peek then pu
    public static int kSmallest(int[] array, int k){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int i = 0; i< k; i++){
            pq.add(array[i]);
        }
        return pq.peek();
    }
    
    // Connect N Ropes with minimum cost
    // O(nlogn)
    private static int connectNropes(int[] array){

        // add all the ith element to the pq min heap
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int i = 0; i< array.length; i++){
            pq.add(array[i]);
        } 

        // to store total sum
        int ans = 0;

        // using min heap we can get two concequitive small element and the add them and then again put those into the pq
        while(pq.size() > 1){
            // size >1 coz we are addint 2 elements and puting only one so size will automatically decrease
            int first = pq.peek();
            int second = pq.poll();
            
            int sum = first + second;

            ans = ans + sum;
            pq.add(sum);
        }
        return ans;
    }

    public static void main(String[] args) {
        int[] array = { 5, 4, 44, 1 };
        // mj3(array);
        // System.out.println(rainwater(array));
        int[] array2 = { 20, 30, 40, 50, 60, 5, 10 };
        int[] array3 = {10,15,-5,15,-10,5};
        int[] array4 = {1,2,2,1,3,1,1,3};
        // System.out.println(rotateSorted(array2, 10));
        // generateSum(array3,5);
        countDistint(array4,4);
    }
}
