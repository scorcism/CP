// Abhishek Pathak - scor32k
// Date: 2023-04-15 23:00:00

import java.util.Scanner;
import java.util.Arrays;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String t = sc.next();
        
        // int[] number_count = new int[4];
        // for(int i  = 0; i<t.length(); i++){
        //     if(t.charAt(i) != '+'){
        //         number_count[t.charAt(i)-'0']++;
        //     }
        // }
        // System.out.println(Arrays.toString(number_count));
        String ans = "";

        char[] char_number = t.toCharArray();
        Arrays.sort(char_number);
        String a  = new String(char_number);

        // System.out.println(a);

        for(int i  = 0 ; i<a.length(); i++){
            if(a.charAt(i)!='+'){
                ans+=a.charAt(i);
                if(i != a.length()-1){
                    ans+="+";
                }
            }
        }
        System.out.println(ans);

    }
}