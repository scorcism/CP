import java.util.Arrays;

public class Mathematics {

    public static void main(String[] args) {

    }
    

    private static int fastPower(int a, int b){
        // return a^b
        int res = 1;
        while(b >0){
            // check if b is odd
            if((b&1) != 0){
                res = res*a;
            }
            a = a *a;
            b = b >>1;
        }

        return res;
    }


    private static int gcd(int a, int b) {
        if (b == 0) {
            return a;
        }
        return gcd(b, a % b);
    }

    private static boolean[] sieveOfEratosthenes(int n) {
        boolean isPrime[] = new boolean[n + 1];
        Arrays.fill(isPrime, true);
        isPrime[0] = false;
        isPrime[1] = false;
        for (int i = 2; i * i <= n; i++) {

            for (int j = 2 * i; j <= n; j++) {
                isPrime[j] = false;
            }
        }
        return isPrime;
    }
}
