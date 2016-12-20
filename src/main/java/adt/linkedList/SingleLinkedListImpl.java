package adt.linkedList;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		return this.head.data == null;
	}

	@Override
	public int size() {
		int cont = 0;
		SingleLinkedListNode<T> atual = head;
		while (!atual.isNIL()) {
			++cont;
			atual = atual.next;
		}
		return cont;
	}

	@Override
	public T search(T element) {
		SingleLinkedListNode<T> atual = head;
		while (atual.data != null && !atual.getData().equals(element)) {
			atual = atual.next;
		}
		return atual.getData();

	}

	@Override
	public void insert(T element) {
		SingleLinkedListNode<T> atual = head;
		if (head.data == null) {
			head = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<>());
		} else {
			while (atual.next != null) {
				atual = atual.next;
			}
			atual.setData(element);
			atual.setNext(new SingleLinkedListNode<>());
		}

	}

	@Override
	public void remove(T element) {
		SingleLinkedListNode<T> atual = head;
		if (head.data.equals(element)) {
			head.data = head.next.data;
			head.next = head.next.next;
		} else {
			while (!atual.getNext().getData().equals(element)) {
				atual = atual.next;
			}
			atual.next = atual.next.next;
		}

	}

	@Override
	public T[] toArray() {
		T[] saida = (T[]) new Comparable[this.size()];
		SingleLinkedListNode<T> atual = head;
		for (int i = 0; i < saida.length; i++) {
			saida[i] = atual.getData();
			atual = atual.next;
		}
		return saida;
	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}