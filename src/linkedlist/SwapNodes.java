package linkedlist;

import linkedlist.LinkedList.Node;

public class SwapNodes {

	public static void swap(LinkedList list, int x, int y) {
		if (x == y) {
			System.out.println("Both the keys are same");
			return;
		}

		if (list != null) {
			Node n = list.head;
			if (n != null) {
				// find previous and current element for both the inputs
				Node nodeX = null;
				Node prevX = null;
				Node nodeY = null;
				Node prevY = null;
				while (n.next != null) {
					if (n.data == x)
						nodeX = n;
					else if (n.next.data == x) {
						prevX = n;
						nodeX = n.next;
					}
					if (n.data == y)
						nodeY = n;
					else if (n.next.data == y) {
						prevY = n;
						nodeY = n.next;
					}
					if (nodeX != null && nodeY != null)
						break;
					n = n.next;
				}

				if (nodeX == null && nodeY == null) {
					System.out.println("One of the key is not present in list");
				} else {

					if (prevX == null)
						list.head = nodeY; // Change head to second node
					else
						prevX.next = nodeY; // Change pointer of previous of first node to second node

					if (prevY == null)
						list.head = nodeX; // Change head to first node
					else
						prevY.next = nodeX; // Change pointer of previous of second node to first node

					Node temp = nodeX.next;// Save pointer of first node in temp
					nodeX.next = nodeY.next; // Change pointer of first Node to Pointer of second node
					nodeY.next = temp; // Change pointer of second node to temp

				}
			} else
				System.out.println("List head is null");

		} else
			System.out.println("List is null");
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(10);
		list.append(15);
		list.append(12);
		list.append(13);
		list.append(20);
		list.append(14);
		print(list);
		swap(list, 15, 20);
		System.out.println("Post swapping");
		print(list);
	}

	public static void print(LinkedList list) {
		Node head = list.head;
		while (head != null) {
			System.out.print(head.data + ",");
			head = head.next;
		}
		System.out.println();
	}
}
