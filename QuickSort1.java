class QuickSort1 {

    public static void main(String[] args) {
        System.out.println("Running...");
        int[] arr = {9,8,7,6,5,4};
        quick(arr, 0, arr.length -1);
        System.out.println(java.util.Arrays.toString(arr));
    }

    public static void quick(int[] arr, int low , int high){
        if(low >= high){
           return;
        }

        int i = low;
        int j = high;

        int mid = low + (high - low) /2 ;
        int pivot = arr[mid];

        while(i <= j){
            while(arr[i] < pivot){
                i++;
            }
            while(arr[j] > pivot){
                j--;
            }
            if(i <= j){
                swap(arr[i],arr[j]);
                i++;
                j--;
            }
        }
        quick(arr, low, j);
        quick(arr, i, high);
    }

    public static void swap(int i, int j) {
        int tmp = i;
        j = i;
        i = tmp;
    }
}