import java.util.*;

public class SortingAlgos {
    public static void main(String[] args) {

    }
}

class MergeSort {

    public static void Main(String[] args) {
        int[] arr = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        int low = 0;
        int high = arr.length - 1;
        mergeSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    static void mergeSort(int[] arr, int low, int high) {
        if (low >= high) { // we have at least one element
            return;
        }
        int mid = (low + high) / 2;
        mergeSort(arr, low, mid); // for left
        mergeSort(arr, mid + 1, high); // for right
        merge(arr, low, mid, high);

    }

    static void merge(int[] arr, int low, int mid, int high) {
        ArrayList<Integer> tmp = new ArrayList<>();
        int left = low;
        int right = mid + 1;

        while (left <= mid && right <= high) {
            if (arr[left] <= arr[right]) {
                tmp.add(arr[left]);
                left++;
            } else {
                tmp.add(arr[right]);
                right++;
            }
        }

        while (left <= mid) {
            tmp.add(arr[left]);
            left++;
        }
        while (right <= high) {
            tmp.add(arr[right]);
            right++;
        }

        for (int i = low; i <= high; i++) {
            arr[i] = tmp.get(i - low);
        }

    }

}

class QuickSort {

    public static void Main(String[] args) {
        int[] arr = { 3, 1, 2, 4, 1, 5, 2, 6, 4 };
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr, low, high);
        System.out.println(Arrays.toString(arr));
    }

    static void quickSort(int[] arr, int low, int high) {
        if (low < high) { // we have at least 1 ele
            int partition = sort(arr, low, high);
            quickSort(arr, low, partition - 1);
            quickSort(arr, partition + 1, high);
        }
    }

    private static int sort(int[] arr, int low, int high) {
        int i = low;
        int j = high;
        int pivot = arr[low];

        while (i < j) {
            while (arr[i] <= pivot && i <= high - 1) {
                i++;
            }
            while (arr[j] >= pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                swap(arr, i, j);
            }
        }
        swap(arr, j, low);
        return j;

    }

    static void swap(int[] arr, int a, int b) {
        int tmp = arr[a];
        arr[a] = arr[b];
        arr[b] = tmp;
    }
}
