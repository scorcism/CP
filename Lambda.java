import java.util.*;


class Lambda {
    // These are one line functions

    int sum (int a, int b){
        return a + b;
    }
    // Converting the sum fucntion into lambda function

    public static void main(String[] args){
        ArrayList<Integer> arr = new ArrayList<>();

        for(int i = 0; i< 5; i++){
            arr.add(i+1);
        }

        arr.forEach((item)->{
            System.out.println(item * 2);
        });

        Operation sum = (a,b)-> a+b;
        Operation prod = (a,b)-> a*b;
        Operation sub = (a,b)-> a-b;
        Operation div = (a,b)-> a/b;

        Lambda myCalc = new Lambda();
        System.out.println(myCalc.operate(6,5,sum));
    }
    
    private int operate(int a, int b, Operation op){
        return op.operation(a,b);
    }

}

interface Operation {
    int operation(int a, int b);
}