import java.util.*;

public class LeetCode {

    public static void main(String[] args) {

    }

    public int longestSubarray(int[] nums) {
        int zc = 0;
        int lw = 0;

        int s = 0;
        for (int i = 0; i < nums.length; i++) {
            zc += (nums[i] == 0 ? 1 : 0);

            while (zc > 1) {
                zc -= (nums[s] == 0 ? 1 : 0);
                start++;
            }
            lw = Math.max(lw, i - s);
        }
        return lw;
    }

    public static int singleNumber3(int[] nums) {
        int res = 0;
        for (int i = 0; i < 3; i++) {
            int sum = 0;
            for (int n : nums) {
                if (((n >> i) & 1) == 1) {
                    sum++;
                }
            }
            sum %= 3;
            res |= sum << i;
        }
        return res;
    }

    public static int singleNumber2(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int n : nums) {
            map.put(n, map.getOrDefault(n, 0) + 1);
        }

        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            if (entry.getValue() == 1) {
                return entry.getKey();
            }
        }

        return -1;
    }

    public static int singleNumber(int[] nums) {
        int[] freq = new int[(int) 1e2];

        for (int i = 0; i < nums.length; i++) {
            freq[nums[i]]++;
        }
        for (int i = 0; i < nums.length; i++) {
            if (freq[i] == 1) {
                return i;
            }
        }
        return -1;
    }

    public boolean buddyStrings(String s, String goal) {
        if (s.length() != goal.length()) {
            return false;
        }

        if (s.equals(goal)) {
            int[] freq = new int[26];
            for (char ch : s.toCharArray()) {
                freq[ch - 'a']++;
                if (freq[ch - 'a'] == 2) {
                    return true;
                }
            }
            return false;
        }

        int firstIndex = -1;
        int secondIndex = -1;

        for (int i = 0; i < s.length(); ++i) {
            if (s.charAt(i) != goal.charAt(i)) {
                if (firstIndex == -1) {
                    firstIndex = i;
                } else if (secondIndex == -1) {
                    secondIndex = i;
                } else {
                    return false;
                }
            }
        }

        if (secondIndex == -1) {
            return false;
        }

        return s.charAt(firstIndex) == goal.charAt(secondIndex) &&
                s.charAt(secondIndex) == goal.charAt(firstIndex);

    }

    public static void shortestPathAllKeys(String[] grid) {
        int n = grid.length;
        int m = grid[0].length();

        int[][] vis = new int[n][m];
        HashMap<Character, Integer> map = new HashMap<>();
        int[] count = new int[1];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid[i].charAt(j) == '@') {
                    dfs29(grid, vis, i, j, map, count);
                    vis[i][j] = 1;
                }
            }
        }
        if (!map.isEmpty()) {
            // Map.Entry<Character, Integer> entry = map.entrySet().iterator().next();
            // Integer value = entry.getValue();
            // return value;
            for (Map.Entry<Character, Integer> entry : map.entrySet()) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
        } else {
            // return -1;
            System.out.println(-1);
        }

    }

    private static void dfs29(String[] grid, int[][] vis, int i, int j, HashMap<Character, Integer> map, int[] count) {
        vis[i][j] = 1;

        int[] delrow = { -1, 0, +1, 0 };
        int[] delcol = { 0, +1, 0, -1 };

        for (int k = 0; k < 4; k++) {
            int nr = i + delrow[k];
            int nc = j + delcol[k];

            if (nr >= 0 && nr < grid.length && nc >= 0 && nc < grid[0].length() && vis[nr][nc] != 1
                    && grid[nr].charAt(nc) != '#') {

                if (Character.isUpperCase(grid[nr].charAt(nc))) {
                    if (map.containsKey(Character.toLowerCase(grid[nr].charAt(nc)))) {
                        count[0]++;
                        dfs29(grid, vis, nr, nc, map, count);
                    } else {
                        return;
                    }

                } else if (Character.isLowerCase(grid[nr].charAt(nc))) {
                    map.put(grid[nr].charAt(nc), count[0]);
                    count[0]++;
                    dfs29(grid, vis, nr, nc, map, count);

                } else if (grid[nr].charAt(nc) == '.') {
                    count[0]++;
                    dfs29(grid, vis, nr, nc, map, count);
                }
            }
        }
    }

    public List<List<Integer>> kSmallestPairs(int[] nums1, int[] nums2, int k) {
        List<List<Integer>> ans = new ArrayList<>();

        return ans;
    }

    public static List<List<Integer>> kSmallestPairs2(int[] nums1, int[] nums2, int k) {

        List<List<Integer>> ans = new ArrayList<>();

        PriorityQueue<Node> pq = new PriorityQueue<>(Collections.reverseOrder((a, b) -> a.sum - b.sum));

        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int x = nums1[i];
                int y = nums2[j];
                int sum = nums1[i] + nums2[j];
                pq.add(new Node(x, y, sum));
                if (pq.size() > k) {
                    pq.poll();
                }
            }
        }
        while (!pq.isEmpty()) {
            List<Integer> a = new ArrayList<>();
            Node top = pq.poll();
            a.add(top.x);
            a.add(top.y);
            ans.add(a);
        }
        return ans;
    }

    static class Node {
        int x;
        int y;
        int sum;

        Node(int x, int y, int sum) {
            this.x = x;
            this.y = y;
            this.sum = sum;
        }
    }

    // From LC , coz not able to solve :)
    public static long totalCost2(int[] costs, int k, int n) {
        PriorityQueue<Integer> head = new PriorityQueue<>();
        PriorityQueue<Integer> tail = new PriorityQueue<>();

        for (int i = 0; i < n; i++) {
            head.add(costs[i]);
        }

        for (int i = Math.max(n, costs.length - n); i < costs.length; i++) {
            tail.add(costs[i]);
        }

        long answer = 0;
        int nexthead = n;
        int nexttail = costs.length - 1 - n;

        for (int i = 0; i < k; i++) {
            if (tail.isEmpty() || !head.isEmpty() && head.peek() <= tail.peek()) {
                answer += head.poll();
                if (nexthead <= nexttail) {
                    head.add(costs[nexthead]);
                    nexthead++;
                }
            } else {
                answer += tail.poll();

                if (nexthead <= nexttail) {
                    tail.add(costs[nexttail]);
                    nexttail--;
                }
            }
        }

        return answer;
    }

    public static long totalCost(int[] costs, int k, int n) {
        ArrayList<Integer> alist = new ArrayList<>();
        for (int i = 0; i < costs.length; i++) {
            alist.add(i, costs[i]);
        }
        PriorityQueue<Integer> min = new PriorityQueue<>();
        PriorityQueue<Integer> max = new PriorityQueue<>();

        long sum = 0;
        while (k > 0) {
            for (int i = 0; i < n; i++) {
                if (alist.size() >= n) {
                    min.add(alist.get(i));
                }
            }
            System.out.print("min: ");
            System.out.println(min);
            int i = 1;
            while (i <= n) {
                if (alist.size() >= n) {
                    max.add(alist.get(alist.size() - i));
                    i++;
                }
            }
            System.out.print("max: ");
            System.out.println(max);
            if (!min.isEmpty() && !max.isEmpty()) {

                if (min.peek() < max.peek()) {
                    sum += min.peek();
                    alist.remove(min.peek());
                } else {
                    sum += max.peek();
                    alist.remove(max.peek());
                }
            }
            while (!min.isEmpty()) {
                min.poll();
            }
            while (!max.isEmpty()) {
                max.poll();
            }
            k--;
        }

        return sum;
    }

    public static long minCost(int[] nums, int[] cost) {
        long[] c = new long[1];
        c[0] = 0;
        int i = 0;
        int n = nums.length;
        long sum = 0;
        int count = 0;
        for (int p : nums) {
            sum += p;
            count++;
        }
        int avg = (int) (sum / count);

        f(i, n, c, nums, cost, avg);

        return c[0];
    }

    private static void f(int i, int n, long[] c, int[] nums, int[] cost, int avg) {
        if (i >= n) {
            return;
        }

        if (nums[i] == avg) {
            f(i + 1, n, c, nums, cost, avg);
        }

        if (nums[i] < avg) {
            nums[i] += 1;
            c[0] += cost[i];
            f(i, n, c, nums, cost, avg);

        } else if (nums[i] > avg) {
            nums[i] -= 1;
            c[0] += cost[i];
            f(i, n, c, nums, cost, avg);
        }
    }

    public int[] getAverages2(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }
        int n = nums.length;
        int[] avg = new int[n];
        Arrays.fill(avg, -1);

        if (2 * k + 1 > n) {
            return avg;
        }

        long windowSim = 0;
        for (int i = 0; i < (2 * k + 1); i++) {
            windowSim += nums[i];
        }
        avg[k] = (int) (windowSim / (2 * k + 1));

        for (int i = (2 * k + 1); i < n; i++) {

            windowSim = windowSim - nums[i - (2 * k + 1)] + nums[i];
            avg[i - k] = (int) (windowSim / (2 * k + 1));

        }
        return avg;

    }

    public int[] getAverages(int[] nums, int k) {
        if (k == 0) {
            return nums;
        }

        int n = nums.length;
        int[] averages = new int[n];
        Arrays.fill(averages, -1);

        if (2 * k + 1 > n) {
            return averages;
        }

        long[] prefix = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + nums[i];
        }

        for (int i = k; i < (n - k); ++i) {
            int leftBound = i - k;
            int rightBound = i + k;
            long subArraySum = prefix[rightBound + 1] - prefix[leftBound];
            int avg = (int) (subArraySum / (2 * k + 1));
            averages[i] = avg;
        }
        return averages;
    }

    static int MOD = (int) 1e9 + 7;

    public int countPaths(int[][] grid) {
        int answer = 0;
        int m = grid.length;
        int n = grid[0].length;

        int[][] vis = new int[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                answer = (answer + dfs(grid, i, j, vis)) % MOD;
            }
        }

        return answer;
    }

    static int dfs(int[][] grid, int i, int j, int[][] dp) {
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        int[][] directions = { { 0, 1 }, { 0, -1 }, { 1, 0 }, { -1, 0 } };

        int answer = 1;

        int[] delrow = { 0, 0, 1, -1 };
        int[] delcol = { 1, -1, 0, 0 };

        for (int k = 0; k < 4; k++) {
            int prevI = i + delrow[k];
            int prevJ = j + delcol[k];
            if (0 <= prevI && prevI < grid.length && 0 <= prevJ && prevJ < grid[0].length
                    && grid[prevI][prevJ] < grid[i][j]) {
                answer += dfs(grid, prevI, prevJ, dp);
                answer %= MOD;
            }
            dp[i][j] = answer;
        }
        return answer;
    }

    public int numOfWays(int[] nums) {
        int count = 0;
        List<Integer> less = new ArrayList<>();
        List<Integer> greater = new ArrayList<>();

        int root = nums[0];

        for (int n : nums) {
            if (n < root) {
                less.add(n);
            } else if (n > root) {
                greater.add(n);
            }
        }

        return 0;

    }

    public static int equalPairs2(int[][] grid) {
        int count = 0;
        int n = grid.length;

        HashMap<String, Integer> map = new HashMap<>();

        for (int[] row : grid) {
            String rowString = Arrays.toString(row);
            map.put(rowString, map.getOrDefault(rowString, 0) + 1);
        }

        for (int c = 0; c < n; c++) {
            int[] colArray = new int[n];
            for (int r = 0; r < n; r++) {
                colArray[r] = grid[r][c];
            }
            count += map.getOrDefault(Arrays.toString(colArray), 0);
        }
        return count;
    }

    public static int equalPairs(int[][] grid) {
        int count = 0;
        int n = grid.length;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                boolean match = true;

                for (int r = 0; r < n; r++) {
                    if (grid[i][r] != grid[r][j]) {
                        match = false;
                        break;
                    }
                }
                count += match ? 1 : 0;
            }
        }
        return count;
    }

    public List<String> summaryRanges(int[] nums) {
        List<String> ranges = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int start = nums[i];

            while (i + 1 < nums.length && nums[i] + 1 == nums[i + 1]) {
                i++;
            }

            if (start != nums[i]) {
                ranges.add(start + "-> " + nums[i]);
            } else {
                ranges.add(String.valueOf(start));
            }
        }
        return ranges;
    }

    public static int[] xorQueries(int[] arr, int[][] queries) {
        int[] xorpre = new int[arr.length];

        xorpre[0] = arr[0];
        for (int i = 1; i < arr.length; i++) {
            xorpre[i] = xorpre[i - 1] ^ arr[i];
        }

        int[] ans = new int[queries.length];

        for (int i = 0; i < queries.length; i++) {
            int[] q = queries[i];
            ans[i] = q[0] > 0 ? xorpre[q[1]] ^ xorpre[q[0] - 1] : xorpre[q[1]];
        }

        return ans;
    }

    public int[][] reconstructQueue(int[][] people) {

        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);

        List<int[]> ans = new ArrayList<>();
        for (int[] p : people) {
            ans.add(p[1], p);
        }
        return ans.toArray(new int[people.length][2]);
    }

    public int maxSum(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int max = 0;

        for (int i = 0; i < n - 2; i++) {
            for (int j = 0; j < m - 2; j++) {
                int currSum = grid[i][j] + grid[i][j + 1] + grid[i][j + 2] + grid[i + 1][j + 1] + grid[i + 2][j]
                        + grid[i + 2][j + 1] + grid[i + 2][j + 2];

                max = Math.max(currSum, max);
            }
        }

        return max;
    }

    public int countBattleships(char[][] board) {
        int n = board.length;
        int m = board[0].length;
        int[][] vis = new int[n][m];
        for (int[] a : vis) {
            Arrays.fill(a, -1);
        }
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (board[i][j] == 'X') {
                    if (vis[i][j] == -1) {
                        dfs(board, i, j, vis);
                    }
                }
            }
        }

        return count;
    }

    private void dfs(char[][] board, int i, int j, int[][] vis) {
        vis[i][j] = 1;

        int[] delrow = {};
        int[] delcol = {};

        for (int k = 0; k < 4; k++) {
            int nrow = delrow[i] + i;
            int ncol = delcol[j] + j;

            if (nrow >= 0 && ncol >= 0 && nrow < board.length && ncol < board[0].length && vis[nrow][ncol] == -1
                    && board[nrow][ncol] == 'X') {
                dfs(board, nrow, ncol, vis);
            }
        }
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int count = 0;
        int lastp = 0;
        int lastm = 0;
        int lastg = 0;

        for (int i = 0; i < garbage.length; i++) {
            for (int j = 0; j < garbage[i].length(); j++) {
                count++;
                if (garbage[i].charAt(j) == 'M') {
                    lastm = i;
                } else if (garbage[i].charAt(j) == 'G') {
                    lastg = i;
                } else {
                    lastp = i;
                }
            }
            System.out.println("count: " + count);
            System.out.println(lastg + " " + lastm + " " + lastp);
        }
        System.out.println("final");
        System.out.println(lastg + " " + lastm + " " + lastp);

        for (int i = 1; i < travel.length; i++) {
            travel[i] += travel[i - 1];
        }
        int ans = count;
        if (lastm > 0) {
            ans += travel[lastm - 1];
            System.out.println("take m");
            System.out.println(ans + " ans1");
        }
        if (lastg > 0) {
            ans += travel[lastg - 1];
            System.out.println("take g");
            System.out.println(ans + " ans2");
        }
        if (lastp > 0) {
            ans += travel[lastp - 1];
            System.out.println(travel[lastp - 1] + " t ka last p");
            System.out.println("take p");
            System.out.println(ans + " ans3");
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
