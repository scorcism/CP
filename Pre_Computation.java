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
}
