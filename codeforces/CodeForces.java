// Abhishek Pathak - scor32k
// Date: 2023-04-15 23:37:46

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int a = sc.nextInt();
        int b = sc.nextInt();

        int count = 0;
        while(a <= b){
            a *= 3;
            b *= 2;
            count++;
        }
        
        System.out.println(count);
    }
}