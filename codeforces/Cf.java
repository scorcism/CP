// Abhishek Pathak - scor32k
// Date: 2023-06-06 11:46:36


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Cf {
    public static void main(String[] args) throws Exception {   
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        long a = fs.nextLong();
        long b = fs.nextLong();
        long c = fs.nextLong();
        long d = fs.nextLong();

        // System.out.println(Math.log(a));
        if(b * Math.log(a) > d * Math.log(c)){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }

        out.close();
    }

    static long getexpo(long a, long b){

        long ans = 1;
        while(b > 0){
            if((b&1)==1){
                ans= ans* a ;
            }
            a =a*a ;
            b >>=1;
        }
        return ans;
    }

    static class FastScanner {
        private BufferedReader reader = null;
        private StringTokenizer tokenizer = null;

        public FastScanner(InputStream in) {
            reader = new BufferedReader(new InputStreamReader(in));
            tokenizer = null;
        }

        public String next() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public String nextLine() {
            if (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    return reader.readLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }

            return tokenizer.nextToken();
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }

        public int[] nextIntArray(int n) {
            int[] a = new int[n];
            for (int i = 0; i < n; i++)
                a[i] = nextInt();
            return a;
        }

        public long[] nextLongArray(int n) {
            long[] a = new long[n];
            for (int i = 0; i < n; i++)
                a[i] = nextLong();
            return a;
        }
    }

    static int min(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

    static int min(int a, int b) {
        return Math.min(a, b);
    }

    private static void swapinarray(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static int max(int a, int b, int c) {
        return Math.max(a, Math.max(b, c));
    }
    
    static int max(int a, int b) {
        return Math.max(a, b);
    }
    
    static void qsort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }
    private static void quickSort(int[] arr, int left, int right) {
        if (left < right) {
            int partition = qucickS(arr, left, right);
            quickSort(arr, left, partition - 1);
            quickSort(arr, partition + 1, right);
        }
    }

    private static int qucickS(int[] arr, int left, int right) {
        int pivot = arr[left];
        int i = left;
        int j = right;

        while (i < j) {
            while (arr[i] <= pivot && i <= right - 1) {
                i++;
            }
            while (arr[j] >= pivot && j >= left + 1) {
                j--;
            }
            if (i < j) {
                swapinarray(arr, i, j);
            }
        }
        swapinarray(arr, j, left);
        return j;
    }
}