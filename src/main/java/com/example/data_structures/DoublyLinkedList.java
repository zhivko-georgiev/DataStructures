package com.example.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class DoublyLinkedList<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	private int count;

	private class ListNode<T> {
		private T value;
		private ListNode<T> nextNode;
		private ListNode<T> prevNode;

		private ListNode(T value) {
			super();
			this.value = value;
		}
	}

	public void аddFirst(T element) {
		if (this.count == 0) {
			this.head = this.tail = new ListNode<T>(element);
		} else {
			ListNode<T> newHead = new ListNode<T>(element);
			newHead.nextNode = this.head;
			this.head.prevNode = newHead;
			this.head = newHead;
		}

		this.count++;
	}

	public void аddLast(T element) {
		if (this.count == 0) {
			this.head = this.tail = new ListNode<T>(element);
		} else {
			ListNode<T> newTail = new ListNode<T>(element);
			newTail.prevNode = this.tail;
			this.tail.nextNode = newTail;
			this.tail = newTail;
		}

		this.count++;
	}

	public T removeFirst() {
		if (this.count == 0) {
			throw new IllegalStateException("Empty List");
		}

		T firstElement = this.head.value;
		this.head = this.head.nextNode;

		if (this.head != null) {
			this.head.prevNode = null;
		} else {
			this.tail = null;
		}

		this.count--;

		return firstElement;
	}

	public T removeLast() {
		if (this.count == 0) {
			throw new IllegalStateException("Empty List");
		}

		T lastElement = this.tail.value;
		this.tail = this.tail.prevNode;

		if (this.tail != null) {
			this.tail.nextNode = null;
		} else {
			this.head = null;
		}

		this.count--;

		return lastElement;
	}

	public int size() {
		return this.count;
	}

	
	public void forEach(Consumer<T> consumer) {
		ListNode<T> currentNode = this.head;
		while (currentNode != null) {
			consumer.accept(currentNode.value);
			currentNode = currentNode.nextNode;
		}

	}

	public Object[] toArray() {
		List<T> list = new ArrayList<>(this.count);

		ListNode<T> currentNode = this.head;

		while (currentNode != null) {
			list.add(currentNode.value);
			currentNode = currentNode.nextNode;
		}

		return list.toArray();
	}
}
