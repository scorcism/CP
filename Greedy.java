import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Arrays;

class Greedy {

    static ArrayList<Integer> candyStore(int candies[],int N,int K){
        Arrays.sort(candies);
        // As the array is sorted the minimum will be at the start index and the 
        // max element will be at the last index
        int mini = 0; // To store the minimum price
        int buy = 0; // For indixating the values to buy
        int free = N-1; // For indexing the values to get for free

        while(buy <= free){
            mini = mini + candies[buy];
            free = free - K;
            buy++;
        }

        int maxi= 0;
        buy = N-1;
        free = 0;
        
        while(free <= buy){
            maxi = maxi + candies[buy];
            buy--;
            free = free + K;
        }

        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(mini);
        ans.add(maxi);

        return ans;
    }

    static class meeting{
        int start;
        int end;
        int pos;

        meeting(int start, int end,int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    static class meetingComparator implements Comparator<meeting>{
        @Override
        
        public int compare(meeting o1,meeting o2){
            return o2.end - o1.end;
        }
    }

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static void maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i = 0; i< start.length ; i++){
            meet.add(new meeting(start[i], end[i], i+1));
        }
        
        meetingComparator mc = new meetingComparator();
        Collections.sort(meet,mc);
        ArrayList<Integer> answer = new ArrayList<>();

        // 1st meeting is added
        answer.add(meet.get(0).pos);
        // so, end time will be the limit of that meeting
        int limit = meet.get(0).end;

        for(int i = 1; i<start.length; i++){
            if(meet.get(i).start > limit){
                limit = meet.get(i).end;
                answer.add(meet.get(i).pos);
            }
        }
        for(int i = 0;i<answer.size(); i++) {
            System.out.print(answer.get(i) + " ");
        }

    }

    public static void main(String[] args) {
        
        int[] candies = {3,2,1,4};
        int N = 4;
        int K = 2;
        System.out.println(candyStore( candies, N, K));
    }
}
