// Abhishek Pathak - scor32k
// Date: 2023-04-15 08:54:09

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String s1 = sc.next();
        String s2 = sc.next();
        s1 = s1.toLowerCase();
        s2 = s2.toLowerCase();

        if(s1.equals(s2)){
            System.out.println(0);
            ;
        }

        for(int i = 0; i < s1.length(); i++){
            if(s1.charAt(i)==s2.charAt(i)){
                continue;
            }else if (s1.charAt(i)<s2.charAt(i)){
                System.out.println(-1);
                break;
            }else {
                System.out.println(1);
                break;
            }
        }
    }
}