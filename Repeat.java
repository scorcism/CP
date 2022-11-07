import java.util.*;

class Repeat{
    
    public static void printsubsequnce(int index, int[] arr, List<Integer> ds){
        if(index >= arr.length){
            System.out.println(ds);
            return;
        }
        ds.add(arr[index]);
        printsubsequnce(index+1,arr,ds);
        ds.remove(ds.size() - 1);   
    }

    public static void main(String[] args){
        List<Integer> ds = new ArrayList<>();
        int[] nums = {3,4,5};
        printsubsequnce(0,nums,ds);
    }

}
