package com.linkedlistimplementationofqueue;

public class PriorityQueue<X> {
	PriorityQNode<X> head = null;
	private int qlength = 0;

	// inner class;
	public void insert(X username) {
		this.insert(username, 0);
	}

	public void insert(X userdata, int priority) {
		if (priority >= 0) {
			PriorityQNode<X> start = head;

			PriorityQNode<X> newnode = new PriorityQNode<>(userdata, priority);
			if (head == null) {
				head = newnode;
			}

			else if (head.getPriority() < priority) {
				newnode.setNext(head);
				head = newnode;
			} else {
				while (start.getNext() != null && start.getNext().getPriority() >= priority) {
					start = start.getNext();
				}
				newnode.setNext(start.getNext());
				start.setNext(newnode);
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
			X result = head.getData();
			head = head.getNext();
			qlength--;
			return result;
		}
	}

	public X peek() {
		return head.getData();
	}

	public boolean contains(X value) {
		PriorityQNode<X> temp = head;
		while (temp.getData() != value && temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp.getData() == value;
	}

	public void reverse() {
		PriorityQNode<X> curnode = head;
		PriorityQNode<X> prenode = null;
		PriorityQNode<X> nxnode = null;
		while (curnode != null) {
			nxnode = curnode.getNext();
			curnode.setNext(prenode);
			prenode = curnode;
			curnode = nxnode;
		}
		head = prenode;
	}

	public int size() {
		return qlength;
	}

	public void display() {
		PriorityQNode<X> temp = head;

		while (temp != null) {
			System.out.print(temp.getData() + ", " + temp.getPriority() + "------");
			temp = temp.getNext();
		}
	}

}
