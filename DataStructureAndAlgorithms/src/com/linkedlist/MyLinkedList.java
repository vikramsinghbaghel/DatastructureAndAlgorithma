package com.linkedlist;

import java.util.logging.Logger;

public class MyLinkedList<X> {

	private Node<X> first;
	private Node<X> last;
	private int nodeCount;

	public Node<X> getFirst() {
		return first;
	}

	public void setFirst(Node<X> first) {
		this.first = first;
	}

	static Logger log = Logger.getLogger("MylinkedList");

	public MyLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}

	public void insert(X item) {
		if (first == null) {
			first = new Node<>(item);
			last = first;
		} else {
			Node<X> newLastNode = new Node<>(item);
			last.setNext(newLastNode);
			last = last.getNext();
		}
		nodeCount++;
	}

	public X delete() {

		if (first == null) {
			throw new IllegalStateException("The linked list is empty and there is no element to remove");

		}

		X deletedItem = first.getItem();

		first = first.getNext();
		nodeCount--;
		return deletedItem;
	}

	public void insertAt(X item, int position) {

		if (size() < position || position < 0) {
			log.info("This element can not be added to the list because the position provided is invalid  ");
			return;
		}

		Node<X> currentNode = first;
		if (position == 0) {
			Node<X> newnode = new Node<>(item);
			newnode.setNext(currentNode);
			first = newnode;
		}

		else {
			for (int i = 1; i < position && currentNode.getNext() != null; i++) {
				currentNode = currentNode.getNext();
			}

			Node<X> newNode = new Node<>(item);
			newNode.setNext(currentNode.getNext());
			currentNode.setNext(newNode);

		}
		nodeCount++;
	}

	public X deleteAt(int position) {
		if (first == null) {
			throw new IllegalStateException("The List is empty");
		}
		if (position >= 0 && position < size()) {
			if (position == 0) {
				return delete();
			} else {
				Node<X> currentNode = first;
				Node<X> previousNode = first;
				for (int i = 0; i < position && currentNode.getNext() != null; i++) {
					previousNode = currentNode;
					currentNode = currentNode.getNext();
				}
				X nodeItem = currentNode.getItem();
				previousNode.setNext(currentNode.getNext());
				nodeCount--;
				return nodeItem;
			}

		} else {
			log.info("The provided position is invalid ");

		}
		return null;

	}

	public void reverse() {
		Node<X> curnode = first;
		Node<X> prenode = null;
		Node<X> nxnode = null;
		while (curnode != null) {
			nxnode = curnode.getNext();
			curnode.setNext(prenode);
			prenode = curnode;
			curnode = nxnode;
		}
		first = prenode;
	}

	public X getCenterNode() {
		int position = size() / 2;
		if (first == null) {
			throw new IllegalStateException("The Linked list is empty ");
		}
		Node<X> currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (i == position) {
				return currentNode.getItem();
			}

			currentNode = currentNode.getNext();
		}

		return null;
	}

	public String toString() {
		StringBuilder contents = new StringBuilder();
		Node<X> currentNode = first;
		while (currentNode != null) {
			contents.append(currentNode.getItem());
			currentNode = currentNode.getNext();

			if (currentNode != null) {
				contents.append(", ");
			}
		}
		return contents.toString();
	}

	public int size() {
		return nodeCount;
	}

}
