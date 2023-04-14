package codeforces;

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        int n = sc.nextInt();
        
        int number = 0;
        for(int i = 0; i<n; i++){
            String op = sc.next();
            
            if(op.charAt(1)=='-'){
                number--;
            }else{
                number++;
            }
        }
        System.out.println(number);

    }
}