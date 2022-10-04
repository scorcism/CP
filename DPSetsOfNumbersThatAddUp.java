public class DPSetsOfNumbersThatAddUp {

    public static int solve(int[] array, int total, int n){
        int to_return;
        if(total == 0){
            return 1;
        }
        if(n <= 0){
            return 0;
        }
        if(array[n] > total){
            to_return =  solve(array, total, n-1);
        }else{
            to_return =  solve(array, total - array[n],  n- 1) + solve(array, total,n -1);
        }
        return to_return;
    }

    public static int countsets(){
        int[] arr = {2,4,6,10};
        int t = 16;
        return solve(arr, t, arr.length -1);
    }

    public static void main(String[] args) {
        System.out.println(countsets()); 
    }
}
