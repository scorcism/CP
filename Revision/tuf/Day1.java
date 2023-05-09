package Revision.tuf;

import java.util.*;

// 09-05-2023
public class Day1 {

    // https://takeuforward.org/interviews/strivers-sde-sheet-top-coding-interview-problems/

    /*
     * 
     */

    public static void main(String[] args) {

    }

    // 75. Sort Colors
    public void sortColors(int[] nums) {
        int n = nums.length;
        int low =  0;
        int mid = 0;
        int high = n-1;
        while(mid <= high){
            if(nums[mid]==0){
                swap(nums,mid,low);
                mid++;
                low++;
            }else if(nums[mid]==1){
                mid++;
            }else{
                swap(nums,mid,high);
                high--;
            }
        }
    }

    // 53. Maximum Subarray
    public int maxSubArray1(int[] nums) {
        // N^3
        // O(1)
        int ans = Integer.MIN_VALUE;
        int n = nums.length;
        for(int i = 0; i< n; i++){
            for(int j = i; j<n ; j++){
                int sum = 0;
                for(int k = i;k<j; k++){
                    sum+=nums[i];
                }
                ans = Math.max(ans, sum); 
            }
        }
        return ans;
    }
    public int maxSubArray2(int[] nums) {
        // Kadane
        // O(1)
        int ans = Integer.MIN_VALUE;
        int sum = 0;
        for(int i = 0; i< nums.length; i++){
            sum+=nums[i];

            if(sum > ans){
                ans =sum;
            }
            if(sum <0){
                sum  = 0;
            }
        }
        return ans;
    }

    // 31. Next Permutation
    public void nextPermutation(int[] nums) {
        int index1 = -1;
        for(int i = nums.length-2; i>=0; i--){
            if(nums[i]< nums[i+1]){
                index1 = i;
                break;
            }
        }

        if(index1 == -1){
            reverse(nums, 0, nums.length-1);
            return;
        }

        for(int i = nums.length-1;i>index1; i--){
            if(nums[i] > nums[index1]){
                swap(nums,i, index1);
                break;
            }
        }
        reverse(nums,index1+1, nums.length-1);
    }
    private void reverse(int[] nums, int i, int j) {
        while(i<j){
            swap(nums, i++, j--);
        }
    }

    void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }


    // 118. Pascal's Triangle
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> curr = null;
        List<Integer> prev = null;
        for (int i = 0; i < numRows; i++) {
            curr = new ArrayList<>();
            for(int j = 0; j<= i; j++){
                if(j==0 || j==i){
                    curr.add(1);
                }else{
                    curr.add(prev.get(j-1)+prev.get(j));   
                }
            }
            prev = curr;
            ans.add(curr);
        }
        return ans;
    }

    // Set Matrix Zeroes
    public void setZeroes1(int[][] matrix) {
        // TLE
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == 0) {
                    int index = j;

                    while (index >= 0) {
                        // for top
                        if (matrix[i][index] != 0) {
                            matrix[i][index] = -1;
                            index--;
                        }
                    }

                    index = j;

                    while (index < matrix[0].length) {
                        if (matrix[i][index] != 0) {
                            // for buttom
                            matrix[i][index] = -1;
                            index++;
                        }
                    }

                    int drow = i;
                    index = j;
                    while (drow >= 0) {
                        if (matrix[drow][index] != 0) {
                            // for left
                            matrix[drow][index] = -1;
                            drow--;
                        }
                    }

                    drow = i;
                    index = j;
                    while (drow < matrix.length) {
                        if (matrix[drow][index] != 0) {
                            // for right
                            matrix[drow][index] = -1;
                            drow++;
                        }
                    }
                }

            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == -1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes2(int[][] matrix) {
        // TC -> O(N*M)
        // SC -> O(N+M)
        int m = matrix.length;
        int n = matrix[0].length;
        int[] drow = new int[m];
        int[] dcol = new int[n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    drow[i] = 1;
                    dcol[j] = 1;
                }
            }
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (drow[i] == 1 && dcol[j] == 1) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    public void setZeroes3(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean flag = false;

        for (int i = 0; i < n; i++) {
            if (matrix[i][0] == 0) {
                flag = true;
            }
            for (int j = 1; j < m; j++) {
                if (matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 1; j--) {
                if (matrix[0][j] == 0 || matrix[i][0] == 0) {
                    matrix[i][j] = 0;
                }
            }
            if (flag) {
                matrix[i][0] = 0;
            }
        }
    }

}
