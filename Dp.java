
public class Dp {
    
    public static int minCoins(int n, int[] nums){

        if(n ==0 ) return 0;

        int ans = Integer.MAX_VALUE;

        for(int i = 0; i < nums.length; i++){
            if(n-nums[i] >= 0){
                int subCoin = minCoins(n - nums[i], nums);

                if( subCoin + 1 < ans ){
                    System.out.print( subCoin + " ");
                    ans = subCoin + 1;
                }
            }
        }
        return ans;
    }
    
    public static void main(String[] args) {
        int[] nums = {7,5,1};
        System.out.println(minCoins(39,nums));
    }
}
