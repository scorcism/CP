import java.util.ArrayList;    

public class BitManupulation {
    
    public static void checkNSet(int n, int position){
        // int mask = (1 << position);
        if((n & (1<<position) ) != 0){
            System.out.println("Set bit present");
        }
        else{
            System.out.println("Not Present");
        }
    }

    public static void lastSigniBit(int num){
        System.out.println(num & ( num- 1) ) ;
    }

    public static void isRaiseTo2(int num){
        if(( num & (num-1)) ==0 ){
        System.out.println("Number is power of 2") ;
        }else{
            System.out.println("NOT power of 2");
        }
    }

    public static void countOf1(int num){
        int count = 0;
        while (num != 0){
            if((num & 1) == 1){
                count++;
            }
            num = num >> 1;
        }
        System.out.println("1s: " + count);
    }
    public static int numSetBits(long a) {
        if(a == 0 ){
            return 0;
        }else{
            return (int) (a & 1) + numSetBits(a >> 1);
        }

	}

    public static long reverse(long a) {
        long rev = 0;
        
        for(int i = 0; i<32; i++){
            // int bit = ((a >> i) & 1);
            // rev = rev | (bit << (31-i));
        }
        return rev;
	}
    

    public static int getCount(int n){
        int count = 0;
        while(n!=0){
            n = (n & (n-1));
            count++;
        }
        return count;
    }
    
    public static void cntBits(ArrayList<Integer> A) {
        
        int difference = 0;
        
        for(int i = 0 ;i< A.size(); i++){
            for(int j = i; j<A.size();j++){
                
                int xor = A.get(i) ^ A.get(j);
                int count = getCount(xor);

                difference += 2 * count;
                // System.out.println("i: "+A.get(i) + " j: " + A.get(j) + " xor: " + xor + " count:  " + count);
                
            }
        
        }
        System.out.println(difference);
    }

    public static void noRepeating(ArrayList<Integer> A){
        // 1st get the xor or all the values
        int xor = 0;
        
    }

    public static void main(String[] args) {
        
        // extractIthBit(13,4);
        // lastSigniBit(11);
        // isRaiseTo2(16);
        // countOf1(3);
        // System.out.println(numSetBits(12));
        // System.out.println(reverse(3));

        ArrayList<Integer> array = new ArrayList<>();
        array.add(1);
        array.add(3);
        array.add(5);
        // array.add(3);
        // array.add(4);
        cntBits(array);
    }
}
