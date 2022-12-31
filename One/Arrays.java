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

    public static void main(String[] args) {
        int[] array = {5,4,4,4,4,1,1,1,1,1};
        mj1(array); 
    }
}