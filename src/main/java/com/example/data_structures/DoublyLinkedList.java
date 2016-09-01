package com.example.data_structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class DoublyLinkedList<T> implements Iterable<T> {
	private ListNode<T> head;
	private ListNode<T> tail;
	private int count;

	private class ListNode<T> {
		private final T value;
		private ListNode<T> nextNode;
		private ListNode<T> prevNode;

		private ListNode(final T value) {
			super();
			this.value = value;
		}
	}

	public void аddFirst(final T element) {
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

	public void аddLast(final T element) {
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

		final T firstElement = this.head.value;
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

		final T lastElement = this.tail.value;
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

	public void forEachNode(Consumer<T> consumer) {
		ListNode<T> currentNode = this.head;
		while (currentNode != null) {
			consumer.accept(currentNode.value);
			currentNode = currentNode.nextNode;
		}

	}

	public Object[] toArray() {
		final List<T> list = new ArrayList<>(this.count);

		ListNode<T> currentNode = this.head;

		while (currentNode != null) {
			list.add(currentNode.value);
			currentNode = currentNode.nextNode;
		}

		return list.toArray();
	}

	@Override
	public Iterator<T> iterator() {
		final DoublyLinkedList<T> list = this;

		return new Iterator<T>() {
			final ListNode<T> firstNode = list.head;
			ListNode<T> currentNode = null;

			@Override
			public boolean hasNext() {
				if (list.count == 0) {
					return false;
				} else if (currentNode == null) {
					return true;
				} else if (currentNode == list.tail) {
					return false;
				}
				return true;
			}

			@Override
			public T next() {
				if (list.count == 0) {
					throw new NoSuchElementException();
				} else if (currentNode == null) {
					this.currentNode = firstNode;
					return currentNode.value;
				} else if (currentNode.nextNode == null) {
					throw new NoSuchElementException();
				}
				this.currentNode = currentNode.nextNode;
				return currentNode.value;
			}
		};
	}
}