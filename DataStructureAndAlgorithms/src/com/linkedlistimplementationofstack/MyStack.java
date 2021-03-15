package com.linkedlistimplementationofstack;

import java.util.logging.Logger;

import com.linkedlist.Commonmethods;
import com.linkedlist.Node;

public class MyStack<X> extends Commonmethods<X> {
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
		newnode.next = top;
		top = newnode;
		count++;

	}

	public X pop() {
		if (top == null) {
			log.info("Stack underflow ");
			return null;
		} else {
			X value = top.item;
			top = top.next;
			count--;
			return value;
		}

	}

	public boolean isEmpty() {

		return top == null;
	}

	public X peek() {
		if (!isEmpty()) {
			return top.item;
		} else {
			log.info("Stack is empty : ");
			return null;
		}
	}

	public void reverse() {
		top = super.reverse(top);
	}

	public boolean contains(X value) {
		return super.contains(value, top);
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
			while (temp.next != null) {

				System.out.print(temp.item + ", ");
				temp = temp.next;
			}

			System.out.println(temp.item);
		}
	}

}
