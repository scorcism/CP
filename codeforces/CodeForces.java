// Abhishek Pathak - scor32k
// Date: 2023-04-16 00:28:38

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        long t = sc.nextLong();
        
        int lucky_count = 0;

        while(t>0){
            long tmp = t % 10;
            // System.out.println(tmp);
            if(tmp == 4 || tmp == 7){
                lucky_count++;
            }
            t /= 10;
        }
        // System.out.println(lucky_count);
        if(lucky_count == 4 || lucky_count == 7){
            System.out.println("YES");
        }else{
            System.out.println("NO");
        }
        
    }
}