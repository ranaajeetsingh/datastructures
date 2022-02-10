package linkedlist;

public class LinkedList {
	Node head;// head of list

	/*
	 * Linked list Node. This inner class is made static so that main() can access
	 * it
	 */
	static class Node {
		int data;
		Node next;

		public Node(int data) {
			super();
			this.data = data;
		}

	}

	public static void main(String[] args) {
		LinkedList list = new LinkedList();
		list.head = new Node(1);
		Node second = new Node(2);
		Node third = new Node(3);
		/*
		 * Three nodes have been allocated dynamically. We have references to these
		 * three blocks as head, second and third
		 * 
		 * Now link the Nodes so that all three nodes are linked.
		 */
		list.head.next = second;
		second.next = third;

		printList(list);

		//Adding node at start
		list.push(4);

		System.out.println("After adding a node at start");
		printList(list);

		// adding node at end
		list.append(5);

		System.out.println("After adding a node at end");
		printList(list);

		// adding node after node
		list.insertAfter(second, 6);

		System.out.println("After adding a after specified node");
		printList(list);

		// removing node by data
		list.remove(5);
		
		System.out.println("After delete element with data");
		printList(list);
		
		//removing node by position
		list.delete(3);
		System.out.println("After deleting element form position");
		printList(list);
	}

	// Printing linked list, initial parameters self node hashcode to verify linking
	// between previous and next node
	private static void printList(LinkedList list) {
		Node n = list.head;
		do {
			System.out.println(n.hashCode() + "," + n.data + "," + (n.next != null ? n.next.hashCode() : "null"));
			n = n.next;
		} while (n != null);

	}

	// Add node at start of the list
	private void push(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	// Add node at end of the list
	private void append(int data) {
		Node n = new Node(data);
		if (head == null)
			head = n;
		else {
			Node temp = head;
			while (temp.next != null) {
				temp = temp.next;
			}
			temp.next = n;
		}
	}

	// Add node after a node of the list
	private void insertAfter(Node prevNode, int data) {
		Node n = new Node(data);
		n.next = prevNode.next;
		prevNode.next = n;
	}

	/*
	 * Iterative Method: To delete a node from the linked list, we need to do the
	 * following steps. 1) Find the previous node of the node to be deleted. 2)
	 * Change the next of the previous node. 3) Free memory for the node to be
	 * deleted.
	 */
	private void remove(int data) {
		Node prevNode = head;
		Node targetNode = null;

		if (null == prevNode)
			return;
		if (prevNode.data == data) {
			prevNode = null;
			return;
		}
		while (prevNode != null) {
			if (prevNode.next != null && prevNode.next.data == data) {
				targetNode = prevNode.next;
				prevNode.next = targetNode.next;
				targetNode = null;
				break;
			} else {
				//System.out.println("Searching For: " + data + " But not found moving ahead");
				prevNode = prevNode.next;
			}
		}
	}

	// delete a linked list node at the given position.
	// Input: position = 1, Linked List = 8->2->3->1->7
	// Output: Linked List = 8->3->1->7
	//
	// Input: position = 0, Linked List = 8->2->3->1->7
	// Output: Linked List = 2->3->1->7
	private void delete(int position) {
		Node prevNode = head;
		Node targetNode = null;
		if (null == prevNode)
			return;
		int i = 0;
		while (prevNode != null) {
			if (i == 0 && i == position) {
				head = head.next;
				break;
			} else if (i == position - 1) {
				targetNode = prevNode.next;
				prevNode.next = targetNode.next;
				targetNode = null;
				break;
			} else {
				prevNode = prevNode.next;
			}
			i++;
		}
	}
}
