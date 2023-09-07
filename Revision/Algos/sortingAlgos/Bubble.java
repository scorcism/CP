package Algos.sortingAlgos;
import java.util.*;


public class Bubble {

    public static void main(String[] args) {
        int[] arr = { 5, 4, 1, 2,0, 3 };
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    public static void sort(int[] arr) {
        boolean isSwap = false;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 1; j < arr.length - i; j++) {
                if (arr[j] < arr[j - 1]) {
                    swap(arr, j, j - 1);
                    isSwap = true;
                }
            }
            if(!isSwap){
                break;
            }
        }
    }

    public static void swap(int[] arr, int a, int b){
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp; 
    }
}

