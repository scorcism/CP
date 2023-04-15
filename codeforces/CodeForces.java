// Abhishek Pathak - scor32k
// Date: 2023-04-15 23:21:11

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String t = sc.next();
        
        char a = t.charAt(0);
        char aa  = Character.toUpperCase(a);
        System.out.println(aa+t.substring(1,t.length()));
    }
}   