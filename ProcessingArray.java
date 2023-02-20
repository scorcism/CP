import java.util.Arrays;

public class ProcessingArray {
    
    public static void main(String[] args) {
        int[] nums = {3,1,4,8,7,2,5};
        System.out.println("Pre: "+ Arrays.toString(preProcessing(nums)));
        System.out.println("Post: "+ Arrays.toString(postProcessing(nums)));
    }

    private static int[] preProcessing(int[] array){
        int n = array.length;
        int[] pre = new int[n];        
        pre[0] = array[0]; // 0th one will be the same coz max at 0th and 0th will be the same
        for(int i  = 1; i < n; i++){
            pre[i] = Math.max(pre[i-1],array[i]);// Getting the max of curr i in array with the i-1 in pre so store the max
        }
        return pre;
    }

    private static int[] postProcessing(int[] array){
        int n = array.length;
        int[] post = new int[n];        
        post[n-1] = array[n-1]; // Here, the last one will be the same coz we are iterating from back side
        for(int i = n-2; i>= 0; i--){
            post[i] = Math.max(post[i+1],array[i]);
        }
        return post;
    }
}
