import java.util.*;

public class Contest {
    public static void main(String[] args) {

        SolutionWeeklyContest357 sol = new SolutionWeeklyContest357();
        ArrayList<Integer> list = new ArrayList<>();
        // list.add(2);
        // list.add(3);
        // list.add(3);
        // list.add(2);
        // list.add(2);
        // list.add(1);
        // list.add(3);
        list.add(2);
        list.add(2);
        list.add(1);
        System.out.println(sol.canSplitArray2(list, 4));
    }
}

class SolutionWeeklyContest357 {

    public int maximumSafenessFactor(List<List<Integer>> grid) {

        int n = grid.size();
        int m = grid.get(0).size();
        int count = 0;

        ArrayList<Pair> al = new ArrayList<>();

        for(int i = 0; i < n; i++){
            for(int j = 0; j< m; j++){
                if(grid.get(i).get(j) == 1){
                    al.add(new Pair(i, j,grid.get(i).get(j) ));
                }
            }
        }

        return count;
    }

    static int getManDist(Pair i, Pair j){
        int ans=  0;

        ans= Math.abs(i.i - j.i) +  Math.abs(i.j - j.j);

        return ans;
    }


    static class Pair{
        int i, j, num;
        
        Pair(int i, int j, int num){
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
            }else if(totalsum < m){
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