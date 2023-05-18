package BS;

public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(bs(new int[] {1,2,3,4,5,6,7,8,9}, 9));
    }

    static int bs(int[] arr, int target) {
        int low = 0;
        int high = arr.length - 1;

        while (low <= high) {
            int mid = (low + high) / 2;

            if(arr[mid]==target){
                return mid;
            }else if(target <= arr[mid]){
                high = mid-1;
            }else{
                low = mid+1;
            }
        }

        return -1;
    }

}