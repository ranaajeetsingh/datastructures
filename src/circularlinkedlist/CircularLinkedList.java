package circularlinkedlist;

public class CircularLinkedList {
	Node last;

	static class Node {
		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			this.next = null;
		}
	}

	// Insert node in empty list;
	public void addToEmpty(int data) {
		if (last != null)
			return;

		Node n = new Node(data);
		last = n;
		last.next = n;
	}

	// Add Node in the beginning
	public void addFirst(int data) {
		Node n = new Node(data);
		n.next = last;
		last.next = n;
	}

	// Add Node at the end
	public void addLast(int data) {
		Node n = new Node(data);
		n.next = last.next;
		last.next = n;
		last = n;
	}

	// Add Node after specified node
	public void addAfter(int data, int item) {
		Node n = new Node(data);
		Node prevNode = last;

		while (prevNode.data != item) {
			prevNode = last.next;
		}

		n.next = prevNode.next;
		prevNode.next = n;
	}

	// Delete a Node from the list
	public void delete(int data) {
		Node targetNode = null;
		Node prevNode = last;
		while (true) {
			if (prevNode.next.data == data) {
				targetNode = prevNode.next;
				break;
			}
			prevNode = prevNode.next;
		}
		prevNode.next = targetNode.next;
		targetNode = null;
	}

	public static void printList(CircularLinkedList list) {
		Node n = list.last;
		do {
			n = n.next;
			System.out.println(n.hashCode() + "," + n.data + "," + n.next.hashCode());
		} while (n.data != list.last.data);

	}

	public static void main(String[] args) {
		CircularLinkedList list = new CircularLinkedList();
		list.addToEmpty(0);
		printList(list);
		System.out.println();
		list.addFirst(1);
		printList(list);
		System.out.println();
		list.addLast(2);
		printList(list);
		System.out.println();
		list.addAfter(3, 1);
		printList(list);
		System.out.println();
		list.delete(3);
		printList(list);
		System.out.println();

	}
}
