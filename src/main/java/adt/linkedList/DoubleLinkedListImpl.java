package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;
	public DoubleLinkedListImpl() {
		this.head = new DoubleLinkedListNode<>();
		last = (DoubleLinkedListNode<T>) head;
	}
	@Override
	public void insertFirst(T element) {
		if(head.isNIL()){
			this.head.setData(element);
			DoubleLinkedListNode<T> aux = new DoubleLinkedListNode<>();
			this.head.setNext(aux);
			aux.previous = (DoubleLinkedListNode<T>) head;
		}else{
			DoubleLinkedListNode<T> novo = new DoubleLinkedListNode<T>(element, (DoubleLinkedListNode<T>) head, new DoubleLinkedListNode<>());
			((DoubleLinkedListNode<T>) head).previous = novo;
			head = novo;
		}
	}

	@Override
	public void removeFirst() {
		if(isEmpty()) return;
		head.data = head.next.data;
		head.next = head.next.next;
		((DoubleLinkedListNode<T>) head.next).setPrevious((DoubleLinkedListNode<T>) head);
		
	}
	public void insert(T element) {
		DoubleLinkedListNode<T> atual = (DoubleLinkedListNode<T>) head;
		if (this.head.data == null) {
			this.head = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(), new DoubleLinkedListNode<>());
			last = (DoubleLinkedListNode<T>) this.head;
		} else {
			DoubleLinkedListNode<T> novo = new DoubleLinkedListNode<T>(element, new DoubleLinkedListNode<>(),last);
			last.next = novo;
			last = novo;
			
		}

	}

	@Override
	public void removeLast() {
		if(isEmpty()) return;
		last = last.previous; 
		last.next = new DoubleLinkedListNode<>();
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
