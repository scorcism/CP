// Abhishek Pathak - scor32k
// Date: 2023-04-16 17:56:43

import java.util.HashSet;
import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        
        String cf = "codeforces";

        HashSet<Character> hash = new HashSet<>();
        for(char c: cf.toCharArray()){
            hash.add(c);
        }

        for(int i = 0; i<t; i++){
            char c = sc.next().charAt(0);
            if(hash.contains(c)){
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }
        }
    }
}