
public class Day16 {

    // String - II
    // commit template -> tuf-day16-questionName
    public static void main(String[] args) {

    }


    // 28. Find the Index of the First Occurrence in a String
    public int strStr(String haystack, String needle) {
        if (needle.length() > haystack.length()) {
            return -1;
        }
        if (needle.length() == 0) {
            return 0;
        }
        int i = 0;
        int j = needle.length();
        while (j <= haystack.length()) {
            if (haystack.substring(i, j).equals(needle)) {
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }
}
