package project;

public class DoubleLinkedNode<T> {

	private T value;
	private DoubleLinkedNode<T> next;
	private DoubleLinkedNode<T> previous;
	
	public DoubleLinkedNode(T value) {
		this.setValue(value);
		this.next = null;
		this.previous = null;
	}
	
	public T getValue() {
		return value;
	}
	
	public void setValue(T value) {
		this.value = value;
	}
	
	public DoubleLinkedNode<T> getNext() {
		return next;
	}
	
	public void setNext(DoubleLinkedNode<T> next) {
		this.next = next;
	}
	
	public DoubleLinkedNode<T> getPrevious() {
		return previous;
	}
	
	public void setPrevious(DoubleLinkedNode<T> previous) {
		this.previous = previous;
	}
}
