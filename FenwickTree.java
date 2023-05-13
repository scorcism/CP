import java.util.Arrays;

public class FenwickTree {

    static int N = 10;
    static int[] fen = new int[N];

    static int sum(int i) {
        int ans = 0;
        for (; i > 0; i -= (i & -i)) {
            ans += fen[i];
        }
        return ans;
    }

    static void update(int i, int x) {
        for (; i <= N; i += (i & (-i))) {
            fen[i] += x;
        }
    }

    public static void main(String[] args) {
        int[] arr = { 8, 4, 9, 2 };
        for (int i = 1; i < arr.length; i++) {
            update(i, arr[i]);
        }
        System.out.println(Arrays.toString(fen));
    }
}
