package com.mainpack;

import com.linkedlistimplementationofqueue.PriorityQueue;

public class PriorityQueueDriver {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PriorityQueue<String> mypqueue = new PriorityQueue<>();

		// add elements to the list
		mypqueue.insert("Rabbit", 1);
		mypqueue.insert("Dog", 3);
		mypqueue.insert("puppy", 2);
		mypqueue.insert("Turtle", 0);
		mypqueue.insert("cat", 2);
		mypqueue.insert("Goldfish", 5);
		mypqueue.insert("mouse", 7);
		mypqueue.insert("kitten", 9);
		mypqueue.insert("Hamster", 6);
		mypqueue.insert("tropical fish", 3);
		mypqueue.insert("Lion");

		mypqueue.delete();
		mypqueue.display();
		System.out.println();
		System.out.println(mypqueue.peek());
		System.out.print(mypqueue.contains("mouse"));
		mypqueue.reverse();

		System.out.println();
		mypqueue.display();
		System.out.println(mypqueue.size());

	}

}
