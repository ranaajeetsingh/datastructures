package linkedlist;

import linkedlist.LinkedList.Node;

public class SwapNodes {

	//TODO Re write the code
	public static void swap(LinkedList list, int a, int b) {
		if (list != null) {
			Node head = list.head;
			if (head != null) {
				Node first = null;
				Node second = null;
				while (head != null) {
					if (head.data == a)
						first = head;
					if (head.data == b)
						second = head;
					if (first != null && second != null)
						break;
					head = head.next;
				}
				if (first != null && second != null) {
					Node temp = first.next;
					first.next = second.next;
					second.next = temp;
				} else {
					System.out.println("One of the key is not present in list");
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
		swap(list, 12, 20);
		System.out.println("Post swapping");
		print(list);
	}
	
	public static void print(LinkedList list) {
		Node head = list.head;
		while(head != null) {
			System.out.print(head.data + ",");
			head = head.next;
		}
	}
}
