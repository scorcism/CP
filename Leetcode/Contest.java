import java.util.*;

public class Contest {
    public static void main(String[] args) {

        Contest365 c = new Contest365();
        System.out.println(c.maximumTripletValue(new int[] { 1000000, 1, 1000000 }));

    }
}

class Contest365 {

    public long maximumTripletValue2(int[] nums) {
        long max = -1;
        
        
        return max;
    }

    public long maximumTripletValue(int[] nums) {
        long max = -1;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    max = Math.max(max, (long)(nums[i] - nums[j]) * nums[k]);
                    // System.out.println((max));
                }
            }
        }
        if (max < 0) {
            return 0;
        } else {
            return max;
        }
    }
}

class Contest363 {

    public int countWays(List<Integer> nums) {
        Collections.sort(nums);
        int ways = 0;

        return ways;
    }

    public int sumIndicesWithKSetBits(List<Integer> nums, int k) {
        int ans = 0;
        for (int i = 0; i < nums.size(); i++) {
            if (getSetBits(i) == k) {
                ans += nums.get(i);
            }
        }
        return ans;
    }

    private static int getSetBits(int index) {
        if (index == 0) {
            return 0;
        } else {
            return (index & 1) + getSetBits(index >> 1);
        }
    }
}

class Contest113 {

    public int minLengthAfterRemovals2(List<Integer> nums) {

        int i = 0;
        int n = nums.size();
        int j = (nums.size() + 1) / 2;
        int ans = n;
        while (i < n / 2 && j < n) {
            if (nums.get(i) < nums.get(j)) {
                ans -= 2;
            }
        }

        return ans;
    }

    public int minLengthAfterRemovals(List<Integer> nums) {
        int ans = 0;
        Map<Integer, Integer> map = new HashMap<>();

        for (int a : nums) {
            map.put(a, map.getOrDefault(a, 0) + 1);
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
            pq.add(entry.getValue());
        }

        while (!pq.isEmpty()) {
            int curr1 = pq.poll();
            if (pq.isEmpty()) {
                ans = curr1;
                break;
            }
            int curr2 = pq.poll();
            curr1--;
            curr2--;
            if (curr1 != 0) {
                pq.add(curr1);
            }
            if (curr2 != 0) {
                pq.add(curr2);
            }
        }

        return ans;
    }

    public int minimumRightShifts(List<Integer> nums) {

        int n = nums.size();
        for (int i = 0; i < n; i++) {
            int found = 0;

            for (int j = i + 1; j < n + i; j++) {
                if (nums.get(j % n) < nums.get((j - 1) % n)) {
                    found = 1;
                    break;
                }
            }
            if (found == 0) {
                return (n - i) % n;
            }
        }

        return -1;
    }
}

class SolutionWeeklyContest357 {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int m = grid.get(0).size();
        int count = 0;

        ArrayList<Pair> al = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (grid.get(i).get(j) == 1) {
                    al.add(new Pair(i, j, grid.get(i).get(j)));
                }
            }
        }

        return count;
    }

    static int getManDist(Pair i, Pair j) {
        int ans = 0;

        ans = Math.abs(i.i - j.i) + Math.abs(i.j - j.j);

        return ans;
    }

    static class Pair {
        int i, j, num;

        Pair(int i, int j, int num) {
            this.i = i;
            this.j = j;
            this.num = num;
        }
    }

    public boolean canSplitArray2(List<Integer> nums, int m) {
        int n = nums.size();
        int count = 1;

        int totalsum = 0;
        for (int p : nums) {
            totalsum += p;
        }
        totalsum -= nums.get(0);

        int i = 1;
        while (i < n) {
            if (totalsum >= m) {
                count++;
                i++;
                totalsum -= nums.get(i);
            } else if (totalsum < m) {
                break;
            }
        }

        return count >= n;
    }

    public boolean canSplitArray(List<Integer> nums, int m) {
        int n = nums.size();

        int i = 0;
        int j = 0;
        int count = 0;
        int sum = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        while (j < n) {
            map.put(nums.get(j), map.getOrDefault(nums.get(j), 0) + 1);

            sum += nums.get(i);
            if (j - i + 1 < 2) {
                j++;

            } else if (j - i + 1 >= 2) {
                if (map.size() >= 1) {
                    count++;
                } else if (sum >= m) {
                    count++;
                }
                if (map.containsKey(nums.get(i))) {
                    map.put(nums.get(i), map.get(nums.get(i)));
                    if (map.get(nums.get(i)) < 1) {
                        map.remove(nums.get(i));
                    }
                    sum -= nums.get(i);
                }

                i++;
                j++;
            }

        }
        return count == n;
    }

    static void foundAndRevere(StringBuilder sb) {
        sb.reverse();
    }

    public String finalString(String s) {
        StringBuilder sb = new StringBuilder();

        for (char c : s.toCharArray()) {
            if (c != 'i') {
                sb.append(c);
            } else if (c == 'i') {
                foundAndRevere(sb);
            }
        }
        return sb.toString();
    }
}

class SolutionWeeklyContest352 {

    // Weekly Contest 352
    public int longestAlternatingSubarray2(int[] nums, int threshold) {
        int maxLen = 0;
        for (int i = 0; i < nums.length; i++) {
            int max = 0;
            if (nums[i] % 2 != 0) {
                max = 0;
            }
            if (nums[i] <= threshold) {
                if (i < nums.length && nums[i] % 2 != nums[i + 1] % 2) {
                    max++;
                }
            }
            if (max > maxLen) {
                maxLen = max;
            }
        }
        return maxLen;
    }

    public int longestAlternatingSubarray(int[] nums, int threshold) {
        int maxLen = 1;
        for (int l = 0; l < nums.length; l++) {

            if (nums[l] % 2 == 0) {

                for (int r = l; r < nums.length; r++) {
                    int max = 1;
                    for (int i = l; i <= r; i++) {

                        if (nums[i] <= threshold) {

                            if (i < nums.length - 1 && nums[i] % 2 != nums[i + 1] % 2) {
                                // System.out.println("In l: "+ nums[l] +" r: " + nums[i]);
                                max++;
                            }

                        }
                    }
                    maxLen = Math.max(maxLen, max);
                }
            }
        }
        return maxLen;
    }
}