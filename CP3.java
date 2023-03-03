import java.util.HashMap;
import java.util.Map;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.LinkedList;
import java.util.Set;
import java.util.HashSet;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;

public class CP3 {
    public static void main(String[] args) {

        String one = "Abhishek";
        String two = "his";
        System.out.println(strStr(one, two));
    }

    public static int strStr(String haystack, String needle) {
          if(needle.length() == 0){
            return 0;
        }
        if(needle.length() > haystack.length()){
            return -1;
        }
        int i = 0;
        int j =needle.length();
        while(j<= haystack.length()){
            // System.out.println(i +" i");
            if(needle.equals(haystack.substring(i,j))){
                // System.out.println("i j " + i + " " + j + " ");
                return i;
            }
            i++;
            j++;
        }
        return -1;
    }

    public static int compressM2(char[] chars){

        int indexAns = 0;
        int index = 0;
        while(index < chars.length){
            char currchar = chars[index];
            int count = 0;
            while(index< chars.length && chars[index] == currchar){
                index++;
                count++;
            }
            chars[indexAns++] = currchar;
            if(count != 1){
                for(char ch:Integer.toString((count)).toCharArray()){
                    chars[indexAns++] = ch;
                }
            }
        }


       return indexAns;
    } 

    public static int compress(char[] chars) {
        int i = 0;
        int res = 0;
        while (i < chars.length) {
            int groupLength = 1;
            while (i + groupLength < chars.length && chars[i] == chars[i + 1]) {
                groupLength++;
            }
            chars[res++] = chars[i];
            if(groupLength > 1){
                for(char c: Integer.toString(groupLength).toCharArray());

                chars[res++] = c;
            }
            i+= groupLength;
        }

        return res;
    }
}
