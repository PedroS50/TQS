package ua.deti.pedros50;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class TqsStackTests {

	@Test
    public void isEmptyOnInit() {
        TqsStack my_stack = new TqsStack();
        assertEquals(true, my_stack.isEmpty(), "Stack should be empty on init.");
	}

	@Test
    public void sizeOnInit() {
        TqsStack my_stack = new TqsStack();
        assertEquals(0, my_stack.size(), "Stack should have size 0 on init.");
	}
	
	@Test
	@DisplayName("3 pushes to empty stack")
    public void push() {
        TqsStack my_stack = new TqsStack();
        my_stack.push("one");
        my_stack.push("two");
		my_stack.push("three");
        assertEquals(false, my_stack.isEmpty(), "Stack shouldn't be empty after pushes have been made.");
        assertEquals(3, my_stack.size(), "Stack size should be 3 after 3 pushes.");
	}
	
	@Test
	public void push_pop() {
		TqsStack my_stack = new TqsStack();
		my_stack.push("One");
		assertEquals("One", my_stack.pop(), "Pop() returned the wrong value.");
	}
	@Test
	public void push_peek() {
		TqsStack my_stack = new TqsStack();
		my_stack.push("One");
		assertEquals("One", my_stack.peek(), "Value peeked should be \"One\".");
		assertEquals(1, my_stack.size(), "Size should remain the same after peek().");
	}

	@Test
	public void n_push_pop() {
		TqsStack my_stack = new TqsStack();
		my_stack.push("One");
		my_stack.push("Two");
		my_stack.push("Three");
		my_stack.push("Four");
		my_stack.pop();
		my_stack.pop();
		my_stack.pop();
		my_stack.pop();
		assertEquals(0, my_stack.size(), "Size of stack with n elements should be 0 after n pops.");
	}

	@Test
	public void pop_empty() {
		TqsStack my_stack = new TqsStack();
		assertThrows(NoSuchElementException.class, () -> { my_stack.pop(); });
	}

	@Test
	public void peek_empty() {
		TqsStack my_stack = new TqsStack();
		assertThrows(NoSuchElementException.class, () -> { my_stack.peek(); });
	}

	@Test
	public void push_bounded() {
		TqsStack my_stack = new TqsStack(3);
		my_stack.push(1);
		my_stack.push(2);
		my_stack.push(3);
		assertThrows(IllegalStateException.class, () -> { my_stack.push(4); }, "Push to full stack didn't throw exception.");
	}
}
