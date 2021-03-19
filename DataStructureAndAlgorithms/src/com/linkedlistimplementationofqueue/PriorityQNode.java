package com.linkedlistimplementationofqueue;

public class PriorityQNode<X> {
	public X getData() {
		return data;
	}

	public void setData(X data) {
		this.data = data;
	}

	public PriorityQNode<X> getNext() {
		return next;
	}

	public void setNext(PriorityQNode<X> next) {
		this.next = next;
	}

	public int getPriority() {
		return priority;
	}

	public void setPriority(int priority) {
		this.priority = priority;
	}

	private X data;
	private PriorityQNode<X> next;
	private int priority;

	public PriorityQNode(X userdata, int priority) {
		this.data = userdata;
		this.priority = priority;
		this.next = null;
	}
}
