package com.example.data_structures;

import java.util.Arrays;

public class Stack<E> {
	private static final int DEFAULT_CAPACITY = 10;

	private int size = 0;
	private Object elements[];

	public Stack() {
		this.elements = new Object[DEFAULT_CAPACITY];
	}

	public Stack(int capacity) {
		this.elements = new Object[capacity];
	}

	public void push(E e) {
		if (this.size == this.elements.length) {
			this.ensureCapacity();
		}
		
		this.elements[size++] = e;
	}

	@SuppressWarnings("unchecked")
	public E pop() {
		if (this.size == 0) {
			throw new IllegalAccessError("The stack is empty.");
		}
		
		E e = (E) this.elements[--this.size];
		this.elements[size] = null;

		return e;
	}

	@SuppressWarnings("unchecked")
	public E peek() {
		if (this.size == 0) {
			throw new IllegalAccessError("The stack is empty.");
		}
		
		E e = (E) this.elements[size - 1];

		return e;
	}
	
	public int size() {
		return this.size;
	}

	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append('[');
		
		for (int i = this.size - 1; i >= 0; i--) {
			sb.append(this.elements[i].toString());
			if (i > 0) {
				sb.append(", ");
			}
		}
		
		sb.append(']');
		
		return sb.toString();
	}
	
	private void ensureCapacity() {
		int newSize = this.elements.length * 2;
		this.elements = Arrays.copyOf(this.elements, newSize);
	}
}
