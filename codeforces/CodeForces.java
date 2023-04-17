// Abhishek Pathak - scor32k
// Date: 2023-04-17 05:23:46

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int t = sc.nextInt();
        
        for(int i = 0; i<t; i++){
            int n = sc.nextInt();

            int p;
            int s;
            for(p = 1, s=  0; p<=n; s++){
                p =p / (p%10)*(p%10+1);
                if(p%10==0){
                    p++;
                }
            }
            System.out.println(s);
        }
    }
}