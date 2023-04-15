// Abhishek Pathak - scor32k
// Date: 2023-04-15 23:51:20

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int k = sc.nextInt();
        int n = sc.nextInt();
        int w = sc.nextInt();
        
        int t = 0;
        for(int i = 1; i<=w; i++){
            t += k*i;
        }
        if(t-n <=0){
            System.out.println(0);
        }else{
            System.out.println(t-n);

        }
    }
}