import java.util.ArrayList;
import java.util.List;


public class RecursionRedo {

    public static void main(String[] args) {

        Subsequences sub = new Subsequences();
        sub.sub1stWithSumkCount(new int[] {1,2,1}, 2);
    }
}

class Subsequences{
    // take not take bases


    // Print subsequence whose sum is K
    public void subsequenceSumK(int[] nums, int K) {
        printsubWithSumk(nums,0,K,0,nums.length,new ArrayList<Integer>());
    }

    private void printsubWithSumk(int[] nums, int i, int target, int sum, int n, ArrayList<Integer> list) {
        if(i == n){
            if(sum==target){
                System.out.println(list);
            }
            return;
        }

        list.add(nums[i]);
        printsubWithSumk(nums, i+1, target, sum+=nums[i], n, list);
        list.remove(list.size()-1);
        printsubWithSumk(nums, i+1, target, sum-nums[i], n, list);
    }


    public  void printSubsequences(int[] arr){
        /*
         * @url: notion: https://www.notion.so/03355ad457734dd798a489e800bf396a?v=f1de444a07444ed48b75dcf8d55592f5&p=e3c06129112e4d29b14450efb261650d&pm=s
         */
        // T.C: 2 ^ n-> coz we have to make choice for each elemets
        // S.C: -> O(n)
        printsubs(arr, 0, new ArrayList<>());
    }

    void printsubs(int[] arr, int i, ArrayList<Integer> list){
        if(i >=arr.length){
            System.out.println(list);
            return;
        }
        // add current index element to list
        list.add(arr[i]);
        // call for take
        printsubs(arr, i+1, list);

        // remove the last added one to perform not take
        list.remove(list.size()-1);

        // call for not take
        printsubs(arr, i+1, list);

    }

    // 3. Print only 1st Sq which sums to K
    public void sub1stWithSumk(int[] nums, int K) {
        printsubWithSumk1(nums,0,K,0,nums.length,new ArrayList<Integer>());
    }

    private boolean printsubWithSumk1(int[] nums, int i, int target, int sum, int n, ArrayList<Integer> list) {
        if(i == n){
            if(sum==target){
                System.out.println(list);
                return true;
            }
            return false;
        }

        list.add(nums[i]);
        if(printsubWithSumk1(nums, i+1, target, sum+=nums[i], n, list) == true){
            return true;
        }
        list.remove(list.size()-1);
        if(printsubWithSumk1(nums, i+1, target, sum-nums[i], n, list)){
            return true;
        }
        return false;
    }

    // 4. Print the count of Sq which sums to K
    public void sub1stWithSumkCount(int[] nums, int K) {
       System.out.println(printsubWithSumkCount(nums,0,K,0,nums.length,new ArrayList<Integer>()));
    }

    private int printsubWithSumkCount(int[] nums, int i, int target, int sum, int n, ArrayList<Integer> list) {
        if(i == n){
            if(sum==target){
                return 1;
            }
            return 0;
        }

        list.add(nums[i]);
        int left = printsubWithSumkCount(nums, i+1, target, sum+=nums[i], n, list);

        list.remove(list.size()-1);

        int right = printsubWithSumkCount(nums, i+1, target, sum-nums[i], n, list);

        return left + right;
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // Pick and Not-Pick
        // TC -> 2 ^k * k
        // SC -> K * X 
        List<List<Integer>> ans= new ArrayList<>();
        solvecs1(candidates, target, 0,  ans, new ArrayList<Integer>());
        return ans;
    }

    private void solvecs1(int[] nums, int target, int index, List<List<Integer>> list, ArrayList<Integer> a) {
        if(index == nums.length){
            if(target ==0){
                list.add(new ArrayList<>(a));
            }
            return;
        }

        // we need to specift a stopping condition or else the take will go on and onnn
        if(nums[index] <= target){

            // add current one to tmp ans i.e a;
            a.add(nums[index]);
            
            solvecs1(nums, target-nums[index], index, list, a);
           
            //remove the last added one
            a.remove(a.size()-1);
        }

        // for not pick
        solvecs1(nums, target, index+1 ,list, a);

    }

    

}


