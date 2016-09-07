package com.example.data_structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class StackTests {

	@Test
	public void emptyStack_ShouldHaveSize_0() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		int size = stack.size();

		// Assert
		assertEquals(0, size);
	}

	@Test
	public void stackWithOnePushedElement_ShouldHaveSize_1() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		int size = stack.size();

		// Assert
		assertEquals(1, size);
	}

	@Test
	public void stackWithTwoPushedElements_ShouldHaveSize_2() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		stack.push("How is it going");
		int size = stack.size();

		// Assert
		assertEquals(2, size);
	}

	@Test
	public void stackWithTwoPushedElements_Peek_ShouldMatchTheSecondAddedElement() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		stack.push("How is it going");

		// Assert
		assertEquals("How is it going", stack.peek());
	}

	@Test
	public void stackWithTwoPushedElements_Pop_ShouldMatchTheSecondAddedElement() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		stack.push("How is it going");

		// Assert
		assertEquals("How is it going", stack.pop());
	}

	@Test
	public void stackWithTwoPushedElements_DoublePop_ShouldMatchTheFirstAddedElement() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		stack.push("How is it going");
		stack.pop();

		// Assert
		assertEquals("Waazz up", stack.pop());
	}

	@Test
	public void stackWithTwoPushedElements_DoublePop_ShouldResetTheStackSizeTo_0() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		stack.push("How is it going");
		stack.pop();
		stack.pop();

		// Assert
		assertEquals(0, stack.size());
	}

	@Test(expected = IllegalAccessError.class)
	public void emptyStack_ShouldThrowAnExceptionOn_Peek() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.peek();
	}

	@Test(expected = IllegalAccessError.class)
	public void emptyStack_ShouldThrowAnExceptionOn_Pop() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.pop();
	}

	@Test
	public void stackWithTwoPushedElements_SinglePop_Peek_ShouldMatchTheFirstAddedElement() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		stack.push("How is it going");
		stack.pop();

		// Assert
		assertEquals("Waazz up", stack.peek());
		assertEquals(1, stack.size());
	}

	@Test
	public void stackWithTwoPushedElements_toString() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Act
		stack.push("Waazz up");
		stack.push("How is it going");

		// Assert
		String expectedToString = "[How is it going, Waazz up]";
		assertEquals(expectedToString, stack.toString());
	}

	@Test
	public void emptyStack_toString() {
		// Arrange
		Stack<String> stack = new Stack<>();

		// Assert
		String expectedToString = "[]";
		assertEquals(expectedToString, stack.toString());
	}
}
