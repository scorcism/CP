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

    public static void main(String[] args) {
        int[] array = {5,4,44,1};
        mj3(array); 
    }
}