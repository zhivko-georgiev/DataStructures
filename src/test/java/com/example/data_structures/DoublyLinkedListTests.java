package com.example.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertArrayEquals;

public class DoublyLinkedListTests {

	/*
	 * AddFirst
	 */

	@Test
	public void AddFirst_EmptyList_ShouldAddElement() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddFirst(5);

		// Assert
		assertEquals(1, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(5));
	}

	@Test
	public void AddFirst_SeveralElements_ShouldAddElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddFirst(10);
		list.аddFirst(5);
		list.аddFirst(3);

		// Assert
		assertEquals(3, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(3, 5, 10));
	}

	/*
	 * AddLast
	 */

	@Test
	public void AddLast_EmptyList_ShouldAddElement() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddLast(5);

		// Assert
		assertEquals(1, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(5));
	}

	@Test
	public void AddLast_SeveralElements_ShouldAddElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddLast(5);
		list.аddLast(10);
		list.аddLast(15);

		// Assert
		assertEquals(3, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(5, 10, 15));
	}

	/*
	 * RemoveFirst
	 */

	@Test
	public void RemoveFirst_OneElement_ShouldMakeListEmpty() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddLast(5);

		// Act
		int element = list.removeFirst();

		// Assert
		assertEquals(5, element);
		assertEquals(0, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, new ArrayList<Integer>());
	}

	@Test(expected = IllegalStateException.class)
	public void RemoveFirst_EmptyList_ShouldThrowException() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		Integer element = list.removeFirst();
	}

	@Test
	public void RemoveFirst_SeveralElements_ShouldRemoveElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddLast(5);
		list.аddLast(6);
		list.аddLast(7);

		// Act
		int element = list.removeFirst();

		// Assert
		assertEquals(5, element);
		assertEquals(2, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(6, 7));
	}

	/*
	 * RemoveLast
	 */

	@Test
	public void RemoveLast_OneElement_ShouldMakeListEmpty() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddFirst(5);

		// Act
		int element = list.removeLast();

		// Assert
		assertEquals(5, element);
		assertEquals(0, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, new ArrayList<Integer>());
	}

	@Test(expected = IllegalStateException.class)
	public void RemoveLast_EmptyList_ShouldThrowException() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		Integer element = list.removeLast();
	}

	@Test
	public void RemoveLast_SeveralElements_ShouldRemoveElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddFirst(10);
		list.аddFirst(9);
		list.аddFirst(8);

		// Act
		int element = list.removeLast();

		// Assert
		assertEquals(10, element);
		assertEquals(2, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(8, 9));
	}

	/*
	 * ToArray
	 */

	@Test
	public void ToArray_EmptyList_ShouldReturnEmptyArray() {
		// Arrange
		DoublyLinkedList<String> list = new DoublyLinkedList<>();

		// Act
		Object[] arr = list.toArray();

		// Assert
		assertArrayEquals(new String[] {}, arr);
	}

	@Test
	public void ToArray_NonEmptyList_ShouldReturnArray() {
		// Arrange
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.аddLast("Five");
		list.аddLast("Six");
		list.аddLast("Seven");

		// Act
		Object[] arr = list.toArray();

		// Assert
		assertArrayEquals(new String[] { "Five", "Six", "Seven" }, arr);
	}

	/*
	 * ForEach
	 */

	@Test
	public void ForEach_EmptyList_ShouldEnumerateElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);

		// Assert
		CollectionUtils.isEqualCollection(items, new ArrayList<Integer>());
	}

	@Test
	public void ForEach_SingleElement_ShouldEnumerateElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddLast(5);

		// Act
		List<Integer> items = new ArrayList<Integer>();
		list.forEach(items::add);

		// Assert
		CollectionUtils.isEqualCollection(items, Arrays.asList(5));
	}

	@Test
	public void ForEach_MultipleElements_ShouldEnumerateElementsCorrectly() {
		// Arrange
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.аddLast("Five");
		list.аddLast("Six");
		list.аddLast("Seven");

		// Act
		List<String> items = new ArrayList<>();
		list.forEach(items::add);

		// Assert
		CollectionUtils.isEqualCollection(items, Arrays.asList("Five", "Six", "Seven"));
	}
}