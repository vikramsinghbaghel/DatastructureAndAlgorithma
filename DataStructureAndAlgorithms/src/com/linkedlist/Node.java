package com.linkedlist;

public class Node<X> {
	private X item;
	private Node<X> next;

	public X getItem() {
		return item;
	}

	public void setItem(X item) {
		this.item = item;
	}

	public Node<X> getNext() {
		return next;
	}

	public void setNext(Node<X> next) {
		this.next = next;
	}

	public Node(X userData) {
		this.next = null;
		this.item = userData;
	}

}
