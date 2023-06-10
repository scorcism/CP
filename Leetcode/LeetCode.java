import java.util.*;

public class LeetCode {

    public static void main(String[] args) {
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        System.out.println(garbageCollection(garbage, travel));
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        int lastp = 0;
        int lastm = 0;
        int lastg = 0;

        for(int i = 0; i< garbage.length; i++){
            for(int j = 0; j< garbage[i].length(); j++){
                count++;
                if(garbage[i].charAt(j)=='M'){
                    lastm = i;
                }else if(garbage[i].charAt(j)=='G'){
                    lastg = i;
                }else{
                    lastp = i;
                }
            }
            System.out.println("count: "+ count);
            System.out.println(lastg +" " + lastm+" "+ lastp);
        }
        System.out.println("final");
        System.out.println(lastg +" " + lastm+" "+ lastp);

        for(int i = 1; i < travel.length; i++){
            travel[i]+= travel[i-1];
        }
        int ans = count;
        if(lastm > 0){
            ans+=travel[lastm-1];
            System.out.println("take m");
            System.out.println(ans +" ans1");
        }
        if(lastg> 0){
            ans+=travel[lastg-1];
            System.out.println("take g");
            System.out.println(ans +" ans2");
        }
        if(lastp > 0){
            ans+=travel[lastp-1];
            System.out.println(travel[lastp-1]+ " t ka last p");
            System.out.println("take p");
            System.out.println(ans +" ans3");
        }
        return ans;
    }

    // X of a Kind in a Deck of Cards
    public boolean hasGroupsSizeX(int[] deck) {
        Map<Integer, Integer> count = new HashMap<>();
        int res = 0;

        for (int i : deck) {
            count.put(i, count.getOrDefault(i, 0) + 1);
        }

        for (int i : count.values()) {
            res = gcd(i, res);
        }
        return res > 1;
    }

    public static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    // 1909. Remove One Element to Make the Array Strictly Increasing
    public boolean canBeIncreasing(int[] nums) {

        int n = nums.length;
        int count = 0;
        int maxtoleft = nums[0];

        for (int i = 1; i < n; i++) {
            if (maxtoleft >= nums[i]) {
                count++;

                if (i > 1 && nums[i - 2] >= nums[i]) {
                    count++;
                    maxtoleft = nums[i - 1];
                    continue;
                }
            }
            maxtoleft = nums[i];
        }
        return count < 2;
    }

    // Valid Mountain Array
    public boolean validMountainArray(int[] arr) {
        if (arr.length < 3) {
            return false;
        }

        int n = arr.length;
        int i = 0;

        while (i + 1 < n && arr[i] < arr[i + 1]) {
            i++;
        }
        if (i == 0 || i == n - 1) {
            return false;
        }

        while (i + 1 < n && arr[i] > arr[i + 1]) {
            i++;
        }

        return i == n - 1;
    }

