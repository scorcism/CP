public class Day5 {

    // commit template -> tuf-day5-questionname
    public static void main(String[] args) {

    }


    

    public ListNode mergeTwoLists1(ListNode list1, ListNode list2) {
        if (list1 == null && list2 == null) {
            return null;
        }
        if (list1 == null && list2 != null) {
            return list2;
        }
        if (list1 != null && list2 == null) {
            return list1;
        }
        ListNode dummyNode = new ListNode(0);
        ListNode d = dummyNode;
        ListNode h1 = list1;
        ListNode h2 = list2;

        while (h1 != null && h2 != null) {
            if (h1.val < h2.val) {
                d.next = h1;
                h1 = h1.next;

            } else {
                d.next = h2;
                h2 = h2.next;
            }
            d = d.next;
        }
        while (h1 != null) {
            d.next = h1;
            h1 = h1.next;
            d = d.next;
        }
        while (h2 != null) {
            d.next = h2;
            h2 = h2.next;
            d = d.next;
        }

        return dummyNode.next;

    }

    public ListNode mergeTwoLists2(ListNode list1, ListNode list2) {
        if (list1 == null) {
            return list2;
        }
        if (list2 == null) {
            return list1;
        }
        // fix the smaller one to list1 ans larget one to list2
        if (list1.val > list2.val) {
            ListNode tmp = list1;
            ;
            list1 = list2;
            list2 = tmp;
        }
        ListNode res = list1;
        while (list1 != null && list2 != null) {
            ListNode tmp = null;
            while (list1 != null && list1.val <= list2.val) {
                tmp = list1;
                list1 = list1.next;
            }
            tmp.next = list2;

            // swap
            ListNode temp = list1;
            list1 = list2;
            list2 = temp;
        }
        return res;
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
