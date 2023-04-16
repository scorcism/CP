// Abhishek Pathak - scor32k
// Date: 2023-04-17 04:31:39

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();

        for (int i = 0; i < t; i++) {
            int a = sc.nextInt();
            int b = sc.nextInt();
            int c = sc.nextInt();
            int n = sc.nextInt();

            int sum = a + b + c + n;

            if (sum % 3 == 0 && a <= sum / 3 && b <= sum / 3 && c <= sum / 3) {
                System.out.println("YES");
            }else{
                System.out.println("NO");
            }

        }
    }
}