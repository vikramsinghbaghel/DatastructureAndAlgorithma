package com.linkedlist;

import com.linkedlistimplementationofstack.*;

public class Commonmethods<X> {
	public Node<X> reverse(Node<X> first) {
		Node<X> curnode = first;
		Node<X> prenode = null;
		Node<X> nxnode = null;
		while (curnode != null) {
			nxnode = curnode.next;
			curnode.next = prenode;
			prenode = curnode;
			curnode = nxnode;
		}
		return prenode;
	}

	public boolean contains(X value, Node<X> top) {
		Node<X> temp = top;
		while (temp.item != value && temp.next != null) {
			temp = temp.next;
		}
		return temp.item == value;
	}

}
