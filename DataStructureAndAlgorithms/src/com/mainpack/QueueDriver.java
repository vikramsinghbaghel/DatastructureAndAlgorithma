package com.mainpack;

import com.linkedlistimplementationofqueue.MyQueue;

public class QueueDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyQueue<String> queue = new MyQueue<>();
		queue.enqueue("one");
		queue.enqueue("two");
		queue.enqueue("three");
		queue.enqueue("four");
		queue.enqueue("five");

		queue.enqueue("six");
		queue.enqueue("seven");
		queue.enqueue("eight");
		queue.enqueue("nine");

		queue.enqueue("ten");
		queue.display();
		queue.dequeue();
		queue.display();
		System.out.println(queue.getTail().getItem());
		System.out.println(queue.peek());
		System.out.println("Queue Contains or not : " + queue.contains("nine"));
		System.out.println("Queue size : " + queue.size());
		queue.reverse();
		queue.display();
		queue.enqueue("eleven");
		queue.dequeue();
		queue.display();
		System.out.println(queue.getTail().getItem());
		System.out.println(queue.peek());

	}

}
