package codeforces;

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n;
        int k;
        n = sc.nextInt();
        k = sc.nextInt();
        int count = 0;
        int[] ar = new int[n+1];
        int j = 1;
        for(int i = 0; i<n; i++){
            int a = sc.nextInt();
            ar[j++] = a; 
        }

        int kth = ar[k];

        // System.out.println(kth + " kth");
        for(int i = 1;i<ar.length; i++){
            if(ar[i]>=kth && ar[i] >0){
                count++;
            }
        } 
        System.out.println(count);
    }
}
