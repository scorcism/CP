class Arrays{


    // Majority Elements in an Array
    static public void mj1(int[] array){
        int element = 0;
        int maxCount = Integer.MIN_VALUE;

        for(int i = 0; i< array.length -1; i++){
            int count = 0;
            for(int j = 1+1; j< array.length-1; j++){
                if(array[j] == array[i]){
                    count++;
                }
            }
            if(count > maxCount){
                maxCount = count;
                element = array[i];
            }
        }
        System.out.println(element);
    }

    // majority using hashmap
    public static void mj2(int[] array){
        // after hashmp
    }
    
    // majority using moore's voting
    public static void mj3(int[] array){
        // after hashmp
        int ele = array[0];
        int count = 1;

        for(int i = 1; i< array.length-1; i++){
            if(ele == array[i]){
                count++;
            }else{
                count--;
            }
            if(count == 0){
                ele = array[i];
                count = 1;
            }
        }
        int maxCount = 0;
        for(int j = 0; j< array.length-1; j++){
            if(array[j] == ele){
                maxCount++;
            }
        }
        if(maxCount > (array.length)/2){
            System.out.println(ele);
        }
        return ;
    }

    // Kadane's Algorithm | Largest Sum Contiguous Subarray
    public static int sumSubarray(int[] array){
        int Maxsum = 0;
        int currSum = 0;
        int n = array.length;
        for(int i = 0 ; i< n; i++){
            currSum = currSum + array[i];

            if(currSum> Maxsum){
                Maxsum = currSum;
            }
            if(currSum < 0){
                currSum = 0;
            }
        }

        return Maxsum;
    }

    // /Best time to buy and sell stock to Maximise Profit 
    public static int getMaxprofit(int[] array){
        int maxProfit = 0;
        int minSoFar = array[0];

        for(int i =0; i< array.length; i++){
            // get the minimum in the current iteration
            minSoFar = Math.min(minSoFar, array[i]);
            // get the profit suppose we are at index 5 then profit will be element at 5 - element at 4
            int profit = array[i] - minSoFar;
            maxProfit = Math.max(profit,maxProfit);
        }
        
        return maxProfit;
    }

    public static void main(String[] args) {
        int[] array = {5,4,44,1};
        // mj3(array); 
        System.out.println(getMaxprofit(array));
    }
}