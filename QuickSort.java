public class QuickSort {
    


    public static void main(String[] args) {
        System.out.println("Henlo...");
        int[] arr = {9,8,7,6,5,4};
        quick(arr, 0, arr.length -1);
        System.out.println(java.util.Arrays.toString(arr));
    }

    public static void quick(int[] arr, int low, int high){
        /*
         * low -> start outbound of array
         * hight -> end outbound of the array
         * i -> will be the start boud for the [devided] subarray
         * j -> will be the end boud for the [devided] subarray
         * 
         * 
         */
        // we ned atleast 2 elements to compare
        if(low >= high){
            return;
        }

        int i = low; 
        int j = high;

        int mid = low + (high - low) / 2;
        int pivot = arr[mid];

        while(i <= j){
            while (arr[i] < pivot) {
                i++;
            }
            while (arr[j] > pivot) {
                j--;
            }
            // At this point the element at the left of pivot is greater then pivot and
            // element at the right of the pivot is smaller then pivot
            // swap both the element
            if(i<=j){
                swap(arr[i],arr[j]);
                i++;
                j--;
            }
        }

        // perform the same for left side of the pivot and the same with the right side of the pivot
        quick(arr,low,j);
        quick(arr, i, high);
    }

    private static void swap(int i, int j) {
        int tmp = i;
        j = i;
        i = tmp;
    }
}
