import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.Queue;

public class CP3 {
    public static void main(String[] args) {

        // String one = "Abhishek";
        // String two = "his";
        // System.out.println(strStr(one, two));
        int[] arr = {2,3,4,7,11};
        int k = 7;
        // System.out.println(findKthPositive(arr, k));
    }

    public static  int findKthPositive(int[] arr, int k) {
        int left = 0;
        int right = arr.length -1;

        while(left <= right){
            int mid = left + (right - left)/2;
            System.out.println("mid: " + mid);
            if(arr[mid]-mid-1<k){
                System.out.println("arr[mid]-mid-1: "+ (arr[mid]-mid-1));
                left = mid +1;
                System.out.println("left = mid+1");
                System.out.println("left: " + left);
            }else{
                right = mid -1;
                System.out.println("right = mid -1");
                System.out.println("right:"  +right);
            }
        }
        System.out.println("left: " + left);
        return left + k;
    }


    public int minJumps(int[] arr) {
        int n = arr.length;
        if (n == 1)
            return 0;

        Map<Integer, List<Integer>> indices = new HashMap<>();
        for (int i = 0; i < n; i++) {
            indices.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);
        }

        Queue<Integer> storeIndex = new LinkedList<>();
        boolean[] visited = new boolean[n];
        storeIndex.offer(0);
        visited[0] = true;
        int steps = 0;

        while (!storeIndex.isEmpty()) {
            int size = storeIndex.size();
            while (size-- > 0) {
                int currIndex = storeIndex.poll();
                if (currIndex == n - 1)
                    return steps;

                List<Integer> jumpNextIndices = indices.get(arr[currIndex]);
                jumpNextIndices.add(currIndex - 1);
                jumpNextIndices.add(currIndex + 1);
                for (int jumpNextIndex : jumpNextIndices) {
                    if (jumpNextIndex >= 0 && jumpNextIndex < n && !visited[jumpNextIndex]) {
                        storeIndex.offer(jumpNextIndex);
                        visited[jumpNextIndex] = true;
                    }
                }
                jumpNextIndices.clear();
            }
            steps++;
        }
        return -1;

    }

    public long countSubarraysMethod1(int[] nums, int minK, int maxK) {
        long leftMostMin = -1;
        long leftMin = -1;
        long rightMax = -1;
        long totalSubArray = 0;

        for (int i = 0; i < nums.length; ++i) {
            if (nums[i] < minK || nums[i] > maxK) {
                leftMostMin = i;
            }
            if (nums[i] == minK) {
                leftMin = i;
            }
            if (nums[i] == maxK) {
                rightMax = i;
            }
            totalSubArray += Math.max(0L, Math.min(leftMin, rightMax) - leftMostMin);
        }
        return totalSubArray;

    }

    public static int strStr(String haystack, String needle) {
        if (needle.length() == 0) {
            return 0;
        }
        if (needle.length() > haystack.length()) {
            return -1;
        }
        int i = 0;
        int j = needle.length();
        while (j <= haystack.length()) {
            // System.out.println(i +" i");
            if (needle.equals(haystack.substring(i, j))) {
                // System.out.println("i j " + i + " " + j + " ");
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }

    public static int compressM2(char[] chars) {

        int indexAns = 0;
        int index = 0;
        while (index < chars.length) {
            char currchar = chars[index];
            int count = 0;
            while (index < chars.length && chars[index] == currchar) {
                index++;
                count++;
            }
            chars[indexAns++] = currchar;
            if (count != 1) {
                for (char ch : Integer.toString((count)).toCharArray()) {
                    chars[indexAns++] = ch;
                }
            }
        }

        return indexAns;
    }

    public static int compress(char[] chars) {
        int i = 0;
        int res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i] == chars[i + 1]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if (groupLength > 1) {
                for (char c : Integer.toString(groupLength).toCharArray())
                    ;

                chars[res++] = c;
            }
            i += groupLength;
        }

        return res;
    }
}
