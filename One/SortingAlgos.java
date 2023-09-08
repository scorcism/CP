import java.util.Arrays;

public class SortingAlgos {

    public static void main(String[] args) {

        int[] array1 = { 5, 8, 1, 3, 9, 12, 4, 6 };
        int[] array2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] array3 = { -5, -8, -1, 3, -9, 12, 4, 6 };

        // System.out.println(Arrays.toString(bubbleSort(array3)));
        // System.out.println(Arrays.toString(insertionSort(array3)));
        // System.out.println(Arrays.toString(selectionSort(array3)));
        // quickSort(array3,0,array3.length-1);
        mergeSort(array3, 0, array3.length);
        System.out.println(Arrays.toString(array3));
    }

    // Ω(n log(n)) θ(n log(n)) O(n log(n)) O(n)
    private static void mergeSort(int[] array, int left, int right) {
        if (right - left == 1) {
            return;
        }
        int mid = (left + right) / 2;
        mergeSort(array, left, mid);
        mergeSort(array, mid, right);
        merge(array, left, mid, right);

    }

    public static void merge(int[] array, int left, int mid, int right) {
        int[] b = new int[right - left];

        int i = left;
        int j = mid;
        int k = 0;

        while (i < mid && j < right) {
            if (array[i] < array[j]) {
                b[k] = array[i];
                i++;
            } else {
                b[k] = array[j];
                j++;
            }
            k++;
        }
        // if anything is left in any of the array
        if (i < mid) {
            b[k] = array[i];
            i++;
            k++;
        }
        if (j < right) {
            b[k] = array[j];
            j++;
            k++;
        }

        // copy the new b array into the orifinal array
        for (int l = 0; l < b.length; l++) {
            array[l + left] = b[l];
        }
        
    }

    // Ω(n log(n)) θ(n log(n)) O(n^2) O(n)
    static void quickSort(int[] arr, int low, int high) {
        if (low >= high) {
            return;
        }
        int s = low;
        int e = high;
        int m = s + (e - s) / 2;
        int pivot = arr[m];
        while (s <= e) {
            while (arr[s] < pivot) {
                s++;
            }
            while (arr[e] > pivot) {
                e--;
            }
            if (s <= e) {
                int tmp = arr[s];
                arr[s] = arr[e];
                arr[e] = tmp;
                s++;
                e--;
            }
        }
        // now the pivot is at correct index plz sort the two halves
        quickSort(arr, low, e);
        quickSort(arr, s, high);

    }

    // Ω(n^2) θ(n^2) O(n^2) O(1)
    public static int[] selectionSort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            int min = i;
            for (int j = i + 1; j < array.length; j++) {
                if (array[j] < array[min]) {
                    min = j;
                }
            }
            if (min != i) {
                // swap min and array[i]
                int tmp = array[min];
                array[min] = array[i];
                array[i] = tmp;
            }
        }
        return array;
    }

    // Ω(n) θ(n^2) O(n^2) O(1)
    public static int[] insertionSort(int[] array) {
        for (int i = 1; i < array.length; i++) {
            int tmp = array[i];
            int j = i - 1;
            while (j >= 0 && array[j] > tmp) {
                array[j + 1] = array[j];
                j--;
            }

            array[j + 1] = tmp;
        }

        return array;
    }

    // Ω(n) θ(n^2) O(n^2) O(1)
    public static int[] bubbleSort(int[] array) {
        int n = array.length;
        /*
         * Compare the adjacent 2 elements
         * If right one is smaller then the left one then swap or else leave
         */
        for (int i = 0; i < n - 1; i++) {
            boolean swapped = false;
            for (int j = 0; j < n - i - 1; j++) {
                if (array[j + 1] < array[j]) {
                    // swap
                    swapped = true;
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
            // If no swap occured in the ith postiion then break the loop.
            if (!swapped) {
                break;
            }
        }

        return array;
    }

    private static void swap(int[] array, int first, int second) {
        int tmp = array[first];
        array[second] = array[first];
        array[first] = tmp;
    }
}
