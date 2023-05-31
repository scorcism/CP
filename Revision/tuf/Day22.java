import java.util.*;

public class Day22 {

    public static void main(String[] args) {

    }

}

class MedianFinder {
    // max Heap
    PriorityQueue<Integer> smallNumbers = new PriorityQueue<>(Collections.reverseOrder());

    // min heap
    PriorityQueue<Integer> largeNumbers = new PriorityQueue<>();

    public MedianFinder() {

    }

    public void addNum(int num) {
        if (smallNumbers.isEmpty() || smallNumbers.peek() >= num) {
            smallNumbers.add(num);
        } else {
            largeNumbers.add(num);
        }

        if (smallNumbers.size() > largeNumbers.size()) {
            largeNumbers.add(smallNumbers.poll());
        } else if (smallNumbers.size() < largeNumbers.size()) {
            smallNumbers.add(largeNumbers.poll());
        }
    }

    public double findMedian() {
        if (smallNumbers.size() == largeNumbers.size()) {
            return smallNumbers.peek() / 2.0 + largeNumbers.peek() / 2.0;
        }
        return smallNumbers.peek();
    }
}