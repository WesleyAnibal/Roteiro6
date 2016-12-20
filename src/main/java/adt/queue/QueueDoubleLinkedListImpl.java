package adt.queue;

import adt.linkedList.DoubleLinkedList;
import adt.linkedList.DoubleLinkedListImpl;
import adt.linkedList.DoubleLinkedListNode;
import adt.linkedList.SingleLinkedListImpl;
import adt.linkedList.SingleLinkedListNode;

public class QueueDoubleLinkedListImpl<T> implements Queue<T> {

	protected DoubleLinkedList<T> list;
	protected int size;

	public QueueDoubleLinkedListImpl(int size) {
		this.size = size;
		this.list = new DoubleLinkedListImpl<T>();
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
		if(isFull()) throw new QueueOverflowException();
		else{
			list.insert(element);
		}
	}

	@Override
	public T dequeue() throws QueueUnderflowException {
		if(isEmpty()) throw new QueueUnderflowException();
		else{
			T aux = ((SingleLinkedListImpl<T>) list).getHead().getData();
			list.removeFirst();
			return aux;
		}
	}

	@Override
	public T head() {
		return ((SingleLinkedListImpl<T>) list).getHead().getData();
	}

	@Override
	public boolean isEmpty() {
		return list.isEmpty();
	}

	@Override
	public boolean isFull() {
		return this.size == list.size();
	}
	public static void main(String[] args) throws Exception {
		QueueDoubleLinkedListImpl<Integer> x = new QueueDoubleLinkedListImpl<>(5);
		x.enqueue(10);
		x.enqueue(78);
		System.out.println(x.head());
		System.out.println(x.dequeue());
		System.out.println(x.head());
		
	}

}
