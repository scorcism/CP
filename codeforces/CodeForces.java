package codeforces;

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        int n;
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        int count = 0;
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();

            if((a==1 && b==1)|| (b==1 && c==1) || (a==1&&c==1)){
                count++;
            }

        }
        System.out.println(count);
    }
}
