

import java.util.*;

public class BinarySearch2 {

    public static void main(String[] args) {
        int a[] = { 1, 2, 3, 4, 7, 8, 9 };
        int aa[] = { 1, 2, 3, 4, 4, 7, 8, 9 };
        int b[] = { 9, 8, 7, 6, 5, 4, 3, 2, 1 };
        int bb[] = { 6, 7, 8, 9, 2, 3, 4, 5 };
        int c[] = { 5, 10, 30, 20, 40 };
        char ch[] = { 'a', 'b', 'c', 'd', 'f', 'i' };
        // System.out.println(nextAlpla(ch, 'd'));

    }

    // Minimum Difference Element in a Sorted Array
    static int minDifference(int[] arr, int target) {
        // basically we need to perfon find floor and find ceil
        // just to basic bs
        // low = ceil of target
        // high = floow of target
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                return arr[mid];
            }
            if (target < arr[mid]) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return Math.min(Math.abs(low - target), Math.abs(high - target));
    }

    // Index of First 1 in a Binary Sorted Infinite Array
    static int infiniteSortedBinary(int[] arr) {
        // infinitee sorted + first occurance
        int low = 0;
        int high = 1;
        int target = 1;
        while (target > arr[high]) {
            low = target;
            high = high * 2;
        }

        int res = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                res = mid;
                high = mid - 1;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    // Find position of an element in an Infinite Sorted Array
    static int infiniteSorted(int[] arr, int target) {
        int start = 0;
        int end = 1;
        while (target > arr[end]) {
            start = end;
            end *= 2;
        }

        // do bs on arr low = start and high end;
        // the value || target will be between these bond
        return 10; // dont take thiss serious, this is for fun :)

    }

    // Next Alphabetical Element
    // Similar to ceil of a number
    private static char nextAlpla(char[] arr, char target) {
        char res = '0';
        int low = 0;
        int high = arr.length - 1;
        while (low <= high) {
            int mid = low + high / 2;

            if (arr[mid] == target) {
                low = mid + 1;
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                res = arr[mid];
                high = mid - 1;
            }
        }

        return res;
    }

    // Find Floor of an element in a Sorted Array
    static int findCeil(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;
        int res = -1;
        while (low <= high) {
            int mid = low + ((high - low) >> 1);
            if (arr[mid] == target) {
                res = arr[mid];
            }
            if (arr[mid] < target) {
                low = mid + 1;
            } else {
                res = arr[mid];
                high = mid - 1;
            }
        }
        return res;
    }

    // Find Floor of an element in a Sorted Array
    static int findFloow(int[] arr, int target) {
        int res = -1;
        int high = arr.length - 1;
        int low = 0;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (arr[mid] == target) {
                res = arr[mid];
            }
            if (arr[mid] < target) {
                res = arr[mid];
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return res;
    }

    // Searching in a Nearly Sorted Array
    static int nearlySorted(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = low + ((high - low) >> 1);

            if (target == arr[mid]) {
                return mid;
            }
            if (mid - 1 >= low && target == arr[mid - 1]) {
                return mid - 1;
            }
            if (mid + 1 <= high && target == arr[mid + 1]) {
                return mid + 1;
            } else if (target < mid) {
                high = mid - 2;
            } else {
                low = mid + 2;
            }
        }
        return -1;

    }

    // Find an Element in a Rotated Sorted Array

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
            } else if (arr[mid] <= arr[arr.length - 1]) {
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