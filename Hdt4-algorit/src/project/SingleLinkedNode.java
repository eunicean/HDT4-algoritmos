/* Universidad del valle de Guatemala
 * Eunice Anah[i Mata - 21231
 *  
 * La clase funciona como mi nodo para LL
 * 
 * */

package project;

public class SingleLinkedNode<T> {
	private T value;
	private SingleLinkedNode<T> next;
	
	public SingleLinkedNode(T value) {
		this.setValue(value);
		this.next = null;
	}
	
	public T getValue() {
		return value;
	}
	public void setValue(T value) {
		this.value = value;
	}
	public SingleLinkedNode<T> getNext() {
		return next;
	}
	public void setNext(SingleLinkedNode<T> next) {
		this.next = next;
	}
}
