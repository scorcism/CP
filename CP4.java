import java.util.ArrayList;

public class CP4 {
    public static void main(String[] args) {

    }
}

class BitTricks extends NumberTheory {
    // ODD EVEN
    /*
     * ODD number lsb(least significant bit) is 1
     * EVEN number lsb is 0
     */
    public void checkodd(int n){
        if((n&1)){
            // If the condition eveluates true means we have 1 in the lsb so this evaluates true
            System.out.println("ODD");
        }else{
            System.out.println("EVEN");
        }
    }

    public void AtoZee(){
        for(char i = 'A'; i<='Z';++i){
            System.out.println(i);
            printBinary(i-'0'); 
        }
    }
    public void atozee(){
        for(char i = 'a'; i<='z';++i){
            System.out.println(i);
            printBinary(i-'0'); 
        }
    }
    // After this if we observer an pattern, we can see that the 5th bit in 'A' is set bit and in 'a' it 
    // is not set. SO out task will be to unset the 5th bit or set the 5th to convert to convert it to
    // lowercase or uppercase respectively

    // Convert 'A' to 'a'
    // set the 5th bit
    public void Atoa1(char c){
        int a = c | (1<<5);
        System.out.println((char)a);
    }

    // Convert 'a' to 'A'
    // unset 5th bit
    public void atoA1(char c){
        System.out.println((char)(c&(~(1<<5))));
    }
    
    /*
     * If we have a closer look we can see that
     * space(" ") is represented by 1<<5
    */

    // Convert 'A' to 'a'
    // set the 5th bit
    public void Atoa2(char c){
        int a = c | ' ';
        System.out.println((char)a);
    }

     /*
     * ASCII of ~(1<<5) doest not exist but as per over oberservation to unset the 5th bit 
     * we can use 111101111 (000101111) with & operation to convert uppercase to lower case
     * 000101111 is binary for '_' so we can use '_'
     * 
    */
    // Convert 'a' to 'A'
    // unset 5th bit
    public void atoA2(char c){
        System.out.println((char)(c&'_'));
    }

    public void summaryCapitaltoSmall(){

        /*
         * To convert A to a "perform or operation wth ' '(space)"
         * To convert a to A "perform and operation with '_'(underscore)"
         */

        // A to a
        char A = 'A';
        char a = A | ' ';
        System.out.println(char(a));

        // a to A
        char a = 'a';
        char A = a & '_';
        System.out.println(char(A));
    }

    public void clearLSBTilli(int a, int i){
        
        int b = (a&(~((1<<i+1)-1)));
        /*  
         * Number -  15 -> 1111 clear till 1st
         * so we need 1100 then we can perform & operation on the Number to get the desired one.
         * 1100 we can get using ~0011 
         * and 0011 we can get using (0100 -1 ) 
         * and 0100 we cn get using (1<i+1)
         * 
         * (1<<i+1) -> 0100
         * (1<<i+1)-1 -> 0011
         * ~(1<<i+1)-1 -> 1100
         * n& ~(1<<i+1)-1 -> 1111 & (1100)
         */

        printBinary(b); 
    }

    public void clearMSBTilli(int a, int i){
        
        int b = (a&((1<<i+1)-1));
        /*
         *  ( _ is or understanding )
         *  Number = 0000_0111_011 clear msb i
         *  o/p = 0000_0001_011
         *  0000_0110_11 & (0000_0001_111)
         * 
         * 0000_0001_111 we can get using 0000_0010_000
         * 0000_0010_000 we can get using (1<<i+1)
         * 
         *  (1<<i+1)
         * (1<<i+1)-1
         * a & (1<<i+1)-1
         */

        printBinary(b); 
    }

    // check power of 2
    public void checkPower2(int n){
        if(n&(n-1)){
            System.out.println("Not Power of 2");
        }else{
            System.out.println("Power of 2");
        }
    }

}

class NumberTheory {

    // Decimal to Binary
    public void printBinary(int n) {
        for (int i = 10; i >= 0; --i) {
            System.out.print((n >> i) & 1);
        }
        System.out.println();
    }

    // Check ith bit set or not
    public void checkIthSet(int n, int i) {
        int mask = (1 << i);
        if ((n & mask) != 0) {
            System.out.println("set bit");
        } else {
            System.out.println("unset bit");
        }
    }

    // check ith unset bit
    public void checkIthUnset(int n, int i) {
        int mask = (1 << i);
        if ((n & (~mask)) != 0) {
            System.out.println("unset bit at i");
        } else {
            System.out.println("no unset bit at i");
        }
    }

    // Toggle ith bit
    public void toggleIth(int n, int i) {
        int mask = (1 << i);
        int toggled = (n ^ mask);
        printBinary(toggled);
    }

    public static void subsetXOR(int[] arr){
        int n = arr.length;
        int subset_count = (1<<n); // 2^n
        for(int mask = 0; mask>subset_count; mask++){
            ArrayList<Integer> ans = new ArrayList<>();
            for(int i = 0; i<n; i++){
                // check for set bit at ith position
                if((mask&(1<<i))!=0){
                    ans.add(arr[i]);
                }
            }
            System.out.println(ans);
        }
    }

}