    // Prime In Diagonal
    public int diagonalPrime(int[][] nums) {
        int n = nums.length;
        int m = nums[0].length;

        int max = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isPrime(nums[i][i])) {
                    max = Math.max(max, nums[i][i]);
                }
                if (isPrime(nums[nums.length - i - 1][i])) {
                    max = Math.max(max, nums[nums.length - i - 1][i]);
                }
            }
        }
        return max;
    }

    static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public int[] buildArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[nums.length];

        for (int i = 0; i < n; i++) {
            ans[i] = nums[nums[i]];
        }
        return ans;

    }

    // 1802. Maximum Value at a Given Index in a Bounded Array
    public int maxValue(int n, int index, int maxSum) {
        return 0;
    }

    // 2035. Partition Array Into Two Arrays to Minimize Sum Difference
    public int minimumDifference(int[] nums) {
        int n = nums.length;
        int[] lTor = new int[n];
        int[] rTol = new int[n];

        lTor[0] = nums[0];
        for (int i = 1; i < n; i++) {
            lTor[i] = lTor[i + 1] + nums[i];
        }

        rTol[n - 1] = nums[n - 1];

        for (int i = n - 2; i >= 0; i--) {
            rTol[i] = rTol[i + 1] + nums[i];
        }

        int min = Integer.MAX_VALUE;

        for (int i = 0; i < n; i++) {
            int diff = Math.abs(lTor[i] - rTol[i]);
            int num = Math.abs(nums[i] - diff);

            min = Math.min(min, num);

        }
        return min;
    }

    public int[] pivotArray3(int[] nums, int pivot) {

        int[] ans = new int[nums.length];

        int n = nums.length;
        int left = 0;
        int right = n - 1;

        for (int i = 0, j = n - 1; i < n; i++, j--) {
            if (nums[i] < pivot) {
                ans[left++] = nums[i];
            }
            if (nums[j] > pivot) {
                ans[right++] = nums[j];
            }
        }

        while (left != right) {
            ans[left++] = pivot;
        }

        return ans;
    }

    public int[] pivotArray2(int[] nums, int pivot) {

        int[] ans = new int[nums.length];
        int i = 0;
        int pivot_count = 0;

        for (int n : nums) {
            if (n < pivot) {
                ans[i++] = n;
            } else if (n == pivot) {
                ++pivot_count;
            }
        }
        while (pivot_count-- > 0) {
            ans[i++] = pivot;
        }
        for (int n : nums) {
            if (n > pivot) {
                ans[i++] = n;
            }
        }
        return ans;
    }

    public int[] pivotArray(int[] nums, int pivot) {
        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();
        List<Integer> l3 = new ArrayList<>();
        int[] ans = new int[nums.length];

        for (int n : nums) {
            if (n < pivot) {
                l1.add(n);
            } else if (n > pivot) {
                l2.add(n);
            } else if (n == pivot) {
                l3.add(n);
            }
        }
        int i = 0;
        for (int n : l1) {
            ans[i++] = n;
        }
        for (int n : l3) {
            ans[i++] = n;
        }
        for (int n : l2) {
            ans[i++] = n;
        }

        return ans;
    }

    public boolean isSubsequence(String s, String t) {
        if (s.length() == 0) {
            return true;
        }

        int i = 0;
        int m = s.length();
        int n = t.length();

        for (int j = 0; j < t.length(); j++) {
            if (i < m && s.charAt(i) == t.charAt(j)) {
                i++;
            }
        }

        return i == m;
    }

    public boolean validPalindrome(String s) {
        int i = 0;
        int j = s.length() - 1;

        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                /*
                 * Suppose string is
                 * s = abcdedczba
                 * z is not require so we use two
                 * pointer i = 0 j = s.length()-1
                 * the character mis-matched at
                 * c - 2;
                 * z - 7
                 * so we will check from 2 to 7 and from 2 to 6
                 */
                return isPallindrome(s, i + 1, j) || isPallindrome(s, i, j - 1);
            }
            i++;
            j--;
        }
        return true;
    }

    private boolean isPallindrome(String s, int i, int j) {
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                return false;
            }
            i++;
            j--;
        }
        return true;
    }

    public boolean isLongPressedName(String a, String b) {

        int i = 0;
        int m = a.length();
        int n = b.length();

        for (int j = 0; j < n; j++) {
            if (i < m && a.charAt(i) == b.charAt(j)) {
                ++i;
            } else if (j == 0 || b.charAt(j) != b.charAt(j - 1)) {
                return false;
            }
        }
        return i == m;

    }

    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();

        for (int n : arr) {
            if (set.contains(n * 2)) {
                return true;
            } else if (n % 2 == 0) { // if the number is even means, we can divide this number by 2 to get a number
                if (set.contains(n / 2)) {
                    return true;
                }
            }
            set.add(n);
        }
        return false;
    }

    public boolean isIsomorphic(String s, String t) {

        int[] smap = new int[256];
        int[] tmap = new int[256];
        Arrays.fill(smap, -1);
        Arrays.fill(tmap, -1);
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i);
            char c2 = t.charAt(i);
            if (smap[c1] == -1 && tmap[c2] == -1) {
                smap[c1] = c2;
                tmap[c2] = c1;
            } else if (smap[c1] != c2 && tmap[c2] != c1) {
                return false;
            }
        }
        return true;
    }

    public int countNegatives(int[][] grid) {
        int count = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] < 0) {
                    count++;
                }
            }
        }
        return count;
    }

    public int countNegatives2(int[][] grid) {
        int count = 0;
        for (int[] row : grid) {
            // do bs in each row
            int low = 0;
            int high = row.length - 1;

            while (low <= high) {
                int mid = low + ((high - low) >> 1);
                // get the first index of <0 ele o the rest of that will be easy to get as the
                // 1st index to n will alwasy have -v1
                if (row[mid] < 0) {
                    high = mid - 1;
                } else {
                    low = mid + 1;
                }
            }
            count += (grid[0].length - low);

        }

        return count;
    }
}
