package com.linkedlistimplementationofstack;

import java.util.logging.Logger;

import com.linkedlist.Node;

public class MyStack<X> {
	static Logger log = Logger.getLogger("MyStack");
	private Node<X> top;

	public Node<X> getTop() {
		return top;
	}

	public void setTop(Node<X> top) {
		this.top = top;
	}

	int count = 0;

	public MyStack() {
		this.top = null;
	}

	public void push(X data) {

		Node<X> newnode = new Node<>(data);
		newnode.setNext(top);
		top = newnode;
		count++;

	}

	public X pop() {
		if (top == null) {
			log.info("Stack underflow ");
			return null;
		} else {
			X value = top.getItem();
			top = top.getNext();
			count--;
			return value;
		}

	}

	public boolean isEmpty() {

		return top == null;
	}

	public X peek() {
		if (!isEmpty()) {
			return top.getItem();
		} else {
			log.info("Stack is empty : ");
			return null;
		}
	}

	public void reverse() {
		Node<X> curnode = top;
		Node<X> prenode = null;
		Node<X> nxnode = null;
		while (curnode != null) {
			nxnode = curnode.getNext();
			curnode.setNext(prenode);
			prenode = curnode;
			curnode = nxnode;
		}
		top = prenode;
	}

	public boolean contains(X value) {
		Node<X> temp = top;
		while (temp.getItem() != value && temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp.getItem() == value;
	}

	public int size() {
		return count;
	}

	public void display() {
		// check for stack underflow
		if (top == null) {
			System.out.printf("\nStack Underflow : the stack does not contain any element");
			return;
		} else {
			Node<X> temp = top;
			while (temp.getNext() != null) {

				System.out.print(temp.getItem() + ", ");
				temp = temp.getNext();
			}

			System.out.println(temp.getItem());
		}
	}

}
