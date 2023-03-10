import java.util.Arrays;

public class CyclicSort {    
    public static void main(String[] args) {
        int[] nums= {5,4,3,2,1};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void cyclicSort(int[] nums){

        int index = 0;
        while(index < nums.length){
            // 3 5 2 1 4
            // staring with 0 index 
            // if 0 is not equal to value at 0th index -1
            //  means that
            // if we take and ordered pair
            //1 2 3 4 5
            // index 2 has the value of 3 means value 3 -1 will be the postion of 3 in the array
            if((index != nums[index] -1)){
                swap(nums,index,nums[index]-1);
            }else{
                index++;
            }
        }
    }

    private static void swap(int[] nums, int index, int index2) {
        int tmp = nums[index];
        nums[index]  =nums[index2];
        nums[index2] = tmp;
    }

}
