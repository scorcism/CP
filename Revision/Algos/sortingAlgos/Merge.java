package Algos.sortingAlgos;

import java.util.Arrays;

public class Merge {
    public static void main(String[] args) {
        int[] arr = { 5, 3, 8, 2, -1, 2, 0, -5 };
        mergeSort(arr, 0, arr.length);
        System.out.println(Arrays.toString(arr));
    }

    public static void mergeSort(int[] arr, int left, int right) {
        if (right - left == 1) {
            return;
        }
        int mid = (right + left) / 2;
        mergeSort(arr, left, mid);
        mergeSort(arr, mid, right);
        merge(arr, left, mid, right);
    }

    static void merge(int[] arr, int left, int mid, int right) {
        int[] tmp = new int[right - left];
        int i = left;
        int j = mid;
        int k = 0;

        while (i < mid && j < right) {
            if (arr[i] < arr[j]) {
                tmp[k] = arr[i];
                i++;
            } else {
                tmp[k] = arr[j];
                j++;
            }
            k++;
        }

        while (i < mid) {
            tmp[k] = arr[i];
            i++;
            k++;
        }

        while (j < right) {
            tmp[k] = arr[j];
            j++;
            k++;
        }

        for (int l = 0; l < tmp.length; l++) {
            arr[l + left] = tmp[l];
        }
    }
}
