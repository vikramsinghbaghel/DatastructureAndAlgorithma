package com.mainpack;

import java.util.logging.Level;
import java.util.logging.Logger;

import com.linkedlistimplementationofstack.MyStack;

public class StackDriver {
	static Logger logr = Logger.getLogger("StackDriver");

	public static void main(String[] args) {

		MyStack<Integer> stack = new MyStack<>();
		// insert Stack value
		stack.push(11);
		stack.push(22);
		stack.push(33);
		stack.push(44);
		stack.push(55);
		stack.push(66);
		stack.push(77);
		stack.push(88);
		stack.push(99);
		stack.push(00);

		logr.info("The stack is : ");
		stack.display();

		int size = stack.size();
		logr.log(Level.INFO, "size of the stack is :" + size);

		logr.log(Level.INFO, "Top element is " + stack.peek());

		boolean result = stack.contains(55);
		logr.log(Level.INFO, "contains or not : " + result);
		stack.pop();

		stack.display();

		logr.log(Level.INFO, "Top element is " + stack.peek());
		stack.reverse();
		stack.display();
		stack.pop();
		stack.display();
		logr.log(Level.INFO, "Top element is " + stack.peek());

	}

}
