import java.util.Arrays;

public class KMP0 {

    public static void main(String[] args) {
        KMP("ababcabcabcabababd", "ababd");
    }

    static int[] _lps(String p) {
        int m = p.length();

        int i = 1;
        int j = 0;

        int lps[] = new int[m];

        while (i < m) {
            if (p.charAt(i) == p.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        return lps;
    }

    static void KMP(String s, String p) {
        int n = s.length();
        int m = p.length();

        int i = 1;
        int j = 0;

        int lps[] = new int[m];

        while (i < m) {
            if (p.charAt(i) == p.charAt(j)) {
                j++;
                lps[i] = j;
                i++;
            } else {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        i = 0;
        j = 0;

        while (i < n) {
            if (s.charAt(i) == p.charAt(j)) {
                i++;
                j++;
            }
            if (j == m) {
                System.out.println("Pattern Found: " + (i - j));
                j = lps[j - 1];
            } else if (i < n && s.charAt(i) != p.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
    }
}
