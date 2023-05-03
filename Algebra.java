import java.util.ArrayList;
import java.util.List;

public class Algebra {

    public static void main(String[] args) {

        // System.out.println(binaryExponentaionRecursive(2, 4));
        // System.out.println(__gcd(18, 12));
        // System.out.println(__lcm(18, 12));
        System.out.println(__gcd(12, 18));
        System.out.println(__lcm(12, 18));
    }

    // Binary Exponentiation
    static int binaryExponentaionRecursive(int a, int b) {
        // i.e a^b
        if (b == 0) {
            return 1;
        }
        if ((b &1) ==1) {
            return a * binaryExponentaionRecursive(a, b / 2) * binaryExponentaionRecursive(a, b / 2);
        } else {
            return binaryExponentaionRecursive(a, b / 2) * binaryExponentaionRecursive(a, b / 2);
        }
    }

    static int binaryExponentaionIterative(int a, int b) {
        // i.e a^b
        int ans = 1;
        while (b > 0) {
            if ((b & 1) == 1) {
                ans = ans * a;
            }
            a = a * a;
            b >>= 1;
        }

        return ans;
    }

    // Compute  x^n mod m.
    long  binpow(long  a,  long b,  long m) {
        a = a%m;
        long res= 1;
        while(b>0){
            if((b&1)==1){
                res = (res * a)%m;
            }
            a *= a % m;
            b>>=1;
        }

        return res;
    }
    // Problem: Compute n-th Fibonacci number  Fn .
    

    
    // Appliying a permutation k times
    // Problem: You are given a sequence of length  n . Apply to it a given permutation k times.
    List<Integer> permute(List<Integer> sequence,List<Integer> permutation, long b ){
        while(b>0){
            if((b&1)==1){
                sequence = applyPermutation(sequence, permutation);
            }
            permutation = applyPermutation(permutation,permutation);
            b>>=1;
        }
        return sequence;
    }

    private List<Integer> applyPermutation(List<Integer> sequence, List<Integer> permutation) {
        List<Integer> newSequence = new ArrayList<>(sequence.size());
        for(int i = 0; i< sequence.size(); i++){
            newSequence.add(i, sequence.get(permutation.get(i)));
        }
        return newSequence;
    }

    // GCD recursive
    static int gcd_recursive(int a, int b){
        while(b>0){
            a %= b;
            // swap(a,b);
        }
        return a;
    }

    static int __gcd(int a, int b){
        if(b ==0){
            return a;
        }
        return __gcd(b, a%b);
    }

    static int __lcm(int a, int b){
        return (a*b)/__gcd(a, b);
    }


}




