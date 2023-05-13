public class Day5 {

    // commit template -> tuf-day5-questionname
    public static void main(String[] args) {

    }

    // Middle of the linked list
    public ListNode middleNode1(ListNode head) {
        long totalNode = 0;
        ListNode tmp = head;
        while (tmp != head) {
            totalNode++;
            tmp = tmp.next;
        }
        long n = (totalNode / 2) + 1;
        tmp = head;
        while (n >= 0) {
            n--;
            tmp = tmp.next;
        }
        return tmp;

    }

    public ListNode middleNode2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        return slow;
    }

    // Reverse a liked list
    public ListNode reverseListIterative(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode currNext = curr.next;
            curr.next = prev;
            prev = curr;
            curr = currNext;
        }

        return prev;
    }

    public ListNode reverseListRecursive(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = reverseListRecursive(head.next);
        ListNode headnext = head.next;
        headnext.next = head;
        head.next = null;
        return newHead;
    }

    static class ListNode {
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
