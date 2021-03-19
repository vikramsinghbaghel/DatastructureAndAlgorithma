package com.linkedlistimplementationofqueue;

import com.linkedlist.Node;

public class MyQueue<X> {
	Node<X> head = null;
	private Node<X> tail = null;
	int nodeCount = 0;

	public void enqueue(X data) {
		Node<X> newNode = new Node<>(data);

		if (head == null) {
			head = newNode;
			setTail(head);
		} else {
			getTail().setNext(newNode);
			setTail(newNode);
		}
		nodeCount++;
	}

	public X dequeue() {
		Node<X> temp;
		if (head == null) {
			System.out.println("The list is already empty dequeue can not be performend");
			return null;
		} else {
			temp = head;
			head = head.getNext();
		}
		nodeCount--;
		return temp.getItem();
	}

	public X peek() {
		return head.getItem();
	}

	public void display() {
		if (head == null) {
			System.out.println("The Queue is empty");

		} else {
			Node<X> temp = head;
			while (temp.getNext() != null) {
				System.out.print(temp.getItem() + ", ");
				temp = temp.getNext();
			}
			System.out.println(temp.getItem() + "");
		}
	}

	public boolean contains(X value) {
		Node<X> temp = head;
		while (temp.getItem() != value && temp.getNext() != null) {
			temp = temp.getNext();
		}
		return temp.getItem() == value;
	}

	public int size() {
		return nodeCount;
	}

	public void reverse() {
		Node<X> curnode = head;
		Node<X> prenode = null;
		Node<X> nxnode = null;
		while (curnode != null) {
			nxnode = curnode.getNext();
			curnode.setNext(prenode);
			prenode = curnode;
			curnode = nxnode;
		}
		head = prenode;
	}

	public Node<X> getTail() {
		return tail;
	}

	public void setTail(Node<X> tail) {
		this.tail = tail;
	}

}
