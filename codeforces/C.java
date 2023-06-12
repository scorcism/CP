// Abhishek Pathak - scor32k
// Date: 2023-06-12 19:33:44

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.InputStream;
import java.util.StringTokenizer;
import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Stack;

public class C {
    public static void main(String[] args) throws Exception {
        FastScanner fs = new FastScanner(System.in);
        PrintWriter out = new PrintWriter(System.out);
        int T = fs.nextInt();

        for (int tt = 0; tt < T; tt++) {
            String s = fs.next();
            HashMap<Character, Integer> map = new HashMap<>();
            map.put('A', 1);
            map.put('B', 10);
            map.put('C', 100);
            map.put('D', 1000);
            map.put('E', 10000);

            int[] arr = new int[s.length()];
            for (int i = 0; i < s.length(); i++) {
                arr[i] = map.get(s.charAt(i));
            }
            int[] next_greater = next_g(arr);
            // System.out.println(Arrays.toString(next_greater));
            int max = Integer.MIN_VALUE;
            for (int i = s.length() - 1; i >= 0; i--) {
                if (arr[i] < next_greater[i]) {
                    arr[i] = arr[i] * -1;
                }   
                max = Math.max(max,arr[i]);
            }
            // System.out.println(Arrays.toString   (arr));

            max = 10000-max;


            long sum = 0;
            for(int n: arr){
                sum+=n;
            }
            sum+=max;
            
            System.out.println(sum);

        }
        out.close();
    }

    static int[] next_g(int[] nums) {

        int[] nge = new int[nums.length];
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= nums[i]) {
                stack.pop();
            }
            if (i < n) {
                if (!stack.isEmpty()) {
                    nge[i] = stack.peek();
                } else {
                    nge[i] = Integer.MIN_VALUE;
                }
            }
            stack.add(nums[i]);

        }
        return nge;
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