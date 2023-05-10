package Revision.tuf;

import java.util.*;

public class Day2 {

    // Commit format => tuf-dayNo-ProblemName
    public static void main(String[] args) {
        // numberOfInversionss(new int[] { 8, 4, 2, 1 });

    }

    static void numberOfInversionss(int[] arr) {
        int n = arr.length;
        int[] tmp = new int[n];
        int ans = _mergeSortInversion(arr, tmp, 0, n - 1);
        System.out.println(ans + " - inversions");
    }

    private static int _mergeSortInversion(int[] arr, int[] tmp, int left, int right) {
        int mid, inv_count = 0;
        if (right > left) {
            mid = (right + left) / 2;
            inv_count += _mergeSortInversion(arr, tmp, left, mid);
            inv_count += _mergeSortInversion(arr, tmp, mid + 1, right);
            inv_count += _merge(arr, tmp, left, mid + 1, right);

        }
        return inv_count;
    }

    private static int _merge(int[] arr, int[] tmp, int left, int mid, int right) {
        int i, j, k = 0;
        int inv_count = 0;
        i = left; // index for left sub-array
        j = mid; // index for right sub-array
        k = left; // for resutant array
        while ((i <= mid - 1) && (j <= right)) {
            if (arr[i] <= arr[j]) {
                tmp[k++] = arr[i++];
            } else {
                tmp[k++] = arr[j++];

                // mid - i -> i is the start index of left array and mid is the end as
                // specidifed in the condition if left one is greater measn all the number in
                // left one will be the inversikn so the length or elements in that left bound
                // will be the count.
                inv_count = inv_count + (mid - i);
            }
        }

        while (i <= mid - 1) {
            tmp[k++] = arr[i++];
        }
        while (j <= right) {
            tmp[k++] = arr[j++];
        }

        for (i = left; i <= right; i++) {
            arr[i] = tmp[i];
        }
        return inv_count;
    }

    static void missingAndRepeating(int[] arr) {
        // Hashing method
        int misssing = -1;
        int repeating = -1;
        boolean[] hash = new boolean[arr.length + 1];
        for (int a : arr) {
            if (hash[a]) {
                repeating = a;
                break;
            } else {
                hash[a] = true;
            }
        }
        for (int i = 1; i < hash.length; i++) {
            if (hash[i] == false) {
                misssing = i;
                break;
            }
        }
        System.out.println("Missing: " + misssing + " Repeating: " + repeating);
    }

    static void missingAndRepeating2(int[] arr) {
        // Using Algebra
        int n = arr.length;

        long sumN = (n * (n + 1)) / 2;
        long sumn2 = (n * (n + 1) * (2 * n + 1)) / 6;
        long arrsum = 0;
        long arrsquare = 0;
        for (int a : arr) {
            arrsum += a;
            arrsquare += a * a;
        }
        // sn-sa
        // s2n-s2a;
        long val1 = sumN - arrsum; // x - y
        long val2 = sumn2 - arrsquare; // x^2 - y^2

        val2 = val2 / val1; // x + y
        long x = (val1 + val2) / 2;
        long y = x - val1;

        System.out.println("Missing: " + x + " Repeating: " + y);
    }

    public int findDuplicate(int[] nums) {
        // performing modified cyclic sort
        int index = 0;
        while (index < nums.length) {
            if (nums[index] != index + 1) {
                int correctIndex = nums[index];
                if (nums[index] != nums[correctIndex]) {
                    swap(nums, index, correctIndex);
                } else {
                    return nums[index];
                }
            }
        }
        return -1;
    }

    public int findDuplicate2(int[] nums) {
        // performing modified cyclic sort
        int slow = nums[0];
        int fast = nums[0];
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);
        fast = nums[0];

        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }
        return slow;
    }

    // 88. Merge Sorted Array
    public void merge1(int[] nums1, int m, int[] nums2, int n) {
        int i = 0;
        int j = 0;
        int[] ans = new int[m + n];
        int k = 0;
        while (i < m && j < n) {
            if (nums1[i] <= nums2[j]) {
                // ith element is small
                ans[k] = nums1[i];
                i++;
                k++;
            } else {
                // jth element is small
                ans[k] = nums2[j];
                j++;
                k++;
            }
        }
        // if left arrya get exosted
        while (i < m) {
            ans[k] = nums1[i];
            k++;
            i++;
        }
        // if right array get exosted
        while (j < n) {
            ans[k] = nums2[j];
            k++;
            j++;
        }
        for (int p = 0; p < ans.length; p++) {
            nums1[p] = ans[p];
        }
    }

    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // GAP method
        for (int i = 0; i < n; i++) {
            nums1[m + i] = nums2[i];
        }
        int length = m + n;
        int gap = length / 2 + length % 2;

        while (gap > 0) {
            for (int i = 0; i < n + m - gap; i++) {
                if (nums1[i] > nums1[i + gap]) {
                    swap(nums1, i, i + gap);
                }
            }
            if (gap == 1) {
                break;
            }
            gap = gap / 2 + gap % 2;

        }
    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }

    // 56. Merge Intervals
    public int[][] merge(int[][] intervals) {
        List<int[]> ans = new ArrayList<>();
        // check for empty intervals
        if (intervals.length == 0 || intervals == null) {
            return ans.toArray(new int[0][]);
        }

        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);

        int[] first = intervals[0];
        for (int[] a : intervals) {
            if (a[0] <= first[1]) {
                // its merging time
                first[1] = Math.max(a[1], first[1]);
            } else {
                // not merging
                // add to the ans list
                ans.add(new int[] { first[0], first[1] });
                // make first to current one
                first = a;
            }
        }
        ans.add(new int[] { first[0], first[1] });
        return ans.toArray(new int[0][]);

    }

    // 48. Rotate Image
    public void rotate(int[][] matrix) {
        // O(N*N)
        // O(1)
        // get the transpose
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int tmp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = tmp;
            }
        }
        // reverse each row
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length / 2; j++) {
                int tmp = matrix[i][matrix.length - i - 1];
                matrix[i][matrix.length - i - 1] = matrix[i][j];
                matrix[i][j] = tmp;
            }
        }
    }
}
