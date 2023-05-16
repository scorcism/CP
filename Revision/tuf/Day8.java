import java.util.*;

public class Day8 {

    // commit template -> tuf-day8-questionName
    // Greedy Algorithm
    public static void main(String[] args) {

    }


    
    // Function to find the minimum number of platforms required at the railway
    // station such that no train waits.
    static int findPlatform(int arr[], int dep[], int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int platforms = 1;
        int maxp = 1;
        int i = 1;
        int j = 0;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platforms++;
                i++;
            } else if (arr[i] > dep[j]) {
                platforms--;
                j++;
            }
            if (platforms > maxp) {
                maxp = platforms;
            }
        }
        return maxp;

    }

    // Function to get the maximum total value in the knapsack.
    double fractionalKnapsack(int W, Item arr[], int n) {
        // Your code here
        Arrays.sort(arr, new Comparator<Item>() {
            public int compare(Item a, Item b) {
                double first = (double) a.value / (double) a.weight;
                double second = (double) b.value / (double) b.weight;

                if (first < second)
                    return 1;
                else if (first > second)
                    return -1;
                else
                    return 0;
            }
        });

        int currWeight = 0;
        double finalvalue = 0.0;

        for (int i = 0; i < n; i++) {
            if (arr[i].weight + currWeight <= W) {
                currWeight += arr[i].weight;
                finalvalue += arr[i].value;
            } else {
                int remain = W - currWeight;
                finalvalue += ((double) arr[i].value / (double) arr[i].weight) * (double) remain;
                break;
            }
        }
        return finalvalue;
    }

    class Item {
        int value, weight;

        Item(int x, int y) {
            this.value = x;
            this.weight = y;
        }
    }

    // Function to find the maximum profit and the number of jobs done.
    int[] JobScheduling(Job arr[], int n) {
        Arrays.sort(arr, (a, b) -> b.profit - a.profit);

        int maxDeadline = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i].deadline > maxDeadline) {
                maxDeadline = arr[i].deadline;
            }
        }

        int result[] = new int[maxDeadline + 1];

        for (int i = 1; i <= maxDeadline; i++) {
            result[i] = -1;
        }

        int countJobs = 0;
        int jobProfit = 0;

        for (int i = 0; i < n; i++) {

            for (int j = arr[i].deadline; j > 0; j--) {
                if (result[j] == -1) {
                    result[j] = i;
                    countJobs++;
                    jobProfit += arr[i].profit;
                    break;
                }
            }
        }
        int[] ans = new int[2];
        ans[0] = countJobs;
        ans[1] = jobProfit;

        return ans;
    }

    class Job {
        int id, profit, deadline;

        Job(int x, int y, int z) {
            this.id = x;
            this.deadline = y;
            this.profit = z;
        }
    }

    class NodeComparator implements Comparator<Node> {

        public int compare(Node a, Node b) {
            return a.data - b.data;
        }

    }

    // Huffman Encoding
    public ArrayList<String> huffmanCodes(String S, int f[], int N) {

        PriorityQueue<Node> pq = new PriorityQueue<Node>();

        for (int n : f) {
            Node node = new Node(n);
            pq.add(node);
        }

        for (int i = 0; i < f.length; i++) {
            Node left = pq.poll();
            Node right = pq.poll();
            Node newNode = new Node(left.data + right.data);
            newNode.left = left;
            newNode.right = right;
            pq.add(newNode);
        }

        Node root = pq.peek();
        // we need preorder traversl of these
        ArrayList<String> a = new ArrayList<>();

        String tmp = "";
        traverse(root, a, tmp);
        return a;

    }

    private void traverse(Node root, ArrayList<String> a, String tmp) {
        if (root.left == null && root.right == null) {
            a.add(tmp);
            return;
        }
        traverse(root.left, a, tmp += "0");
        traverse(root.right, a, tmp += "1");
    }

    static class Node {
        int data;
        Node left;
        Node right;

        Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    // Function to return the minimum cost of connecting the ropes.
    long minCost(long arr[], int n) {
        // as default one is min heap
        PriorityQueue<Long> pq = new PriorityQueue<>();

        for (long num : arr) {
            pq.add(num);
        }

        long cost = 0;
        while (pq.size() > 1) {
            long first = pq.poll();
            long second = pq.poll();
            long a = first + second;
            cost += a;
            pq.add(a);
        }
        return cost;
    }

    public long findMinDiff(ArrayList<Integer> a, int n, int m) {
        Collections.sort(a);
        int min = Integer.MAX_VALUE;
        int i = 0;
        int j = m - 1;
        while (j < a.size()) {
            min = Math.min(min, a.get(j) - a.get(i));
            i++;
            j++;
        }
        return min;
    }

    // Check if it is possible to survive on Island
    static int minimumDays(int S, int N, int M) {
        int sundays = S / 7;
        int totalDays = S - sundays;

        int totalFood = S * M;
        int ans = 0;
        if (totalFood % N == 0) {
            ans = totalFood / N;
        } else {
            ans = totalFood / N + 1;
        }

        if (ans <= totalDays) {
            return ans;
        } else {
            return -1;
        }

    }

    // shop in candy store
    static ArrayList<Integer> candyStore(int candies[], int N, int K) {
        Arrays.sort(candies);
        int mini = 0;
        int buy = 0;
        int free = N - 1;

        while (buy <= free) {
            mini += candies[buy];
            buy++;
            free = free - K;
        }

        int maxi = 0;
        buy = N - 1;
        free = 0;
        while (free <= buy) {
            maxi += candies[buy];
            buy--;
            free = free + K;
        }
        ArrayList<Integer> a = new ArrayList<>();
        a.add(mini);
        a.add(maxi);

        return a;
    }

    public static ArrayList<Integer> maxMeetings(int N, int[] S, int[] F) {
        ArrayList<meeting> a = new ArrayList<>();
        ArrayList<Integer> ans = new ArrayList<>();

        for (int i = 0; i < N; i++) {
            a.add(new meeting(S[i], F[i], i + 1));
        }
        Collections.sort(a, new Comparator<meeting>() {
            public int compare(meeting a, meeting b) {
                return a.end - b.end;
            }
        });

        int endtime = a.get(0).end;
        ans.add(a.get(0).pos);
        for (int i = 1; i < N; i++) {
            if (a.get(i).start > endtime) {
                ans.add(a.get(i).pos);
                endtime = a.get(i).end;
            }
        }

        Collections.sort(ans);

        return ans;
    }

    static class meeting {
        int start;
        int end;
        int pos;

        meeting(int s, int e, int p) {
            this.start = s;
            this.end = e;
            this.pos = p;
        }
    }

    // N meetings in one room
    public static int maxMeetings(int start[], int end[], int n) {

        ArrayList<Meeting> a = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            a.add(new Meeting(start[i], end[i]));
        }

        Collections.sort(a, new Comparator<Meeting>() {
            public int compare(Meeting m1, Meeting m2) {
                return m2.end - m1.end;
            }
        });

        int count = 1;
        int endtime = a.get(0).end;
        for (int i = 1; i < n; i++) {
            if (a.get(i).start > endtime) {
                count++;
                endtime = a.get(i).end;
            }
        }

        return count;

    }

    static class Meeting {
        int start;
        int end;

        Meeting(int s, int e) {
            this.start = s;
            this.end = e;
        }
    }

}
