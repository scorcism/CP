// Abhishek Pathak - scor32k
// Date: 2023-05-12 22:06:56

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
        /*
         
         */
        for (int tt = 0; tt < T; tt++) {
            int n = fs.nextInt();
            long left = Integer.MAX_VALUE;
            long right = Integer.MAX_VALUE;
            long both = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
                int num = fs.nextInt();
                char[] s = fs.next().toCharArray();
                // System.out.println(s[0] + " " + s[1] + " s");
                if (s[0] == '0') {
                    if (s[1] == '0') {
                        //skip current one
                    } else {
                        right = Math.min(right, num);
                    }
                } else if (s[0] == '1') {
                    if (s[1] == '0') {
                        left = Math.min(num, left);
                    } else {
                        both = Math.min(both, num);
                    }
                }
            }
            long ans = Math.min(both, left + right);
            if(ans >= Integer.MAX_VALUE){
                System.out.println(-1);
            }else{
                System.out.println(ans);
            }

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
}