package com.linkedListImplementationOfQueue;

import com.linkedlist.Commonmethods;
import com.linkedlist.Node;

public class MyQueue<X> extends Commonmethods<X> {
	Node<X> head = null;
	public Node<X> tail = null;
	int nodecount = 0;

	public void enqueue(X data) {
		Node<X> newNode = new Node<>(data);

		if (head == null) {
			head = newNode;
			tail = head;
		} else {
			tail.next = newNode;
			tail = newNode;
		}
		nodecount++;
	}

	public X dequeue() {
		Node<X> temp;
		if (head == null) {
			System.out.println("The list is already empty dequeue can not be performend");
			return null;
		} else {
			temp = head;
			head = head.next;
		}
		nodecount--;
		return temp.item;
	}

	public X peek() {
		return head.item;
	}

	public void display() {
		if (head == null) {
			System.out.println("The Queue is empty");

		} else {
			Node<X> temp = head;
			while (temp.next != null) {
				System.out.print(temp.item + ", ");
				temp = temp.next;
			}
			System.out.println(temp.item + "");
		}
	}

	public boolean contains(X value) {
		return super.contains(value, head);
	}

	public int size() {
		return nodecount;
	}

	public void reverse() {
		tail = head;
		head = super.reverse(head);
	}

}
