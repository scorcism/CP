import java.util.PriorityQueue;

public class ToCheckCodes {

}

class Solution2 {
    public int minimumDeviation(int[] nums) {
        // First create a priority Queue
        // and implemented a custom comperator, which help us in making this priority
        // queue act like a max heap
        // concept of max heap states that, highest value should lie at the front of the
        // queue & lowest value at the back of the queue
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a); // so we apply the custom comperator over here

        int min = Integer.MAX_VALUE; // creating minimum variable
        for (int i : nums) { // add these values in priority queue
            if (i % 2 == 1)
                i *= 2; // if value is odd mult. by 2 & make it even
            min = Math.min(min, i); // find the minimum
            pq.add(i);
        } // now we have the value in the priority queue, where we have convert all the
          // odd's into even

        // let's find the maximum of all the value
        int diff = Integer.MAX_VALUE;
        while (pq.peek() % 2 == 0) {
            int max = pq.remove(); // max will be at top of the queue
            diff = Math.min(diff, max - min); // find the difference
            min = Math.min(max / 2, min);// minimum can change because, new value we are getting by half max can be
            // lower then current minimum
            pq.add(max / 2); // add that in the queue
        }

        return Math.min(diff, pq.peek() - min);
    }
}

class Solution {
    public int trap(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }
        int left = 0;
        int right = height.length - 1; // Pointers to both ends of the array.
        int maxLeft = 0;
        int maxRight = 0;

        int totalWater = 0;
        while (left < right) {
            // Water could, potentially, fill everything from left to right, if there is
            // nothing in between.
            if (height[left] < height[right]) {
                // If the current elevation is greater than the previous maximum, water cannot
                // occupy that point at all.
                // However, we do know that everything from maxLeft to the current index, has
                // been optimally filled, as we've
                // been adding water to the brim of the last maxLeft.
                if (height[left] >= maxLeft) {
                    // So, we say we've found a new maximum, and look to see how much water we can
                    // fill from this point on.
                    maxLeft = height[left];
                    // If we've yet to find a maximum, we know that we can fill the current point
                    // with water up to the previous
                    // maximum, as any more will overflow it. We also subtract the current height,
                    // as that is the elevation the
                    // ground will be at.
                } else {
                    totalWater += maxLeft - height[left];
                }
                // Increment left, we'll now look at the next point.
                left++;
                // If the height at the left is NOT greater than height at the right, we cannot
                // fill from left to right without over-
                // flowing; however, we do know that we could potentially fill from right to
                // left, if there is nothing in between.
            } else {
                // Similarly to above, we see that we've found a height greater than the max,
                // and cannot fill it whatsoever, but
                // everything before is optimally filled
                if (height[right] >= maxRight) {
                    // We can say we've found a new maximum and move on.
                    maxRight = height[right];
                    // If we haven't found a greater elevation, we can fill the current elevation
                    // with maxRight - height[right]
                    // water.
                } else {
                    totalWater += maxRight - height[right];
                }
                // Decrement left, we'll look at the next point.
                right--;
            }
        }
        // Return the sum we've been adding to.
        return totalWater;
    }
}
