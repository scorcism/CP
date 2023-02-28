import java.util.*;

public class CP2 {

    public static void main(String[] args) {
        // System.out.println(minOperations(15));
        // System.out.println(minOperations(20));
        // int[] nums = { 1, 1, 2, 3, 4, 5 };
        // topKFrequent(nums, 2);
        // System.out.println(minOperations(6126));
    }
    
    public List<TreeNode> findDuplicateSubtrees(TreeNode root) {
        List<TreeNode> ans = new ArrayList<>();
        postorder(root, new HashMap<>(), ans); // run a post order to iterate in the tree
        return ans;
    }
    

    private String postorder(TreeNode curr,Map<String, Integer> map, List<TreeNode> ans) {
        if(curr == null){
            return "#"; // If the root is null we have to take that position also into consideration
        }
        String serial = curr.val + "," + postorder(curr.left, map, ans) + "," + postorder(curr.right, map, ans); // serial entire root + left + right 
        map.put(serial,map.getOrDefault(serial, 0)+1 ); // store the serialied string into the hash map with values of its occurance
        if(map.get(serial) == 2){
            //  if the serialised node is already present before the add to the main anser
            ans.add(curr);
        }
        // return the serialized string which can be used for further analyses in postorder
        return serial;
    }


public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }
  
    int longSubarrWthSumDivByKMethod1(int a[], int n, int k)
    {
        // Complete the function
        int max_len = 0;
        for(int i  = 0; i< n; i++){
            int local_sum = 0;
            for(int j = i; j< n; j++){
                local_sum = local_sum+a[j] ;
                if(local_sum %k== 0){
                    max_len = Math.max(max_len, j-i+1);
                }
            }
        }
        return max_len;
    }

    int longSubarrWthSumDivByKMethod2(int a[], int n, int k)
    {
        int max_len = 0;
        int[] modati = new int[n]; // To store mod of each index
        int curr_sum = 0; // to store the prefix sum at that index from 0
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i  = 0; i< n; i++){
            curr_sum += a[i];
            modati[i] = (curr_sum%k +k)%k;

            if(modati[i] ==0 ){
                max_len = i+1;
            }
            else if(!hm.containsKey(modati[i])){
                hm.put(modati[i], i);
            }else{
                if(max_len<(i-hm.get(modati[i]))){
                    max_len = i - hm.get(modati[i]);
                }
            }
        }
        return max_len;
    }



    public static String printLargest(String[] arr){
        StringBuilder sb = new StringBuilder();
        Arrays.sort(arr, new Comparator<String>(){
            public int compare(String a, String b){
                String ab = a+b;
                String ba = b+a;

                return ab.compareTo(ba) > 0 ? -1:1;
            }
        });
        for(String s: arr){
            sb.append(s);
        }
        return sb.toString();
    }


    public static int findMindOps(int[] nums){
        int ans = 0;
        for(int i = 0, j = nums.length-1; i<j;){
            if(nums[i] == nums[j]){
                i++;
                j--;
            }else if(nums[i] > nums[j]){
                // if ith one is greater then merge the two right me 
                j--;
                nums[j]+=nums[j+1];
                ans++;
            }else{
                i++;
                nums[i]+=nums[i-1];
                ans++;
            }
        }
        return ans;
    }


    public int[][] mergeIntevals(int[][] intervals) {
        List<int[]> list = new ArrayList<>();
        if(intervals == null || intervals.length == 0){
            return new int[0][];
        }
        // sort on the bases of start index
        Arrays.sort(intervals, (a,b)->a[0]-b[0]);
        int start = intervals[0][0];
        int end = intervals[0][1];

        for(int i =0 ; i< intervals.length; i++){
            // check if the new ith array in intervals has start less then prev inteval end if yes the merge the end with start
            int[] curr = intervals[i];
            if(curr[0] <= end ){
                end = Math.max(end,curr[1]);                
            }else{
                // If is is a new interval then
                list.add(new int[]{start,end});
                start = curr[0];
                end = curr[1];
            }
        }
        list.add(new int[]{start,end});

        return list.toArray(new int[0][]);
    }

    public static int kthSmallest(int[] arr, int l, int r, int k) 
    { 
        //Your code here
        // Arrays.sort(arr);
        // return arr[k-1];
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for(int a: arr){
            pq.add(a);
        }
        for(int i = 0; i< k-1; i++){
            pq.poll();
        }
        return pq.peek();
    } 


    int Countpair(int a[], int n, int sum)
    {
        // Complete the function
        int count = 0;
        // using hashing
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i< n; i++){
            if(map.containsKey(sum-a[i])){
                count+= map.get(sum - a[i]);
            }
            if(map.containsKey(a[i])){
                map.put(a[i], map.get(a[i])+1);
            }else{
                map.put(a[i],1);
            }
        }
        
        return count > 0 ? count : -1;
    }

    public int maxArea(int[] height) {
        // base * heigh will be the max water container at each level
        int left = 0;
        int right = height.length -1;
        int max  = Integer.MIN_VALUE;
        while(left < right){
            int area = (right - left) * Math.min(height[left],height[right]);
            // width * height -> area of rectangle
            max = Math.max(max,area);
            if(height[left] < height[right]){
                left++;
            }else{
                right--;
            }
        }
        return max;
    }

    public List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> ans =  new HashSet<>();
        if(nums.length < 3){
            return new ArrayList<>();
        }
        Arrays.sort(nums);
        for(int i = 0; i< nums.length-2; i++){
            int first = i;
            int second = i +1;
            int last = nums.length-1;
            while(second < last){
                int sum = nums[first] + nums[second]+ nums[last];
                if(sum == 0){
                    ans.add(Arrays.asList(nums[i],nums[second++], nums[last--]));   
                }else if(sum > 0){
                    last--;
                }else if(sum < 0){
                    second++;
                }
                
            }
        }
        return new ArrayList<>(ans);
    }


    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;
        while(left < right){
            int mid = left + (right - left)/2;
            if(nums[mid]== target){
                return mid;
            }  
            if(nums[left] <= nums[mid]){
                if(target >= nums[left] && target <= nums[mid]){
                    right = mid -1;
                }else{
                    left = mid+1;
                }
            }else{
                if(target >=nums[mid] && target <= nums[right]){
                    left = mid +1;
                }else{
                    right  = mid -1;
                }
            }
        }
        return -1;
    }

    public int maxProfit(int[] nums) {
        // Using peek and valley techinque
        int max = 0;
        int valley = nums[0];
        int peek = nums[0];
        int i = 0;
        while (i < nums.length - 1) {
            while (i < nums.length - 1 && nums[i] >= nums[i + 1]) {
                // This is the peek value
                i++;
            }
            valley = nums[i];
            // getting the valley
            while (i < nums.length - 1 && nums[i] <= nums[i + 1]) {
                // This is the peek value
                i++;
            }
            peek = nums[i];
            max += peek - valley;

        }
        return max;
    }

    public int maxProfit2(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;

    }

    public int maxProductMethod1(int[] nums) {

    }

    public int findMin(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int[] productExceptSelfM1(int[] nums) {
        int n = nums.length;
        int produtOfArray = 1;
        for (int k : nums) {
            produtOfArray = produtOfArray * k;
        }
        int[] res = new int[n];

        for (int i = 0; i < n; i++) {
            if (nums[i] > 0) {
                res[i] = produtOfArray / nums[i];
            } else {
                res[i] = 0;
            }
        }
        return res;
    }

    public int[] productExceptSelfM2(int[] nums) {
        int n = nums.length;
        int[] left = new int[n];
        int[] right = new int[n];

        left[0] = nums[0];
        right[n - 1] = nums[n - 1];

        for (int i = 1; i < n; i++) {
            left[i] = left[i - 1] * nums[i];
        }

        for (int i = n - 2; i >= 0; i--) {
            right[i] = right[i + 1] * nums[i];
        }
        // System.out.println(Arrays.toString(left));
        // System.out.println(Arrays.toString(right));
        int[] ans = new int[n];

        ans[0] = right[1];
        ans[n - 1] = left[n - 2];
        for (int i = 1; i < n - 1; i++) {
            ans[i] = left[i - 1] * right[i + 1];
        }
        return ans;
    }

    public int[] productExceptSelfM3(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        if (n < 1) {
            return res;
        }
        res[0] = nums[0];
        for (int i = 1; i < n; i++) {
            res[i] = res[i - 1] * nums[i];
        }
        int product = 1;
        for (int i = n - 1; i > 0; i++) {
            res[i] = res[i - 1] * product;
            product = product * nums[i];
        }
        res[0] = product;
        return res;
    }

    public int trap2(int[] height) {
        int n = height.length;
        int[] pre = new int[n];
        int[] post = new int[n];
        int ans = 0;
        pre[0] = height[0];
        post[n - 1] = height[n - 1];

        for (int i = 1; i < n; i++) {
            pre[i] = Math.max(pre[i - 1], height[i]);
        }

        for (int i = n - 2; i >= 0; i--) {
            post[i] = Math.max(post[i + 1], height[i]);
        }

        for (int i = 0; i < n; i++) {
            ans += Math.min(pre[i], post[i]) - height[i];
        }
        return ans;
    }

    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        int left = 0;
        int right = height.length - 1;
        int maxLeft = 0;
        int maxRight = 0;
        int totalWater = 0;

        while (left < right) {
            if (height[left] < height[right]) {
                if (height[left] >= maxLeft) {
                    maxLeft = height[left];
                } else {
                    totalWater += maxLeft - height[left];
                }
                left++;
            } else {
                if (height[right] >= maxRight) {
                    maxRight = height[right];
                } else {
                    totalWater += maxRight - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }

    public int findKthLargest(int[] nums, int k) {

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());

        for (int num : nums) {
            pq.add(num);
        }
        for (int i = 1; i < k; i++) {
            pq.poll();
        }
        return pq.poll();
    }

    public int missingNumber(int[] nums) {

        if (nums.length == 1) {
            return 0;
        }

        int[] toCheck = new int[nums.length + 1];
        Arrays.fill(toCheck, 0);
        for (int i = 0; i < nums.length; i++) {
            toCheck[nums[i]] = 1;
        }

        for (int i = 1; i < toCheck.length; i++) {
            if (toCheck[i] != 1) {
                return i;
            }
        }
        return nums.length;
    }

    public static int missingNumberMethod2(int[] nums) {
        int n = nums.length;
        // Using Maths
        // Here, we have n +1 number
        // which are in ascending orer form 0 -> n
        // what we can do iss get the sum of all natural numbers till n
        // and get the sum of all the number in nums and the we subtract it to get the
        // result

        int sumOfN = (n * (n + 1)) / 2;
        int sumOfNums = 0;
        for (int w : nums) {
            sumOfNums = w + sumOfNums;
        }
        return sumOfN - sumOfNums;

    }

    public static int missingNumberMethod3(int[] nums) {
        // USing xor
        // we knwo xor of same number is 0
        // so, we will xor nums[i] with each other and the output we will xor withe the
        // xor of n natural number
        // n natural number = nxor = = (1^2^3^4)
        // suppose nums = numsxor = (1^2^4)
        // ans = nxor ^ numsxoor
        int numsxor = 0;
        for (int i = 0; i < nums.length; i++) {
            numsxor = numsxor ^ nums[i];
        }

        int nxor = 0;
        for (int i = 0; i < nums.length + 1; i++) {
            nxor = nxor ^ i;
        }

        return numsxor ^ nxor;

    }

    public List<Integer> getRow(int rowIndex) {
        int[] arr = new int[rowIndex + 1];
        arr[0] = 1;
        for (int i = 1; i < rowIndex; i++) {
            for (int j = i; j > 0; j--) {
                arr[j] = arr[j] + arr[j - 1];
            }
        }

        List<Integer> res = new ArrayList<>();
        for (int a : arr) {
            res.add(a);
        }
        return res;
    }

    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curres, prev = null;

        for (int i = 0; i < numRows; i++) {
            curres = new ArrayList<>();
            for (int j = 0; j <= i; j++) {
                if (j == 0 || j == i) {
                    curres.add(1);
                } else {
                    curres.add(prev.get(j - 1) + prev.get(j));
                }
            }
            prev = curres;
            ans.add(curres);
        }
        return ans;
    }

    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length == 1) {
            return;
        }

        // This includes 4 step
        // 1) start iterating from the back side and find the index where the element at
        // ith index is less then the element at i+1 index
        int ind1 = nums.length - 2; // -2 coz we will compare 1st one with second one and we are starting from the
                                    // end so to avoid overflow, if we take -1 then there will be no ele to check
        while (ind1 >= 0 && nums[ind1] >= nums[ind1 + 1]) {
            ind1--;
        }
        // 2) again iterate from the back side and find the ele which is greater then
        // ind1
        int ind2 = nums.length - 1;
        if (ind1 >= 0) {
            // This check will make sure that if the provided no are not decending order if
            // it is and we will direclty return the reverse as mentioned
            while (nums[ind2] <= nums[ind1]) { // less then coz we find any bigger value the loop should break
                ind2--;
            }
            // 3) swap the ind1 and ind2 values
            swap(nums, ind1, ind2);
        }
        // 4) reverse the array from ind1+1 to end
        reverse(nums, ind1 + 1, nums.length - 1);
    }

    private void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }

    private void reverse(int[] nums, int i, int j) {
        while (i < j) {
            swap(nums, i++, j--);
        }
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        boolean[] taken = new boolean[nums.length];
        computePermute(res, ds, taken, nums);

        return res;
    }

    private void computePermute(List<List<Integer>> res, List<Integer> ds, boolean[] taken, int[] nums) {
        if (ds.size() == nums.length) {
            res.add(new ArrayList<>(ds));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (!taken[i]) {
                ds.add(nums[i]);
                computePermute(res, ds, taken, nums);
                ds.remove(ds.size() - 1);
                taken[i] = false;
            }
        }

    }

    public static int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> map.get(a) - map.get(b));

        for (int num : map.keySet()) {
            pq.offer(num);

            // if size is greater then k remove the top one coz the buttom once will be
            // greater
            if (pq.size() > k) {
                pq.poll();
            }
        }

        int[] ans = new int[k];
        for (int i = 0; i < k; i++) {
            ans[i] = pq.poll();
        }

        return ans;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        // create a new ListNode
        ListNode tmp = new ListNode(0);
        ListNode curr = tmp; // for moving the pointers

        // why pq coz we want the elements in ascending order and in pq we can define
        // the order of elements by sorting them so in later by iterating it we get the
        // values in sorted order by default

        // put everything in pq
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> a.val - b.val);

        // Add all the elements to pq
        for (ListNode node : lists) {
            if (node != null) {
                // if the current node is not null means it is not the last ele of the curren
                // array of LL
                pq.add(node);
            }
        }

        // iterating in the queue to add ele to out own ll
        while (!pq.isEmpty()) {
            curr.next = pq.poll();
            curr = curr.next;

            //
            if (curr.next != null) {
                pq.add(curr.next);
            }

        }
        return tmp.next;
    }

    public static int minOperations(int n) {

        int res = 0;
        while (n > 0) {
            if ((n & 3) == 3) {
                n++;
                res++;
            } else {
                res += n & 1;
                n >>= 1;
            }
        }
        return res;
    }

    public int[][] mergeArrays(int[][] nums1, int[][] nums2) {

        List<int[]> list = new ArrayList<>();

        int n1 = nums1.length;
        int n2 = nums2.length;
        int i = 0;
        int j = 0;
        while (i < n1 && j < n2) {
            int[] num1val = nums1[i];
            int[] num2val = nums2[j];
            if (num1val[0] < num2val[0]) {
                list.add(num1val);
                i++;
            } else if (num1val[0] > num2val[0]) {
                list.add(num2val);
                j++;
            } else if (num1val[0] == num2val[0]) {
                // both are same
                int tmp = num1val[1] + num2val[1];
                int[] newtmp = { num1val[0], tmp };
                list.add(newtmp);
                i++;
                j++;
            }
        }
        while (i < n1) {
            list.add(nums1[i]);
            i++;
        }
        while (j < n2) {
            list.add(nums2[j]);
            j++;
        }
        return list.toArray(new int[list.size()][]);
    }

    public class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

    public List<List<Integer>> levelOrder(TreeNode root) {

        List<List<Integer>> ans = new LinkedList<>();
        if (root == null) {
            return ans;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        while (!q.isEmpty()) {
            // getting the size of the q so that we can take both the value sin one go
            int size = q.size();
            List<Integer> l = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                if (q.peek().left != null) {
                    q.offer(q.peek().left);
                }
                if (q.peek().right != null) {
                    q.offer(q.peek().right);
                }
                l.add(q.poll().val);
            }
            ans.add(l);
        }

        return ans;
    }

}
