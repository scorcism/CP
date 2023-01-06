import java.util.Scanner;

public class Patterns {

    // https://takeuforward.org/strivers-a2z-dsa-course/must-do-pattern-problems-before-starting-dsa/

    static void pattern1(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print("*" + " ");
            }
            System.out.println();
        }
    }

    static void pattern2(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern3(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern4(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(i + " ");
            }
            System.out.println();
        }
    }

    static void pattern5(int n){
        for(int i = 1; i<= n; i++){
            for(int j = 1; j <= (n-i)+1; j++){
                System.out.print("* ");
            }
            System.out.println();
        }

    static void pattern6(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= (n - i) + 1; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern7(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // pattern
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pattern8(int n) {
        for (int i = 0; i < n; i++) {
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 0; j < 2 * n - (2 * i + 1); j++) {
                System.out.print("*");
            }
            // space
            for (int j = 0; j < i; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pattern9(int n) {
        pattern7(n);
        pattern8(n);
    }

    static void pattern10(int n) {
        for (int i = 1; i <= 2 * n - 1; i++) {
            int steps = i;
            if (i > n) {
                steps = 2 * n - i;
            }
            for (int j = 0; j < steps; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
    }

    static void pattern11(int n) {
        int toPrint = 0;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                toPrint = 1;
            } else {
                toPrint = 0;
            }

            for (int j = 0; j <= i; j++) {
                System.out.print(toPrint + " ");
                toPrint = 1 - toPrint;
            }
            System.out.println();
        }

    }

    static void pattern12(int n) {
        int spaces = 2 * (n - 1);
        for (int i = 1; i <= n; i++) {
            // Number
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            // space
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }

            // Number
            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
            spaces = spaces - 2;
        }
    }

    static void pattern13(int n) {
        int num = 1;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(num++ + " ");
            }
            System.out.println();
        }
    }

    static void pattern14(int n) {
        for (int i = 0; i < n; i++) {
            for (char j = 'A'; j <= 'A' + i; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern15(int n) {
        for (int i = 0; i < n; i++) {
            for (char ch = 'A'; ch <= 'A' + (n - i - 1); ch++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    static void pattern16(int n) {
        for (int i = 0; i < n; i++) {
            char ch = (char) ('A' + i);
            for (int j = 0; j <= i; j++) {
                System.out.print(ch + " ");
            }
            System.out.println();
        }
    }

    static void pattern17(int n) {
        for (int i = 0; i < n; i++) {

            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            // character
            char ch = 'A';
            for (int j = 0; j < 2 * i + 1; j++) {
                System.out.print(ch);
                if (j <= ((2 * i + 1) / 2)) {
                    ch++;
                } else {

                    ch--;
                }
            }

            // space
            for (int j = 0; j < n - i - 1; j++) {
                System.out.print(" ");
            }
            System.out.println();
        }
    }

    static void pattern18(int n) {
        for (int i = 0; i < n; i++) {
            for (char j = (char) ('E' - i); j <= 'E'; j++) {
                System.out.print(j + " ");
            }
            System.out.println();
        }
    }

    static void pattern19(int n) {
        int spaces = 0;
        for (int i = 0; i < n; i++) {
            // star
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 1; j <= spaces; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 1; j <= n - i; j++) {
                System.out.print("*");
            }
            spaces = spaces + 2;
            System.out.println();
        }
        spaces = 2 * n - 2;
        for (int i = 1; i <= n; i++) {
            // star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            // spaces
            for (int j = 0; j < spaces; j++) {
                System.out.print(" ");
            }
            // star
            for (int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            spaces = spaces - 2;
            System.out.println();
        }
    }

    static void pattern20(int n) {
        int spaces =  2*n-2;
        for (int i = 1; i <= 2*n-1; i++) {
            int stars = i;
            if(i >n){
                stars = 2*n -i;
            }
            // stars
            for(int j = 1; j<= stars; j++){
                System.out.print("*");
            }
            // spaces
            for(int j = 1; j <= spaces; j++){
                System.out.print(" ");
            }
            // stars
            for(int j = 1; j<= stars; j++){
                System.out.print("*");
            }
            if(i < n){
                spaces = spaces -2;
            }else{
                spaces = spaces +2;
            }
            System.out.println();
        }
    }

    static void pattern21(int n){
        for(int i = 0; i< n; i++){
            for (int j = 0; j< n; j++){
                if(i==0 || j ==0  || i == n-1|| j == n-1){
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Number: ");
        int n = sc.nextInt();

        pattern21(n);
    }
}
