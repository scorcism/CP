public class CP5 {
    
    public static void main(String[] args) {
        
        System.out.println(squareOfNumber(30));
    }

    public static int squareOfNumber(int n){
        // Given an integer n, calculate the square of a number without using *, / and pow(). 

        int square = 0;

        int noOfBits = (int)((Math.log(n)/ Math.log(2)) +1);
        // System.out.println(noOfBits);
        
        for(int i  = 0; i<noOfBits; i++){
            if(((n>>i)&1)==1){

                square += n << (1<<i);
            }
        }

        return square;
    }
}
