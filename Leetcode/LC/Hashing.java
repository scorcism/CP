package LC;

import java.util.*;

public class Hashing {

}

class Easy {

    // 2423. Remove Letter To Equalize Frequency
    public boolean equalFrequency(String word) {
        // TC -> O(L+26*26)
        // Sc -> O(26) -> O(1)
        int[] char_freq = new int[26];

        for (char a : word.toCharArray()) {
            char_freq[a - 'a']++;
        }

        for (int i = 0; i < char_freq.length; i++) {
            // decrease the count of curr one and check if by decreasing the array is same
            // or not
            char_freq[i]--;
            if (checkSame(char_freq)) {
                return true;
            }
            // if by descreaing the count arrray is not same again increase it and gotfor
            // next one
            char_freq[i]++;
        }
        return false;

    }

    static boolean checkSame(int[] arr) {
        int lastcount = 0;
        for (int c : arr) {
            if (c == 0) {
                continue;
            }
            if (lastcount != 0 && c != lastcount) {
                return false;
            }
            lastcount = c;
        }
        return true;
    }
}