public class KMP1 {
    public static void main(String[] args) {
        KMP("ababcabcabcabababd", "ababd");
    }

    public static void KMP(String s, String p) {
        // get the lps or pi table
        int m = s.length();
        int n = p.length();

        int[] lps = new int[n];

        int i = 1;
        int j = 0;

        while (i < n) {
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
        while (i < m) {
            if (s.charAt(i) ==p.charAt(j)) {
                i++;
                j++;
            }
            if (j == n) {
                System.out.println("Pattern found at: " + (i - j));
                j = lps[j - 1];
            } 
            else if (i<m && s.charAt(i) != p.charAt(j)) {
                if (j != 0) {
                    j = lps[j - 1];
                } 
                else {
                    i++;
                }
            }
        }
    }
}
