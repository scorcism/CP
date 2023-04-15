// Abhishek Pathak - scor32k
// Date: 2023-04-16 00:00:44

import java.util.Scanner;

public class CodeForces {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int t = sc.nextInt();
        System.out.println(t % 5 == 0 ? t / 5 : t / 5 + 1);
    }
}