import java.util.ArrayList;
import java.util.Arrays;

public class Number_Theory {
    public static void main(String[] args) {
        // half in CP4.java
        NumberTheoryy nt = new NumberTheoryy();
    }

}


class NumberTheoryy {

    public static void inverse(int a){
        long M = (int)1e9+7;
        long inve = binaryExp(a,M-2,M);
        System.out.println("inv: " + inve);
    }
    


    private static long binaryExp(long a, long b, long M) {
        long ans = 1;

        while(b>0){
            if((b&1)!=0){
                ans =( ans * a)%M;
            }
            a = (a * a)%M;
            b>>=1;
        }
        return ans;
    }

    public static void factoralTillN(){
        int M = (int)1e9+7;
        int N = (int)1e6+7;
        long[] fact = new long[N];
        fact[0]  =1;
        for(int i = 1 ; i<N;i++){
            fact[i] = (fact[i-1] * i)%M;
        }
        System.out.println(Arrays.toString(fact));
    }


    public void seive_divisors(){
        int N = 100;
        int[] div = new int[N];

        for(int i = 2; i< N; i++){
            for(int j = i ; i<N; i+=i){
                div[j] = i;
            }
        }
    }

    public void sieve_versions(){
        // lowest prime and highest prime
        int N = 100;
        boolean[] isPrime = new boolean[N];
        Arrays.fill(isPrime,true);
        isPrime[0] = isPrime[1] = false;

        int[] lp = new int[N];
        int[] hp = new int[N];
        Arrays.fill(lp,0);
        Arrays.fill(hp,0);


        for(int i = 2; i< N; i++){
            if(isPrime[i]){
                for(int j = 2*i; j<N; j+=i){
                    isPrime[j] = false;
                    hp[j] = i;
                    if(lp[j] == 0){
                        lp[j] = i;
                    }
                }
            }
        }

        int num = 24;
        ArrayList<Integer> factors = new ArrayList<>();

        while(num >1){
            int prime_factor = hp[num];
            while(num % prime_factor ==0){
                num /= prime_factor;
                factors.add(prime_factor);
            }
        }

    }

    public void sieve_algo(){
        int N = 100;
        boolean[] isPrime = new boolean[N];
        
        Arrays.fill(isPrime, true);

        isPrime[0] = isPrime[1] = false;

        for(int i =2; i<N; i++){
            if(isPrime[i]){
                for(int j = 2*i; j<N; j+=i){
                    isPrime[j] = false;
                }
            }
        }

        System.out.println(Arrays.toString(isPrime));
    }


    public static void prime_factors(int a){
        ArrayList<Integer> ans = new ArrayList<>();

        for(int i  =2; i*i<=a; i++){
            while(a%i==0){
                ans.add(i);
                a/=i;
            }
        }
        if(a>1){
            ans.add(a);
        }
    }

    public static void all_divisors(int a) {
        int count = 0;
        int sum = 0;
        for (int i = 1; i * i <= a; i++) {
            if (a % i == 0) {
                System.out.println(i + " " + a / i);
                count++;
                sum = sum + i;
                if (a / i != i) {
                    count++;
                    sum += a / i;
                }
            }
        }
        System.out.println(count);
        System.out.println(sum);
    }

    long binaryExponentiationRecur(int a, int b) {
        /*
         * if(b==0) return 1;
         * if((b&1)!=0){
         * // if b is odd
         * return a * binaryExponentiationRecur(a, b/2) * binaryExponentiationRecur(a,
         * b/2);
         * }else{
         * return binaryExponentiationRecur(a, b/2) * binaryExponentiationRecur(a, b/2);
         * }
         */

        if (b == 0) {
            return 1;
        }

        long res = binaryExponentiationRecur(a, b / 2);
        if ((b & 1) != 0) {
            return a * res * res;
        } else {
            return res * res;
        }
    }

    int binaryExponentiationIterative(int a, int b) {
        int ans = 0;
        while (b > 0) {
            // check if 0th bit is set
            if ((b & 1) != 0) {
                ans = ans * a;
            }
            a = a * a;
            b >>= 1;
        }
        return ans;
    }

    public int gcd(int a, int b) {
        if (b == 0)
            return a;
        return gcd(b, a % b);
    }

    public int lcm(int a, int b) {
        return ((a * b) / gcd(a, b));
    }

    public int minFraction(int a, int b) {
        return (a / gcd(a, b) / b / gcd(a, b));
    }

    public void swapsingXor(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a + "b: " + b);
    }

    // Generate subset
    public static ArrayList<ArrayList<Integer>> subsets(int[] a) {
        ArrayList<ArrayList<Integer>> ans = new ArrayList<>();
        int n = a.length;
        int subset_count = (1 << n); // 2^n

        for (int mask = 0; mask < subset_count; mask++) {
            ArrayList<Integer> subset = new ArrayList<>();

            // check for mask and ith value
            for (int i = 0; i < n; i++) {
                if ((mask & (1 << i)) != 0) {
                    subset.add(a[i]);
                }
            }
            ans.add(subset);
        }

        return ans;
    }
}
