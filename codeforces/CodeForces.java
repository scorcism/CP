// Abhishek Pathak - scor32k
// Date: 2023-04-16 18:05:53

import java.util.Scanner;
import java.util.Arrays;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        
        for(int i = 0; i<t; i++){
            // int a = sc.nextInt();
            // int b = sc.nextInt();
            // int c = sc.nextInt();

            // int min = Math.min(Math.min(a, b),c);
            // int max = Math.max(Math.max(a, b),c);

            int[] ar = new int[3];
            for(int j = 0; j<3; j++){
                ar[j] = sc.nextInt();
            }
            Arrays.sort(ar);
            System.out.println(ar[1]);


        }
    }
}