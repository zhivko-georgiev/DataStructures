package com.example.data_structures;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
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
	public void addFirst_EmptyList_ShouldAddElement() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddFirst(5);

		// Assert
		assertEquals(1, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(5));
	}

	@Test
	public void addFirst_SeveralElements_ShouldAddElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddFirst(10);
		list.аddFirst(5);
		list.аddFirst(3);

		// Assert
		assertEquals(3, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(3, 5, 10));
	}

	/*
	 * AddLast
	 */

	@Test
	public void addLast_EmptyList_ShouldAddElement() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddLast(5);

		// Assert
		assertEquals(1, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(5));
	}

	@Test
	public void addLast_SeveralElements_ShouldAddElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		list.аddLast(5);
		list.аddLast(10);
		list.аddLast(15);

		// Assert
		assertEquals(3, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(5, 10, 15));
	}

	/*
	 * RemoveFirst
	 */

	@Test
	public void removeFirst_OneElement_ShouldMakeListEmpty() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddLast(5);

		// Act
		int element = list.removeFirst();

		// Assert
		assertEquals(5, element);
		assertEquals(0, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, new ArrayList<Integer>());
	}

	@Test(expected = IllegalStateException.class)
	public void removeFirst_EmptyList_ShouldThrowException() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		@SuppressWarnings("unused")
		Integer element = list.removeFirst();
	}

	@Test
	public void removeFirst_SeveralElements_ShouldRemoveElementsCorrectly() {
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
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(6, 7));
	}

	/*
	 * RemoveLast
	 */

	@Test
	public void removeLast_OneElement_ShouldMakeListEmpty() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddFirst(5);

		// Act
		int element = list.removeLast();

		// Assert
		assertEquals(5, element);
		assertEquals(0, list.size());

		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, new ArrayList<Integer>());
	}

	@Test(expected = IllegalStateException.class)
	public void removeLast_EmptyList_ShouldThrowException() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		@SuppressWarnings("unused")
		Integer element = list.removeLast();
	}

	@Test
	public void removeLast_SeveralElements_ShouldRemoveElementsCorrectly() {
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
		list.forEachNode(items::add);
		CollectionUtils.isEqualCollection(items, Arrays.asList(8, 9));
	}

	/*
	 * ToArray
	 */

	@Test
	public void toArray_EmptyList_ShouldReturnEmptyArray() {
		// Arrange
		DoublyLinkedList<String> list = new DoublyLinkedList<>();

		// Act
		Object[] arr = list.toArray();

		// Assert
		assertArrayEquals(new String[] {}, arr);
	}

	@Test
	public void toArray_NonEmptyList_ShouldReturnArray() {
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
	public void forEach_EmptyList_ShouldEnumerateElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();

		// Act
		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);

		// Assert
		CollectionUtils.isEqualCollection(items, new ArrayList<Integer>());
	}

	@Test
	public void forEach_SingleElement_ShouldEnumerateElementsCorrectly() {
		// Arrange
		DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
		list.аddLast(5);

		// Act
		List<Integer> items = new ArrayList<Integer>();
		list.forEachNode(items::add);

		// Assert
		CollectionUtils.isEqualCollection(items, Arrays.asList(5));
	}

	@Test
	public void forEach_MultipleElements_ShouldEnumerateElementsCorrectly() {
		// Arrange
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.аddLast("Five");
		list.аddLast("Six");
		list.аddLast("Seven");

		// Act
		List<String> items = new ArrayList<>();
		list.forEachNode(items::add);

		// Assert
		CollectionUtils.isEqualCollection(items, Arrays.asList("Five", "Six", "Seven"));
	}

	/*
	 * Iterable
	 */

	@Test
	public void iterable_Foreach_MultipleElements() {
		// Arrange
		DoublyLinkedList<String> list = new DoublyLinkedList<>();
		list.аddLast("Five");
		list.аddLast("Six");
		list.аddLast("Seven");

		// Act
		List<String> items = new ArrayList<>();
		for (String element : list) {
			items.add(element);
		}

		// Assert
		CollectionUtils.isEqualCollection(items, Arrays.asList("Five", "Six", "Seven"));
	}

	@Test
	public void iterable_NonGeneric_MultipleElements() {
		// Arrange
		DoublyLinkedList<Object> list = new DoublyLinkedList<>();
		list.аddLast("Five");
		list.аddLast(6);
		list.аddLast(7.77);

		// Act
		Iterator<Object> iterator = list.iterator();
		List<Object> items = new ArrayList<>();

		while (iterator.hasNext()) {
			items.add(iterator.next());
		}

		// Assert
		CollectionUtils.isEqualCollection(items, Arrays.asList("Five", 6, 7.77));
	}
}