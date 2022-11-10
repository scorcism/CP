import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;
import java.util.Queue;
import java.util.PriorityQueue;

class Greedy {

    static ArrayList<Integer> candyStore(int candies[], int N, int K) {
        Arrays.sort(candies);
        // As the array is sorted the minimum will be at the start index and the
        // max element will be at the last index
        int mini = 0; // To store the minimum price
        int buy = 0; // For indixating the values to buy
        int free = N - 1; // For indexing the values to get for free

        while (buy <= free) {
            mini = mini + candies[buy];
            free = free - K;
            buy++;
        }

        int maxi = 0;
        buy = N - 1;
        free = 0;

        while (free <= buy) {
            maxi = maxi + candies[buy];
            buy--;
            free = free + K;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(mini);
        ans.add(maxi);

        return ans;
    }

    static class meeting {
        int start;
        int end;
        int pos;

        meeting(int start, int end, int pos) {
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class meetingComparator implements Comparator<meeting> {
        @Override

        public int compare(meeting o1, meeting o2) {
            return o2.end - o1.end;
        }
    }

    // Function to find the maximum number of meetings that can
    // be performed in a meeting room.
    public static void maxMeetings(int start[], int end[], int n) {
        ArrayList<meeting> meet = new ArrayList<>();
        for (int i = 0; i < start.length; i++) {
            meet.add(new meeting(start[i], end[i], i + 1));
        }

        meetingComparator mc = new meetingComparator();
        Collections.sort(meet, mc);
        ArrayList<Integer> answer = new ArrayList<>();

        // 1st meeting is added
        answer.add(meet.get(0).pos);
        // so, end time will be the limit of that meeting
        int limit = meet.get(0).end;

        for (int i = 1; i < start.length; i++) {
            if (meet.get(i).start > limit) {
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        for (int i = 0; i < answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

    }

    /*
     * N – The maximum unit of food you can buy each day.
     * S – Number of days you are required to survive.
     * M – Unit of food required each day to survive.
     */
    static public int minimumDays(int S, int N, int M) {
        int totalsundays = S / 7; // total sundays
        int buyingdays = S - totalsundays;
        int totalfood = S * M;
        int ans = 0;
        if (totalfood % N == 0) {
            ans = totalfood / N;
        } else {
            ans = (totalfood / N) + 1;
        }

        if (ans <= buyingdays) {
            return ans;
        } else {
            return -1;
        }
    }

    public static String reverse_string(String S) {
        String reverse = "";

        for (int i = S.length() - 1; i >= 0; i--) {
            reverse += S.charAt(i);
        }
        return reverse;
    }

    public static String reverseWords(String S) {
        String answer = "";
        String tmp = "";

        for (int i = S.length() - 1; i >= 0; i--) {
            if (S.charAt(i) == '.') {
                String reverse_tmp = reverse_string(tmp);
                answer = answer + reverse_tmp;
                answer += ".";
                tmp = "";
            } else {
                tmp += S.charAt(i);
            }
        }
        String reverse_tmp = reverse_string(tmp);
        answer = answer + reverse_tmp;

        return answer;
    }

    public static long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        int mini = Integer.MAX_VALUE;
        int i = 0;
        int j = m - 1;

        while (j < a.size()) {
            int diff = a.get(j) - a.get(i);
            mini = Math.min(mini, diff);
            i++;
            j++;
        }

        return mini;

    }

    public static long minCost(long arr[], int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        for (long i = 0; i < arr.length; i++) {
            pq.add(i);
        }
        long cost = 0;

        while (pq.size() > 1) {
            long first = pq.poll();
            // pq.remove();

            long second = pq.poll();
            // pq.remove();

            long combined_values = first + second;
            cost = cost + combined_values;
            pq.add(combined_values);
        }
        return cost;
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    // static class MyCmp implements Comparator<Node> {
    // public int compare(Node a, Node b) {
    // return a.data - b.data;
    // }
    // }
    static class MyCmp implements Comparator<Node> {
        public int compare(Node a, Node b) {
            return a.data - b.data;
        }
    }

    public static void traverse(Node root, ArrayList<String> ans, String tmp) {
        // base
        // If left and right are null means it is a leaf node
        if (root.left == null && root.right == null) {
            ans.add(tmp);
            return;
        }
        traverse(root.left, ans, tmp + "0");
        traverse(root.right, ans, tmp + "1");
    }

    // // static class HuffmanSolve {

    //     String s;
    //     int N;
    //     int[] f;

    //     HuffmanSolve(String s, int N, int[] f) {
    //         this.s = s;
    //         this.N = N;
    //         this.f = f;
    //     }

    //     // PriorityQueue<Node> pq = new PriorityQueue<Node>(N, new MyCmp());

    //     // put all freq in the pq
    //     for(
    //     int i = 0;i<N;i++)
    //     {
    //         Node tmp = new Node(f[i]);
    //         pq.add(tmp);
    //     }
    //     Node root = null;// denotes the root node
    //     // Get the 2 low freq bunch it up in new node and put again into the pq
    //     while(pq.size()>1)
    //     {
    //         Node left = pq.peek();
    //         pq.poll();

    //         Node right = pq.peek();
    //         pq.poll();

    //         Node newNode = new Node(left.data + right.data);
    //         // make left as the left of the new node and right as right of the new node
    //         newNode.left = left;
    //         newNode.right = right;

    //         root = newNode;
    //         pq.add(newNode);
    //         // tree is created at this point
    //     }
    //     // Traversing the tree to get the huffman encoding
    //     ArrayList<String> ans = new ArrayList<>();
    //     String tmp = ""; // to store the answer at the temporary level

    //     // traverse(root,ans,tmp);
    // }

        static class Item {
            int value, weight;

            Item(int x, int y) {
                this.value = x;
                this.weight = y;
            }
        }
        // fractionalKnapsack
    public static double getMaxValue(int W, Item arr[], int n) 
    {
        Arrays.sort(arr, new Comparator<Item>(){
            public int compare(Item item1, Item item2){
                double cpr1
                = (double)item1.value
                             / (double)item1.weight;
            double cpr2
                = (double)item2.value
                             / (double)item2.weight;

            if (cpr1 < cpr2)
                return 1;
            else
                return -1;
            }
        });

        for(int i = 0; i<n; i++){
            System.out.println(i+ " ith: " + arr[i].value + " "+arr[i].weight);
        }

        double totalvalue = 0d;
        for(int i = 0; i< arr.length; i++){
            // Getting current values
            // Current item weight is greater then wight
            int currW =  arr[i].weight;
            int currV = arr[i].value;

            if( currW >= W ){
                totalvalue += W*arr[i].value;
                W  = 0;
            }
            // Current value weight is less then weight
            else{
                totalvalue = totalvalue+arr[i].value;
                W = W-arr[i].value;
                System.out.println("\n"+ i + " ith weight  " + totalvalue);
               
            }
        }

        return totalvalue;

    }

    public static void main(String[] args) {

        // int[] candies = { 3, 2, 1, 4 };
        // int N = 4;
        // int K = 2;
        // System.out.println(candyStore(candies, N, K));
        // String S = "i.like.this.program.very.much";
        // System.out.println(reverseWords(S));
        // int N = 8; int M = 5;
        // int[] A = {3, 4, 1, 9, 56, 7, 9, 12};
        // ArrayList<Integer> A = new ArrayList<>();
        // A.add(3);
        // A.add(4);
        // A.add(1);
        // A.add(9);
        // A.add(56);
        // A.add(7);
        // A.add(9);
        // A.add(12);
        // System.out.println(findMinDiff(A, N, M));

        // int n = 4;
        // long[] arr = {4, 3, 2, 6};

        // System.out.println(minCost(arr, n));
        // String S = "abcdef";
        // int f[] = {5, 9, 12, 13, 16, 45};
        // HuffmanSolve h = new HuffmanSolve(S,6,f);

        Item[] arr = { new Item(60, 10),
            new Item(100, 20),
            new Item(120, 30) };

        int capacity = 50;

        double maxValue = getMaxValue(capacity, arr,3);

        // Function call
        System.out.println(maxValue);

    }
}
