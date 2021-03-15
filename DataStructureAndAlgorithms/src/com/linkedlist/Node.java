package com.linkedlist;

public class Node<X> {
	public X item;
	public Node<X> next;

	public Node(X userData) {
		this.next = null;
		this.item = userData;
	}

}
