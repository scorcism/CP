import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CyclicSort {    
    public static void main(String[] args) {
        int[] nums= {5,4,3,2,1};
        cyclicSort(nums);
        System.out.println(Arrays.toString(nums));
    }

    public static void cyclicSort(int[] nums){

        int index = 0;
        while(index < nums.length){
            if((nums[index] != nums[nums[index]-1])){
                swap(nums,index,nums[index]-1);
            }else{
                index++;
            }
        }
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer>  list  = new ArrayList<>();
        int index = 0;
        while(index < nums.length){
            if(nums[index] != nums[nums[index]-1]){
                swap(nums, index, nums[index]-1);
            }else{
                index++;
            }
        }

        for(int i = 0; i < nums.length; i++){
            if(i+1 != nums[i]){
                list.add(nums[i]);
            }
        }

        return list;
    }


    public int findDuplicate(int[] nums) {
        
        // performing modified cyclic sort
        int index = 0;
        while(index < nums.length){
            if(nums[index]!=index+1){
                if(nums[index] != nums[nums[index]-1]){
                    swap(nums,index,nums[index]-1);
                }else{
                    return nums[index];
                }
            }else{
                index++;
            }
        }
        return -1;
    }

    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        if(nums == null){
            return ans;
        }
        // perform cyclic sort
        // and check if element at that index +1 appread or not if not add to the list

        // cyclic sort
        int index = 0;
        while(index<nums.length){
            if(nums[index] != nums[nums[index]-1]){
                swap(nums, index, nums[index]-1);
            }else{
                index++;
            }
        }

        for(int i = 0; i< nums.length; i++){
            if(i+1 != nums[i]){
                ans.add(i+1);
            }
        }
        return ans;
    }

    private static void swap(int[] nums, int index, int index2) {
        int tmp = nums[index];
        nums[index]  =nums[index2];
        nums[index2] = tmp;
    }

}
