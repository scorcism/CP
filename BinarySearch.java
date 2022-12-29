public class BinarySearch {
    
    public static void main(String[] args) {
        
        /*
         * arr = [2,4,6,8,10,12,14,16,20,24,26,30]
         *        |                             |    
         *       star                          end
         * target = 26
         * 
         * 0) array should be sorted
         * 1) find the middle element
         * 2) target > middle  => search in right
         *  if in right move the left  = mid + 1 
         *                     else search in left
         * if in left move the right  = mid -1 
         * 3) if middle ele == target return ele
         * 4) if start > end -> element not found 
         * 
         * Q)   Why Binary Search
         * and) 
         */

        int[] arr = {2,4,6,8,10,12,14,16,20,24,26,30};
        int target = 26;
        System.out.println(binarySearch(arr, target));

        /*
         * Order Agnostic Ninary search
         * In Binary search we will with sorted array 
         * what if we don't know the array is sorted in ascending order or descnding order
         * 
         */

    }

    // return index
    // return -1 if not found
    private static int binarySearch(int[] arr, int target){
        int start = 0;
        int end = arr.length - 1;

        while(start <= end){
            int middle  = start + (end - start) / 2;
            if(arr[middle] < target){
                start  = middle + 1;
            }
            else if(arr[middle] > target){
                end  = middle -1;
            }else{
                return middle;
            }
        }
        return -1;
    }

    private static int orderAgnosticBS(int[] arr, int target){
        int start = 0;
        int end = arr.length -1;

        if(arr[start] < arr[end]){
            // array is sorted in ascending order
            
        }else{
            // array is sorted in decending order

        }


        return -1;
    }

}
