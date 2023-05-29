// Abhishek Pathak - scor32k
// Date: 2023-05-27 01:38:36


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
        int T = fs.nextInt();

        for (int tt = 0; tt < T; tt++) {
            String s = fs.next();
            // System.out.println(s.charAt(0)+ " char");
            int dig = s.charAt(0)-'0';
            // System.out.println(dig+ " dig");
            int len = s.length();
            System.out.println(10 * (dig -1) + (len*(len+1)/2));
            // was easy
            // suppose we have 1111 for this we we have clicked for 10 times
            // so for 777 we know that we ould have liked for 6666 so for 666 it would be 10 * (777).charAt(0) i.e 7 - 6 = 6 times i.t 60 is confirm but now for 777 so 777 will be 
            // 777.lengrh = (3 * 4) / 2
            // but how come this formula so the idea is we first dialed 7 which conatisn 1 then 77 which contans 2 digits and then 777 4 so we know the formla sum of n number i,r n (n+1)/2 so here we have n i.r len(777)
        }

        out.close();
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