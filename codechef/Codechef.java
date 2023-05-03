package codechef;

import java.util.*;
import java.lang.*;
import java.io.*;

/* Name of the class has to be "Main" only if the class is public. */
class Codechef
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
        Scanner sc  = new Scanner(System.in);
        int t = sc.nextInt();

        for(long i = 0; i< t; i++){
            long A = sc.nextLong();
            long B = sc.nextLong();
            
            // co for gcd a should be always greater then b
            long max = Math.max(A,B);
            long min = Math.min(A,B);

            long gcd =   __gcd(max,min);
            long lcm = (A*B)/gcd;

            System.out.println(gcd + " " + lcm);
        }

	}

    private static long __gcd(long a, long b) {
        if(b==0){
            return a;
        }else{
            return __gcd(b, a%b);
        }
    }

    
}
