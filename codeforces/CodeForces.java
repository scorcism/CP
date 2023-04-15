// Abhishek Pathak - scor32k
// Date: 2023-04-16 00:41:57

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        int k = sc.nextInt();

        
        while(k-->0){
            int tmp = n % 10;
            if(tmp == 0){
                n /= 10;
            }else if(tmp !=0){
                n = n-1;
            }
        }
        System.out.println(n);
    }
}