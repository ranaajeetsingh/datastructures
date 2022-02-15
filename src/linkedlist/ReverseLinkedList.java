package linkedlist;

import linkedlist.LinkedList.Node;

public class ReverseLinkedList {

//	Input: Head of following linked list 
//	1->2->3->4->NULL 
//	Output: Linked list should be changed to, 
//	4->3->2->1->NULL
	public static void reverse(LinkedList list) {
		Node prev = null;
		Node curr = list.head;
		Node next = null;
		while (curr != null) {
			next = curr.next;
			curr.next = prev;
			prev = curr;
			curr = next;
		}
		list.head = prev;
	}

	// recursion
	static Node reverse(Node head) {
		if (head == null || head.next == null)
			return head;

		/*
		 * reverse the rest list and put the first element at the end
		 */
		Node rest = reverse(head.next);
		head.next.next = head;
		System.out.println(head.data);

		/* tricky step -- see the diagram */
		head.next = null;

		/* fix the head pointer */
		return rest;
	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		list.append(2);
		list.append(3);
		list.append(4);
		list.append(5);
		list.append(6);
		SwapNodes.print(list);
		list.head = reverse(list.head);
		System.out.println("Post reversal");
		SwapNodes.print(list);
	}
}
