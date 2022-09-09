class Binary {

    static void sumOfTwoInteger(int a, int b) {
        // Here b is used as an carry
        while (b != 0) {
            int tmp = (a & b) << 1;
            a = a ^ b;
            b = tmp; // b stores carry
        }
        // Answer will be stored in variable a
        System.out.println("Sum: " + a);
    }

    public static void main(String[] args) {
        sumOfTwoInteger(9, 11);
    }

}