import java.util.*;

public class Day8 {

    // commit template -> tuf-day8-questionName
    // Greedy Algorithm
    public static void main(String[] args) {

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
