import java.util.HashSet;
import java.util.List;

public class Day6 {

    // commit template: tuf-day6-questionName
    public static void main(String[] args) {

    }

    

    Node mergeTwoListsFlatten(Node a, Node b) {

        Node temp = new Node(0);
        Node res = temp;

        while (a != null && b != null) {
            if (a.data < b.data) {
                temp.bottom = a;
                temp = temp.bottom;
                a = a.bottom;
            } else {
                temp.bottom = b;
                temp = temp.bottom;
                b = b.bottom;
            }
        }
        if (a != null) {
            temp.bottom = a;
        } else {
            temp.bottom = b;
        }
        return res.bottom;
    }

    Node flatten(Node root) {
        // Your code here
        if (root == null || root.next == null) {
            return root;
        }

        // recur for the list on right
        root.next = flatten(root.next);

        // now merge
        root = mergeTwoListsFlatten(root, root.next);

        // return the root
        // it will be in turn merged with its left
        return root;
    }

    public ListNode detectCycleII(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }

        ListNode slow = head;
        ListNode fast = head;
        ListNode start = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                while (slow != start) {
                    slow = slow.next;
                    start = start.next;
                }
                return start;
            }
        }
        return null;
    }

    // Palindrome Linked List
    public boolean isPalindrome2(ListNode head) {
        if (head == null || head.next == null) {
            return true;
        }
        ListNode h = head;

        // Get the middle node
        ListNode slow = h;
        ListNode fast = h;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // mid is in the slow;
        // reverse from mid +1
        slow.next = reverse(slow.next);

        // move slow to mid+1 i.e right half
        slow = slow.next;

        while (slow != null) {
            if (h.val != slow.val) {
                return false;
            }
            h = head.next;
            slow = slow.next;
        }
        return true;
    }

    static ListNode reverse(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode tmp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = tmp;
        }
        return prev;
    }

    // Reverse Nodes in k-Group
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null || k == 1) {
            return head;
        }
        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode curr = dummy, nxt = dummy, pre = dummy;

        int count = 0;
        while (curr.next != null) {
            curr = curr.next;
            count++;
        }

        while (count >= k) {
            curr = pre.next;
            nxt = curr.next;

            for (int i = 1; i < k; i++) {
                curr.next = nxt.next;
                nxt.next = pre.next;
                pre.next = nxt;
                nxt = curr.next;
            }
            pre = curr;
            count -= k;
        }
        return dummy.next;

    }

    // Linked List Cycle
    public boolean hasCycle1(ListNode head) {
        HashSet<ListNode> set = new HashSet<>();
        ListNode a = head;
        while (a != null) {
            if (set.contains(a)) {
                return true;
            }
            a = a.next;
        }
        return false;
    }

    public boolean hasCycle2(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if (slow == fast) {
                return true;
            }
        }
        return false;
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

    class Node {
        int data;
        Node next;
        Node bottom;

        Node(int d) {
            data = d;
            next = null;
            bottom = null;
        }
    }

}
