package com.hashtableimplementation;

import java.util.ArrayList;

public class MyHashTable<K, V> {
	// bucketArray is used to store array of chains
	private ArrayList<HashNode<K, V>> baseArray;

	// Current capacity of array list
	private int capacity;

	// Current size of array list
	private int size;

	// Constructor (Initializes capacity, size and empty chains.
	public MyHashTable() {
		baseArray = new ArrayList<>();
		capacity = 5;
		size = 0;

		// Create empty chains
		for (int i = 0; i < capacity; i++)
			baseArray.add(null);
	}

	public int size() {
		return size;
	}

	// This implements hash function to find index
	// for a key
	private int getArrayIndex(K key) {
		int hashCode = key.hashCode();
		int index = hashCode % capacity;

		// key.hashCode() could be negative.
		index = index < 0 ? index * -1 : index;

		return index;
	}

	// Method to remove a given key
	public V delete(K key) {
		// Apply hash function to find index for given key
		int baseIndex = getArrayIndex(key);

		// Get head of chain
		HashNode<K, V> head = baseArray.get(baseIndex);

		// Search for key in its chain

		HashNode<K, V> prev = null;

		while (head != null) {
			// If Key found
			if (head.key.equals(key))
				break;

			// Else keep moving in chain
			prev = head;
			head = head.next;
		}

		// If key was not there
		if (head == null)
			return null;

		// Reduce size
		size--;

		// Remove key
		if (prev != null)
			prev.next = head.next;
		else
			baseArray.set(baseIndex, head.next);

		return head.value;
	}

	// Returns value for a key
	public V getValueByKey(K key) {
		// Find head of chain for given key
		int arrayIndex = getArrayIndex(key);
		HashNode<K, V> head = baseArray.get(arrayIndex);

		// Search key in chain
		while (head != null) {
			if (head.key.equals(key)) {
				return head.value;
			}
			head = head.next;
		}

		// If key not found
		return null;
	}

	// Adds a key value pair to hash
	public void insert(K key, V value) {
		// Find head of chain for given key
		int arrayIndex = getArrayIndex(key);
		HashNode<K, V> head = baseArray.get(arrayIndex);

		// Check if key is already present
		while (head != null) {
			if (head.key.equals(key)) {
				head.value = value;
				return;
			}
			head = head.next;
		}

		// Insert key in chain
		size++;
		head = baseArray.get(arrayIndex);
		HashNode<K, V> newNode = new HashNode<>(key, value);
		newNode.next = head;
		baseArray.set(arrayIndex, newNode);

		// If load factor goes beyond threshold, then
		// double hash table size

		if ((1.0 * size) / capacity >= 0.7) {
			ArrayList<HashNode<K, V>> temp = baseArray;
			baseArray = new ArrayList<>();
			capacity = 2 * capacity;
			size = 0;
			for (int i = 0; i < capacity; i++)
				baseArray.add(null);

			for (HashNode<K, V> headNode : temp) {
				while (headNode != null) {
					insert(headNode.key, headNode.value);
					headNode = headNode.next;
				}
			}
		}
	}

	public void display() {

		ArrayList<HashNode<K, V>> temp = baseArray;

		for (HashNode<K, V> headNode : temp) {
			if (headNode != null) {
				System.out.println();
			}
			while (headNode != null) {
				System.out.print(headNode.key + "---->" + headNode.value + ", ");
				headNode = headNode.next;
			}

		}

	}

	public boolean contains(K key) {

		ArrayList<HashNode<K, V>> temp = baseArray;

		for (HashNode<K, V> headNode : temp) {
			while (headNode != null) {
				if (headNode.key.equals(key)) {
					return true;
				}
				headNode = headNode.next;
			}

		}
		return false;

	}

}