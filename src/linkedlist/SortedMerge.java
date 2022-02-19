package linkedlist;

import linkedlist.LinkedList.Node;

public class SortedMerge {

	// personal implementation
	public static LinkedList sortedMerge(LinkedList first, LinkedList second) {
		LinkedList list = new LinkedList();

		if (first.head != null && second.head != null) {
			if (first.head.data > second.head.data) {
				list.head = second.head;
				Node n = second.head;
				while (n.next != null) {
					n = n.next;
				}
				n.next = first.head;

			} else {
				list.head = first.head;
				Node n = first.head;
				while (n.next != null) {
					n = n.next;
				}
				n.next = second.head;
			}

			Node prev = list.head;
			Node n = list.head.next;
			while (n.next != null) {
				if (n.data > n.next.data) {
					Node temp = n.next;
					prev.next = n.next;
					n.next = temp.next;
					temp.next = n;
					n = temp;
				}

				prev = n;
				n = n.next;
			}
		} else if (first.head != null) {
			return first;
		} else if (second.head != null) {
			return second;
		}
		return list;
	}

	// Dummy node implementation
	// Non dummy node implementation; use dummy as null
	public static LinkedList.Node sortedMerge(Node a, Node b) {
		Node dummy = new Node(0);
		Node tail = dummy;
		while (true) {
			/*
			 * if either list runs out, use the other list
			 */
			if (a == null) {
				tail.next = b;
				break;
			}
			if (b == null) {
				tail.next = a;
				break;
			}

			// Compare the data of two and to tail
			if (a.data < b.data) {
				tail.next = a;
				a = a.next;
			} else {
				tail.next = b;
				b = b.next;
			}

			// Change the tail node
			tail = tail.next;
		}

		return dummy.next;
	}

	public static void main(String[] args) {
		LinkedList first = new LinkedList();
		LinkedList second = new LinkedList();
		first.append(5);
		first.append(10);
		first.append(15);
		second.append(2);
		second.append(3);
		second.append(20);
		// LinkedList result = sortedMerge(first, second);

		Node result = sortedMerge(first.head, second.head);

		Node n = result;
		while (n != null) {
			System.out.println(n.data);
			n = n.next;
		}

	}
}
