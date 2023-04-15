// Abhishek Pathak - scor32k
// Date: 2023-04-15 23:32:40

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
       
        String color= sc.next();

        
        int count = 0;
        for(int i = 0; i<t-1; i++){
            if(color.charAt(i) == color.charAt(i+1)){
                count++;
            }
        }
        System.out.println(count);
    }
}