package adt.stack;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;

public class StackDoubleLinkedListImpl<T> implements Stack<T> {

	protected DoubleLinkedList<T> top;
	protected int size;

	public StackDoubleLinkedListImpl(int size) {
		this.size = size;
		this.top = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void push(T element) throws StackOverflowException {
		if(isFull()) throw new StackOverflowException();
		else{
			top.insert(element);
		}

	}

	@Override
	public T pop() throws StackUnderflowException {
		if(isEmpty()) throw new StackUnderflowException();
		else{
			T aux =  ((DoubleLinkedListImpl<T>) top).getLast().getData();
			top.removeLast();
			return aux;
		}
	}

	@Override
	public T top() {
		return ((DoubleLinkedListImpl<T>) top).getLast().getData();
	}

	@Override
	public boolean isEmpty() {
		return top.isEmpty();
	}

	@Override
	public boolean isFull() {
		return top.size() == this.size;
	}public static void main(String[] args) throws Exception {
		StackDoubleLinkedListImpl<Integer> x = new StackDoubleLinkedListImpl<>(5);
		x.push(5);
		x.push(10);
		System.out.println(x.top());
		x.push(99);
		System.out.println(x.top());
		System.out.println(x.pop());
		System.out.println(x.pop());
		System.out.println(x.top());
		
		
	}

}
