class ImpAlgos{


    public static void PowerSet(String text){
        // Loop All the 2^n values
        for(int i = 0; i< ((1 << text.length()));i++){
            // Loop for each index value.
            // To check if each bit is set or not.
            String sub = "";
            for(int j = 0; j< text.length() ;j++){
                // Check if ith bit is set or not
                if((i & (1<<j)) != 0){
                    sub = sub + text.charAt(j);
                }
            }
            System.out.println(sub);
        }
    }

    public static void main(String[] agrs){
        String name = "abc";
        PowerSet(name);

    }
}