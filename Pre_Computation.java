import java.util.Scanner;

public class Pre_Computation {
    
    public static void main(String[] args) {
        
        // basic1();
        hashing1();
    }

    public static void basic1(){
        int M = (int)1e9+7;
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            int number = sc.nextInt();
            int fact = 1;
            for(int i = 2; i<=number; i++){
                fact = (fact * i)%M;
            }
            System.out.println(fact);
        }
    }
    public static void basic2(){
        int M = (int)1e9+7;
        int N = (int)1e5;
        int arr_len = (int)1e5+10;
        int[] factorials = new int[arr_len];

        // precomputing factoral values
        factorials[0] = factorials[1] = 1;
        for(int i = 2; i<N; i++){
            factorials[i] = factorials[i-1] * i;
        }
        
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        while(T-->0){
            int number = sc.nextInt();
            System.out.println(factorials[number]);
        }
    }

    public static void hashing1(){
        /*
         * Given array a of N integeres. Give Q queries an in each given a number X, print count of that number in array.
         * 
         * Constraints
         * 1 <= N <= 10^5
         * a <= a[i] <= 10^7
         * 1 <= Q <= 10^5
         */

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];

        for(int i = 0; i<n; i++){
            a[i] = sc.nextInt();
        }

        int q = sc.nextInt();
        while(q-->0){
            int number = sc.nextInt();
            int count = 0;
            for(int i = 0; i<n; i++){
                if(a[i]==number){
                    count++;
                }
            }
            System.out.println(count);
        }
        // O(N) + O(Q*N) = O(N*2) = 10^10; (in 1 second only 10^7 itertion can take place)
        
    }

    public static void hashing2(){

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        int count_array[] = new int[n+10];
        
        for(int i = 0; i<n; i++){
            a[i] = sc.nextInt();
            count_array[a[i]]++;
        }

        int q = sc.nextInt();
        while(q-->0){
            int number = sc.nextInt();
            System.out.println(count_array[number]);
        }
        
    }

    public static void prefix_sum1(){
        /*
         * Given an array of N integers. Given Q queries and in each query given L and R print sum of array elements from index L to R (L,R included) 
         * Constrainst:
         * 1 <= N <= 10^5
         * 1 <= a[i] <= 10^9
         * 1 <= Q <= 10^5
         * 1 <= L, R <= N
         */
        // Preferred to use 1 based array
         int N = (int)1e6+10;
         int[] a = new int[N];
         Scanner sc = new Scanner(System.in);
         int n = sc.nextInt();

        for(int i = 1; i<= n; i++){
            a[i] = sc.nextInt();
        }

        int q;
        q = sc.nextInt();

        while(q-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            long sum = 0;
            for(int i = l; i<=r; i++){
                sum = sum + a[i];
            }
            System.out.println(sum);

        }
        // O(N) + O(Q*N) = 10 ^ 10
    }

    public static void prefix_sum2(){
        int N = (int)1e6+10;
        int[] a = new int[N];
        int[] prefix_sum = new int[N];
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for(int i = 1; i<= n; i++){
            a[i] = sc.nextInt();
            prefix_sum[i] = prefix_sum[i-1]+a[i];
        }

        int q;
        q = sc.nextInt();

        while(q-->0){
            int l = sc.nextInt();
            int r = sc.nextInt();
            
            System.out.println(prefix_sum[r]-prefix_sum[l-1]);

        }

    }

    public static void prefix_2D_array1(){
        /*
         * Given 2d array a of N*N integers. Give Q queries and in each query given a,b,c and d print sum of squar rpresented by (a,b) as top left point and (c,d) as bottom right point
         * 
         * Constraints
         * 1 <= N <= 10^3
         * 1 <= a[i][j] <= 10^9
         * 1 <= Q <= 10^5
         * a <= a,b,c,d <= N
         */

         int N = (int)1e3+10;
         int ar[][] = new int[N][N];

         Scanner sc  = new Scanner(System.in);
         int n  = sc.nextInt();
         for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                ar[i][j] = sc.nextInt();
            }
         }

         int q = sc.nextInt();

         while(q-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();
            long sum = 0;
            for(int i = a; i<= c; i++){
                for(int j = b; j<=d; j++){
                    sum+=ar[i][j];
                }
            }
            System.out.println(sum);

            // O(N^2) + O(Q*N^2) = 10 ^ 5  * 10 ^ 6 = 10^11
         }

    }

    public static void prefix_2D_array2(){

         int N = (int)1e3+10;
         int ar[][] = new int[N][N];
         int prefix_sum[][] = new int[N][N];

         Scanner sc  = new Scanner(System.in);
         int n  = sc.nextInt();
         for(int i = 1; i<=n; i++){
            for(int j = 1; j<=n; j++){
                ar[i][j] = sc.nextInt();
                prefix_sum[i][j] = prefix_sum[i][j]+prefix_sum[i][j-1]+prefix_sum[i-1][j];
            }
         }

         int q = sc.nextInt();

         while(q-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int d = sc.nextInt();

            System.out.println(prefix_sum[c][d]-prefix_sum[a-1][d]-prefix_sum[c][b-1]+prefix_sum[a-1][b-a]);

            // O(N^2) + O(Q)  = 10 ^ 6 + 10 ^5 = 10 ^ 6
         }

    }

    // https://www.codechef.com/problems/GCDQ
    public static void gcdQ1(){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n, q;
            n = sc.nextInt();
            q = sc.nextInt();

            int a[] = new int[n+10];
            for(int i = 1; i<=n; i++){
                a[i] =sc.nextInt();
            }

            while(q-->0){
                int l;
                int r;
                l = sc.nextInt();
                r = sc.nextInt();

                int gc = 0;
                for(int i = 1; i<=l-1; i++){
                    gc = __gcd(gc, a[i]);
                }
                
                for(int i = r+1; i<=n; i++){
                    gc = __gcd(gc, a[i]);
                }
                System.out.println(gc);

            } 
            // O(T * (N + Q * (N))) = O(T * N * T *N*Q) 
        }

    }
    public static void gcdQ2(){
        // Using forward and backward  prefix gcd array
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-->0){
            int n, q;
            n = sc.nextInt();
            q = sc.nextInt();

            int a[] = new int[n+10];
            for(int i = 1; i<=n; i++){
                a[i] =sc.nextInt();
            }

             // forward array
             int[] forward = new int[n+10];
             // backward array
             int[] backward = new int[n+10];
 
             forward[0] = 0;
             backward[n+1] = 0;

             for(int i = 1; i<=n;i++){
                forward[i] = __gcd(forward[i-1],a[i]);
             }

             for(int i = n; i>=0;i--){
                backward[i] = __gcd(backward[i+1],a[i]);
             }


            while(q-->0){
                int l;
                int r;
                l = sc.nextInt();
                r = sc.nextInt();

                int gc = __gcd(forward[l-1],backward[r+1]);
                
                System.out.println(gc);

            } 
            
        }

    }

    public static int __gcd(int a, int b){
        if(b == 0){
            return a;
        }
        return __gcd(b,a%b);
    }

    // https://www.hackerrank.com/challenges/crush/problem
    public static void array_manupulation1(){
        int N = (int)1e7+10;
        long[] ar = new long[N];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            for(int i = a; i<=b; i++){
                ar[i] +=d;
            }
            long max = 0;
            for(int i = 1; i<=n;i++){
                if(max<ar[i]){
                    max = ar[i];
                }
            }
            System.out.println(max);
            // O(m*n+N) = 2 * 10 ^ 5 * 10 ^ 7
        }
    }
    
    public static void array_manupulation2(){
        int N = (int)1e7+10;
        long[] ar = new long[N];

        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        while(m-->0){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int d = sc.nextInt();
            
            ar[a] += d;
            ar[b+1]-=d;

            for(int i = 1; i<=n ; i++){
                ar[i] += ar[i-1];
            }

            long max = 0;
            for(int i = 1; i<=n;i++){
                if(max<ar[i]){
                    max = ar[i];
                }
            }
            System.out.println(max);
            // O(m+N) = 2 * 10 ^ 5 + 10 ^ 7 ~ 10^7
        }
    }


}
