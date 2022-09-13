class Recursion{

    public static void base(int n){
        // This is called abse condition
        if(n<=10){
            return;
        }
        System.out.println(n);
        n++;
        base(n);
    }
    
    public static void printName(String name,int n){
        if(n < 1){
            return;
        }

        System.out.println(name);
        printName(name,n-1);
    }

    public static void printNumber1(int s,int e){
        if( s > e){
            return;
        }
        System.out.println(s);
        printNumber1(s+1,e);
    }

    public static void printNumber2(int e){
      if( e < 1){
        return;
      }  
      System.out.println(e);
      printNumber2(e-1);
    }


    public static void printNumber3(int n){
       if(n<1){
        return;
       }
       printNumber3(n-1);
       System.out.println(n);
    }
    
    // public static void printName(int n){
       
    // }

    public static int sum1(int n, int sum){
        if ( n < 0){
            System.out.println(sum);
            return 0;
        }

        return sum1(n-1,sum + n);
    }

    public static int sum2(int n){
        if ( n < 1){
            return 0;
        }
        return ( n + sum2(n-1) ) ;
    }

    public static int factorial1(int n){
        if(n<1){
            return 1;
        }
        return n * factorial1(n-1);
    }

    public static boolean palindrome1(String n, int s){
        if(s >= (n.length() / 2)){
            return true;
        }

        if(n.charAt(s) != n.charAt((n.length() - s) -1)){
            return false;
        }

        return palindrome1(n,s+1);
    }

    public static int fibo1(int n){
        // 0 1 1 2 3 5 8 13 21
        // eg 5th fibo  => 5
        if( n == 1 ){
            return 1;
        }
        if(n == 0){
            return 0;
        }

        return fibo1(n-2) + fibo1(n-1);
    }

    public static int subSequence(String text){
        // This can be done using Power-Set
        
    }

    public static void main(String[] args){
        /**
        // base(1);
        // Print name 5 time
        String name = "Abhishek";
        // printName(name,5);

        // Print linearly from 1 to N
        // printNumber1(1,10);

        // Print from N to 1
        // printNumber2(10);

        // Print linearly from 1 to N ( But By Backtrack ) +1 is not allowed using backtracing 
        // printNumber3(10);

        // Print linearly from N to 1 ( But By Backtrack )
        // Same :)

        // Sum of 1st n number
        // 1st way  (Parameter way)
        // sum1(3,0);
        // 2nd way (Function way)
        // System.out.println(sum2(3));

        // System.out.println(factorial1(5));
        
        // Reverse an array
        //  This requires pass by refrence but in java we cannot pass by reference

        // check if the given string is palindrome or not
        // if(palindrome1("madam",0)){
        //     System.out.println("palinform");
        // }else{
        //     System.out.println("NOT palinform");
        // }


        */

        // Multiple recursion calls
        // Fibonachi number
        // Given N we have to write a recursive function which will give us the nth fibonachi number
        // System.out.println(fibo1(8));

        // Print all sub sequences
        //  A contagious / non- contagious seq. which follows te order
        subSequence("name");
    }
}