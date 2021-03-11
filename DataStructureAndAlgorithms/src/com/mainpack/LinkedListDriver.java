package com.mainpack;

import java.util.logging.Logger;

import com.linkedlist.MyLinkedList;

public class LinkedListDriver {
	public static final Logger log = Logger.getLogger("LinkedListDriver");

	public static void main(String[] args) {
		MyLinkedList<String> mylist = new MyLinkedList<>();
		String list;
		// add elements to the list...
		mylist.insert("Rabbit");
		mylist.insert("Dog");
		mylist.insert("puppy");
		mylist.insert("Turtle");
		mylist.insert("cat");
		mylist.insert("Goldfish");
		mylist.insert("mouse");
		mylist.insert("kitten");
		mylist.insert("Hamster");
		mylist.insert("tropical fish");

		list = mylist.toString();
		log.info(list);
		// add element to specific position..

		mylist.insertAt("cow", 0);
		mylist.insertAt("sheep", 1);
		mylist.insertAt("deer", 5);
		mylist.insertAt("goat", mylist.size() - 1);
		list = mylist.toString();
		log.info(list);

		// invalid inputs.
		mylist.insertAt("horse", 20);
		mylist.insertAt("horse", -2);
		// mylist.insertAt(1, 2);
		list = mylist.toString();
		log.info(list);

		mylist.insertAt("bee", mylist.size());
		list = mylist.toString();
		log.info(list);

		// delete and removeAt...

		mylist.delete();
		mylist.deleteAt(5);
		mylist.deleteAt(mylist.size() - 1);
		list = mylist.toString();
		log.info(list);

		// invalid input
		mylist.deleteAt(mylist.size());
		mylist.deleteAt(20);
		mylist.deleteAt(-20);
		list = mylist.toString();
		log.info(list);

		String value = mylist.getcenterNode();
		log.info("the center node is :");
		log.info(value);

		mylist.reverse();
		list = mylist.toString();
		log.info(list);

	}

}
