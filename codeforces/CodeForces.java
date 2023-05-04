// Abhishek Pathak - scor32k
// Date: 2023-05-04 09:43:10

import java.util.Scanner;

public class CodeForces {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
       
        int t = sc.nextInt();
        
        for(int i = 0; i<t; i++){
            solve();
        }
    }

    public static void solve(){
        int n = sc.nextInt();
        int k = sc.nextInt();
        k--;
        if(n%2 ==0){
            System.out.println(1+ k%n);
        }else{
            int intersect = k / ((n-1)/2);
            System.out.println(1 + (k+intersect) % n);
        }
    }
}