import java.util.HashSet;

public class Day6 {

    // commit template: tuf-day6-questionName
    public static void main(String[] args) {

    }



    // Intersection of Two Linked Lists
    public ListNode getIntersectionNode1(ListNode headA, ListNode headB) {
        ListNode a = headA;
        ListNode b = headB;

        while (b != null) {
            while (a != null) {
                if (a == b) {
                    return a;
                }
                a = a.next;
            }
            b = b.next;
        }
        return null;
    }

    public ListNode getIntersectionNode2(ListNode headA, ListNode headB) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode a = headA;
        ListNode b = headB;

        while (a != null) {
            set.add(a);
            a = a.next;
        }

        while (b != null) {
            if (set.contains(b)) {
                return b;
            }
        }
        return null;

    }

    public ListNode getIntersectionNode3(ListNode headA, ListNode headB) {

        ListNode a = headA;
        ListNode b = headB;
        int counta = 0;
        int countb = 0;

        while (a != null) {
            counta++;
            a = a.next;
        }

        while (b != null) {
            countb++;
            b = b.next;
        }
        int max = Math.max(countb, counta);
        int min = Math.min(countb, counta);
        int diff = max - min;

        ListNode d1 = null;
        ListNode d2 = null;
        if (max == counta) {
            d1 = headA;
            d2 = headB;
            while (max >= 0) {
                d1 = d1.next;
                max--;
            }
        } else if (max == countb) {
            d1 = headB;
            d2 = headA;
            while (max >= 0) {
                d1 = d1.next;
                max--;
            }
        }

        while (d1 != null && d2 != null) {
            if (d1 == d2) {
                return d1;
            }
            d1 = d1.next;
            d2 = d2.next;
        }

        return null;
    }

    public ListNode getIntersectionNode4(ListNode headA, ListNode headB) {

        if (headA == null || headB == null) {
            return null;
        }
        ListNode a = headA;
        ListNode b = headB;

        while (a != b) {
            a = a == null ? headB : a.next;
            b = b == null ? headA : b.next;
        }

        return a;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode(int x) {
            val = x;
            next = null;
        }
    }

}
