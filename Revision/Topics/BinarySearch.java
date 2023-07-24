import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {

        BS bs = new BS();

        System.out.println(bs.minEatingSpeed(new int[] { 3, 6, 7, 11 }, 8));
    }
}

class BS {
    public int bs(int[] nums, int k) {
        int low = 0;
        int high = nums.length - 1;
        while (low <= high) {
            i++;
            int mid = low + ((high - low) >> 1);

            if (nums[mid] == k) {
                return mid;
            } else if (nums[mid] < k) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public int minEatingSpeed(int[] piles, int h) {

        int ans = 0;
        int start = 1;
        int end = 0;

        for (int n : piles) {
            end = Math.max(end, n);
        }

        while (start <= end) {
            int mid = start + ((end - start) >> 1);

            if (isPosibleToEat(piles, h, mid)) {
                ans = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return ans;
    }

    public static boolean isPosibleToEat(int[] nums, int h, int mid) {
        int hours = 0;

        for (int i = 0; i < nums.length; i++) {
            int div = nums[i] / mid;
            hours += div;
            if (nums[i] % mid != 0) {
                hours++;
            }
        }

        return hours <= h;
    }

}
