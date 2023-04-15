// Abhishek Pathak - scor32k
// Date: 2023-04-16 00:19:49

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        String t = sc.next();
        
        int l = 0;
        int u = 0;
        for(int i = 0; i<t.length(); i++){
            if(Character.isLowerCase(t.charAt(i))){
                l++;
            }else{
                u++;
            }
        }
        // System.out.println(l + " " + u);     
        if(l==u || l>u){
            System.out.println(t.toLowerCase());
        }else {
            System.out.println(t.toUpperCase());
        }
    }
}