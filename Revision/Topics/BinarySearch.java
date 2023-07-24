import java.util.*;

public class BinarySearch {

    public static void main(String[] args) {

        BS bs = new BS();

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

}
