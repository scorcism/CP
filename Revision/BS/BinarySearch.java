package BS;

public class BinarySearch {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int b[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        // System.out.println(bs(a , 9));
        System.out.println(reverseArray(b, 2));
    }


    
    // Order Not Known Search -> dont know if ascending or decending
    // Order Agnostic Search
    static int notKnowOrder(int[] arr, int target) {
        // compare 1st and last ele
        int start = 0;
        int end = arr.length - 1;
        if (arr[start] < arr[end]) {
            // sorted in ascending
        } else if (arr[start] > arr[end]) {
            // sorted in descending

        }

        return -1;
    }

    // Reverse sorted array
    static int reverseArray(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = start + ((end - start) >> 1);
            if (arr[mid] == target) {
                return mid;
            } else if (target < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int bs(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == target) {
                return mid;
            } else if (target <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return -1;
    }

}