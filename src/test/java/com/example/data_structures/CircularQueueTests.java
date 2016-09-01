package com.example.data_structures;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;

import org.junit.Test;

public class CircularQueueTests {

	/*
	 * Enqueue
	 */

	@Test
	public void enqueue_EmptyQueue_ShouldAddElement() {
		// Arrange
		CircularQueue<Integer> queue = new CircularQueue<>();

		// Act
		queue.Enqueue(5);

		// Assert
		assertEquals(1, queue.size());
	}

	@Test
	public void enqueueDeque_ShouldWorkCorrectly() {
		// Arrange
		CircularQueue<String> queue = new CircularQueue<>();
		String element = "some value";

		// Act
		queue.Enqueue(element);
		String elementFromQueue = queue.Dequeue();

		// Assert
		assertEquals(0, queue.size());
		assertEquals(element, elementFromQueue);
	}

	/*
	 * Dequeue
	 */

	@Test(expected = IllegalStateException.class)
	public void dequeue_EmptyQueue_ThrowsException() {
		// Arrange
		CircularQueue<Integer> queue = new CircularQueue<>();

		// Act
		queue.Dequeue();

		// Assert: expect and exception
	}

	@Test
	public void enqueueDequeue1000Elements_ShouldWorkCorrectly() {
		// Arrange
		CircularQueue<Integer> queue = new CircularQueue<>();
		int numberOfElements = 1000;

		// Act
		for (int i = 0; i < numberOfElements; i++) {
			queue.Enqueue(i);
		}

		// Assert
		for (int i = 0; i < numberOfElements; i++) {
			assertEquals(numberOfElements - i, queue.size());
			int element = queue.Dequeue();
			assertEquals(i, element);
			assertEquals(numberOfElements - i - 1, queue.size());
		}
	}

	@Test
	public void circularQueue_EnqueueDequeueManyChunks_ShouldWorkCorrectly() {
		// Arrange
		CircularQueue<Integer> queue = new CircularQueue<>();
		int chunks = 100;

		// Act & Assert in a loop
		int value = 1;
		for (int i = 0; i < chunks; i++) {
			assertEquals(0, queue.size());
			int chunkSize = i + 1;
			for (int counter = 0; counter < chunkSize; counter++) {
				assertEquals(value - 1, queue.size());
				queue.Enqueue(value);
				assertEquals(value, queue.size());
				value++;
			}
			for (int counter = 0; counter < chunkSize; counter++) {
				value--;
				assertEquals(value, queue.size());
				queue.Dequeue();
				assertEquals(value - 1, queue.size());
			}
			assertEquals(0, queue.size());
		}
	}

	@Test
	public void initialCapacity1_EnqueueDequeue20Elements_ShouldWorkCorrectly() {
		// Arrange
		int elementsCount = 20;
		int initialCapacity = 1;

		// Act
		CircularQueue<Integer> queue = new CircularQueue<>(initialCapacity);
		for (int i = 0; i < elementsCount; i++) {
			queue.Enqueue(i);
		}

		// Assert
		assertEquals(elementsCount, queue.size());
		for (int i = 0; i < elementsCount; i++) {
			int elementFromQueue = queue.Dequeue();
			assertEquals(i, elementFromQueue);
		}
	}

	/*
	 * ToArray
	 */

	@Test
	public void Enqueue500Elements_ToArray_ShouldWorkCorrectly() {
		// Arrange
		Integer[] array = new Integer[500];
		for (int i = 0; i < array.length; i++) {
			array[i] = i;
		}

		CircularQueue<Integer> queue = new CircularQueue<>();

		// Act
		for (int i = 0; i < array.length; i++) {
			queue.Enqueue(array[i]);
		}

		Integer[] arrayFromQueue = Arrays.copyOf(queue.toArray(), 500, Integer[].class);

		// Assert
		assertArrayEquals(array, arrayFromQueue);
	}
}
