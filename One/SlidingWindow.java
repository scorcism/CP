public class SlidingWindow {
    
    // sliding window maximum
    static void getMax(int[] array, int K){

        int start = 0;int end = 0;
        int maxEle = Integer.MAX_VALUE;
        while(end < K){
            maxEle = Math.max(maxEle,array[end]);
            
            while(end - start +1 < K){
                end++;
            }
            if((end - start +1) == K){
                
            }
        }
    }
    

    public static void main(String[] args) {
        
    }
}
