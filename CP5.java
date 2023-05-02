public class CP5 {
    
    public static void main(String[] args) {
        // System.out.println(squareOfNumber(15));
        System.out.println(divide(3, 33));
    }

    public static int divide(int a, int b)
    {
        int divident = Math.abs(a);
        int divisor = Math.abs(b);
        int res = 0;

        while(divident-divisor>=0){
            int x = 0; // 2 ^ 0 = 1

            while(divident-(divisor<<1<<x)>=0){
                x++;
            }
            res += 1<<x;
            divident -= divisor<<x;
        }

        return (divident>=0)== (divisor>=0) ? res : -res;
    }

    public static int squareOfNumber(int n){
        int square = 0;

        int noOfBits = (int)((Math.log(n)/ Math.log(2)) +1);
        
        for(int i  = 0; i<noOfBits; i++){
            if(((n>>i)&1)==1){
                square += n << i;
            }
        }

        return square;
    }
}
