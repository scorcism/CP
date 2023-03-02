import java.util.ArrayList;
import java.util.Vector;

public class BitManupulation2 {
    public static void main(String[] args) {
     
        
        int n = 1;
        System.out.println();
    }


    // Count number of set bits
    int countOne(int n){
        int count = 0;
        while(n>0){
            n = n & (n-1);
            count++;
        }
        return count;
    }

    // is Power of 4
    boolean isPowerOfFour(int n){
        return (n&(n-1))==0 && (n&0x5555555)==0;
        // check again may be error
    }

    // One number that is missing
    int missingNumber(ArrayList<Integer> nums){
        int ret = 0;
        for(int i = 0; i< nums.size();i++){
            ret ^=i;
            ret^= nums.get(i);
        }
        return ret^=nums.size();
    }

    // FInd largest power of 2 todo
    long largestPoerOfTwo(long n){
        n = n | (n>>1) ;
        n = n | (n>>2) ;
        n = n | (n>>4) ;
        n = n | (n>>8) ;
        n = n | (n>>16) ;
        return ((n+1)>>1 );
    }

    int reverseBit(int n){
        int result = 0;
        for(int i = 0; i< 32; i++){
            if((n&1)==1){
                result+=1;
            }
            n>>=1;
        }
        return result;
    }

    // BITWISE AND of all number in the range
    int rangeBitwiseAnd(int m ,int n){
        int a = 0;
        while(m!=n){
            m>>=1;
            n>>=1;
            a++;
        }
        return m<<a;
    }


}
