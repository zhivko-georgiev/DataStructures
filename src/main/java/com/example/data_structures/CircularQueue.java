package com.example.data_structures;

public class CircularQueue<T> {
	private static final int InitialCapacity = 16;

	private int count;
	private Object[] elements;
	private int startIndex;
	private int endIndex;

	public CircularQueue(int capacity) {
		this.elements = new Object[capacity];
	}

	public CircularQueue() {
		this(InitialCapacity);
	}

	public int size() {
		return this.count;
	}

	public void Enqueue(T element) {
		if (this.count >= this.elements.length) {
			this.grow();
		}
		this.elements[this.endIndex] = element;
		this.endIndex = (this.endIndex + 1) % this.elements.length;
		this.count++;
	}

	public T Dequeue() {
		if (this.count == 0) {
			throw new IllegalStateException("The queue is empty");
		}

		@SuppressWarnings("unchecked")
		T result = (T) this.elements[this.startIndex];
		this.startIndex = (this.startIndex + 1) % this.elements.length;
		this.count--;

		return result;
	}

	public Object[] toArray() {
		Object[] resultArr = new Object[this.count];
		this.copyAllElementsTo(resultArr);
		
		return resultArr;
	}

	private void grow() {
		Object[] newElements = new Object[2 * this.elements.length];
		this.copyAllElementsTo(newElements);
		this.elements = newElements;
		this.startIndex = 0;
		this.endIndex = this.count;
	}

	@SuppressWarnings("unchecked")
	private void copyAllElementsTo(Object[] newElements) {
		int sourceIndex = this.startIndex;
		int destinationIndex = 0;

		for (int i = 0; i < this.count; i++) {
			newElements[destinationIndex] = (T) this.elements[sourceIndex];
			sourceIndex = (sourceIndex + 1) % this.elements.length;
			destinationIndex++;
		}
	}
}
