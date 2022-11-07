class PowerSet {

    static public void printSet(int size, int[] arr){
        // print the subsenqunce of arr
        for(int i = 0 ; i< (1 << size); i++){
            String sub = "";
            for(int j = 0; j< size; j++){
                // set of the bit is set or nor
                if((i & (1<<j)) != 0){
                    sub = sub + arr[j];
                } 
            }
            System.out.println(sub);
        }
    
    }

    public static void main(String[] args){
        int[] chars = {3,2,1};
        // System.out.println(chars[1]);
        printSet(3,chars);
    }
}