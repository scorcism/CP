// Abhishek Pathak - scor32k
// Date: 2023-04-15 23:25:28

import java.util.HashSet;
import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String word = sc.next();

        HashSet<Character> set = new HashSet<>();

        for(char c: word.toCharArray()){
            set.add(c);
        }   

        if((set.size()&1)!=0){
            System.out.println("IGNORE HIM!");
        }else{
            System.out.println("CHAT WITH HER!");
        }

    }
}