import java.util.*;

class SlidingWindow{

	// Max Sum Subarray of size K
	static long maximumSumSubarray(int K, ArrayList<Integer> arr,int N){
        // code here
		long max = Integer.MIN_VALUE;
		long sum  = 0;

		int start =  0;int end = 0;

		// cant use for loop cause start is depended on the condition
		// it not required to move start after each for loop

		while(end < N){

			sum = sum + arr.get(end);

			// Achieving the window size

			if((end - start +1) < K){
				end++;
			}

			// At this point windows size is acheived
			else if((end - start +1) == K){
				max = Math.max(sum, max);

				sum = sum - arr.get(start);
				start++;
				end++;
			}
		}

		return max;
    }

	public static void main(String[] args){
		System.out.println("Henlo World");


	}
}
