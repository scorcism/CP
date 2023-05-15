public class Day7 {

    // commit template -> tuf-day7-questionName
    public static void main(String[] args) {

    }


    

    // Rotate List
    public ListNode rotateRight(ListNode head, int k) {

        if (head == null || head.next == null) {
            return head;
        }

        int len = 1;
        ListNode t = head;

        while (t.next != null) {
            t = t.next;
            len++;
        }

        t.next = head;
        k = k % len;
        k = len - k;
        while (k > 0) {
            t = t.next;
            k--;
        }

        head = t.next;
        t.next = null;

        return head;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }
}