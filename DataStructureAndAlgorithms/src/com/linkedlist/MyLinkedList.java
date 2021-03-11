package com.linkedlist;

import java.util.logging.Logger;

public class MyLinkedList<X> {
	private Node first;
	private Node last;
	private int nodeCount;
	static Logger log = Logger.getLogger("MylinkedList");
	public MyLinkedList() {
		first = null;
		last = null;
		nodeCount = 0;
	}
	
	

	public void insert(X item) {
		if (first == null) {
			first = new Node(item);
			last = first;
		} else {
			Node newLastNode = new Node(item);
			last.next = newLastNode;
			last=last.next;
		}
		nodeCount++;
	}

	public X delete() {

		if (first == null) {
			throw new IllegalStateException("The linked list is empty and there is no element to remove");

		}

		X deletedItem = first.item;

		first = first.next;
		nodeCount--;
		return deletedItem;
	}

	public void insertAt(X item, int position) throws NullPointerException{
		
		if (size() < position || position<0) {
			log.info("This element can not be added to the list because the position provided is invalid  ");
			return;
		}
		
		
		Node currentNode = first;
		if(position==0) {
			Node newnode=new Node(item);
			newnode.next=currentNode;
			first=newnode;
		}
		
		else {
		for (int i = 1; i < position && currentNode.next != null; i++) {
			currentNode = currentNode.next;
		}
	
		Node newNode = new Node(item);
		newNode.next = currentNode.next;
		currentNode.next=newNode;
		
		}
		nodeCount++;
	}

	public X deleteAt(int position) {
		if (first == null) {
			throw new IllegalStateException("The List is empty");
		}
		if(position>=0 && position<size()) {
		if(position==0) {
			return delete();
		}
		else {
		Node currentNode = first;
		Node previousNode = first;
		for (int i = 0; i < position && currentNode.next != null; i++) {
			previousNode = currentNode;
			currentNode = currentNode.next;
		}
		X nodeItem = currentNode.item;
		previousNode.next=currentNode.next;
		nodeCount--;
		return nodeItem;
		}
		
		}
		else {
			log.info("The provided position is invalid ");
			
		}
		return null;
		
	}

	public X getcenterNode() {
		int position=size()/2;
		if (first == null) {
			throw new IllegalStateException("The Linked list is empty ");
		}
		Node currentNode = first;
		for (int i = 0; i < size() && currentNode != null; i++) {
			if (i == position) {
				return currentNode.item;
			}

			currentNode = currentNode.next;
		}
	
		return null;
	}
	
	public void reverse() {
		Node curnode=first;
		Node prenode=null;
		Node nxnode=null;
		while(curnode !=null) {
			nxnode=curnode.next;
			curnode.next=prenode;
			prenode=curnode;
			curnode=nxnode;
		}
		first=prenode;
	}

	
	public String toString() {
		StringBuilder contents=new StringBuilder();
		Node currentNode=first;
		while(currentNode!=null) {
			contents.append(currentNode.item);
			currentNode=currentNode.next;
			
			if(currentNode!=null) {
				contents.append(", ");
			}
		}
		return contents.toString();
	}

	public int size() {
		return nodeCount;
	}
	
	
	
	
	
//inner class which will provide the node..
	private class Node {
		private  X item;
		private Node next;

		public Node(X userData) {
			this.next = null;
			this.item = userData;
		}

	}

	
		
	

}
