
class Node {
	int data;
	Node next;

	Node(int data) {
		this.data = data;
		this.next = null;
	}
}

public class LinkedList1 {

	public static void traverse(Node head) {
		// creating a temp node which will point towards the head so we cannot loose the
		// head
		Node tmp = head;
		while (tmp != null) {
			System.out.println(tmp.data);
			tmp = tmp.next;
		}
	}

	public static void insert(int value, Node head, int pos) {
		Node tmp = new Node(value);
		if (pos == 0) {
			tmp.next = head;
			head = tmp;
			return;
		}
		Node prev = head;

		for (int i = 0; i < pos - 1; i++) {
			prev = prev.next;
		}
		tmp.next = prev.next;
		prev.next = tmp;
	}

	public static void delete(Node head, int pos) {
		if (pos == 0) {
			head = head.next;
			return;
		}
		Node tmp = head;
		for (int i = 0; i < pos - 1; i++) {
			tmp = tmp.next;
		}
		tmp.next = tmp.next.next;
	}

	public static void main(String[] args) {

		Node n1 = new Node(10);
		Node n2 = new Node(1);
		Node n3 = new Node(43);

		Node head = n1;
		head.next = n2;
		n2.next = n3;
		n3.next = null;

		traverse(head);
	}
}
