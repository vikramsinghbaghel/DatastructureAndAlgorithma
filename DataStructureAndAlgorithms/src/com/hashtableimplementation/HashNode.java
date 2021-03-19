package com.hashtableimplementation;

class HashNode<K, V> {
	K key;
	V value;

	HashNode<K, V> next;

	// Constructor
	public HashNode(K key, V value) {
		this.key = key;
		this.value = value;
	}
}