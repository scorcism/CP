public class Basic {
    
    public static void reverseNumber(int n){
        int number = n;
        int sum = 0;

        while(number > 0){
            int tmp = number % 10;
            System.out.println("tmp: " + tmp);
            sum = tmp + (sum * 10);
            System.out.println("sum: " + sum);
            number = number / 10;
            System.out.println("number: " + number);
        }

        System.out.println(sum);

    }

    public static void main(String[] args) {
        reverseNumber(321);
    }
}
