package com.mainpack;

import com.hashtableimplementation.MyHashTable;

public class HashTableDriver {

	public static void main(String[] args) {
		MyHashTable<String, String> map = new MyHashTable<>();
		map.insert("Monday", "somwar");
		map.insert("Tuesday", "mangal");
		map.insert("Tuesdby", "mangbl");
		map.insert("Tuesdcy", "mangcl");

		map.insert("wednessday", "budh");
		map.insert("Thursday", "guru");
		map.insert("Friday", "shukr");
		System.out.println(map.size());
		System.out.println(map.getValueByKey("Thursday"));
		// map.delete("Thursday");
		System.out.println(map.size());
		System.out.println(map.getValueByKey("Thursday"));

		map.insert("Saturday", "shani");
		map.insert("Sunday", "ravi");
		System.out.println(map.size());

		System.out.println("does the list contain :" + map.contains(""));
		map.display();

	}

}
