package Algos.sortingAlgos;

import java.util.*;

public class Quick {
    public static void main(String[] args) {
        int[] arr = { 4, 1, 2, 7, 4, 0, -1, -6 };
        quick(arr);
        System.out.println(Arrays.toString(arr));
    }

    static void quick(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low;
        int j = high;
        int m = low + (high - low) / 2;
        int pivot = arr[m];

        while (i <= j) {
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            if (i <= j) {
                int tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        quickSort(arr, low, j);
        quickSort(arr, i, high);

    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[j] = arr[i];
        arr[i] = tmp;
    }

}
