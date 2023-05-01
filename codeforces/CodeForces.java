// Abhishek Pathak - scor32k
// Date: 2023-05-01 00:07:01

import java.util.HashMap;
import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        int t = sc.nextInt();

        for(int i = 0; i<t; i++){

            int size = sc.nextInt();
            HashMap<Integer, Integer> hash  = new HashMap<>();
            for(int k = 0; k< size; k++){
                int n = sc.nextInt();
                hash.put(n, hash.getOrDefault(n, 0)+1);
            }
               
        }
    }
}