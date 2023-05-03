import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;

public class CP5 {

    public static void main(String[] args) {
        // System.out.println(squareOfNumber(15));
        // System.out.println(divide(3, 33));
        // List<List<Integer>> ans = powerSet(new int[] {1,2,3});
        // System.out.println(ans);
        System.out.println(Arrays.toString(singleNumber(new int[] {1,2,3,2,1,4})));
    }


    


    public static int[] singleNumber(int[] nums)
    {
        int[] ans= new int[2];
        int n = nums.length;
        int xor = 0;
        for(int i = 0; i< n ; i++){
            xor ^= nums[i];
        }

        // getting the right most set bit 
        int rightmostSetBit = xor & ~(xor-1);
        int x = 0;
        int y = 0;

        for(int i = 0; i<n; i++){
            if((nums[i] & rightmostSetBit )!=0){
                x = x ^ nums[i];
            }else{
                y = y ^ nums[i];
            }   
        }
        ans[0] = x;
        ans[1] = y;
        Arrays.sort(ans);
        return ans;
    }


    public int arraySign(int[] nums) {
        int countp = 0;
        int countn = 0;
        for (int n : nums) {
            if (n == 0) {
                return 0;
            }
            if (n < 0) {
                countn++;
            } else if (n > 0) {
                countp++;
            }
        }

        return ((countn & 1) == 1) ? -1 : 1;
    }

    public static List<List<Integer>> powerSet(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int size = nums.length;
        for (int i = 0; i < (1 << size); i++) {
            List<Integer> a = new ArrayList<>();
            for (int j = 0; j < size; j++) {
                if (((i >> j) & 1) == 1) {
                    a.add(nums[j]);
                }
            }
            ans.add(a);
        }
        return ans;
    }

    public static int divide(int a, int b) {
        int divident = Math.abs(a);
        int divisor = Math.abs(b);
        int res = 0;

        while (divident - divisor >= 0) {
            int x = 0; // 2 ^ 0 = 1

            while (divident - (divisor << 1 << x) >= 0) {
                x++;
            }
            res += 1 << x;
            divident -= divisor << x;
        }

        return (divident >= 0) == (divisor >= 0) ? res : -res;
    }

    public static int squareOfNumber(int n) {
        int square = 0;

        int noOfBits = (int) ((Math.log(n) / Math.log(2)) + 1);

        for (int i = 0; i < noOfBits; i++) {
            if (((n >> i) & 1) == 1) {
                square += n << i;
            }
        }

        return square;
    }
}
