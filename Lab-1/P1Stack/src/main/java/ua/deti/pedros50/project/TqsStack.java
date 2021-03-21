package ua.deti.pedros50;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.ArrayList;

public class TqsStack<T> {

	private List<T> my_stack;
	private int max_size;

	TqsStack() {
		this.my_stack = new ArrayList<T>();
		this.max_size = -1;
	}

	TqsStack(int size) {
		this.my_stack = new ArrayList<T>();
		this.max_size = size;
	}

	public void push(T elem) {
		if ( this.max_size != -1 ) {
			if ( this.size() == this.max_size )
				throw new IllegalStateException();
		}
		my_stack.add(elem);
	}

	public T pop() {
		if ( my_stack.size() == 0 ) {
			throw new NoSuchElementException();
		}
		T temp = my_stack.get(my_stack.size()-1);
		my_stack.remove(my_stack.size()-1);
		return temp;
	}

	public T peek() {
		if ( my_stack.size() == 0 ) {
			throw new NoSuchElementException();
		}
		return my_stack.get(my_stack.size()-1);
	}

	public int size() {
		return my_stack.size();
	}

	public boolean isEmpty() {
		return my_stack.isEmpty();
	}

}
