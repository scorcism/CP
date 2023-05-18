package BS;

import java.util.Arrays;

public class BinarySearch {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        int aa[] = { 1, 2, 3, 4, 4, 7, 8, 9 };
        int b[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int bb[] = { 6, 7, 8, 9, 2, 3, 4, 5 };
        // System.out.println(bs(a , 9));
        // System.out.println(reverseArray(b, 2));
        // System.out.println(Arrays.toString(firstandlast(aa, 2)));
        // System.out.println(countinSortedArray(aa, 4));
        System.out.println(numberOfTimes(bb));
    }

    

    // Number of Times a Sorted array is Rotated
    static int numberOfTimes(int[] arr) {
        // Index of min element
        // coz min element was supposed to be at 0th index but its is shifte by x
        // position
        // and we have to return that x value
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            // System.out.println(mid);

            int prev = (mid - 1 + arr.length) % arr.length;

            int next = (mid + 1) % arr.length;

            if (arr[mid] <= arr[prev] && arr[mid] <= arr[next]) {
                return mid;
            }

            if (arr[0] <= arr[mid]) {
                low = mid + 1;
            } else if (arr[mid] <= arr[arr.length-1]) {
                high = mid - 1;
            }
        }
        return -1;
    }

    // count of ele in sorted array
    static int countinSortedArray(int[] arr, int target) {

        int first = -1;
        int last = -1;

        int low = 0;
        int high = arr.length - 1;

        // for 1st occurace
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (target <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = arr.length - 1;
        // for 1st occurace
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (target <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return last - first + 1;
    }

    // First and Last occcurance
    static int[] firstandlast(int[] arr, int target) {

        int first = -1;
        int last = -1;

        int low = 0;
        int high = arr.length - 1;

        // for 1st occurace
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == target) {
                first = mid;
                high = mid - 1;
            } else if (target <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        low = 0;
        high = arr.length - 1;
        // for 1st occurace
        while (low <= high) {
            // int mid = (low + high) / 2;
            int mid = low + ((high - low) >> 1);

            if (arr[mid] == target) {
                last = mid;
                low = mid + 1;
            } else if (target <= arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return new int[] { first, last };
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