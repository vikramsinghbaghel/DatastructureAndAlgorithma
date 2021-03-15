package com.linkedListImplementationOfQueue;

public class PriorityQueue<X> {
	Node<X> head = null;
	private int qlength = 0;

	// inner class;
	private class Node<X> {
		private X data;
		private Node next;
		private int priority;

		public Node(X userdata, int priority) {
			this.data = userdata;
			this.priority = priority;
			this.next = null;
		}
	}

	public void insert(X userdata, int p) {
		if (p >= 0) {
			Node start = head;

			Node newnode = new Node(userdata, p);
			if (head == null) {
				head = newnode;
			}

			else if (head.priority < p) {
				newnode.next = head;
				head = newnode;
			} else {
				while (start.next != null && start.next.priority >= p) {
					start = start.next;
				}
				newnode.next = start.next;
				start.next = newnode;
			}
			qlength++;
		} else {
			System.out.println("Priority can not be negative  ");
		}

	}

	public X delete() {
		if (head == null) {
			System.out.println("Yhe list is already empty: ");
			return null;
		} else {
			X result = head.data;
			head = head.next;
			qlength--;
			return result;
		}
	}

	public X peek() {
		return head.data;
	}

	public boolean contains(X value) {
		Node temp = head;
		while (temp.data != value && temp.next != null) {
			temp = temp.next;
		}
		return temp.data == value;
	}

	public void reverse() {
		Node<X> curnode = head;
		Node<X> prenode = null;
		Node<X> nxnode = null;
		while (curnode != null) {
			nxnode = curnode.next;
			curnode.next = prenode;
			prenode = curnode;
			curnode = nxnode;
		}
		head = prenode;
	}

	public int size() {
		return qlength;
	}

	public void display() {
		Node temp = head;

		while (temp != null) {
			System.out.print(temp.data + ", " + temp.priority + "------");
			temp = temp.next;
		}
	}

}
