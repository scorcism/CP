import java.util.ArrayList;
import java.util.Comparator;


class Greedy {

    class meeting{
        int start;
        int end;
        int pos;

        meeting(int start, int end,int pos){
            this.start = start;
            this.end = end;
            this.pos = pos;
        }
    }

    class meetingComparator implements Comparator<meeting>{
        @Override
        
        public int compare(meeting o1,meeting o2){
            return o2.end - o1.end;
        }
    }

    //Function to find the maximum number of meetings that can
    //be performed in a meeting room.
    public static int maxMeetings(int start[], int end[], int n)
    {
        ArrayList<meeting> meet = new ArrayList<>();
        for(int i = 0; i< start.length ; i++){
            meet.add(new meeting(start[i], end[i], i+1));
        }
        
        meetingComparator mc = new meetingComparator();
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
        
    }
}
