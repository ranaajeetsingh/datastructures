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
//		Node newStart = new Node(4);
//		addNodeAtStart(newStart, list);
		
		list.push(4);
		
		System.out.println("After adding a node at start");
		printList(list);
		
//		Node newEnd = new Node(5);
//		addNodeAtEnd(newEnd, list);
		list.append(5);
		
		System.out.println("After adding a node at end");
		printList(list);
		
//		Node newRandom = new Node(6);
//		addNodeAtRandomPosition(newRandom,third, list);
		
		list.insertAfter(second, 6);
		
		System.out.println("After adding a after specified node");
		printList(list);
	}

	// Printing linked list, initial parameters self node hashcode to verify linking
	// between previous and next node
	private static void printList(LinkedList list) {
		// [1,hash],[hash,2,hash],[hash,3,null]
//		Node n = head;
//        while (n != null) {
//            System.out.print(n.data + " ");
//            n = n.next;
//        }

		Node n = list.head;

		do {
			System.out.println(n.hashCode() + "," + n.data + "," + (n.next != null ? n.next.hashCode() : "null"));
			n = n.next;
		} while (n != null);

//		StringBuilder str = new StringBuilder("[").append(list.head.data).append(",").append(list.head.next.hashCode())
//				.append("],");
//		str.append(("[")).append(list.head.next.hashCode()).append(",").append(list.head.next.data).append(",")
//				.append(list.head.next.next.hashCode()).append("],");
//		str.append(("[")).append(list.head.next.next.hashCode()).append(",").append(list.head.next.next.data)
//				.append(",").append(list.head.next.next.next).append("],");
//		System.out.println(str.toString());
	}

	// Add node at start of the list
	private static void addNodeAtStart(Node node, LinkedList list) {
		Node temp = list.head;
		node.next = temp;
		list.head = node;
	}
	
	private void push(int data) {
		Node n = new Node(data);
		n.next = head;
		head = n;
	}

	// Add node at end of the list
	private static void addNodeAtEnd(Node node, LinkedList list) {
		Node temp = list.head;
		while (temp.next != null) {
			temp = temp.next;
		}
		temp.next = node;
	}
	
	private void append(int data) {
		Node n = new Node(data);
		if( head == null)
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
	private static void addNodeAtRandomPosition(Node targetNode, Node node, LinkedList list) {
		Node n = list.head;
		while (n != node) {
			n = n.next;
		}
		targetNode.next = n.next;
		node.next = targetNode;
	}
	
	private void insertAfter(Node prevNode, int data) {
		Node n = new Node(data);
		n.next = prevNode.next;
		prevNode.next = n;
	}
}
