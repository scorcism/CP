import java.util.Arrays;

public class SortingAlgos {

    public static void main(String[] args) {

        int[] array1 = { 5, 8, 1, 3, 9, 12, 4, 6 };
        int[] array2 = { 9, 8, 7, 6, 5, 4, 3, 2, 1, 0 };
        int[] array3 = { -5, -8, -1, 3, -9, 12, 4, 6 };

        // System.out.println(Arrays.toString(bubbleSort(array3)));
        // System.out.println(Arrays.toString(insertionSort(array3)));
        // System.out.println(Arrays.toString(selectionSort(array3)));
    }

    // Ω(n^2)	θ(n^2)	O(n^2)	O(1)
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

}
